package com.weelfly.common.util;

import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * BigDecimalUtils
 */
public abstract class BigDecimalUtils {


    /**
     * 保留N位小数,N位之后的全部去掉<br>
     *
     * @param current  : 当前需要改变的
     * @param position : 位数
     */
    public static BigDecimal setScaleDown(BigDecimal current, int position) {
        return current.setScale(position, RoundingMode.DOWN);
    }

    /**
     * 判断是否是一个正数
     * <p>正数定义：比0大的实数叫正数[,正数前面常有一个符号"+",通常可以省略不写.</p>
     *
     * @param bigDecimal input
     */
    public static boolean isPositiveNumber(BigDecimal bigDecimal) {
        return bigDecimal.compareTo(BigDecimal.ZERO) > 0;
    }

    /**
     * 判断是否不是一个正数
     *
     * @param bigDecimal input
     */
    public static boolean isNotPositiveNumber(BigDecimal bigDecimal) {
        return !isPositiveNumber(bigDecimal);
    }

    /**
     * 判断两个参数是否相等
     *
     * @param before param1
     * @param after  param2
     */
    public static boolean isEqual(BigDecimal before, BigDecimal after) {
        return (before == null && after == null) || (before != null && before.compareTo(after) == 0);

    }

    /**
     * 判断两个参数是否相等
     *
     * @param before param1
     * @param after  param2
     */
    public static boolean isEqual(BigDecimal before, String after) {
        return isEqual(before, NumberUtils.createBigDecimal(after));
    }


    public static boolean isNotEqual(BigDecimal before, String after) {
        return isNotEqual(before, NumberUtils.createBigDecimal(after));
    }


    /**
     * 判断两个参数是否不相等
     *
     * @param before param1
     * @param after  param2
     */
    public static boolean isNotEqual(BigDecimal before, BigDecimal after) {
        return !isEqual(before, after);
    }

    /**
     * 乘法计算
     *
     * @param before param1
     * @param after  param2
     */
    public static BigDecimal multiply(BigDecimal before, int after) {
        return before.multiply(NumberUtils.createBigDecimal(String.valueOf(after)));
    }

    /**
     * 减法
     *
     * @param before param1
     * @param after  param2
     */
    public static BigDecimal subtract(BigDecimal before, String after) {
        return before.subtract(NumberUtils.createBigDecimal(after));
    }

    public static BigDecimal subtract(BigDecimal before, BigDecimal after) {
        return before.subtract(after);
    }

    /**
     * 加法
     *
     * @param before param1
     * @param after  param2
     */
    public static BigDecimal add(BigDecimal before, String after) {
        return before.add(NumberUtils.createBigDecimal(after));
    }

    /**
     * 加法
     *
     * @param before param1
     * @param after  param2
     */
    public static BigDecimal add(BigDecimal before, BigDecimal after) {
        return before.add(after);
    }


}
