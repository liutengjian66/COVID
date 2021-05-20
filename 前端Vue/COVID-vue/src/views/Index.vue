<template>
  <div class="index">
      <el-container style="height: 100%; border: 1px solid #eee">
  <el-aside width="200px" style="background-color: rgb(238, 241, 246)">

    <el-menu router :default-active='$route.path'>
      <el-submenu  v-for="(item,index) in router" :index="index+''" :key="index" >
        <template slot="title"><i class="el-icon-setting"></i>{{item.name}}</template>
        <el-menu-item  v-for="(item2,index2) in item.children"  :index="item2.path" :key="index2" 
        >{{item2.name}}</el-menu-item>
        </el-submenu> 
    </el-menu>
  </el-aside>
    <el-main>
      <router-view></router-view>
    </el-main>
</el-container>
  </div>
</template>
<script>

export default {
  data(){
    return{
      currentMenu:'',
      router:""
    }
  },
  created(){
    this.router = this.$router.options.routes.filter(i=>{
      return i.meta
    })
  },
  name: 'index',
}
</script>
