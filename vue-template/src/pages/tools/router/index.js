import Vue from 'vue'
import Router from 'vue-router'
import Tools from '@/modules/Tools'
import System from '@/modules/System'

Vue.use(Router)
export const items = [
  {
    path: '/',
    name: 'tools',
    title: '工具'
  }, {
    path: '/system',
    name: 'system',
    title: '系统'
  }
]

let components = [Tools, System]
let routes = []
for (let i = 0; i < items.length; i++) {
  routes.push({
    path: items[i].path,
    name: items[i].name,
    component: components[i],
    meta: {
      title: items[i].title
    }
  })
}

let router = new Router({ routes })
router.beforeEach((to, from, next) => {
  if (to.meta.title) {
    document.title = to.meta.title
  }
  next()
})

export default router
