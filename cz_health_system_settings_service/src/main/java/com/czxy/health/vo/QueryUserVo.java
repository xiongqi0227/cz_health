package com.czxy.health.vo;

import lombok.Data;

/**
 * Created by xiongqi.
 */
@Data
public class QueryUserVo {
    private Integer pageNum;
    private Integer pageSize;
    private String umName;
    private String umUsername;
}
