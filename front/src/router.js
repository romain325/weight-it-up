import { createRouter, createWebHistory } from "vue-router";

// 1. Define route components.
// These can be imported from other files
const Home = { template: '<div>Home</div>' }
const PageNotFound = { template : "<div>Erreur 404 : page non trouvée</div>"}
import Test from './Test.vue'

// 2. Define some routes
// Each route should map to a component.
// We'll talk about nested routes later.
const routes = [
    { path: '/test', component: Test },
    { path: '/', component: Home },
    { path: '/:pathMatch(.*)*', component: PageNotFound }
]

// 3. Create the router instance and pass the `routes` option
// You can pass in additional options here, but let's
// keep it simple for now.
const router = createRouter({
    // 4. Provide the history implementation to use. We are using the hash history for simplicity here.
    history: createWebHistory(),
    routes, // short for `routes: routes`
})

export default router;