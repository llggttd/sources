import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/modules/Home'
import About from '@/modules/About'
import Me from '@/modules/Me'

Vue.use(Router)
export const items = [
  {
    path: '/',
    name: 'home',
    title: '首页'
  }, {
    path: '/me',
    name: 'me',
    title: '我们'
  }, {
    path: '/help',
    name: 'help',
    title: '帮助'
  }
]

let components = [Home, Me, About]
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
