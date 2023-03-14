import React from "react";
import { Button, Card, Image } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { DEVICE_ROUTE } from "../utils/consts";
// import {useHistory} from 'react-router-dom'
const DeviceItem = ({device}) => {
    const navigate = useNavigate()
    console.log(device)
    return (
        <Card  className="mt-2 p-3 shadow border-white">
            
            <div className="d-flex justify-content-between align-items-center">
                <Card.Img variant="left" height={150}  className="pt-2 pb-2" src={device.image}/>
                <Card.Body>
                    <Card.Title 
                        onClick={() => navigate(DEVICE_ROUTE+'/'+device.deviceId)}
                        style={{cursor:'pointer'}}
                    >
                        {device.name}</Card.Title>
                </Card.Body>
                <div className="p-1">{device.price+' ₽'}</div>
                {/* <div>{device.rating}</div> */}
                <Button variant="outline-primary" className="pt-1">Купить</Button>
            </div>
        
        </Card>
    )
}
export default DeviceItem; 