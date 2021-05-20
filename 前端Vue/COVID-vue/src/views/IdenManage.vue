<template>
  <div>
    <el-button type="primary" @click="addDialogFormVisible = true" size="medium"
      >新增记录</el-button
    >
    <el-input
      placeholder="请输入内容"
      v-model="stext"
      class="input-with-select"
      style="width: 40%"
    >
      <el-select
        v-model="cname"
        slot="prepend"
        placeholder="请选择"
        @change="getKey"
      >
        <el-option label="姓名" value="name"></el-option>
        <el-option label="就诊医院" value="place"></el-option>
        <el-option label="所属部门" value="depart"></el-option>
        <el-option label="就诊日期" value="idate"></el-option>
      </el-select>
      <el-button
        slot="append"
        icon="el-icon-search"
        @click="search()"
      ></el-button>
    </el-input>

    <el-table :data="tableData" border style="width: 100%">
      <el-table-column fixed prop="name" label="姓名" width="100">
      </el-table-column>
      <el-table-column prop="id" label="编号" width="50"> </el-table-column>
      <el-table-column prop="sex" label="性别" width="50"> </el-table-column>
      <el-table-column prop="idcard" label="身份证号码" width="170">
      </el-table-column>
      <el-table-column prop="idate" label="就诊日期" width="160">
      </el-table-column>
      <el-table-column prop="place" label="就诊医院" width="200">
      </el-table-column>
      <el-table-column prop="depart" label="所属部门" width="120">
      </el-table-column>
      <el-table-column prop="phonenum" label="手机号码" width="120">
      </el-table-column>
      <el-table-column prop="register" label="登记时间" width="170">
      </el-table-column>
      <el-table-column width="120" label="操作" fixed="right">
        <template slot-scope="scope">
          <el-button
            @click="(dialogFormVisible = true), edit(scope.row)"
            type="text"
            size="small"
            >修改</el-button
          >
          <el-button type="text" size="small" @click="deleteRecord(scope.row)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <div class="block">
      <el-pagination
        @current-change="handleCurrentChange"
        :page-size="6"
        layout="total, prev, pager, next"
        :total="total"
      >
      </el-pagination>

      <el-dialog
        title="修改确诊/疑似病例记录"
        :visible.sync="dialogFormVisible"
        slot
      >
        <el-form :model="EmpIden" ref="EmpIden">
          <el-form-item label="姓名" :label-width="formLabelWidth">
            <el-input v-model="EmpIden.name" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="性别" :label-width="formLabelWidth">
            <el-radio v-model="EmpIden.sex" label="男">男</el-radio>
            <el-radio v-model="EmpIden.sex" label="女">女</el-radio>
          </el-form-item>
          <el-form-item label="身份证号" :label-width="formLabelWidth">
            <el-input v-model="EmpIden.idcard" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="就诊日期" :label-width="formLabelWidth">
            <el-date-picker
              v-model="EmpIden.idate"
              align="right"
              type="date"
              placeholder="选择日期"
              :picker-options="pickerOptions"
            >
            </el-date-picker>
          </el-form-item>
          <el-form-item label="就诊医院" :label-width="formLabelWidth">
            <el-input v-model="EmpIden.place" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="所属部门" :label-width="formLabelWidth">
            <el-select
              v-model="EmpIden.depart"
              clearable
              placeholder="请选择"
            >
              <el-option
                v-for="(item, index) in options2"
                :key="index"
                :label="item"
                :value="item"
              >
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="手机号码" :label-width="formLabelWidth">
            <el-input v-model="EmpIden.phonenum" autocomplete="off"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button
            type="primary"
            @click="(dialogFormVisible = false), update()"
            >确 定</el-button
          >
        </div>
      </el-dialog>

      <el-dialog
        title="新增确诊/疑似病例记录"
        :visible.sync="addDialogFormVisible"
        slot
      >
        <el-form :model="addEmpIden">
          <el-form-item label="姓名" :label-width="formLabelWidth">
            <el-input v-model="addEmpIden.name" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="性别" :label-width="formLabelWidth">
            <el-radio v-model="addEmpIden.sex" label="男">男</el-radio>
            <el-radio v-model="addEmpIden.sex" label="女">女</el-radio>
          </el-form-item>
          <el-form-item label="身份证号" :label-width="formLabelWidth">
            <el-input v-model="addEmpIden.idcard" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="就诊日期" :label-width="formLabelWidth">
            <el-date-picker
              v-model="addEmpIden.idate"
              align="right"
              type="date"
              placeholder="选择日期"
              :picker-options="pickerOptions"
            >
            </el-date-picker>
          </el-form-item>
          <el-form-item label="就诊医院" :label-width="formLabelWidth">
            <el-input v-model="addEmpIden.place" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="所属部门" :label-width="formLabelWidth">
            <el-select
              v-model="addEmpIden.depart"
              clearable
              placeholder="请选择"
            >
              <el-option
                v-for="(item, index) in options2"
                :key="index"
                :label="item"
                :value="item"
              >
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="手机号码" :label-width="formLabelWidth">
            <el-input
              v-model="addEmpIden.phonenum"
              autocomplete="off"
            ></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="addDialogFormVisible = false">取 消</el-button>
          <el-button
            type="primary"
            @click="(addDialogFormVisible = false), submitForm()"
            >确 定</el-button
          >
        </div>
      </el-dialog>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    search() {
      if (!this.stext) {
        axios.get("http://localhost:8080/empiden/findAll/1/6").then((resp) => {
          this.tableData = resp.data.records;
          this.total = resp.data.total;
          this.cname = "";
        });
      } else {
        axios
          .get(
            "http://localhost:8080/empiden/search/" +
              this.searchKey +
              "/" +
              this.stext
          )
          .then((resp) => {
            this.tableData = resp.data;
            this.total = resp.data.total;
          });
      }
    },
    getKey(e) {
      this.searchKey = e;
    },
    submitForm() {
      axios
        .post("http://localhost:8080/empiden/save", this.addEmpIden)
        .then((resp) => {
          if (resp.data == "success") {
            this.$alert("确诊/疑似病例添加成功！", "消息", {
              confirmButtonText: "确定",
              callback: (action) => {
                window.location.reload();
              },
            });
          }
        });
    },
    deleteRecord(row) {
      this.$confirm("是否确定要删除" + row.name + "的病例记录?", "删除数据", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        axios
          .delete("http://localhost:8080/empiden/deleteById/" + row.id)
          .then((resp) => {
            this.$alert(row.name + "的病例记录删除成功！", "消息", {
              confirmButtonText: "确定",
              callback: (action) => {
                window.location.reload();
              },
            });
          });
      });
    },

    update() {
      axios
        .put("http://localhost:8080/empiden/update", this.EmpIden)
        .then((resp) => {
          console.log(resp);
          if (resp.data == "success") {
            this.$alert(this.EmpIden.name + "的病例记录修改成功！", "消息", {
              confirmButtonText: "确定",
              callback: (action) => {
                window.location.reload();
              },
            });
          }
        });
    },
    edit(row) {
      axios
        .get("http://localhost:8080/empiden/findById/" + row.id)
        .then((resp) => {
          this.EmpIden = resp.data;
        });
    },
    handleCurrentChange(currentPage) {
      axios
        .get("http://localhost:8080/empiden/findAll/" + currentPage + "/6")
        .then((resp) => {
          this.tableData = resp.data.records;
          this.total = resp.data.total;
        });
    },
    remoteMethod(query) {
      if (query !== "") {
        this.loading = true;
        setTimeout(() => {
          this.loading = false;
          this.options = this.list.filter((item) => {
            return item.label.toLowerCase().indexOf(query.toLowerCase()) > -1;
          });
        }, 200);
      } else {
        this.options = [];
      }
    },
  },
  created() {
    axios.get("http://localhost:8080/empiden/findAll/1/6").then((resp) => {
      this.tableData = resp.data.records;
      this.total = resp.data.total;
    });
    axios.get("http://localhost:8080/depart/findAll").then((resp) => {
      console.log(resp.data);
      this.options2 = resp.data;
    });
  },

  data() {
    return {
      options2: [
        {
          value: "",
          label: "",
        },
      ],
      value: "",
      cname: "",
      stext: "",
      pickerOptions: {
        disabledDate(time) {
          return time.getTime() > Date.now();
        },
        shortcuts: [
          {
            text: "今天",
            onClick(picker) {
              picker.$emit("pick", new Date());
            },
          },
          {
            text: "昨天",
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24);
              picker.$emit("pick", date);
            },
          },
          {
            text: "一周前",
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit("pick", date);
            },
          },
        ],
      },
      options: [],
      value: [],
      list: [],
      loading: false,
      tableData: null,
      total: null,
      dialogTableVisible: false,
      dialogFormVisible: false,
      addDialogFormVisible: false,
      formLabelWidth: "120px",
      addLabelWidth: "50px",
      EmpIden: {
        id: "",
        name: "",
        sex: "",
        idcard: "",
        idate: "",
        place: "",
        depart: "",
        phonenum: "",
      },
      addEmpIden: {
        id: "",
        name: "",
        sex: "",
        idcard: "",
        idate: "",
        place: "",
        depart: "",
        phonenum: "",
      },
    };
  },
};
</script>
<style>
.el-select .el-input {
  width: 130px;
}
.input-with-select {
  float: right;
}

.input-with-select .el-input-group__prepend {
  background-color: #fff;
}
</style>