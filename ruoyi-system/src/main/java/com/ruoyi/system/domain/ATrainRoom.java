package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 实训室信息对象 a_train_room
 * 
 * @author ruoyi
 * @date 2024-10-17
 */
public class ATrainRoom extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 实训室id */
    private Long id;

    /** 实训室名称 */
    @Excel(name = "实训室名称")
    private String name;

    /** 位置信息 */
    @Excel(name = "位置信息")
    private String place;

    /** 容纳人数 */
    @Excel(name = "容纳人数")
    private Long userCapacity;

    /** 设备清单 */
    @Excel(name = "设备清单")
    private String equipment;

    /** 使用状态 0未使用 1使用中 */
    @Excel(name = "使用状态 0未使用 1使用中")
    private Long useStatus;

    /** 实训室负责人 */
    @Excel(name = "实训室负责人")
    private String roomLeader;

    /** 开放开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开放开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date openStartTime;

    /** 开放结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开放结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date openEndTime;

    /** 负责人联系方式 */
    @Excel(name = "负责人联系方式")
    private String leaderContact;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPlace(String place) 
    {
        this.place = place;
    }

    public String getPlace() 
    {
        return place;
    }
    public void setUserCapacity(Long userCapacity) 
    {
        this.userCapacity = userCapacity;
    }

    public Long getUserCapacity() 
    {
        return userCapacity;
    }
    public void setEquipment(String equipment) 
    {
        this.equipment = equipment;
    }

    public String getEquipment() 
    {
        return equipment;
    }
    public void setUseStatus(Long useStatus) 
    {
        this.useStatus = useStatus;
    }

    public Long getUseStatus() 
    {
        return useStatus;
    }
    public void setRoomLeader(String roomLeader) 
    {
        this.roomLeader = roomLeader;
    }

    public String getRoomLeader() 
    {
        return roomLeader;
    }
    public void setOpenStartTime(Date openStartTime) 
    {
        this.openStartTime = openStartTime;
    }

    public Date getOpenStartTime() 
    {
        return openStartTime;
    }
    public void setOpenEndTime(Date openEndTime) 
    {
        this.openEndTime = openEndTime;
    }

    public Date getOpenEndTime() 
    {
        return openEndTime;
    }
    public void setLeaderContact(String leaderContact) 
    {
        this.leaderContact = leaderContact;
    }

    public String getLeaderContact() 
    {
        return leaderContact;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("place", getPlace())
            .append("userCapacity", getUserCapacity())
            .append("equipment", getEquipment())
            .append("useStatus", getUseStatus())
            .append("roomLeader", getRoomLeader())
            .append("openStartTime", getOpenStartTime())
            .append("openEndTime", getOpenEndTime())
            .append("leaderContact", getLeaderContact())
            .append("remark", getRemark())
            .toString();
    }
}
