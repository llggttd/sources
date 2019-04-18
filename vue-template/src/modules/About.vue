<template>
  <div class="outer">
    <common-header :active="3"></common-header>
    <main role="main" class="container">

      <div>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalBox">确定</button>
        <centered-modal v-bind:modalTitle="title" v-bind:modalMessage="message" v-on:save="save"/>
      </div>

    </main>
    <common-footer></common-footer>
  </div>
</template>

<script>
import CommonHeader from '@/components/CommonHeader'
import CommonFooter from '@/components/CommonFooter'
import CenteredModal from '@/components/CenteredModal'

export default {
  name: 'About',
  components: {
    CommonHeader,
    CommonFooter,
    CenteredModal
  },
  data () {
    return {
      title: '提示',
      message: '重跑之前的数据需要1-2分钟，在任务结束前请不要关闭本页面。'
    }
  },
  methods: {
    save: function () {
      console.log('centered-modal save')
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
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
