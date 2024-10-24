package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.AReservation;

/**
 * 预约记录Service接口
 * 
 * @author ruoyi
 * @date 2024-10-17
 */
public interface IAReservationService 
{
    /**
     * 查询预约记录
     * 
     * @param id 预约记录主键
     * @return 预约记录
     */
    public AReservation selectAReservationById(Long id);

    /**
     * 查询预约记录列表
     * 
     * @param aReservation 预约记录
     * @return 预约记录集合
     */
    public List<AReservation> selectAReservationList(AReservation aReservation);

    /**
     * 新增预约记录
     * 
     * @param aReservation 预约记录
     * @return 结果
     */
    public int insertAReservation(AReservation aReservation);

    /**
     * 修改预约记录
     * 
     * @param aReservation 预约记录
     * @return 结果
     */
    public int updateAReservation(AReservation aReservation);

    /**
     * 批量删除预约记录
     * 
     * @param ids 需要删除的预约记录主键集合
     * @return 结果
     */
    public int deleteAReservationByIds(Long[] ids);

    /**
     * 删除预约记录信息
     * 
     * @param id 预约记录主键
     * @return 结果
     */
    public int deleteAReservationById(Long id);
}
