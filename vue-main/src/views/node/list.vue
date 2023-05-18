<template>
<div>
  <el-table
    :data="tableData.slice((pages.currentPage-1)*pages.size,pages.currentPage*pages.size)"
    height=""
    border
    style="width: 100%">
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
    <el-table-column label="操作">
      <template slot-scope="scope">
        <el-button
          size="mini"
          type="primary"
          @click="handleEdit(scope.row)">编辑</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index,scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
    <el-dialog title="编辑监控点信息" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-input v-model="form.node_id" v-show="false"></el-input>
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
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="handleUpdate()">确 定</el-button>
        <el-button @click="dialogFormVisible = false">取 消</el-button>
      </div>
  </el-dialog>
  <div style="text-align: right">
    <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :page-sizes="[5, 10, 15, 20]"
        :page-size=pages.size
        layout="total, sizes, prev, pager, next"
        :total=pages.total>
    </el-pagination>
  </div>

</div>
</template>

<script>
import { list,deleted,update } from "@/api/node.js";
  export default {
   data() {
      return {
        dialogFormVisible: false,
        tableData: [],
        pages:{
          total: 0,
          size: 5,
          currentPage: 1,
        },
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
        index: "",
      }
    },
    //生命周期函数（渲染组件时）
    mounted: function(){
      this.loadData()
    },
    methods: {
    loadData(){
      list().then((response)=>{
      this.tableData = response.data.data;
      this.pages.total = response.data.data.length
      })
    },
    // 把当前的行对象row传入
    handleEdit(row) {
      this.form.node_id = row.node_id
      this.form.node_name = row.node_name
      this.form.fault_info = row.fault_info
      this.form.latitude = row.latitude
      this.form.longitude = row.longitude
      this.dialogFormVisible = true;
      },
    handleUpdate(){
      update(this.form).then(
        response => {
        this.dialogFormVisible = false;
        this.loadData()
        this.$message({
          message: '更新成功',
          type: 'success'
        })})
      },
    handleDelete(index,row) {
        //删除记录
        var id = row.node_id
        this.$confirm('此操作将永久删除该信息, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          deleted(id).then(
            response => {
              /*splice () 方法通过删除或替换现有元素或者原地添加新的元素来修改数组，并以数组形式返回被修改的内容。 */
              this.tableData.splice(index,1);
              this.$message({
                  message: "成功删除",
                  type: 'success'
                });
            }
          )
         }).catch(() => {
           this.$message({
             type: 'info',
             message: '已取消删除'
           });
         });
      },
    handleSizeChange(val) {
      this.pages.size = val;
    },
    handleCurrentChange(val) {
      this.pages.currentPage = val;
    }
  }
}
</script>



