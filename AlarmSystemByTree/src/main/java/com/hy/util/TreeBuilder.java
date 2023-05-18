package com.hy.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeBuilder {

    public static TreeNode buildTree(List<String> nodes) {
        if (nodes == null || nodes.isEmpty()) {
            return null;
        }

        String rootVal = nodes.get(0);
        TreeNode root = new TreeNode(rootVal);

        if (nodes.size() == 1) {
            return root;
        }

        List<String> leftNodes = new ArrayList<>(nodes.subList(1, nodes.size() / 2 + 1));
        List<String> rightNodes = new ArrayList<>(nodes.subList(nodes.size() / 2 + 1, nodes.size()));

        root.children.add(buildTree(leftNodes));
        root.children.add(buildTree(rightNodes));

        return root;
    }

    public static void main(String[] args) {
        List<String> nodes = Arrays.asList("1", "2", "3", "4");

        TreeNode root = buildTree(nodes);
        System.out.println(root);
    }
}

class TreeNode {
    String name;
    List<TreeNode> children;

    public TreeNode(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "{" +
                "name:'" + name + '\'' +
                ", children:" + children +
                '}';
    }
}