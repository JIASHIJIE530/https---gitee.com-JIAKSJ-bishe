package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物料信息对象 a_material
 * 
 * @author ruoyi
 * @date 2024-10-17
 */
public class AMaterial extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 类别 */
    @Excel(name = "类别")
    private String category;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private Long count;

    /** 价格 */
    @Excel(name = "价格")
    private Long price;

    /** 供应商 */
    @Excel(name = "供应商")
    private Long supplierId;

    /** 批次 */
    @Excel(name = "批次")
    private Long batch;

    /** 使用说明 */
    @Excel(name = "使用说明")
    private String introduction;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCategory(String category) 
    {
        this.category = category;
    }

    public String getCategory() 
    {
        return category;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setCount(Long count) 
    {
        this.count = count;
    }

    public Long getCount() 
    {
        return count;
    }
    public void setPrice(Long price) 
    {
        this.price = price;
    }

    public Long getPrice() 
    {
        return price;
    }
    public void setSupplierId(Long supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() 
    {
        return supplierId;
    }
    public void setBatch(Long batch) 
    {
        this.batch = batch;
    }

    public Long getBatch() 
    {
        return batch;
    }
    public void setIntroduction(String introduction) 
    {
        this.introduction = introduction;
    }

    public String getIntroduction() 
    {
        return introduction;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("category", getCategory())
            .append("name", getName())
            .append("unit", getUnit())
            .append("count", getCount())
            .append("price", getPrice())
            .append("supplierId", getSupplierId())
            .append("batch", getBatch())
            .append("introduction", getIntroduction())
            .toString();
    }
}
