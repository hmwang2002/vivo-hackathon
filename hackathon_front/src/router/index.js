import {
    createRouter,
    createWebHistory
} from 'vue-router'

const routes = [
    {
        path: '/',
        name: 'start',
        component: () => import('../components/start.vue'),
        meta: {
            title: 'Wonder World'
        }
    },
    {
        path: '/main',
        name: 'Main',
        component: () => import('../components/main.vue'),
        meta: {
            title: 'Main'
        }
    },
    {
        path: '/details',
        name: 'Details',
        component: () => import('../components/details.vue'),
        meta: {
            title: 'City Details'
        }
    }    
]


const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router