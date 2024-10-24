package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AReservationMapper;
import com.ruoyi.system.domain.AReservation;
import com.ruoyi.system.service.IAReservationService;

/**
 * 预约记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-17
 */
@Service
public class AReservationServiceImpl implements IAReservationService 
{
    @Autowired
    private AReservationMapper aReservationMapper;

    /**
     * 查询预约记录
     * 
     * @param id 预约记录主键
     * @return 预约记录
     */
    @Override
    public AReservation selectAReservationById(Long id)
    {
        return aReservationMapper.selectAReservationById(id);
    }

    /**
     * 查询预约记录列表
     * 
     * @param aReservation 预约记录
     * @return 预约记录
     */
    @Override
    public List<AReservation> selectAReservationList(AReservation aReservation)
    {
        return aReservationMapper.selectAReservationList(aReservation);
    }

    /**
     * 新增预约记录
     * 
     * @param aReservation 预约记录
     * @return 结果
     */
    @Override
    public int insertAReservation(AReservation aReservation)
    {
        return aReservationMapper.insertAReservation(aReservation);
    }

    /**
     * 修改预约记录
     * 
     * @param aReservation 预约记录
     * @return 结果
     */
    @Override
    public int updateAReservation(AReservation aReservation)
    {
        return aReservationMapper.updateAReservation(aReservation);
    }

    /**
     * 批量删除预约记录
     * 
     * @param ids 需要删除的预约记录主键
     * @return 结果
     */
    @Override
    public int deleteAReservationByIds(Long[] ids)
    {
        return aReservationMapper.deleteAReservationByIds(ids);
    }

    /**
     * 删除预约记录信息
     * 
     * @param id 预约记录主键
     * @return 结果
     */
    @Override
    public int deleteAReservationById(Long id)
    {
        return aReservationMapper.deleteAReservationById(id);
    }
}
