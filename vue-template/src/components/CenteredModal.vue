<template>
  <div class="modal fade" id="modalBox" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-dialog-centered" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="modalBoxTitle">{{modalTitle}}</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close" v-if="topCloseButton">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <div class="text-left">
            <span>{{modalMessage}}</span>
          </div>
          <div class="progress mt-4">
            <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" style="width: 100%"></div>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
          <button type="button" class="btn btn-primary" data-dismiss="modal" @click="onSave">保存</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'CenteredModal',
  props: ['modalTitle', 'modalMessage', 'topCloseButton'],
  data () {
    return {}
  },
  methods: {
    onSave: function () {
      this.$emit('save')
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
