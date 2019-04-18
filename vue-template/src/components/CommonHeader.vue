<template>
  <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <a class="navbar-brand"><img class="logo" src="static/favicon.png" /></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbars" aria-controls="navbars"
      aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbars">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item" v-bind:class="{ active: active === 1}">
          <router-link to="/" class="nav-link">首页</router-link>
        </li>
        <li class="nav-item" v-bind:class="{ active: active === 2}">
          <router-link to="/me" class="nav-link">工具</router-link>
        </li>
        <li class="nav-item" v-bind:class="{ active: active === 3}">
        <router-link to="/about" class="nav-link">系统</router-link>
        </li>
      </ul>
    </div>
  </nav>
</template>

<script>
export default {
  name: 'CommonHeader',
  props: ['active'],
  data () {
    return {
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.logo {
  width: 2.0rem;
  height: 2.0rem;
  padding: 0.2rem;
}
</style>
