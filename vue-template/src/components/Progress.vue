<template>
  <div class="progress">
    <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" style="width: {{progress}}%"></div>
  </div>
</template>

<script>
export default {
  name: 'Progress',
  data () {
    return {
      progress: 0
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
