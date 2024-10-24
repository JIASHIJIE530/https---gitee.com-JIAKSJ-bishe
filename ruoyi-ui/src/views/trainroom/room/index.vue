<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="实训室名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入实训室名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="位置信息" prop="place">
        <el-input
          v-model="queryParams.place"
          placeholder="请输入位置信息"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="容纳人数" prop="userCapacity">
        <el-input
          v-model="queryParams.userCapacity"
          placeholder="请输入容纳人数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="使用状态 0未使用 1使用中" prop="useStatus">
        <el-select v-model="queryParams.useStatus" placeholder="请选择使用状态 0未使用 1使用中" clearable>
          <el-option
            v-for="dict in dict.type.a_use_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="实训室负责人" prop="roomLeader">
        <el-input
          v-model="queryParams.roomLeader"
          placeholder="请输入实训室负责人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="开放开始时间">
        <el-date-picker
          v-model="daterangeOpenStartTime"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="开放结束时间">
        <el-date-picker
          v-model="daterangeOpenEndTime"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="负责人联系方式" prop="leaderContact">
        <el-input
          v-model="queryParams.leaderContact"
          placeholder="请输入负责人联系方式"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['trainroom:room:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['trainroom:room:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['trainroom:room:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['trainroom:room:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="roomList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="实训室id" align="center" prop="id" />
      <el-table-column label="实训室名称" align="center" prop="name" />
      <el-table-column label="位置信息" align="center" prop="place" />
      <el-table-column label="容纳人数" align="center" prop="userCapacity" />
      <el-table-column label="设备清单" align="center" prop="equipment" />
      <el-table-column label="使用状态 0未使用 1使用中" align="center" prop="useStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.a_use_status" :value="scope.row.useStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="实训室负责人" align="center" prop="roomLeader" />
      <el-table-column label="开放开始时间" align="center" prop="openStartTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.openStartTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="开放结束时间" align="center" prop="openEndTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.openEndTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="负责人联系方式" align="center" prop="leaderContact" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['trainroom:room:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['trainroom:room:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改实训室信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="实训室名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入实训室名称" />
        </el-form-item>
        <el-form-item label="位置信息" prop="place">
          <el-input v-model="form.place" placeholder="请输入位置信息" />
        </el-form-item>
        <el-form-item label="容纳人数" prop="userCapacity">
          <el-input v-model="form.userCapacity" placeholder="请输入容纳人数" />
        </el-form-item>
        <el-form-item label="设备清单" prop="equipment">
          <el-input v-model="form.equipment" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="使用状态 0未使用 1使用中" prop="useStatus">
          <el-select v-model="form.useStatus" placeholder="请选择使用状态 0未使用 1使用中">
            <el-option
              v-for="dict in dict.type.a_use_status"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="实训室负责人" prop="roomLeader">
          <el-input v-model="form.roomLeader" placeholder="请输入实训室负责人" />
        </el-form-item>
        <el-form-item label="开放开始时间" prop="openStartTime">
          <el-date-picker clearable
            v-model="form.openStartTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择开放开始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="开放结束时间" prop="openEndTime">
          <el-date-picker clearable
            v-model="form.openEndTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择开放结束时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="负责人联系方式" prop="leaderContact">
          <el-input v-model="form.leaderContact" placeholder="请输入负责人联系方式" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listRoom, getRoom, delRoom, addRoom, updateRoom } from "@/api/trainroom/room";

export default {
  name: "Room",
  dicts: ['a_use_status'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 实训室信息表格数据
      roomList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 备注时间范围
      daterangeOpenStartTime: [],
      // 备注时间范围
      daterangeOpenEndTime: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        place: null,
        userCapacity: null,
        equipment: null,
        useStatus: null,
        roomLeader: null,
        openStartTime: null,
        openEndTime: null,
        leaderContact: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询实训室信息列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeOpenStartTime && '' != this.daterangeOpenStartTime) {
        this.queryParams.params["beginOpenStartTime"] = this.daterangeOpenStartTime[0];
        this.queryParams.params["endOpenStartTime"] = this.daterangeOpenStartTime[1];
      }
      if (null != this.daterangeOpenEndTime && '' != this.daterangeOpenEndTime) {
        this.queryParams.params["beginOpenEndTime"] = this.daterangeOpenEndTime[0];
        this.queryParams.params["endOpenEndTime"] = this.daterangeOpenEndTime[1];
      }
      listRoom(this.queryParams).then(response => {
        this.roomList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        name: null,
        place: null,
        userCapacity: null,
        equipment: null,
        useStatus: null,
        roomLeader: null,
        openStartTime: null,
        openEndTime: null,
        leaderContact: null,
        remark: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.daterangeOpenStartTime = [];
      this.daterangeOpenEndTime = [];
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加实训室信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getRoom(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改实训室信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateRoom(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addRoom(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除实训室信息编号为"' + ids + '"的数据项？').then(function() {
        return delRoom(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('trainroom/room/export', {
        ...this.queryParams
      }, `room_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
