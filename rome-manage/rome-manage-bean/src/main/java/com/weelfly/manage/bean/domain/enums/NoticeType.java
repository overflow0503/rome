package com.weelfly.manage.bean.domain.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.weelfly.manage.bean.domain.SystemLog;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 通知类型(SMS:短信,MAIL:邮箱)
 * 对应字段 {@link SystemLog#getNoticeType()}
 */
@Getter
@AllArgsConstructor
public enum NoticeType implements IEnum<String> {
    /**
     *
     */
    SMS("SMS", "短信通知"),
    MAIL("MAIL", "邮箱通知");

    /**
     * 数据库存储值
     **/
    private final String value;
    /**
     * 相应注释
     **/
    private final String comment;


}
