package com.weelfly.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 分页信息接收实体
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class PagingRequest implements Serializable {

    private int pageNumber;
    private int pageSize;


    public PagingRequest() {
        this(GlobalConstant.DEFAULT_PAGE_NUMBER, GlobalConstant.DEFAULT_PAGE_SIZE);
    }

    public PagingRequest(int pageNumber, int pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }


}
