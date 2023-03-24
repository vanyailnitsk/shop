import React, { useContext, useEffect, useState } from "react";
import { Row,Col, Container } from "react-bootstrap";
import { Context } from "..";
import BasketList from "../components/BasketList";
import DeviceItem from "../components/DeviceItem";
import DeviceList from "../components/DeviceList";
import { fetchBasketItems } from "../http/deviceAPI";

const Basket = () => {
    const {device} = useContext(Context)
    const {user} = useContext(Context)
    const [len,setLen] = useState()
    useEffect(() => {
        fetchBasketItems().then(data =>  {
            user.setBasket(data)
            setLen(user.basket.length)
        })
      }, [])
      document.body.style.backgroundColor = '#f6f6f6';
    return (
        <Container>
            <div className="d-flex flex-row align-items-center">
            <h2 className="p-3">Корзина</h2>
            <h6>{len+' товара'}</h6></div>
            <Row>
                <Col md={7} className="ms-5">
                    <BasketList/>
                </Col>
            </Row>
        </Container>
    )
}
export default Basket; 