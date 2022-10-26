import { createApp } from 'vue/dist/vue.esm-bundler'
import router from "@/router";
import App from "@/App";

const Application = createApp(App);
Application.use(router);
Application.mount('#app');

