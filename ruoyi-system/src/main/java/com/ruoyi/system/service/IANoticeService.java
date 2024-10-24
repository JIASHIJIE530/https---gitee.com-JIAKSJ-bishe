package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ANotice;

/**
 * 公告Service接口
 * 
 * @author ruoyi
 * @date 2024-10-17
 */
public interface IANoticeService 
{
    /**
     * 查询公告
     * 
     * @param id 公告主键
     * @return 公告
     */
    public ANotice selectANoticeById(Long id);

    /**
     * 查询公告列表
     * 
     * @param aNotice 公告
     * @return 公告集合
     */
    public List<ANotice> selectANoticeList(ANotice aNotice);

    /**
     * 新增公告
     * 
     * @param aNotice 公告
     * @return 结果
     */
    public int insertANotice(ANotice aNotice);

    /**
     * 修改公告
     * 
     * @param aNotice 公告
     * @return 结果
     */
    public int updateANotice(ANotice aNotice);

    /**
     * 批量删除公告
     * 
     * @param ids 需要删除的公告主键集合
     * @return 结果
     */
    public int deleteANoticeByIds(Long[] ids);

    /**
     * 删除公告信息
     * 
     * @param id 公告主键
     * @return 结果
     */
    public int deleteANoticeById(Long id);
}
