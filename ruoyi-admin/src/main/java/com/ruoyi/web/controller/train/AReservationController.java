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
import com.ruoyi.system.domain.AReservation;
import com.ruoyi.system.service.IAReservationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 预约记录Controller
 *
 * @author ruoyi
 * @date 2024-10-17
 */
@RestController
@RequestMapping("/trainroom/reservation")
public class AReservationController extends BaseController
{
    @Autowired
    private IAReservationService aReservationService;

    /**
     * 查询预约记录列表
     */
    @PreAuthorize("@ss.hasPermi('trainroom:reservation:list')")
    @GetMapping("/list")
    public TableDataInfo list(AReservation aReservation)
    {
        startPage();
        List<AReservation> list = aReservationService.selectAReservationList(aReservation);
        return getDataTable(list);
    }

    /**
     * 导出预约记录列表
     */
    @PreAuthorize("@ss.hasPermi('trainroom:reservation:export')")
    @Log(title = "预约记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AReservation aReservation)
    {
        List<AReservation> list = aReservationService.selectAReservationList(aReservation);
        ExcelUtil<AReservation> util = new ExcelUtil<AReservation>(AReservation.class);
        util.exportExcel(response, list, "预约记录数据");
    }

    /**
     * 获取预约记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('trainroom:reservation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(aReservationService.selectAReservationById(id));
    }

    /**
     * 新增预约记录
     */
    @PreAuthorize("@ss.hasPermi('trainroom:reservation:add')")
    @Log(title = "预约记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AReservation aReservation)
    {
        return toAjax(aReservationService.insertAReservation(aReservation));
    }

    /**
     * 修改预约记录
     */
    @PreAuthorize("@ss.hasPermi('trainroom:reservation:edit')")
    @Log(title = "预约记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AReservation aReservation)
    {
        return toAjax(aReservationService.updateAReservation(aReservation));
    }

    /**
     * 删除预约记录
     */
    @PreAuthorize("@ss.hasPermi('trainroom:reservation:remove')")
    @Log(title = "预约记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(aReservationService.deleteAReservationByIds(ids));
    }
}
