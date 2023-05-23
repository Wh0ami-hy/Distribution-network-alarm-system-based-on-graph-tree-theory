<template>
  <div>
<el-input placeholder="请输入内容" v-model="content" class="input-with-select"
  style="margin-top: 15px;width:80%;margin-left: 15px;">
  <el-select v-model="select" slot="prepend" placeholder="请选择">
    <el-option label="名称" value="node_name"></el-option>
    <el-option label="故障" value="fault_info"></el-option>
  </el-select>
  <el-button slot="append" icon="el-icon-search" @click="handleSearch()"
    style="background-color: #409EFF;color: #fff;"></el-button>
  <el-button slot="append" icon="el-icon-download" @click="exportExcel()"
    style="background-color: #67C23A;color: #fff;"></el-button>
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
        label="经度"
        width=""
        align="center">
          <template slot-scope="scope">
            {{ scope.row.latitude }}
        </template>
      </el-table-column>
      <el-table-column
        label="纬度"
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
import { read, write, utils } from 'xlsx';

export default {
   data() {
      return {
        tableData: [],
        content: '',
        select:'',
      }
    },
  methods: {
    exportExcel(){
            const header = ['名称', '故障', '经度', '纬度', '电流', '电场', '温度', '湿度', '电池电压', '太阳能电压'];
      const data = [];
      for (let row of this.tableData) {
        data.push([
          row.node_name,
          row.fault_info,
          row.latitude,
          row.longitude,
          row.current,
          row.electric_field,
          row.temperature,
          row.humidity,
          row.battery_voltage,
          row.solar_voltage
        ]);
      }
      const worksheet = utils.aoa_to_sheet([header, ...data]);

      const workbook = utils.book_new();
      utils.book_append_sheet(workbook, worksheet, 'Sheet1');

      const filename = 'data.xlsx';
      const wbout = write(workbook, { bookType: 'xlsx', type: 'array' });
      const blob = new Blob([wbout], { type: 'application/octet-stream' });
      const link = document.createElement('a');
      link.href = URL.createObjectURL(blob);
      link.download = filename;
      link.click();
    },
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
