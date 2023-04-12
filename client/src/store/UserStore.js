import { makeAutoObservable } from "mobx"

export default class UserStore {
    constructor() {
        this._isAuth = false
        this._user = {}
        this._basket = []
        this._orders = []
        makeAutoObservable(this)
    }

    setIsAuth(bool) {
        this._isAuth = bool
    }
    setUser(user) {
        this._user = user
    }
    get isAuth() {
        return this._isAuth
    }
    get User() {
        return this._user 
    }
    setBasket(basket) {
        this._basket = basket
    }
    get basket() {
        return this._basket
    }
    setOrders(orders) {
        this._orders = orders
    }
    get orders() {
        return this._orders
    }
}