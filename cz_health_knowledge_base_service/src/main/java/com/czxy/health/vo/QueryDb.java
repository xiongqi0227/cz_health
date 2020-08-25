package com.czxy.health.vo;

import lombok.Data;

/**
 * Created by xiongqi.
 */
@Data
public class QueryDb {
    private Integer pageNum;
    private Integer pageSize;
    private String dbNumber;
    private String dbName;
}
