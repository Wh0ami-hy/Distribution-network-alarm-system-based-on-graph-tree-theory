<template>
  <div>
    <binary-tree :data="treeData" :width="1020" :height="475" />
  </div>
</template>

<script>
import BinaryTree from './components/BinaryTree/BinaryTree.vue';

export default {
  name: 'App',
  components: {
    'binary-tree': BinaryTree
  },
  data() {
    return {
      treeData: {
        name: 'A',
        children: [
          {
            name: 'B',
            children: [
              {
                name: 'D'
              },
              {
                name: 'E'
              }
            ]
          },
          {
            name: 'C',
            children: [
              {
                name: 'F'
              },
              {
                name: 'G'
              }
            ]
          }
        ]
      }
    };
  }
};
</script>