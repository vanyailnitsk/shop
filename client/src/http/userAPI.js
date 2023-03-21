import {$authHost, $host} from "./index";
import jwt_decode from "jwt-decode";
import axios from "axios";

export const registration = async (name, email, password) => {
    const {data} = await $host.post('auth/register', {name, email, password})
    localStorage.setItem('token', data.token)
    return jwt_decode(data.token)
}

export const login = async (email, password) => {
    const {data} = await $host.post('auth/login', {email, password})
    localStorage.setItem('token', data.token)
    //axios.defaults.headers.common["Authorization"] = `Bearer ${data.token}`;
    return jwt_decode(data.token)
}

export const check = async () => {
    const {data} = await $authHost.get('auth/check')
    localStorage.setItem('token', data.token)
    return jwt_decode(data.token)
}
