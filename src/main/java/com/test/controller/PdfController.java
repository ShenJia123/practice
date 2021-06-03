package com.test.controller;

import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.db.Page;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.test.domain.R;
import com.test.dto.PdfDto;
import com.test.util.MultipartFileToFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

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


    @PostMapping("imgTransferPdf")
    public R imgTransferPdf(@RequestParam("file") MultipartFile multipartFile) {
        Document document = new Document(PageSize.A4);
        try {
            String fileName = UUID.randomUUID().toString().replaceFirst("-", "");
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(target + fileName + ".pdf"));
            document.open();
            Image image = Image.getInstance(multipartFile.getBytes());
            int percent = getPercent(image.getHeight(), image.getWidth());
            image.setAlignment(Image.MIDDLE);
            image.scalePercent(percent);
            document.add(image);
            document.close();
            pdfWriter.close();
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
        return R.ok();
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
