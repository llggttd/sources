<template>
  <div class="outer">
    <common-header :items="items" :active="1"></common-header>
    <main role="main" class="container">
    <div class="jumbotron system shadow">
      <h1 class="display-4">Windows 10</h1>
      <div>
        <div class="input-group input-group-sm mb-1">
          <div class="input-group-prepend">
            <button class="btn btn-outline-secondary btn-block" type="button" disabled>文件名</button>
          </div>
          <input type="text" class="form-control"
            placeholder="cn_windows_10_business_editions_version_1809_updated_jan_2019_x64_dvd_ee4a2f95.iso" disabled>
        </div>
        <div class="input-group input-group-sm mb-1">
          <div class="input-group-prepend">
            <button class="btn btn-outline-secondary btn-block" type="button" disabled>SHA1</button>
          </div>
          <input type="text" class="form-control" placeholder="427d065d73774fb97228804dde3cb07e70eb5d41" disabled>
        </div>
        <div class="input-group input-group-sm mb-1">
          <div class="input-group-prepend">
            <button class="btn btn-outline-secondary btn-block" type="button" disabled>文件大小</button>
          </div>
          <input type="text" class="form-control" placeholder="4.79GB" disabled>
        </div>
        <div class="input-group input-group-sm mb-1">
          <div class="input-group-prepend">
            <button class="btn btn-outline-secondary btn-block" type="button" disabled>发布时间</button>
          </div>
          <input type="text" class="form-control" placeholder="2019-01-16" disabled>
        </div>
        <div class="input-group input-group-sm mb-1">
          <input type="text" class="form-control text-info"
            placeholder="ed2k://|file|cn_windows_10_business_editions_version_1809_updated_jan_2019_x64_dvd_ee4a2f95.iso|5142784000|689DBCB5C2B6E022BC7E901D02DB10F1|/"
            disabled id="iso-url">
          <div class="input-group-append" id="tooltip-wrapper">
            <button class="btn btn-success" type="button"
              data-clipboard-text="ed2k://|file|cn_windows_10_business_editions_version_1809_updated_jan_2019_x64_dvd_ee4a2f95.iso|5142784000|689DBCB5C2B6E022BC7E901D02DB10F1|/"
              id="copy" @click="onCopy">复制</button>
          </div>
        </div>
      </div>
    </div>
    </main>
    <common-footer></common-footer>
  </div>
</template>

<script>
import CommonHeader from '@/components/CommonHeader'
import CommonFooter from '@/components/CommonFooter'
import { items } from '@/pages/tools/router'
import Clipboard from 'clipboard'

export default {
  name: 'System',
  components: {
    CommonHeader,
    CommonFooter
  },
  data () {
    return {
      items
    }
  },
  methods: {
    onCopy: function () {
      let clipboard = new Clipboard('#copy')
      clipboard.on('success', function (e) {
        console.log('ok')
        e.clearSelection()
      })
      clipboard.on('error', function (e) {
        console.error('Action:', e.action)
        console.error('Trigger:', e.trigger)
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.system {
  background-color: antiquewhite;
  margin: 2rem 0rem;
  padding: 3rem 1.5rem;
  text-align: left;
  border: 1px solid antiquewhite;
  border-radius: 1.0rem
}

.system .input-group-prepend {
  width: 6rem;
}
</style>
