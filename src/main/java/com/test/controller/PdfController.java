package com.test.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.test.domain.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * ClassName : PdfController<br>
 * Description : TODO<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/6/3
 */
@Slf4j
@RestController
@RequestMapping("/pdf")
public class PdfController {

    @Value("${target}")
    private String target;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @PostMapping("imgTransferPdf")
    public R imgTransferPdf(@RequestParam("file") MultipartFile multipartFile,
                            @RequestParam("id") String id) {
        Document document = new Document(PageSize.A4);
        try {
            String fileName = UUID.randomUUID().toString().replaceAll("-", "");
            String fileUrl = target + fileName + ".pdf";
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(fileUrl));
            document.open();
            Image image = Image.getInstance(multipartFile.getBytes());
            int percent = getPercent(image.getHeight(), image.getWidth());
            image.setAlignment(Image.MIDDLE);
            image.scalePercent(percent);
            document.add(image);
            document.close();
            pdfWriter.close();
            if (!redisTemplate.hasKey(id)) {
                log.info("{}", fileUrl);
                redisTemplate.opsForValue().set(id, fileUrl, 1L);
            } else {
                redisTemplate.opsForValue().append(id, "," + fileUrl);
            }
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
        return R.ok();
    }

    @GetMapping("toZip")
    public void toZip(@RequestParam("id") String id, HttpServletResponse response) throws IOException {
        String fileUrl = redisTemplate.opsForValue().get(id);
        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + ".zip";
        log.info("文件名称：{}", fileName);
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(target + fileName));
        byte[] buffer = new byte[1024];
        List<String> files = Arrays.asList(fileUrl.trim().split(","));
        for (String url : files) {
            FileInputStream fis = new FileInputStream(url);
            zos.putNextEntry(new ZipEntry(url));
            int len = 0;
            while ((len = fis.read(buffer)) != -1) {
                zos.write(buffer, 0, len);
            }
            zos.closeEntry();
            fis.close();
        }
        // 设置文件名
        zos.close();
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        response.addHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fis = new FileInputStream(target + fileName);
            bis = new BufferedInputStream(fis);
            OutputStream os = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 第二种解决方案，统一按照宽度压缩
     * 这样来的效果是，所有图片的宽度是相等的，自我认为给客户的效果是最好的
     *
     * @param h
     * @param w
     */
    public int getPercent2(float h, float w) {
        int p = 0;
        float p2 = 0.0f;
        p2 = 530 / w * 100;
        System.out.println("--" + p2);
        p = Math.round(p2);
        return p;
    }

    private int getPercent(float h, float w) {
        int p = 0;
        float p2 = 0.0f;
        if (h > w) {
            p2 = 297 / h * 100;
        } else {
            p2 = 210 / w * 100;
        }
        p = Math.round(p2);
        return p;
    }

}
