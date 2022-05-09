package com.test.controller;

import com.test.dto.CreditDetail;
import com.test.dto.PdfDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * ClassName : TestCtrl<br>
 * Description : TestCtrl<br>
 *
 * @author : sj
 * @date : 2022/4/8
 */
@Slf4j
@RestController
public class TestCtrl {


    @PostMapping("test")
    public void test(@RequestBody CreditDetail creditDetail, @RequestBody PdfDto pdfDto) {
        log.info("{}.{}", creditDetail, pdfDto);
    }


}
