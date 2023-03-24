import React from "react";
import { Button, Card, Image } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { basketRemoveDevice } from "../http/deviceAPI";
import { DEVICE_ROUTE } from "../utils/consts";
// import {useHistory} from 'react-router-dom'
const BasketItem = ({device}) => {
    const navigate = useNavigate()
    function refreshPage() {
        window.location.reload(false);
      }
    return (
        <Card  className="mt-2 p-3 shadow-sm border-white" >
            
            <div className="d-flex justify-content-between align-items-center">
                <Card.Img variant="left" height={90}  className="pt-2 pb-2" src={device.image}/>
                <Card.Body>
                    <Card.Title 
                        onClick={() => navigate(DEVICE_ROUTE+'/'+device.deviceId)}
                        style={{cursor:'pointer'}}
                    >
                        <h6>{device.name}</h6></Card.Title>
                </Card.Body>
                <div className="p-1">
                    <h6>{device.price+' ₽'}</h6>
                    <a style={{fontSize:'14px',cursor:'pointer'}} onClick={() => basketRemoveDevice(device.deviceId).then(refreshPage)}>Удалить</a>
                </div>
                
                {/* <div>{device.rating}</div> */}
            </div>
        
        </Card>
    )
}
export default BasketItem; 