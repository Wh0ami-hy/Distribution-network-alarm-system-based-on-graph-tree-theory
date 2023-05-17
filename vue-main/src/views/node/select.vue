<template>
  <div>
    <el-input placeholder="请输入内容" v-model="content" class="input-with-select"
    style="margin-top: 15px;width:50%;margin-left: 15px;">
      <el-select v-model="select" slot="prepend" placeholder="请选择">
        <el-option label="名称" value="node_name"></el-option>
        <el-option label="故障" value="fault_info"></el-option>
      </el-select>
      <el-button slot="append" icon="el-icon-search" @click="handleSearch()"></el-button>
    </el-input>

    <el-table
        :data="tableData"
        border
        style="margin-top: 15px;width:90%;margin-left: 15px;">
              <el-table-column
        label="名称"
        width=""
        align="center">
          <template slot-scope="scope">
            {{ scope.row.node_name }}
        </template>
      </el-table-column>
      <el-table-column
        label="故障"
        width=""
        align="center">
          <template slot-scope="scope">
            {{ scope.row.fault_info }}
        </template>
      </el-table-column>
      <el-table-column
        label="纬度"
        width=""
        align="center">
          <template slot-scope="scope">
            {{ scope.row.latitude }}
        </template>
      </el-table-column>
      <el-table-column
        label="经度"
        width=""
        align="center">
          <template slot-scope="scope">
            {{ scope.row.longitude }}
        </template>
      </el-table-column>
      <el-table-column
        label="电流"
        width=""
        align="center">
          <template slot-scope="scope">
            {{ scope.row.current }}
        </template>
      </el-table-column>
      <el-table-column
        label="电场"
        width=""
        align="center">
          <template slot-scope="scope">
            {{ scope.row.electric_field }}
        </template>
      </el-table-column>
      <el-table-column
        label="温度"
        width=""
        align="center">
          <template slot-scope="scope">
            {{ scope.row.temperature }}
        </template>
      </el-table-column>
      <el-table-column
        label="湿度"
        width=""
        align="center">
          <template slot-scope="scope">
            {{ scope.row.humidity }}
        </template>
      </el-table-column>
      <el-table-column
        label="电池电压"
        width=""
        align="center">
          <template slot-scope="scope">
            {{ scope.row.battery_voltage }}
        </template>
      </el-table-column>
      <el-table-column
        label="太阳能电压"
        width=""
        align="center">
          <template slot-scope="scope">
            {{ scope.row.solar_voltage }}
        </template>
      </el-table-column>
      </el-table>
  </div>
</template>


<script>
import {selected} from "@/api/node.js";

export default {
   data() {
      return {
        tableData: [],
        content: '',
        select:'',
      }
    },
  methods: {
    handleSearch(){
      var content = this.content;
      var select = this.select;
      var data = {
        content:content,
        select:select
      }
      if(select == null || "" == select){
        this.$message({
          message: "选择查询类别",
          type: 'error'
        });
        return;
      }

      if(content == null || "" == content){
        this.$message({
          message: "查询内容不能为空",
          type: 'error'
        });
        return;
      }
      selected(data).then(
        response=>{
          this.tableData = [];
          if(response.data.data.length == 0){
            this.$message({
              message: "无匹配结果",
              type: 'warning'
            });
          }else{
            this.tableData = response.data.data;
          }
        }
      )
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
</style>
