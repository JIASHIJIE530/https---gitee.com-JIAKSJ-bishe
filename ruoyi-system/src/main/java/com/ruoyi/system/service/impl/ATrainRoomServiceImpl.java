package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ATrainRoomMapper;
import com.ruoyi.system.domain.ATrainRoom;
import com.ruoyi.system.service.IATrainRoomService;

/**
 * 实训室信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-17
 */
@Service
public class ATrainRoomServiceImpl implements IATrainRoomService 
{
    @Autowired
    private ATrainRoomMapper aTrainRoomMapper;

    /**
     * 查询实训室信息
     * 
     * @param id 实训室信息主键
     * @return 实训室信息
     */
    @Override
    public ATrainRoom selectATrainRoomById(Long id)
    {
        return aTrainRoomMapper.selectATrainRoomById(id);
    }

    /**
     * 查询实训室信息列表
     * 
     * @param aTrainRoom 实训室信息
     * @return 实训室信息
     */
    @Override
    public List<ATrainRoom> selectATrainRoomList(ATrainRoom aTrainRoom)
    {
        return aTrainRoomMapper.selectATrainRoomList(aTrainRoom);
    }

    /**
     * 新增实训室信息
     * 
     * @param aTrainRoom 实训室信息
     * @return 结果
     */
    @Override
    public int insertATrainRoom(ATrainRoom aTrainRoom)
    {
        return aTrainRoomMapper.insertATrainRoom(aTrainRoom);
    }

    /**
     * 修改实训室信息
     * 
     * @param aTrainRoom 实训室信息
     * @return 结果
     */
    @Override
    public int updateATrainRoom(ATrainRoom aTrainRoom)
    {
        return aTrainRoomMapper.updateATrainRoom(aTrainRoom);
    }

    /**
     * 批量删除实训室信息
     * 
     * @param ids 需要删除的实训室信息主键
     * @return 结果
     */
    @Override
    public int deleteATrainRoomByIds(Long[] ids)
    {
        return aTrainRoomMapper.deleteATrainRoomByIds(ids);
    }

    /**
     * 删除实训室信息信息
     * 
     * @param id 实训室信息主键
     * @return 结果
     */
    @Override
    public int deleteATrainRoomById(Long id)
    {
        return aTrainRoomMapper.deleteATrainRoomById(id);
    }
}
