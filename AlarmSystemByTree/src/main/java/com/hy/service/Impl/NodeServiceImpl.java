package com.hy.service.Impl;

import com.hy.entity.Node;
import com.hy.mapper.NodeMapper;
import com.hy.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeServiceImpl implements NodeService {
    @Autowired
    NodeMapper nodeMapper;
    @Override
    public List<Node> list() {
        return nodeMapper.list();
    }

    @Override
    public Integer update(Node node) {
        return nodeMapper.update(node);
    }

    @Override
    public Integer delete(Integer node_id) {
        return nodeMapper.delete(node_id);
    }

    @Override
    public Integer insert(Node node) {
        return nodeMapper.insert(node);
    }

    @Override
    public List<Node> selectByName(String node_name) {
        return nodeMapper.selectByName(node_name);
    }

    @Override
    public List<Node> selectByFault(String fault_info) {
        return nodeMapper.selectByFault(fault_info);
    }

    @Override
    public List<Node> createTree() {
        return nodeMapper.createTree();
    }

    @Override
    public List<Node> createMap() { return nodeMapper.createMap(); }
}
