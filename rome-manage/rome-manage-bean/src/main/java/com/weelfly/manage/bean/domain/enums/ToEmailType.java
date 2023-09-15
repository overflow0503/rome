package com.weelfly.manage.bean.domain.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 收件箱类型(SYSTEM:系统邮箱,OTHER:其他邮箱[非系统邮箱]),默认为 : SYSTEM
 */
@Getter
@AllArgsConstructor
public enum ToEmailType implements IEnum<String> {

    SYSTEM("SYSTEM", "系统邮箱"),
    OTHER("OTHER", "其他邮箱[非系统邮箱])");

    /**
     * 数据库存储值
     **/
    private final String value;
    /**
     * 相应注释
     **/
    private final String comment;

}

