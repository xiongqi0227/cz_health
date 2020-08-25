package com.czxy.health.vo;

import lombok.Data;

/**
 * Created by xiongqi.
 */
@Data
public class QueryHp {
    private Integer pageNum;
    private Integer pageSize;
    private String hpNumber;
    private String hpSchemeCategory;
}
