import axios from "axios";

const api= axios.create({
    baseURL:"https://coding-panic-detector-backend.onrender.com"
});

export default api;