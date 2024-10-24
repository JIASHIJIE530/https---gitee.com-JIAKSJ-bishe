<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="实训名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入实训名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="负责人" prop="trainLeader">
        <el-input
          v-model="queryParams.trainLeader"
          placeholder="请输入负责人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="负责人手机号" prop="phone">
        <el-input
          v-model="queryParams.phone"
          placeholder="请输入负责人手机号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="实训时间" prop="trainTime">
        <el-date-picker clearable
          v-model="queryParams.trainTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择实训时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="实训室id" prop="trainRoomId">
        <el-input
          v-model="queryParams.trainRoomId"
          placeholder="请输入实训室id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="实训容量" prop="trainCapacity">
        <el-input
          v-model="queryParams.trainCapacity"
          placeholder="请输入实训容量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="实训目标" prop="trainTarget">
        <el-input
          v-model="queryParams.trainTarget"
          placeholder="请输入实训目标"
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
          v-hasPermi="['train:trainInfo:add']"
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
          v-hasPermi="['train:trainInfo:edit']"
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
          v-hasPermi="['train:trainInfo:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['train:trainInfo:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="trainInfoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="实训id" align="center" prop="id" />
      <el-table-column label="实训名称" align="center" prop="name" />
      <el-table-column label="描述" align="center" prop="description" />
      <el-table-column label="负责人" align="center" prop="trainLeader" />
      <el-table-column label="负责人手机号" align="center" prop="phone" />
      <el-table-column label="实训时间" align="center" prop="trainTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.trainTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="实训室id" align="center" prop="trainRoomId" />
      <el-table-column label="实训容量" align="center" prop="trainCapacity" />
      <el-table-column label="实训要求" align="center" prop="trainRequire" />
      <el-table-column label="公告" align="center" prop="notice" />
      <el-table-column label="实训目标" align="center" prop="trainTarget" />
      <el-table-column label="参与者名单" align="center" prop="participants" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['train:trainInfo:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['train:trainInfo:remove']"
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

    <!-- 添加或修改实训对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="实训名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入实训名称" />
        </el-form-item>
        <el-form-item label="描述" prop="description">
          <el-input v-model="form.description" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="负责人" prop="trainLeader">
          <el-input v-model="form.trainLeader" placeholder="请输入负责人" />
        </el-form-item>
        <el-form-item label="负责人手机号" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入负责人手机号" />
        </el-form-item>
        <el-form-item label="实训时间" prop="trainTime">
          <el-date-picker clearable
            v-model="form.trainTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择实训时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="实训室id" prop="trainRoomId">
          <el-input v-model="form.trainRoomId" placeholder="请输入实训室id" />
        </el-form-item>
        <el-form-item label="实训容量" prop="trainCapacity">
          <el-input v-model="form.trainCapacity" placeholder="请输入实训容量" />
        </el-form-item>
        <el-form-item label="实训要求" prop="trainRequire">
          <el-input v-model="form.trainRequire" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="公告" prop="notice">
          <el-input v-model="form.notice" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="实训目标" prop="trainTarget">
          <el-input v-model="form.trainTarget" placeholder="请输入实训目标" />
        </el-form-item>
        <el-form-item label="参与者名单" prop="participants">
          <el-input v-model="form.participants" type="textarea" placeholder="请输入内容" />
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
import { listTrainInfo, getTrainInfo, delTrainInfo, addTrainInfo, updateTrainInfo } from "@/api/train/trainInfo";

export default {
  name: "TrainInfo",
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
      // 实训表格数据
      trainInfoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        description: null,
        trainLeader: null,
        phone: null,
        trainTime: null,
        trainRoomId: null,
        trainCapacity: null,
        trainRequire: null,
        notice: null,
        trainTarget: null,
        participants: null
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
    /** 查询实训列表 */
    getList() {
      this.loading = true;
      listTrainInfo(this.queryParams).then(response => {
        this.trainInfoList = response.rows;
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
        description: null,
        trainLeader: null,
        phone: null,
        trainTime: null,
        trainRoomId: null,
        trainCapacity: null,
        trainRequire: null,
        notice: null,
        trainTarget: null,
        participants: null
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
      this.title = "添加实训";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getTrainInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改实训";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateTrainInfo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTrainInfo(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除实训编号为"' + ids + '"的数据项？').then(function() {
        return delTrainInfo(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('train/trainInfo/export', {
        ...this.queryParams
      }, `trainInfo_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
