package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ClassName : ViewController<br>
 * Description : TODO<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/6/3
 */
@Controller
public class ViewController {

    @GetMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("imgToPdf")
    public String imgToPdf() {
        return "imgToPdf";
    }

}
