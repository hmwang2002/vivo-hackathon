import {api} from "../api/index.js";
import {ref} from "vue";

export default function getLandScapes() {
    const result = ref([])
    const getLandscapes = async () => {
        await api.post("/scenerySpot/queryNameAndLocation").then((res) => {
            result.value = res.data;
            console.log(result.value);
        }).catch((e) => {
            console.log(e);
        })
        return result.value;
    }

    const getLandscapeByName = async (name) => {
        let params = new URLSearchParams();
        params.append("name", name);
        await api.get("/scenerySpot/queryByName", {params}).then((res) => {
            result.value = res.data;
            console.log(result.value);
        }).catch((e) => {
            console.log(e);
        })
        return result.value;
    }

    return {
        getLandscapes,
        getLandscapeByName,
    }
}

