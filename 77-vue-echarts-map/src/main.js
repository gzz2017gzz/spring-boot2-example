import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import App from './App.vue'
import echarts from 'echarts'
Vue.prototype.$echarts = echarts;
Vue.use(ElementUI);
new Vue({
  el: '#app',
  render: h => h(App)
});
