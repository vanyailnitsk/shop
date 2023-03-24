import Admin from "./pages/Admin"
import Auth from "./pages/Auth"
import Basket from "./pages/Basket"
import DevicePage from "./pages/DevicePage"
import Home from "./pages/Home"
import Shop from "./pages/Shop"
import { ADMIN_ROUTE, BASKET_ROUTE, DEVICE_ROUTE, HOME_ROUTE, LOGIN_ROUTE, REGISTRATION_ROUTE, SHOP_ROUTE } from "./utils/consts"

 export const authRoutes =[
    {
        path: ADMIN_ROUTE,
        Component: Admin
    }

 ]
 export const publicRoutes = [
    {
        path: SHOP_ROUTE + '/:type',
        Component: Shop
    },
    {
        path: BASKET_ROUTE,
        Component: Basket
    },
    {
        path: DEVICE_ROUTE + '/:id',
        Component: DevicePage
    },
    {
        path: LOGIN_ROUTE,
        Component: Auth
    },
    {
        path: REGISTRATION_ROUTE,
        Component: Auth
    },
    {
        path:HOME_ROUTE,
        Component:Home
    }
 ]