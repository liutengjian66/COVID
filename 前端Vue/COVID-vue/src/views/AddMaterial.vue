<template>
<el-form style="width:60%" :model="Mat" :rules="rules" ref="Mat" label-width="100px" class="demo-Mat">
    <el-form-item label="物资名称" :label-width="formLabelWidth" prop="name">
      <el-input v-model="Mat.name"  autocomplete="off" ></el-input>
    </el-form-item>
    <el-form-item label="物资数量" :label-width="formLabelWidth" prop="count">
      <el-input v-model="Mat.count" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="计量单位" :label-width="formLabelWidth" prop="type">
      <el-input v-model="Mat.type" autocomplete="off"></el-input>
    </el-form-item>
     <el-form-item label="是否为重要物资" :label-width="formLabelWidth" prop="isImp">
        <el-radio v-model="Mat.isImp" label="是">是</el-radio>
        <el-radio v-model="Mat.isImp" label="否">否</el-radio>
    </el-form-item>
     <el-form-item label="负责人" :label-width="formLabelWidth" prop="charge">
      <el-input v-model="Mat.charge" autocomplete="off"></el-input>
    </el-form-item>
     <el-form-item label="负责人电话" :label-width="formLabelWidth" prop="cnum">
      <el-input v-model="Mat.cnum" autocomplete="off"></el-input>
    </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="submitForm('Mat')">立即创建</el-button>
    <el-button @click="resetForm('Mat')">重置</el-button>
  </el-form-item>
</el-form>
</template>
<script>
  export default {
    data() {
      return {
        formLabelWidth: '130px',
        Mat: {
            name:"",
            count:"",
            type:"",
            isImp:"",
            charge:"",
            cnum:"",
                },
        rules: {
          name: [
            { required: true, message: '请输入物资名称', trigger: 'blur' },
            { min: 3, max: 20, message: '长度在 3 到 20 个字符', trigger: 'blur' }
          ],
          count: [
            { required: true, message: '请输入物资数量', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '请输入计量单位', trigger: 'blur' }
          ],
          isImp: [
            { required: true, message: '请输入是否为重要物资', trigger: 'blur' }
          ],
          charge: [
            { required: true, message: '请输入负责人', trigger: 'blur' }
          ],
          cnum: [
            { required: true, message: '请输入负责人电话', trigger: 'blur' }
          ]
      
        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            axios.post('http://localhost:8080/Material/save',this.Mat).then((resp)=>{
              if(resp.data=='success'){
               this.$alert('物资添加成功！',"消息",{
                 confirmButtonText:"确定",
                 callback:action=>{
                   this.$router.push('/MaterialManage')
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