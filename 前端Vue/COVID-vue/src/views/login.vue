<template>
  <div>
    <el-card class="login-form-layout">
      <el-form
        autocomplete="on"
        :model="loginForm"
        ref="loginForm"
        label-position="left"
      >
        <div style="text-align: center">
          <svg-icon icon-class="login-mall" style="width: 56px;height: 56px;color: #409EFF"></svg-icon>
        </div>
        <h2 class="login-title color-main">疫情防控管理系统登录</h2>
        <el-form-item prop="username">
          <el-input
            name="username"
            type="text"
            v-model="loginForm.username"
            autocomplete="on"
            placeholder="请输入用户名"
          >
            <span slot="prefix">
              <svg-icon icon-class="user" class="color-main"></svg-icon>
            </span>
          </el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input
            name="password"
            :type="pwdType"
            @keyup.enter.native="handleLogin"
            v-model="loginForm.password"
            autocomplete="on"
            placeholder="请输入密码"
            show-password
          >
            <span slot="prefix">
              <svg-icon icon-class="password" class="color-main"></svg-icon>
            </span>
            <span slot="suffix" @click="showPwd">
              <svg-icon icon-class="eye" class="color-main"></svg-icon>
            </span>
          </el-input>
        </el-form-item>
        <el-form-item style="margin-bottom: 60px">
          <el-button
            style="width: 48%"
            type="primary"
            :loading="loading"
            @click.native.prevent="handleLogin"
          >登录</el-button>
          <el-button
            style="width: 48%"
            type="success"
            :loading="loading"
            @click="dialogFormVisible = true"
          >注册</el-button>
        </el-form-item>
      </el-form>
    </el-card>

<el-dialog title="用户注册" :visible.sync="dialogFormVisible" center="">
  <el-form :model="user">
    <el-form-item label="用户名" :label-width="formLabelWidth">
      <el-input v-model="user.username" autocomplete="off" size="small" :label-width="LabelWidth"></el-input>
    </el-form-item>
    <el-form-item label="密码" :label-width="formLabelWidth">
      <el-input  show-password :type="pwdType" v-model="user.password" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="确认密码" :label-width="formLabelWidth">
      <el-input show-password :type="pwdType" v-model="user.repassword" autocomplete="off"></el-input>
    </el-form-item>
 <el-form-item label="所属部门" :label-width="formLabelWidth">
            <el-select
              v-model="user.depart"
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
  </el-form>
  <div slot="footer" class="dialog-footer">
    <el-button @click="dialogFormVisible = false">取 消</el-button>
    <el-button type="primary" @click="register()">注 册</el-button>
  </div>
</el-dialog>
  </div>
</template>
 
<script>
export default {
  created(){
        axios.get("http://localhost:8080/depart/findAll").then((resp) => {
      this.options2 = resp.data;
    });
  },
  name: "login",
  data() {
    return {
      options2: [
        {
          value: "",
          label: "",
        },
      ],
      formLabelWidth:'120px',
      LabelWidth:'40px',
      dialogFormVisible : false,
      user:{
        username: "",
        password: "",
        repassword:"",
        depart:""
      },
      loginForm: {
        username: "",
        password: ""
      },
      loading: false,
      pwdType: "password",
    };
  },
  methods: {
    register(){
      this.dialogFormVisible = false
         if(this.user.username==""||this.user.password=="") {
                            this.$alert("注册用户名或密码不能为空")
                            this.loading=false;
           }else if(this.user.password==this.user.repassword){
        axios.post('http://localhost:8080/userlogin/register',this.user).then((resp)=>{
          console.log(resp)
          this.loading=true;
                if(resp.data=='success'){
                  this.loading=false;
                this.$alert("注册成功!请登录");
                }else if(resp.data=='repeat'){
                   this.loading=false;
                   this.$alert('用户名已存在!请重新注册')
                }else{
                  this.loading=false;
                  this.$alert("注册失败!请重新注册")
                  window.location.reload()
                }
        })}
        else {
          this.$alert("两次输入的密码不一致!");
        }
    },
    showPwd() {
      if (this.pwdType === "password") {
        this.pwdType = "";
      } else {
        this.pwdType = "password";
      }
    },
    handleLogin() {
        axios.post('http://localhost:8080/userlogin/user',this.loginForm).then((resp)=>{
          console.log(resp)
          this.loading=true;
           if(this.loginForm.username==""||this.loginForm.password=="") {
                            this.$alert("用户名或密码不能为空")
                            this.loading=false;
           }
            else {
                if(resp.data=='success'){
                  this.loading=false;
                this.$message({
                  showClose: true,
                  message: '登录成功',
                  type: 'success'
        });
                  this.$router.push('/index')
                }else {
                  this.loading=false;
                  this.$alert("用户名或密码错误")
                }
                    }
          
        })
      }
    }
  };
</script>
 
<style scoped>
.login-form-layout {
  position: absolute;
  left: 0;
  right: 0;
  width: 360px;
  margin: 140px auto;
  border-top: 10px solid #409eff;
}
 
.login-title {
  text-align: center;
}
 
.login-center-layout {
  background: #409eff;
  width: auto;
  height: auto;
  max-width: 100%;
  max-height: 100%;
  margin-top: 200px;
}
</style>