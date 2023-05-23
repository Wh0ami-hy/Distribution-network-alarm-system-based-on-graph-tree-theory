<template>
  <div>
    <canvas ref="canvas" width="800" height="600"></canvas>
  </div>
</template>

<script>
import { createTree } from "@/api/node.js";

export default {
  data() {
    return {
      treeData: null,
    }
  },

  methods: {
    loadData() {
      createTree().then((response) => {
        this.treeData = response.data.data;
        const tree = this.treeData;

        const canvas = this.$refs.canvas;
        const ctx = canvas.getContext("2d");

        const nodeDistanceX = 100;
        const nodeDistanceY = 80;

        const nodeColor = "red";
        const pathColor = "red";

        const drawNode = (node, x, y, level) => {
          ctx.fillStyle = nodeColor;
          ctx.beginPath();
          ctx.arc(x, y, 20, 0, 2 * Math.PI);
          ctx.stroke();
          ctx.fill();
          ctx.fillStyle = "white";
          ctx.fillText(node.value, x - 5, y + 5);

          if (node.left) {
            const x1 = x - nodeDistanceX / Math.pow(2, level + 1);
            const y1 = y + nodeDistanceY;
            ctx.strokeStyle = pathColor;
            ctx.beginPath();
            ctx.moveTo(x, y + 20);
            ctx.lineTo(x1, y1 - 20);
            ctx.stroke();
            drawNode(node.left, x1, y1, level + 1);
          }

          if (node.right) {
            const x2 = x + nodeDistanceX / Math.pow(2, level + 1);
            const y2 = y + nodeDistanceY;
            ctx.strokeStyle = pathColor;
            ctx.beginPath();
            ctx.moveTo(x, y + 20);
            ctx.lineTo(x2, y2 - 20);
            ctx.stroke();
            drawNode(node.right, x2, y2, level + 1);
          }
        };

        drawNode(tree, 400, 50, 0);
      })
    },
  },

  mounted() {
    this.loadData();
  }
};
</script>