package com.yang.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author: yang
 * @Date: 11/18/20 10:10 PM
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestObject {

    private Integer id;
    private BigDecimal data;


}
