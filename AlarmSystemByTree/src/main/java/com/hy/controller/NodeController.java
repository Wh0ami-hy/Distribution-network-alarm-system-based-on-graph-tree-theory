package com.hy.controller;

import com.alibaba.fastjson.JSONObject;
import com.hy.entity.Node;
import com.hy.service.NodeService;
import com.hy.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
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

}
