package com.czxy.health.vo;

import lombok.Data;

/**
 * Created by xiongqi.
 */
@Data
public class QueryFb {
    private Integer pageNum;
    private Integer pageSize;
    private String fbNumber;
    private String fbName;
}
