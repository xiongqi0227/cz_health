package com.czxy.health.controller;

import com.czxy.health.domain.SportsProjectLibrary;
import com.czxy.health.service.SplService;
import com.czxy.health.vo.BaseResult;
import com.czxy.health.vo.QuerySpl;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by xiongqi.
 */
@RestController
@RequestMapping("/spl")
public class SplController {
    @Resource
    private SplService splService;

    /**
     * 分页条件查询运动项目列表
     * @param querySpl
     * @return
     */
    @PostMapping("/findSplList")
    public BaseResult findSplList(@RequestBody QuerySpl querySpl) {
        PageInfo<SportsProjectLibrary> pageInfo = splService.findSplList(querySpl);
        return pageInfo!=null?BaseResult.ok("查询成功",pageInfo):BaseResult.error("查询失败");
    }

    /**
     * 添加运动项目
     * @param sportsProjectLibrary
     * @return
     */
    @PostMapping("/addSpl")
    public BaseResult addSpl(@RequestBody SportsProjectLibrary sportsProjectLibrary) {
        int result = splService.addSpl(sportsProjectLibrary);
        return result==1?BaseResult.ok("添加成功"):BaseResult.error("该项目已存在！");
    }

    /**
     * 根据id查询运动项目
     * @param splId
     * @return
     */
    @GetMapping("/findSplById/{splId}")
    public BaseResult findSplById(@PathVariable(name = "splId") Integer splId) {
        SportsProjectLibrary sportsProjectLibrary = splService.findSplById(splId);
        return sportsProjectLibrary!=null?BaseResult.ok("查询成功",sportsProjectLibrary):BaseResult.error("查询失败");
    }

    /**
     * 修改运动项目
     * @param sportsProjectLibrary
     * @return
     */
    @PutMapping
    public BaseResult editSpl(@RequestBody SportsProjectLibrary sportsProjectLibrary) {
        int result = splService.editSpl(sportsProjectLibrary);
        return result==1?BaseResult.ok("修改成功"):BaseResult.error("修改失败");
    }

    /**
     * 删除运动项目
     * @param splId
     * @return
     */
    @DeleteMapping("/{splId}")
    public BaseResult deleteSpl(@PathVariable(name = "splId") Integer splId) {
        int result = splService.deleteSpl(splId);
        return result==1?BaseResult.ok("删除成功"):BaseResult.error("删除失败");
    }
}
