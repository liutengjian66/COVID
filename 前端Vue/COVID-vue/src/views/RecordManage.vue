<template>
<div>
  <el-input placeholder="请输入内容" v-model="stext" class="input-with-select" style="width:40%">
    <el-select v-model="cname" slot="prepend" placeholder="请选择" @change="getKey">
      <el-option label="姓名" value="name"></el-option>
      <el-option label="健康状况" value="health"></el-option>
      <el-option label="打卡时间" value="createTime"></el-option>
    </el-select>
    <el-button slot="append" icon="el-icon-search" @click="search()"></el-button>
  </el-input>

  <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      fixed
      prop="id"
      label="编号"
      sortable
      width="120">
    </el-table-column>
    <el-table-column
      prop="name"
      label="姓名"
      width="120">
    </el-table-column>
    <el-table-column
      prop="sex"
      label="性别"
      width="50">
    </el-table-column>
    <el-table-column
      prop="phonenum"
      label="手机号码"
      width="120">
    </el-table-column>
    <el-table-column
      label="体温"
      prop="temp"
      width="80"
      sortable>
      <template slot-scope="scope">
          <div slot="reference" >
            <p size="medium" :class="scope.row.temp>36 && scope.row.temp<37.2 ? '' : 'red'">{{ scope.row.temp+"°C"}}</p>
          </div>
        </template>
    </el-table-column>
    
    <el-table-column
      prop="risk"
      label="是否到达过高风险地区"
      width="120">
    </el-table-column>
    <el-table-column
      prop="health"
      label="健康状况"
      width="170">
    </el-table-column>
    <el-table-column
      prop="createTime"
      label="打卡时间"
      width="170"
      sortable>
    </el-table-column>
       <el-table-column
      prop="depart"
      label="所属部门"
      width="120">
    </el-table-column>
    <el-table-column
      prop="content"
      label="备注"
      width="120">
    </el-table-column>
   <el-table-column width="120" label="操作" fixed="right">
      <template slot-scope="scope">
        <el-button @click="dialogFormVisible = true,edit(scope.row)" type="text" size="small">修改</el-button>
        <el-button type="text" size="small" @click="deleteRecord(scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>

  <div class="block">
    <el-pagination
      @current-change="handleCurrentChange"
      :page-size="6"
      layout="total, prev, pager, next"
      :total="total">
    </el-pagination>

<el-dialog title="修改打卡记录" :visible.sync="dialogFormVisible" slot>
  <el-form :model="Emp" ref="Emp">
    <el-form-item label="姓名" :label-width="formLabelWidth">
      <el-input v-model="Emp.name"  autocomplete="off" ></el-input>
    </el-form-item>
      <el-form-item label="性别" :label-width="formLabelWidth" prop="sex">
  <el-radio v-model="Emp.sex" label="男">男</el-radio>
  <el-radio v-model="Emp.sex" label="女">女</el-radio>
    </el-form-item>
    <el-form-item label="手机号码" :label-width="formLabelWidth">
      <el-input v-model="Emp.phonenum" autocomplete="off"></el-input>
    </el-form-item>
     <el-form-item label="体温" :label-width="formLabelWidth">
      <el-input v-model="Emp.temp" autocomplete="off"></el-input>
    </el-form-item>
     <el-form-item label="是否曾到达高风险地区" :label-width="formLabelWidth">
      <el-input v-model="Emp.risk" autocomplete="off"></el-input>
    </el-form-item>
          <el-form-item label="健康状况" :label-width="formLabelWidth" prop="health">
      <el-select v-model="Emp.health" clearable placeholder="请选择">
    <el-option
      v-for="item in options2"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>
    </el-form-item>
     <el-form-item label="打卡时间" :label-width="formLabelWidth" >
      <el-input v-model="Emp.createTime" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="所属部门" :label-width="formLabelWidth">
            <el-select
              v-model="Emp.depart"
              clearable
              placeholder="请选择"
            >
              <el-option
                v-for="(item, index) in options3"
                :key="index"
                :label="item"
                :value="item"
              >
              </el-option>
            </el-select>
          </el-form-item>
     <el-form-item label="备注" :label-width="formLabelWidth">
      <el-input v-model="Emp.content" autocomplete="off"></el-input>
    </el-form-item>

  </el-form>
  <div slot="footer" class="dialog-footer">
    <el-button @click="dialogFormVisible = false">取 消</el-button>
    <el-button type="primary" @click="dialogFormVisible = false,update()">确 定</el-button>
  </div>
</el-dialog>
  </div>

</div>

</template>

<script>
  export default {
    methods: {
    search(){
      if(!this.stext){
        
      axios.get('http://localhost:8080/emp/findAll/1/6').then((resp)=>{
        console.log(resp)
        this.tableData=resp.data.records
        this.total=resp.data.total
        this.cname=""
      })
      }else{
      axios.get('http://localhost:8080/emp/search/'+this.searchKey+"/"+this.stext).then((resp)=>{
              this.tableData=resp.data
              this.total=resp.data.total
            })}
    },
    getKey(e){
      this.searchKey = e
    },

   deleteRecord(row){
        this.$confirm('是否确定要删除'+row.name+'的打卡记录?','删除数据',{
          confirmButtonText:'确定',
          cancelButtonText:'取消',
          type:'warning'
        }).then(()=>{axios.delete('http://localhost:8080/emp/deleteById/'+row.id).then((resp)=>{
          this.$alert(row.name+'的打卡记录删除成功！',"消息",{
                 confirmButtonText:"确定",
                 callback:action=>{
                   window.location.reload()
                 }
               })
        })})
      },

      update(){
            axios.put('http://localhost:8080/emp/update',this.Emp).then((resp)=>{
              console.log(resp)
              if(resp.data=='success'){
               this.$alert(this.Emp.name+'的打卡记录修改成功！',"消息",{
                 confirmButtonText:"确定",
                 callback:action=>{
                   window.location.reload()
                 }
               })
              }
            })
        },
      edit(row) {
         axios.get('http://localhost:8080/emp/findById/'+row.id).then((resp)=>{
        this.Emp=resp.data;
      })
      },
      handleCurrentChange(currentPage){
        axios.get('http://localhost:8080/emp/findAll/'+currentPage+'/6').then((resp)=>{
        this.tableData=resp.data.records
        this.total=resp.data.total
      })
      },
      remoteMethod(query) {
        if (query !== '') {
          this.loading = true;
          setTimeout(() => {
            this.loading = false;
            this.options = this.list.filter(item => {
              return item.label.toLowerCase()
                .indexOf(query.toLowerCase()) > -1;
            });
          }, 200);
        } else {
          this.options = [];
        }
      }
    },
    created(){
      axios.get('http://localhost:8080/emp/findAll/1/6').then((resp)=>{
        console.log(resp)
        this.tableData=resp.data.records
        this.total=resp.data.total
      });
          axios.get("http://localhost:8080/depart/findAll").then((resp) => {
      console.log(resp.data);
      this.options3 = resp.data;
    });
    },

    data() {

      return {
          options3:[
        {
          value: "",
          label: "",
        },
      ],
        options2: [{
          value: '正常',
          label: '无下列情况，身体健康'
        }, {
          value: '咳嗽',
          label: '咳嗽'
        }, {
          value: '乏力',
          label: '乏力'
        }, {
          value: '呼吸困难',
          label: '呼吸困难'
        }, {
          value: '与新冠肺炎有关的其他症状，如流涕，咽痛，肌痛，腹泻等',
          label: '与新冠肺炎有关的其他症状，如流涕，咽痛，肌痛，腹泻等'
        }],
        value: '',
        cname:'',
        stext:'',
        searchKey:"",
        options: [],
        value: [],
        list: [],
        loading: false,
        tableData: null,
        total:null,
        dialogTableVisible: false,
        dialogFormVisible: false,
         formLabelWidth: '120px',
         LabelWidth: '180px',
          Emp: {
            id:"",
            name:"",
            sex:"",
            phonenum:"",
            temp:"",
            risk:"",
            health:"",
            createTime:"",
            content:"",
            depart:""
                }
      }
    }
  }
</script>
<style>
  .el-select .el-input {
    width: 130px;
  }
  .input-with-select .el-input-group__prepend {
    background-color: #fff;
  }
  .red{
    color: red;
  }
</style>