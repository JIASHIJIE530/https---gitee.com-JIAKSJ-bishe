package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ATrainMapper;
import com.ruoyi.system.domain.ATrain;
import com.ruoyi.system.service.IATrainService;

/**
 * 实训Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-17
 */
@Service
public class ATrainServiceImpl implements IATrainService 
{
    @Autowired
    private ATrainMapper aTrainMapper;

    /**
     * 查询实训
     * 
     * @param id 实训主键
     * @return 实训
     */
    @Override
    public ATrain selectATrainById(Long id)
    {
        return aTrainMapper.selectATrainById(id);
    }

    /**
     * 查询实训列表
     * 
     * @param aTrain 实训
     * @return 实训
     */
    @Override
    public List<ATrain> selectATrainList(ATrain aTrain)
    {
        return aTrainMapper.selectATrainList(aTrain);
    }

    /**
     * 新增实训
     * 
     * @param aTrain 实训
     * @return 结果
     */
    @Override
    public int insertATrain(ATrain aTrain)
    {
        return aTrainMapper.insertATrain(aTrain);
    }

    /**
     * 修改实训
     * 
     * @param aTrain 实训
     * @return 结果
     */
    @Override
    public int updateATrain(ATrain aTrain)
    {
        return aTrainMapper.updateATrain(aTrain);
    }

    /**
     * 批量删除实训
     * 
     * @param ids 需要删除的实训主键
     * @return 结果
     */
    @Override
    public int deleteATrainByIds(Long[] ids)
    {
        return aTrainMapper.deleteATrainByIds(ids);
    }

    /**
     * 删除实训信息
     * 
     * @param id 实训主键
     * @return 结果
     */
    @Override
    public int deleteATrainById(Long id)
    {
        return aTrainMapper.deleteATrainById(id);
    }
}
