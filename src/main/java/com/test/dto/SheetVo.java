package com.test.dto;

import lombok.Data;

import java.util.Collection;

/**
 * ClassName : SheetVo<br>
 * Description : SheetVo<br>
 *
 * @author : sj
 * @date : 2022/4/8
 */
@Data
public class SheetVo {

    private String sheetName;

    private Collection<?> collection;

}
