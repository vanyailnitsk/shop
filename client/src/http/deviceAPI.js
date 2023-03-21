import { $authHost, $host } from "."

export const fetchTypes = async () => {
    const {data} = await $host.get('type')
    return data
}

export const fetchDevices = async (type) => {
    const {data} = await $host.get('devices/type/'+type)
    return data
}

export const fetchOneDevice = async (id) => {
    const {data} = await $host.get('devices/' + id)
    return data
}

export const fetchBasketItems = async () => {
    const{data} = await $authHost.get('basket/items')
    return data
}

export const basketAddDevice = async (deviceId) => {
    const {data} = await $authHost.post('basket/add/'+deviceId)
    return data
}