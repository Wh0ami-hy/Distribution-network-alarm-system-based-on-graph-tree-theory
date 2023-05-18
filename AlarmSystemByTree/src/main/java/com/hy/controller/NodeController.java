package com.hy.controller;

import com.alibaba.fastjson.JSONObject;
import com.hy.entity.Node;
import com.hy.service.NodeService;
import com.hy.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/node")
public class NodeController {

    @Autowired
    private NodeService nodeService;

    @GetMapping("/list")
    public Result listNode(){

        return Result.ok().data("data",nodeService.list());
    }

    @PostMapping("/update")
    public Result updateNode(@RequestBody Node node){
        nodeService.update(node);
        System.out.println(node.toString());
        return Result.ok();
    }

    @PostMapping("/insert")
    public Result insertNode(@RequestBody Node node){
        LocalDate date = LocalDate.now();
        Date sqlDate = Date.valueOf(date);
        String nowDate = sqlDate.toString();
        node.setCreate_time(nowDate);
        nodeService.insert(node);
        System.out.println(node.toString());
        return Result.ok();
    }

    @PostMapping("/deleted/{node_id}")
    public Result deleteNode(@PathVariable Integer node_id) {
        nodeService.delete(node_id);
        return Result.ok();
    }

    @PostMapping("/selected")
    public Result selectNode(@RequestBody JSONObject param){
        String content = param.getString("content");
        String select = param.getString("select");
        List<Node> nodes = null;
        System.out.println(select + "-->" + content);

        if (select.equals("node_name")) {
            nodes = nodeService.selectByName(content);
        }else if (select.equals("fault_info")){
            nodes = nodeService.selectByFault(content);
        }
        return Result.ok().data("data",nodes);
    }
    @GetMapping("/createMap")
    public Result createMap(){

        List result = new ArrayList();

        List<Node> nodes = nodeService.createMap();
        for(Node node : nodes){
            if (node.getFault_info().equals("正常") || node.getFault_info() == null || node.getFault_info().equals("")){
                JSONObject json_string1 = JSONObject.parseObject("{ center: [" + node.getLatitude() + "," + node.getLongitude() + "], fillColor: '#22dc19' }");
                result.add(json_string1);
                //System.out.println("{ center: [" + node.getLatitude() + "," + node.getLongitude() + "], fillColor: '#22dc19' },");
            }else {
                JSONObject json_string2 = JSONObject.parseObject("{ center: [" + node.getLatitude() + "," + node.getLongitude() + "], fillColor: '#c80539' }");
                result.add(json_string2);
                //System.out.println("{ center: [" + node.getLatitude() + "," + node.getLongitude() + "], fillColor: '#c80539' },");
            }
        }
        System.out.println(result);

        return Result.ok().data("data", result);
    }
    @GetMapping("/createTree")
    public Result createTree(){
        List result = new ArrayList();
        List<Node> nodes = nodeService.createTree();
        for(Node node : nodes){
            if (node.getFault_info().equals("正常") || node.getFault_info() == null || node.getFault_info().equals("")){

            }else {
                result.add(node.getNode_id());
            }
        }
        System.out.println(result);
        return Result.ok().data("data", result);
    }

}
