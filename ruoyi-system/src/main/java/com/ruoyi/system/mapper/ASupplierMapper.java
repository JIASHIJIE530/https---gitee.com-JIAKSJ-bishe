package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ASupplier;

/**
 * 供应商Mapper接口
 * 
 * @author ruoyi
 * @date 2024-10-17
 */
public interface ASupplierMapper 
{
    /**
     * 查询供应商
     * 
     * @param id 供应商主键
     * @return 供应商
     */
    public ASupplier selectASupplierById(Long id);

    /**
     * 查询供应商列表
     * 
     * @param aSupplier 供应商
     * @return 供应商集合
     */
    public List<ASupplier> selectASupplierList(ASupplier aSupplier);

    /**
     * 新增供应商
     * 
     * @param aSupplier 供应商
     * @return 结果
     */
    public int insertASupplier(ASupplier aSupplier);

    /**
     * 修改供应商
     * 
     * @param aSupplier 供应商
     * @return 结果
     */
    public int updateASupplier(ASupplier aSupplier);

    /**
     * 删除供应商
     * 
     * @param id 供应商主键
     * @return 结果
     */
    public int deleteASupplierById(Long id);

    /**
     * 批量删除供应商
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteASupplierByIds(Long[] ids);
}
