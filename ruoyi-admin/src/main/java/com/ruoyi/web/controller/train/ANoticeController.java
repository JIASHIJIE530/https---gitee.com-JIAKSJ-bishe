package com.ruoyi.web.controller.train;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.ANotice;
import com.ruoyi.system.service.IANoticeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 公告Controller
 *
 * @author ruoyi
 * @date 2024-10-17
 */
@RestController
@RequestMapping("/notice/info")
public class ANoticeController extends BaseController
{
    @Autowired
    private IANoticeService aNoticeService;

    /**
     * 查询公告列表
     */
    @PreAuthorize("@ss.hasPermi('notice:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(ANotice aNotice)
    {
        startPage();
        List<ANotice> list = aNoticeService.selectANoticeList(aNotice);
        return getDataTable(list);
    }

    /**
     * 导出公告列表
     */
    @PreAuthorize("@ss.hasPermi('notice:info:export')")
    @Log(title = "公告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ANotice aNotice)
    {
        List<ANotice> list = aNoticeService.selectANoticeList(aNotice);
        ExcelUtil<ANotice> util = new ExcelUtil<ANotice>(ANotice.class);
        util.exportExcel(response, list, "公告数据");
    }

    /**
     * 获取公告详细信息
     */
    @PreAuthorize("@ss.hasPermi('notice:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(aNoticeService.selectANoticeById(id));
    }

    /**
     * 新增公告
     */
    @PreAuthorize("@ss.hasPermi('notice:info:add')")
    @Log(title = "公告", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ANotice aNotice)
    {
        return toAjax(aNoticeService.insertANotice(aNotice));
    }

    /**
     * 修改公告
     */
    @PreAuthorize("@ss.hasPermi('notice:info:edit')")
    @Log(title = "公告", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ANotice aNotice)
    {
        return toAjax(aNoticeService.updateANotice(aNotice));
    }

    /**
     * 删除公告
     */
    @PreAuthorize("@ss.hasPermi('notice:info:remove')")
    @Log(title = "公告", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(aNoticeService.deleteANoticeByIds(ids));
    }
}
