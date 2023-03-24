import { observer } from "mobx-react-lite";
import React, { useContext } from "react";
import { Row } from "react-bootstrap";
import { Context } from "..";
import BasketItem from "./BasketItem";
import DeviceItem from "./DeviceItem";

const BasketList = observer(() => {
    const {user} = useContext(Context)
    return (
        <Row className="d-flex pl-5" >
            {user.basket.map(device =>
                <BasketItem key={device.id} device={device}/>
            )}
        </Row>
    )
})
export default BasketList;