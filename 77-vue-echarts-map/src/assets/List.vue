<template>
    <div>
        长春的高梁米没有吉林的高梁米大
        <component :is="myc"></component>
    </div>
</template>
<script>
    import  list1 from "./List1";
  export default {
    data: function () {
      return {
        myc: "list1",
      }
    },
    computed: {},
    created: function () {
    },
    methods: {
    },
    mounted() {
    },
    components: {list1}
  }
</script>
<style>
</style>
