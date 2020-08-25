package com.czxy.health.controller;

import com.czxy.health.domain.FoodBank;
import com.czxy.health.service.FbService;
import com.czxy.health.vo.BaseResult;
import com.czxy.health.vo.QueryFb;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by xiongqi.
 */
@RestController
@RequestMapping("/fb")
public class FbController {
    @Resource
    private FbService fbService;

    /**
     * 分页查询膳食库列表
     * @param queryFb
     * @return
     */
    @PostMapping("/findFbList")
    public BaseResult findFbList(@RequestBody QueryFb queryFb) {
        PageInfo<FoodBank> pageInfo = fbService.findFbList(queryFb);
        return pageInfo!=null?BaseResult.ok("查询成功",pageInfo):BaseResult.error("查询失败");
    }

    /**
     * 添加食品
     * @param foodBank
     * @return
     */
    @PostMapping("/addFb")
    public BaseResult addFb(@RequestBody FoodBank foodBank) {
        int result = fbService.addFb(foodBank);
        return result==1?BaseResult.ok("添加成功！"):BaseResult.error("该食品已存在");
    }

    /**
     * 根据id查询食品
     * @param fbId
     * @return
     */
    @GetMapping("/findFbById/{fbId}")
    public BaseResult findFbById(@PathVariable(name = "fbId") Integer fbId) {
        FoodBank foodBank = fbService.findFbById(fbId);
        return foodBank!=null?BaseResult.ok("查询成功",foodBank):BaseResult.error("查询失败");
    }

    /**
     * 修改食品
     * @param foodBank
     * @return
     */
    @PutMapping
    public BaseResult editFb(@RequestBody FoodBank foodBank) {
        int result = fbService.editFb(foodBank);
        return result==1?BaseResult.ok("修改成功！"):BaseResult.error("修改失败");
    }

    /**
     * 删除食品
     * @param fbId
     * @return
     */
    @DeleteMapping("/{fbId}")
    public BaseResult deleteFb(@PathVariable(name = "fbId") Integer fbId) {
        int result = fbService.deleteFb(fbId);
        return result==1?BaseResult.ok("删除成功！"):BaseResult.error("删除失败");
    }
}
