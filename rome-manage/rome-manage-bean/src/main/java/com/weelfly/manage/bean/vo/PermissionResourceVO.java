package com.weelfly.manage.bean.vo;

import com.weelfly.common.util.RecursionUtils;
import com.weelfly.manage.bean.domain.PermissionResource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@ToString(callSuper = true)
public class PermissionResourceVO extends PermissionResource implements RecursionUtils.ParentChildrenRecursion<PermissionResourceVO> {

    private List<String> methods = new ArrayList<>();
    private List<PermissionResourceVO> children = new ArrayList<>();

}
