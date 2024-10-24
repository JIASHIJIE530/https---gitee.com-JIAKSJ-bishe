package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 实训对象 a_train
 * 
 * @author ruoyi
 * @date 2024-10-17
 */
public class ATrain extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 实训id */
    private Long id;

    /** 实训名称 */
    @Excel(name = "实训名称")
    private String name;

    /** 描述 */
    @Excel(name = "描述")
    private String description;

    /** 负责人 */
    @Excel(name = "负责人")
    private String trainLeader;

    /** 负责人手机号 */
    @Excel(name = "负责人手机号")
    private String phone;

    /** 实训时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "实训时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date trainTime;

    /** 实训室id */
    @Excel(name = "实训室id")
    private Long trainRoomId;

    /** 实训容量 */
    @Excel(name = "实训容量")
    private Long trainCapacity;

    /** 实训要求 */
    @Excel(name = "实训要求")
    private String trainRequire;

    /** 公告 */
    @Excel(name = "公告")
    private String notice;

    /** 实训目标 */
    @Excel(name = "实训目标")
    private String trainTarget;

    /** 参与者名单 */
    @Excel(name = "参与者名单")
    private String participants;

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
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setTrainLeader(String trainLeader) 
    {
        this.trainLeader = trainLeader;
    }

    public String getTrainLeader() 
    {
        return trainLeader;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setTrainTime(Date trainTime) 
    {
        this.trainTime = trainTime;
    }

    public Date getTrainTime() 
    {
        return trainTime;
    }
    public void setTrainRoomId(Long trainRoomId) 
    {
        this.trainRoomId = trainRoomId;
    }

    public Long getTrainRoomId() 
    {
        return trainRoomId;
    }
    public void setTrainCapacity(Long trainCapacity) 
    {
        this.trainCapacity = trainCapacity;
    }

    public Long getTrainCapacity() 
    {
        return trainCapacity;
    }
    public void setTrainRequire(String trainRequire) 
    {
        this.trainRequire = trainRequire;
    }

    public String getTrainRequire() 
    {
        return trainRequire;
    }
    public void setNotice(String notice) 
    {
        this.notice = notice;
    }

    public String getNotice() 
    {
        return notice;
    }
    public void setTrainTarget(String trainTarget) 
    {
        this.trainTarget = trainTarget;
    }

    public String getTrainTarget() 
    {
        return trainTarget;
    }
    public void setParticipants(String participants) 
    {
        this.participants = participants;
    }

    public String getParticipants() 
    {
        return participants;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("description", getDescription())
            .append("trainLeader", getTrainLeader())
            .append("phone", getPhone())
            .append("trainTime", getTrainTime())
            .append("trainRoomId", getTrainRoomId())
            .append("trainCapacity", getTrainCapacity())
            .append("trainRequire", getTrainRequire())
            .append("notice", getNotice())
            .append("trainTarget", getTrainTarget())
            .append("participants", getParticipants())
            .toString();
    }
}
