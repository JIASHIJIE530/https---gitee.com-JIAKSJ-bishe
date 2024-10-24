package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ASupplierMapper;
import com.ruoyi.system.domain.ASupplier;
import com.ruoyi.system.service.IASupplierService;

/**
 * 供应商Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-17
 */
@Service
public class ASupplierServiceImpl implements IASupplierService 
{
    @Autowired
    private ASupplierMapper aSupplierMapper;

    /**
     * 查询供应商
     * 
     * @param id 供应商主键
     * @return 供应商
     */
    @Override
    public ASupplier selectASupplierById(Long id)
    {
        return aSupplierMapper.selectASupplierById(id);
    }

    /**
     * 查询供应商列表
     * 
     * @param aSupplier 供应商
     * @return 供应商
     */
    @Override
    public List<ASupplier> selectASupplierList(ASupplier aSupplier)
    {
        return aSupplierMapper.selectASupplierList(aSupplier);
    }

    /**
     * 新增供应商
     * 
     * @param aSupplier 供应商
     * @return 结果
     */
    @Override
    public int insertASupplier(ASupplier aSupplier)
    {
        return aSupplierMapper.insertASupplier(aSupplier);
    }

    /**
     * 修改供应商
     * 
     * @param aSupplier 供应商
     * @return 结果
     */
    @Override
    public int updateASupplier(ASupplier aSupplier)
    {
        return aSupplierMapper.updateASupplier(aSupplier);
    }

    /**
     * 批量删除供应商
     * 
     * @param ids 需要删除的供应商主键
     * @return 结果
     */
    @Override
    public int deleteASupplierByIds(Long[] ids)
    {
        return aSupplierMapper.deleteASupplierByIds(ids);
    }

    /**
     * 删除供应商信息
     * 
     * @param id 供应商主键
     * @return 结果
     */
    @Override
    public int deleteASupplierById(Long id)
    {
        return aSupplierMapper.deleteASupplierById(id);
    }
}
