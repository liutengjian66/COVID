<template>
<el-form style="width:60%" :model="Emp" :rules="rules" ref="Emp" label-width="100px" class="demo-Emp">
    <el-form-item label="姓名" :label-width="formLabelWidth" prop="name">
      <el-input v-model="Emp.name"  autocomplete="off" ></el-input>
    </el-form-item>
    
    <el-form-item label="性别" :label-width="formLabelWidth" prop="sex">
  <el-radio v-model="Emp.sex" label="男">男</el-radio>
  <el-radio v-model="Emp.sex" label="女">女</el-radio>
    </el-form-item>

    <el-form-item label="手机号码" :label-width="formLabelWidth" prop="phonenum">
      <el-input v-model="Emp.phonenum" autocomplete="off"></el-input>
    </el-form-item>
     <el-form-item label="体温" :label-width="formLabelWidth" prop="temp">
      <el-input v-model="Emp.temp" autocomplete="off"></el-input>
    </el-form-item>
     <el-form-item label="是否曾到达高风险地区" :label-width="formLabelWidth" prop="risk">
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
     <el-form-item label="所属部门" :label-width="formLabelWidth" prop="depart">
            <el-select
              v-model="Emp.depart"
              clearable
              placeholder="请选择"
            >
              <el-option  v-for="(item, index) in options3" :key="index" :label="item" :value="item">
              </el-option>
            </el-select>
          </el-form-item>
     <el-form-item label="备注" :label-width="formLabelWidth">
      <el-input v-model="Emp.content" autocomplete="off"></el-input>
    </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="submitForm('Emp')">立即创建</el-button>
    <el-button @click="resetForm('Emp')">重置</el-button>
  </el-form-item>
</el-form>
</template>
<script>
  export default {
     created() {
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
      
        formLabelWidth: '120px',
        options: [{
          value: '选项1',
          label: '男'
        }, {
          value: '选项2',
          label: '女'
        }],
        Emp: {
            name:"",
            sex:"",
            phonenum:"",
            temp:"",
            risk:"",
            health:"",
            createTime:"",
            content:"",
            depart:""
                },
        rules: {
          name: [
            { required: true, message: '请输入姓名', trigger: 'blur' },
            { min:2, max: 20, message: '长度在 3 到 20 个字符', trigger: 'blur' }
          ],
          sex: [
            { required: true, message: '请输入性别', trigger: 'blur' }
          ],
          phonenum: [
            { required: true, message: '请输入手机号码', trigger: 'blur' },
            { min: 8, max: 20, message: '长度在 8 到 20 个字符', trigger: 'blur' }
          ],
          temp: [
            { required: true, message: '请输入体温', trigger: 'blur' }
          ],
          risk: [
            { required: true, message: '请选择是否曾到达高风险地区', trigger: 'blur' }
          ],
          health: [
            { required: true, message: '请输入健康状况', trigger: 'blur' }
          ],
          depart: [
            { required: true, message: '请选择部门', trigger: 'blur' }
          ]
      
        }
      };
    },
    methods: {

      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            axios.post('http://localhost:8080/emp/save',this.Emp).then((resp)=>{
              if(resp.data=='success'){
               this.$alert('打卡成功！',"消息",{
                 confirmButtonText:"确定",
                 callback:action=>{
                   this.$router.push('/RecordManage')
                 }
               })
              }
            })
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>