package com.weelfly.manage.bean.vo;

import com.weelfly.manage.bean.domain.Role;
import com.weelfly.manage.bean.domain.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 * 后台管理用户
 * </p>
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class UserVO extends User {

    private Role role;


}
