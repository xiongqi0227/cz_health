package com.czxy.health.controller;

import com.czxy.health.domain.DiseaseBank;
import com.czxy.health.service.DbService;
import com.czxy.health.vo.BaseResult;
import com.czxy.health.vo.QueryDb;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by xiongqi.
 */
@RestController
@RequestMapping("/db")
public class DbController {
    @Resource
    private DbService dbService;

    /**
     * 分页条件查询疾病库
     *
     * @param queryDb
     * @return
     */
    @PostMapping("findDbList")
    public BaseResult findDbList(@RequestBody QueryDb queryDb) {
        PageInfo<DiseaseBank> pageInfo = dbService.findDbList(queryDb);
        return pageInfo != null ? BaseResult.ok("查询成功", pageInfo) : BaseResult.error("查询失败");
    }

    /**
     * 添加疾病
     *
     * @param diseaseBank
     * @return
     */
    @PostMapping("/addDb")
    public BaseResult addDb(@RequestBody DiseaseBank diseaseBank) {
        int result = dbService.addDb(diseaseBank);
        return result == 1 ? BaseResult.ok("添加成功") : BaseResult.error("添加失败");
    }

    /**
     * 根据id查询疾病
     *
     * @param dbId
     * @return
     */
    @GetMapping("/findDbById/{dbId}")
    public BaseResult findDbById(@PathVariable(name = "dbId") Integer dbId) {
        DiseaseBank diseaseBank = dbService.findDbById(dbId);
        return diseaseBank != null ? BaseResult.ok("查询成功", diseaseBank) : BaseResult.error("查询失败");
    }

    /**
     * 修改疾病
     *
     * @param diseaseBank
     * @return
     */
    @PutMapping
    public BaseResult editDb(@RequestBody DiseaseBank diseaseBank) {
        int result = dbService.editDb(diseaseBank);
        return result == 1 ? BaseResult.ok("修改成功") : BaseResult.error("修改失败");
    }

    /**
     * 删除疾病
     *
     * @param dbId
     * @return
     */
    @DeleteMapping("/{dbId}")
    private BaseResult deleteDb(@PathVariable(name = "dbId") Integer dbId) {
        int result = dbService.deleteDb(dbId);
        return result == 1 ? BaseResult.ok("删除成功") : BaseResult.error("删除失败");
    }
}
