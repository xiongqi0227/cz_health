package com.czxy.health.controller;

import com.czxy.health.domain.MemberProfileDynamicInformation;
import com.czxy.health.domain.MemberProfileEssentialInformation;
import com.czxy.health.domain.MemberProfileMedicalHistory;
import com.czxy.health.service.MPEIService;
import com.czxy.health.utils.CreateMPNumber;
import com.czxy.health.vo.BaseResult;
import com.czxy.health.vo.MPVo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by xiongqi.
 */
@RestController
@RequestMapping("/mp")
public class MPEIController {
    @Resource
    private MPEIService mpeiService;

    /**
     * 分页条件查询会员列表
     *
     * @param mpVo
     * @return
     */
    @PostMapping("/findMPList")
    public BaseResult findMPList(@RequestBody MPVo mpVo) {
        PageInfo<MemberProfileEssentialInformation> pageInfo = mpeiService.findMPList(mpVo);
        return pageInfo != null ? BaseResult.ok("查询成功", pageInfo) : BaseResult.error("查询失败");
    }

    /**
     * 添加会员（基本信息）
     *
     * @param mpei
     * @return
     */
    @PostMapping("/addMpei")
    public BaseResult addMpei(@RequestBody MemberProfileEssentialInformation mpei) {
        int mpeiId = mpeiService.addMpei(mpei);
        return mpeiId != 0 ? BaseResult.ok("添加成功") : BaseResult.error("添加失败");
    }

    /**
     * 添加会员（动态信息）
     *
     * @param mpdi
     * @return
     */
    @PostMapping("/addMpDi")
    public BaseResult addMpDi(@RequestBody MemberProfileDynamicInformation mpdi) {
        int result = mpeiService.addMpDi(mpdi);
        return result == 1 ? BaseResult.ok("添加成功") : BaseResult.error("添加失败");
    }

    /**
     * 添加会员（病史）
     *
     * @param mpmh
     * @return
     */
    @PostMapping("/addMpMh")
    public BaseResult addMpMh(@RequestBody MemberProfileMedicalHistory mpmh) {
        int result = mpeiService.addMpMh(mpmh);
        return result == 1 ? BaseResult.ok("添加成功") : BaseResult.error("添加失败");
    }

    /**
     * 生成档案号
     *
     * @return
     */
    @GetMapping("/getMPNumber")
    public BaseResult getMPNumber() {
        return BaseResult.ok("生成", CreateMPNumber.getMPNumber());
    }

    /**
     * 删除会员档案
     *
     * @param mpId
     * @return
     */
    @DeleteMapping("/{mpId}")
    public BaseResult deleteMp(@PathVariable(name = "mpId") Integer mpId) {
        int result = mpeiService.deleteMp(mpId);
        return result == 1 ? BaseResult.ok("删除成功") : BaseResult.error("删除失败");
    }

    /**
     * 根据id查询会员档案（基本信息）
     *
     * @param mpId
     * @return
     */
    @GetMapping("/findMpEiById/{mpId}")
    public BaseResult findMpEiById(@PathVariable(name = "mpId") Integer mpId) {
        MemberProfileEssentialInformation mpei = mpeiService.findMpEiById(mpId);
        return mpei != null ? BaseResult.ok("查询成功", mpei) : BaseResult.error("查询失败");
    }

    /**
     * 根据id查询会员档案（动态信息）
     *
     * @param mpId
     * @return
     */
    @GetMapping("/findMpDiById/{mpId}")
    public BaseResult findMpDiById(@PathVariable(name = "mpId") Integer mpId) {
        MemberProfileDynamicInformation mpdi = mpeiService.findMpDiById(mpId);
        return mpdi != null ? BaseResult.ok("查询成功", mpdi) : BaseResult.error("查询失败");
    }

    /**
     * 根据id查询会员档案（病史）
     *
     * @param mpId
     * @return
     */
    @GetMapping("/findMpMhById/{mpId}")
    public BaseResult findMpMhById(@PathVariable(name = "mpId") Integer mpId) {
        MemberProfileMedicalHistory mpmh = mpeiService.findMpMhById(mpId);
        return mpmh != null ? BaseResult.ok("查询成功", mpmh) : BaseResult.error("查询失败");
    }

    /**
     * 修改会员档案（基本信息）
     *
     * @param mpei
     * @return
     */
    @PutMapping("/editMpei")
    public BaseResult editMpei(@RequestBody MemberProfileEssentialInformation mpei) {
        int result = mpeiService.editMpei(mpei);
        return result == 1 ? BaseResult.ok("修改成功") : BaseResult.error("修改失败");
    }

    /**
     * 修改会员档案（动态信息）
     *
     * @param mpdi
     * @return
     */
    @PutMapping("/editMpdi")
    public BaseResult editMpdi(@RequestBody MemberProfileDynamicInformation mpdi) {
        int result = mpeiService.editMpdi(mpdi);
        return result == 1 ? BaseResult.ok("修改成功") : BaseResult.error("修改失败");
    }

    /**
     * 修改会员档案（病史）
     *
     * @param mpmh
     * @return
     */
    @PutMapping("/editMpmh")
    public BaseResult editMpmh(@RequestBody MemberProfileMedicalHistory mpmh) {
        int result = mpeiService.editMpmh(mpmh);
        return result == 1 ? BaseResult.ok("修改成功") : BaseResult.error("修改失败");
    }

}
