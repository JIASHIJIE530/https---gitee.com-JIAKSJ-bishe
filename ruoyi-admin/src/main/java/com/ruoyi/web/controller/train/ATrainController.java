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
import com.ruoyi.system.domain.ATrain;
import com.ruoyi.system.service.IATrainService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 实训Controller
 *
 * @author ruoyi
 * @date 2024-10-17
 */
@RestController
@RequestMapping("/train/trainInfo")
public class ATrainController extends BaseController
{
    @Autowired
    private IATrainService aTrainService;

    /**
     * 查询实训列表
     */
    @PreAuthorize("@ss.hasPermi('train:trainInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(ATrain aTrain)
    {
        startPage();
        List<ATrain> list = aTrainService.selectATrainList(aTrain);
        return getDataTable(list);
    }

    /**
     * 导出实训列表
     */
    @PreAuthorize("@ss.hasPermi('train:trainInfo:export')")
    @Log(title = "实训", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ATrain aTrain)
    {
        List<ATrain> list = aTrainService.selectATrainList(aTrain);
        ExcelUtil<ATrain> util = new ExcelUtil<ATrain>(ATrain.class);
        util.exportExcel(response, list, "实训数据");
    }

    /**
     * 获取实训详细信息
     */
    @PreAuthorize("@ss.hasPermi('train:trainInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(aTrainService.selectATrainById(id));
    }

    /**
     * 新增实训
     */
    @PreAuthorize("@ss.hasPermi('train:trainInfo:add')")
    @Log(title = "实训", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ATrain aTrain)
    {
        return toAjax(aTrainService.insertATrain(aTrain));
    }

    /**
     * 修改实训
     */
    @PreAuthorize("@ss.hasPermi('train:trainInfo:edit')")
    @Log(title = "实训", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ATrain aTrain)
    {
        return toAjax(aTrainService.updateATrain(aTrain));
    }

    /**
     * 删除实训
     */
    @PreAuthorize("@ss.hasPermi('train:trainInfo:remove')")
    @Log(title = "实训", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(aTrainService.deleteATrainByIds(ids));
    }
}
