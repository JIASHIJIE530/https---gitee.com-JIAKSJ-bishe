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
import com.ruoyi.system.domain.AMaterial;
import com.ruoyi.system.service.IAMaterialService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 物料信息Controller
 *
 * @author ruoyi
 * @date 2024-10-17
 */
@RestController
@RequestMapping("/material/info")
public class AMaterialController extends BaseController
{
    @Autowired
    private IAMaterialService aMaterialService;

    /**
     * 查询物料信息列表
     */
    @PreAuthorize("@ss.hasPermi('material:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(AMaterial aMaterial)
    {
        startPage();
        List<AMaterial> list = aMaterialService.selectAMaterialList(aMaterial);
        return getDataTable(list);
    }

    /**
     * 导出物料信息列表
     */
    @PreAuthorize("@ss.hasPermi('material:info:export')")
    @Log(title = "物料信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AMaterial aMaterial)
    {
        List<AMaterial> list = aMaterialService.selectAMaterialList(aMaterial);
        ExcelUtil<AMaterial> util = new ExcelUtil<AMaterial>(AMaterial.class);
        util.exportExcel(response, list, "物料信息数据");
    }

    /**
     * 获取物料信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('material:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(aMaterialService.selectAMaterialById(id));
    }

    /**
     * 新增物料信息
     */
    @PreAuthorize("@ss.hasPermi('material:info:add')")
    @Log(title = "物料信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AMaterial aMaterial)
    {
        return toAjax(aMaterialService.insertAMaterial(aMaterial));
    }

    /**
     * 修改物料信息
     */
    @PreAuthorize("@ss.hasPermi('material:info:edit')")
    @Log(title = "物料信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AMaterial aMaterial)
    {
        return toAjax(aMaterialService.updateAMaterial(aMaterial));
    }

    /**
     * 删除物料信息
     */
    @PreAuthorize("@ss.hasPermi('material:info:remove')")
    @Log(title = "物料信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(aMaterialService.deleteAMaterialByIds(ids));
    }
}
