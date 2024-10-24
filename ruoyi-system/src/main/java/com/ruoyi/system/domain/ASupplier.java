package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 供应商对象 a_supplier
 * 
 * @author ruoyi
 * @date 2024-10-17
 */
public class ASupplier extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 供应商id */
    private Long id;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 负责人 */
    @Excel(name = "负责人")
    private String leader;

    /** 企业名称 */
    @Excel(name = "企业名称")
    private String name;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setLeader(String leader) 
    {
        this.leader = leader;
    }

    public String getLeader() 
    {
        return leader;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("phone", getPhone())
            .append("leader", getLeader())
            .append("name", getName())
            .toString();
    }
}
