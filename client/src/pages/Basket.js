import React, { useContext, useEffect, useState } from "react";
import { Row,Col, Container, Card } from "react-bootstrap";
import { Context } from "..";
import BasketList from "../components/BasketList";
import BasketOrder from "../components/BasketOrder";
import DeviceItem from "../components/DeviceItem";
import DeviceList from "../components/DeviceList";
import { fetchBasketItems } from "../http/deviceAPI";

const Basket = () => {
    const {user} = useContext(Context)
    const [len,setLen] = useState()
    useEffect(() => {
        fetchBasketItems().then(data =>  {
            user.setBasket(data)
            setLen(user.basket.length)
        })
      }, [])
    return (
        <Container className="d-flex justify-content-between mt-3">
            <Card className="d-flex flex-column mt-3 border-white shadow-sm" style={{width:'65%',borderRadius:'16px'}}>
            <div className="d-flex flex-row align-items-center">
            <h3 className="p-3">Корзина</h3>
            <h6>{len+' товара'}</h6></div>
            <Row>
                <Col className="ms-3 me-3">
                    <BasketList/>
                </Col>
            </Row>
            </Card>
                <BasketOrder itemsAmount={len}/>
        </Container>
    )
}
export default Basket; 