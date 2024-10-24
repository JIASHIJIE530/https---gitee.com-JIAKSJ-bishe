package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ATrainRoom;

/**
 * 实训室信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-10-17
 */
public interface ATrainRoomMapper 
{
    /**
     * 查询实训室信息
     * 
     * @param id 实训室信息主键
     * @return 实训室信息
     */
    public ATrainRoom selectATrainRoomById(Long id);

    /**
     * 查询实训室信息列表
     * 
     * @param aTrainRoom 实训室信息
     * @return 实训室信息集合
     */
    public List<ATrainRoom> selectATrainRoomList(ATrainRoom aTrainRoom);

    /**
     * 新增实训室信息
     * 
     * @param aTrainRoom 实训室信息
     * @return 结果
     */
    public int insertATrainRoom(ATrainRoom aTrainRoom);

    /**
     * 修改实训室信息
     * 
     * @param aTrainRoom 实训室信息
     * @return 结果
     */
    public int updateATrainRoom(ATrainRoom aTrainRoom);

    /**
     * 删除实训室信息
     * 
     * @param id 实训室信息主键
     * @return 结果
     */
    public int deleteATrainRoomById(Long id);

    /**
     * 批量删除实训室信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteATrainRoomByIds(Long[] ids);
}
