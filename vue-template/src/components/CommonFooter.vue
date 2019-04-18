<template>
  <footer class="mastfoot mt-auto">
    <div class="inner text-center">
      <p>©{{year}} 0z0ne</p>
    </div>
  </footer>
</template>

<script>
export default {
  name: 'CommonFooter',
  data () {
    return {
      year: new Date().getFullYear()
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
 .mastfoot {
  color: rgba(0, 0, 0);
}
</style>
