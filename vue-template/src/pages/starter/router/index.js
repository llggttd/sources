import Vue from 'vue'
import Router from 'vue-router'
import Rank from '@/modules/Rank'
import About from '@/modules/About'
import Me from '@/modules/Me'

Vue.use(Router)

let router = new Router({
  routes: [
    {
      path: '/',
      name: 'Rank',
      meta: {
        title: '首页'
      },
      component: Rank
    },
    {
      path: '/me',
      name: 'me',
      meta: {
        title: '工具'
      },
      component: Me
    },
    {
      path: '/about',
      name: 'About',
      meta: {
        title: '系统'
      },
      component: About
    }
  ]
})

router.beforeEach((to, from, next) => {
  if (to.meta.title) {
    document.title = to.meta.title
  }
  next()
})
export default router
