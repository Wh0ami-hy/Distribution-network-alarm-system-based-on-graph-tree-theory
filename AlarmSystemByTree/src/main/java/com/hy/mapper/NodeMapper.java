package com.hy.mapper;

import com.hy.entity.Node;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface NodeMapper {
    public List<Node> list();

    public Integer update(Node node);

    public Integer delete(Integer node_id);

    public Integer insert(Node node);

    public List<Node> selectByName(String node_name);

    public List<Node> selectByFault(String fault_info);

    public List<Node> createTree();

    public List<Node> createMap();
}
