package com.czxy.health.vo;

import lombok.Data;

/**
 * Created by xiongqi.
 */
@Data
public class QuerySpl {
    private Integer pageNum;
    private Integer pageSize;
    private String splNumber;
    private String splName;
}
