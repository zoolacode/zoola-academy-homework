package com.zoolatech.lecture4.tasks._5;

import java.math.BigDecimal;

@FunctionalInterface
public interface Calculator {
    BigDecimal calculate(BigDecimal v1, BigDecimal v2, char operator);
}
