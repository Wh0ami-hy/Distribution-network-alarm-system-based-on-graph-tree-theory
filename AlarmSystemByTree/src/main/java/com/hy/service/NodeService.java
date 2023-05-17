package com.hy.service;

import com.hy.entity.Node;

import java.util.List;

public interface NodeService {

    public List<Node> list();

    public Integer update(Node node);

    public Integer delete(Integer node_id);

    public Integer insert(Node node);

    public List<Node> selectByName(String node_name);

    public List<Node> selectByFault(String fault_info);

    public void createTree(List<Node> list);

    public void createMap(List<Node> list);

}
