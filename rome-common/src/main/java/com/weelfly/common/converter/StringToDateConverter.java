package com.weelfly.common.converter;

import com.weelfly.common.SimpleDateFormatPro;
import com.weelfly.common.util.DateFormatStyle;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 * 这里只能对普通参数进行转换
 * <p>
 * 对 {@link org.springframework.web.bind.annotation.RequestBody} 接收的参数无效
 */
public class StringToDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        return new SimpleDateFormatPro(DateFormatStyle.getDateFormatStyles()).parse(source);
    }
}
