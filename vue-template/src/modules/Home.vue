<template>
  <div class="outer">
    <common-header :items="items" :active="0"></common-header>
    <main role="main" class="container">
      <h1>Home</h1>
      <h3>{{ msg }}</h3>
    </main>
    <common-footer></common-footer>
  </div>
</template>

<script>
import CommonHeader from '@/components/CommonHeader'
import CommonFooter from '@/components/CommonFooter'
import { items } from '@/pages/starter/router'

export default {
  name: 'Home',
  components: {
    CommonHeader,
    CommonFooter
  },
  data () {
    return {
      items,
      msg: '如果你为了俯瞰大地上的各个王国而登上了雄伟的马特峰，竟在山顶上发现了草莓，这也许是令人愉快的事情。但是，你不是为了草莓才去攀登山峰的。'
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
