package com.weelfly.common.annotation;

import com.weelfly.common.util.Export;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 导出注解,如果控制器某个方法需要进行导出操作,请在该方法上注上该注解
 * 配合{@link ExportFiledComment}使用
 * <p>
 * <p style="color:red">
 * 要求 :
 * <ul>
 * <li>1. {@link com.weelfly.common.ResponseEntityPro} 返回类型,并在泛型中指定类型</li>
 * <li>2. 指定的类型字段释义用 {@link ExportFiledComment} 指定,如果未指定,那么字段默认释义就是这个字段的名称 </li>
 * </ul>
 * </p>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface NeedExport {

    String value() default "";

    /**
     * 导出的对象类型
     * <p style="color:red">
     * 不支持Map类型,如果需要采用此方法导出,就必须写一个实体,否则请直接使用 {@link Export} 导出
     * </p>
     */
    Class<?> exportClass();

    /**
     * 导出类型,默认 xlsx 格式
     *
     * @return {@link Export}
     */
    Export.Type exportDefaultType() default Export.Type.MS07;

    /**
     * 导出文件名称,默认 <code>""</code> + 当前时间
     */
    String exportFileDefaultName() default "文档";


}
