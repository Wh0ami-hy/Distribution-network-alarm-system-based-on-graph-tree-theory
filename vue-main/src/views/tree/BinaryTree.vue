<template>
  <div>
    <svg ref="svg" :viewBox="[0,0,0,0]"></svg>
  </div>
</template>

<script>
import * as d3 from 'd3';

export default {
  name: 'BinaryTree',
  props: {
    data: {
      type: Object,
      required: true
    },
    width: {
      type: Number,
      default: 400
    },
    height: {
      type: Number,
      default: 400
    }
  },
  mounted() {
    this.drawTree();
  },
  methods: {
    drawTree() {
      const treeData = d3.hierarchy(this.data);
      const treeLayout = d3.tree().size([this.width, this.height]);
      const nodes = treeLayout(treeData).descendants();
      const links = treeLayout(treeData).links();

      const svg = d3.select(this.$refs.svg);

      const linkGroup = svg.append('g')
        .attr('class', 'links');

      linkGroup.selectAll('line')
        .data(links)
        .enter()
        .append('line')
        .attr('x1', d => d.source.x)
        .attr('y1', d => d.source.y)
        .attr('x2', d => d.target.x)
        .attr('y2', d => d.target.y)
        .attr('stroke', '#E91616')
        .attr('stroke-width', '5');

      const nodeGroup = svg.append('g')
        .attr('class', 'nodes');

      const nodesSelection = nodeGroup.selectAll('g')
        .data(nodes)
        .enter()
        .append('g')
        .attr('transform', d => `translate(${d.x},${d.y})`);

      nodesSelection.append('circle')
        .attr('r', 20)
        .attr('fill', '#fff')
        .attr('stroke', '#000')
        .attr('stroke-width', '2');

      nodesSelection.append('text')
        .text(d => d.data.name)
        .attr('x', 0)
        .attr('y', 5)
        .style('text-anchor', 'middle')
        .style('font-size', '14px')
        .style('font-weight', 'bold');
    }
  }
};
</script>

<style>
svg {
  background-color: #f9f9f9;
  border: 1px solid rgb(250, 245, 245);
}
</style>