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
    const {data} = await $authHost.get('devices/' + id)
    return data
}