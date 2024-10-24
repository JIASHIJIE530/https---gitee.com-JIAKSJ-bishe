package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AMaterialMapper;
import com.ruoyi.system.domain.AMaterial;
import com.ruoyi.system.service.IAMaterialService;

/**
 * 物料信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-17
 */
@Service
public class AMaterialServiceImpl implements IAMaterialService 
{
    @Autowired
    private AMaterialMapper aMaterialMapper;

    /**
     * 查询物料信息
     * 
     * @param id 物料信息主键
     * @return 物料信息
     */
    @Override
    public AMaterial selectAMaterialById(Long id)
    {
        return aMaterialMapper.selectAMaterialById(id);
    }

    /**
     * 查询物料信息列表
     * 
     * @param aMaterial 物料信息
     * @return 物料信息
     */
    @Override
    public List<AMaterial> selectAMaterialList(AMaterial aMaterial)
    {
        return aMaterialMapper.selectAMaterialList(aMaterial);
    }

    /**
     * 新增物料信息
     * 
     * @param aMaterial 物料信息
     * @return 结果
     */
    @Override
    public int insertAMaterial(AMaterial aMaterial)
    {
        return aMaterialMapper.insertAMaterial(aMaterial);
    }

    /**
     * 修改物料信息
     * 
     * @param aMaterial 物料信息
     * @return 结果
     */
    @Override
    public int updateAMaterial(AMaterial aMaterial)
    {
        return aMaterialMapper.updateAMaterial(aMaterial);
    }

    /**
     * 批量删除物料信息
     * 
     * @param ids 需要删除的物料信息主键
     * @return 结果
     */
    @Override
    public int deleteAMaterialByIds(Long[] ids)
    {
        return aMaterialMapper.deleteAMaterialByIds(ids);
    }

    /**
     * 删除物料信息信息
     * 
     * @param id 物料信息主键
     * @return 结果
     */
    @Override
    public int deleteAMaterialById(Long id)
    {
        return aMaterialMapper.deleteAMaterialById(id);
    }
}
