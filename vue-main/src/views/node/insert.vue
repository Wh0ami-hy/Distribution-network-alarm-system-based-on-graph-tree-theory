<template>
  <el-form ref="form" :model="form" label-width="80px" style="width:50%;margin-top:20px" >
    <el-form-item label="名称">
      <el-input v-model="form.node_name"></el-input>
    </el-form-item>
    <el-form-item label="故障">
      <el-input v-model="form.fault_info"></el-input>
    </el-form-item>
    <el-form-item label="经度">
      <el-input v-model="form.latitude"></el-input>
    </el-form-item>
    <el-form-item label="纬度">
      <el-input v-model="form.longitude"></el-input>
    </el-form-item>
    <el-form-item label="电流">
      <el-input v-model="form.current"></el-input>
    </el-form-item>
    <el-form-item label="电场">
      <el-input v-model="form.electric_field"></el-input>
    </el-form-item>
    <el-form-item label="温度">
      <el-input v-model="form.temperature"></el-input>
    </el-form-item>
    <el-form-item label="湿度">
      <el-input v-model="form.humidity"></el-input>
    </el-form-item>
    <el-form-item label="电池电压">
      <el-input v-model="form.battery_voltage"></el-input>
    </el-form-item>
    <el-form-item label="太阳能电压">
      <el-input v-model="form.solar_voltage"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit()">添加</el-button>
      <el-button @click="reform()">重置</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import {insert} from "@/api/node.js";

export default {
  data() {
      return {
        form: {
          node_id:'',
          node_name: '',
          fault_info: '',
          latitude: '',
          longitude: '',
          current: '',
          electric_field: '',
          temperature: '',
          humidity: '',
          battery_voltage: '',
          solar_voltage: ''
        },
      }
    },
  methods: {
      onSubmit() {
        //提交添加请求
        if(this.form.node_name.length < 1 ||
          this.form.fault_info.length < 1 ||
          this.form.latitude.length < 1 ||
          this.form.longitude.length < 1
         ){
           this.$message({
             message: "请填写完整的信息",
             type: "error"
           })
         }else{

           insert(this.form).then(
            response=>{
            this.$message({
             message:'添加成功',
             type: "success"
             })
             })
           }
         },
      reform(){
        this.form.node_name='',
        this.form.fault_info='',
        this.form.latitude='',
        this.form.longitude='',
        this.form.current='',
        this.form.electric_field='',
        this.form.temperature='',
        this.form.humidity='',
        this.form.battery_voltage='',
        this.form.solar_voltage=''
        },
      },
}
</script>