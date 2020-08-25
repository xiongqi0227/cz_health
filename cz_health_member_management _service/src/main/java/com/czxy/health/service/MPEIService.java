package com.czxy.health.service;

import com.czxy.health.domain.MemberProfileDynamicInformation;
import com.czxy.health.domain.MemberProfileEssentialInformation;
import com.czxy.health.domain.MemberProfileMedicalHistory;
import com.czxy.health.vo.MPVo;
import com.github.pagehelper.PageInfo;

/**
 * Created by xiongqi.
 */
public interface MPEIService {
    /**
     * 分页条件查询会员列表
     *
     * @param mpVo
     * @return
     */
    PageInfo<MemberProfileEssentialInformation> findMPList(MPVo mpVo);

    /**
     * 添加会员档案（基本信息）
     *
     * @param mpei
     * @return
     */
    int addMpei(MemberProfileEssentialInformation mpei);

    /**
     * 添加会员档案（动态信息）
     *
     * @param mpdi
     * @return
     */
    int addMpDi(MemberProfileDynamicInformation mpdi);

    /**
     * 添加会员（病史）
     *
     * @param mpmh
     * @return
     */
    int addMpMh(MemberProfileMedicalHistory mpmh);

    /**
     * 删除会员档案
     *
     * @param mpId
     * @return
     */
    int deleteMp(Integer mpId);

    /**
     * 根据id查询会员档案（基本信息）
     *
     * @param mpId
     * @return
     */
    MemberProfileEssentialInformation findMpEiById(Integer mpId);

    /**
     * 根据id查询会员档案（动态信息）
     *
     * @param mpId
     * @return
     */
    MemberProfileDynamicInformation findMpDiById(Integer mpId);

    /**
     * 根据id查询会员档案（病史）
     *
     * @param mpId
     * @return
     */
    MemberProfileMedicalHistory findMpMhById(Integer mpId);

    /**
     * 修改会员档案（基本信息）
     *
     * @param mpei
     * @return
     */
    int editMpei(MemberProfileEssentialInformation mpei);

    /**
     * 修改会员档案（动态信息）
     *
     * @param mpdi
     * @return
     */
    int editMpdi(MemberProfileDynamicInformation mpdi);

    /**
     * 修改会员档案（病史）
     *
     * @param mpmh
     * @return
     */
    int editMpmh(MemberProfileMedicalHistory mpmh);
}
