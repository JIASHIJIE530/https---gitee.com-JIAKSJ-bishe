package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ANoticeMapper;
import com.ruoyi.system.domain.ANotice;
import com.ruoyi.system.service.IANoticeService;

/**
 * 公告Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-17
 */
@Service
public class ANoticeServiceImpl implements IANoticeService 
{
    @Autowired
    private ANoticeMapper aNoticeMapper;

    /**
     * 查询公告
     * 
     * @param id 公告主键
     * @return 公告
     */
    @Override
    public ANotice selectANoticeById(Long id)
    {
        return aNoticeMapper.selectANoticeById(id);
    }

    /**
     * 查询公告列表
     * 
     * @param aNotice 公告
     * @return 公告
     */
    @Override
    public List<ANotice> selectANoticeList(ANotice aNotice)
    {
        return aNoticeMapper.selectANoticeList(aNotice);
    }

    /**
     * 新增公告
     * 
     * @param aNotice 公告
     * @return 结果
     */
    @Override
    public int insertANotice(ANotice aNotice)
    {
        return aNoticeMapper.insertANotice(aNotice);
    }

    /**
     * 修改公告
     * 
     * @param aNotice 公告
     * @return 结果
     */
    @Override
    public int updateANotice(ANotice aNotice)
    {
        return aNoticeMapper.updateANotice(aNotice);
    }

    /**
     * 批量删除公告
     * 
     * @param ids 需要删除的公告主键
     * @return 结果
     */
    @Override
    public int deleteANoticeByIds(Long[] ids)
    {
        return aNoticeMapper.deleteANoticeByIds(ids);
    }

    /**
     * 删除公告信息
     * 
     * @param id 公告主键
     * @return 结果
     */
    @Override
    public int deleteANoticeById(Long id)
    {
        return aNoticeMapper.deleteANoticeById(id);
    }
}
