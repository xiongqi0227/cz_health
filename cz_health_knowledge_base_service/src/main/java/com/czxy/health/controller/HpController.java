package com.czxy.health.controller;

import com.czxy.health.domain.HealthProgramme;
import com.czxy.health.service.HpService;
import com.czxy.health.vo.BaseResult;
import com.czxy.health.vo.QueryHp;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by xiongqi.
 */
@RestController
@RequestMapping("/hp")
public class HpController {
    @Resource
    private HpService hpService;

    /**
     * 分页条件查询健康方案列表
     *
     * @param queryHp
     * @return
     */
    @PostMapping("/findHpList")
    public BaseResult findHpList(@RequestBody QueryHp queryHp) {
        PageInfo pageInfo = hpService.findHpList(queryHp);
        return pageInfo != null ? BaseResult.ok("查询成功", pageInfo) : BaseResult.error("查询失败");
    }

    /**
     * 添加健康方案
     *
     * @param healthProgramme
     * @return
     */
    @PostMapping("/addHp")
    public BaseResult addHp(@RequestBody HealthProgramme healthProgramme) {
        int result = hpService.addHp(healthProgramme);
        return result == 1 ? BaseResult.ok("添加成功") : BaseResult.error("添加失败");
    }

    /**
     * 根据id查询健康方案
     *
     * @param hpId
     * @return
     */
    @GetMapping("/findHpById/{hpId}")
    public BaseResult findHpById(@PathVariable(name = "hpId") Integer hpId) {
        HealthProgramme healthProgramme = hpService.findHpById(hpId);
        return healthProgramme != null ? BaseResult.ok("查询成功", healthProgramme ) : BaseResult.error("查询失败");
    }

    /**
     * 修改健康方案
     *
     * @param healthProgramme
     * @return
     */
    @PutMapping
    public BaseResult editHp(@RequestBody HealthProgramme healthProgramme) {
        int result = hpService.editHp(healthProgramme);
        return result == 1 ? BaseResult.ok("修改成功") : BaseResult.error("修改失败");
    }

    /**
     * 删除健康方案
     *
     * @param hpId
     * @return
     */
    @DeleteMapping("/{hpId}")
    public BaseResult deleteHp(@PathVariable(name = "hpId") Integer hpId) {
        int result = hpService.deleteHp(hpId);
        return result == 1 ? BaseResult.ok("删除成功") : BaseResult.error("删除失败");
    }
}
