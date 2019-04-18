<template>
  <div class="outer">
    <common-header :active=1></common-header>
    <main role="main" class="container">
      <h1>Rank</h1>
      <h3>{{ msg }}</h3>
    </main>
    <common-footer></common-footer>
  </div>
</template>

<script>
import CommonHeader from '@/components/CommonHeader'
import CommonFooter from '@/components/CommonFooter'

export default {
  name: 'Rank',
  components: {
    CommonHeader,
    CommonFooter
  },
  data () {
    return {
      msg: 'This is rank'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
