import {defineStore} from "pinia";
import router from "../router/index.js";

export const useLandscapeStore = defineStore("landscape",{
    persistent: true,
    state: () => ({
        name: "",
        realCity: "",
        summary: "",
        photo: "",
    }),
})