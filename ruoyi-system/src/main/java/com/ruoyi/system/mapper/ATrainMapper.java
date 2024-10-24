package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ATrain;

/**
 * 实训Mapper接口
 * 
 * @author ruoyi
 * @date 2024-10-17
 */
public interface ATrainMapper 
{
    /**
     * 查询实训
     * 
     * @param id 实训主键
     * @return 实训
     */
    public ATrain selectATrainById(Long id);

    /**
     * 查询实训列表
     * 
     * @param aTrain 实训
     * @return 实训集合
     */
    public List<ATrain> selectATrainList(ATrain aTrain);

    /**
     * 新增实训
     * 
     * @param aTrain 实训
     * @return 结果
     */
    public int insertATrain(ATrain aTrain);

    /**
     * 修改实训
     * 
     * @param aTrain 实训
     * @return 结果
     */
    public int updateATrain(ATrain aTrain);

    /**
     * 删除实训
     * 
     * @param id 实训主键
     * @return 结果
     */
    public int deleteATrainById(Long id);

    /**
     * 批量删除实训
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteATrainByIds(Long[] ids);
}
