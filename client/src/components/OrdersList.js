import { observer } from "mobx-react-lite";
import React, { useContext } from "react";
import { Row } from "react-bootstrap";
import { Context } from "..";
import BasketItem from "./BasketItem";
import DeviceItem from "./DeviceItem";
import OrdersItem from "./OrdersItem";

const OrdersList = observer(({ items }) => {
    return (
        <Row className="d-flex flex-column pl-5" >
            <div>
                <h5>{'Заказ от '+items.date}</h5>
                </div>
            {items.items.map(device=>
                <OrdersItem key={device.devicecId} device={device}/>
            )}
            
        </Row>
    )
})
export default OrdersList;