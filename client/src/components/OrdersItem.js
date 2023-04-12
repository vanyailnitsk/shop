import React from "react";
import { Button, Card, Image } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { basketRemoveDevice } from "../http/deviceAPI";
import { DEVICE_ROUTE } from "../utils/consts";
const OrdersItem = ({ device }) => {
    const navigate = useNavigate()
    return (
        <Card className="mt-2 p-2 border-white" >
            <div className="d-flex justify-content-between align-items-center">
                <Card.Img variant="left" height={90} className="pt-2 pb-2" src={device.image} />
                <Card.Body>
                    <Card.Title
                        onClick={() => navigate(DEVICE_ROUTE + '/' + device.deviceId)}
                        style={{ cursor: 'pointer' }}
                    >
                        <h6>{device.name}</h6></Card.Title>
                </Card.Body>
                <div className="p-1">
                    <h6>{device.price + ' ₽'}</h6>
                </div>

                {/* <div>{device.rating}</div> */}
            </div>

        </Card>
    )
}
export default OrdersItem; 