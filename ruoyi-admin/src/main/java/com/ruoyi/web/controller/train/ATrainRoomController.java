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
import com.ruoyi.system.domain.ATrainRoom;
import com.ruoyi.system.service.IATrainRoomService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 实训室信息Controller
 *
 * @author ruoyi
 * @date 2024-10-17
 */
@RestController
@RequestMapping("/trainroom/room")
public class ATrainRoomController extends BaseController
{
    @Autowired
    private IATrainRoomService aTrainRoomService;

    /**
     * 查询实训室信息列表
     */
    @PreAuthorize("@ss.hasPermi('trainroom:room:list')")
    @GetMapping("/list")
    public TableDataInfo list(ATrainRoom aTrainRoom)
    {
        startPage();
        List<ATrainRoom> list = aTrainRoomService.selectATrainRoomList(aTrainRoom);
        return getDataTable(list);
    }

    /**
     * 导出实训室信息列表
     */
    @PreAuthorize("@ss.hasPermi('trainroom:room:export')")
    @Log(title = "实训室信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ATrainRoom aTrainRoom)
    {
        List<ATrainRoom> list = aTrainRoomService.selectATrainRoomList(aTrainRoom);
        ExcelUtil<ATrainRoom> util = new ExcelUtil<ATrainRoom>(ATrainRoom.class);
        util.exportExcel(response, list, "实训室信息数据");
    }

    /**
     * 获取实训室信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('trainroom:room:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(aTrainRoomService.selectATrainRoomById(id));
    }

    /**
     * 新增实训室信息
     */
    @PreAuthorize("@ss.hasPermi('trainroom:room:add')")
    @Log(title = "实训室信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ATrainRoom aTrainRoom)
    {
        return toAjax(aTrainRoomService.insertATrainRoom(aTrainRoom));
    }

    /**
     * 修改实训室信息
     */
    @PreAuthorize("@ss.hasPermi('trainroom:room:edit')")
    @Log(title = "实训室信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ATrainRoom aTrainRoom)
    {
        return toAjax(aTrainRoomService.updateATrainRoom(aTrainRoom));
    }

    /**
     * 删除实训室信息
     */
    @PreAuthorize("@ss.hasPermi('trainroom:room:remove')")
    @Log(title = "实训室信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(aTrainRoomService.deleteATrainRoomByIds(ids));
    }
}
