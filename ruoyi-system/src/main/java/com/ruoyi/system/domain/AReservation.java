package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 预约记录对象 a_reservation
 * 
 * @author ruoyi
 * @date 2024-10-17
 */
public class AReservation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 预约id */
    private Long id;

    /** 预约人id */
    @Excel(name = "预约人id")
    private Long userId;

    /** 预约状态 0逾期 1使用中 2已完成 */
    @Excel(name = "预约状态 0逾期 1使用中 2已完成")
    private Long resStatus;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setResStatus(Long resStatus) 
    {
        this.resStatus = resStatus;
    }

    public Long getResStatus() 
    {
        return resStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("resStatus", getResStatus())
            .toString();
    }
}
