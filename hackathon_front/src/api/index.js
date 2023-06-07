import axios from "axios";
const api_url = "http://localhost:8080";

const api = axios.create({
    baseURL: api_url,
});

export {api};