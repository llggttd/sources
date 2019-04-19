<template>
  <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <a class="navbar-brand"><img class="logo" src="static/favicon.png" /></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbars" aria-controls="navbars"
      aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbars">
      <ul class="navbar-nav mr-auto">
        <li v-for="(item, index) in items" v-bind:key="index" v-bind:class="{ active: active == index }">
          <router-link :to="item.path" class="nav-link">{{ item.title }}</router-link>
        </li>
      </ul>
    </div>
  </nav>
</template>

<script>
export default {
  name: 'CommonHeader',
  props: {
    items: Array,
    active: Number
  },
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
