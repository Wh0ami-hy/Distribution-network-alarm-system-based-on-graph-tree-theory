package com.hy.util;

import java.util.List;

public class TreeUtils {

    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            sb.append("value: ").append(value);
            sb.append(", ");
            if (left == null) {
                sb.append("left: null");
            } else {
                sb.append("left: ").append(left.toString());
            }
            sb.append(", ");
            if (right == null) {
                sb.append("right: null");
            } else {
                sb.append("right: ").append(right.toString());
            }
            sb.append("}");
            return sb.toString();
        }
    }

    public static TreeNode convert(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }

        // 将列表转换为数组
        Integer[] arr = list.toArray(new Integer[list.size()]);

        // 构建完全二叉树
        TreeNode[] nodes = new TreeNode[arr.length];
        for (int i = 0; i <arr.length; i++) {
            nodes[i] = new TreeNode(arr[i]);
        }
        for (int i = 0; i < nodes.length / 2; i++) {
            if (2 * i + 1 < nodes.length) {
                nodes[i].left = nodes[2 * i + 1];
            }
            if (2 * i + 2 < nodes.length) {
                nodes[i].right = nodes[2 * i + 2];
            }
        }

        return nodes[0];
    }
}