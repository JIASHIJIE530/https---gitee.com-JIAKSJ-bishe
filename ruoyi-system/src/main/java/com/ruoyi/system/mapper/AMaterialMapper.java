package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.AMaterial;

/**
 * 物料信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-10-17
 */
public interface AMaterialMapper 
{
    /**
     * 查询物料信息
     * 
     * @param id 物料信息主键
     * @return 物料信息
     */
    public AMaterial selectAMaterialById(Long id);

    /**
     * 查询物料信息列表
     * 
     * @param aMaterial 物料信息
     * @return 物料信息集合
     */
    public List<AMaterial> selectAMaterialList(AMaterial aMaterial);

    /**
     * 新增物料信息
     * 
     * @param aMaterial 物料信息
     * @return 结果
     */
    public int insertAMaterial(AMaterial aMaterial);

    /**
     * 修改物料信息
     * 
     * @param aMaterial 物料信息
     * @return 结果
     */
    public int updateAMaterial(AMaterial aMaterial);

    /**
     * 删除物料信息
     * 
     * @param id 物料信息主键
     * @return 结果
     */
    public int deleteAMaterialById(Long id);

    /**
     * 批量删除物料信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAMaterialByIds(Long[] ids);
}
