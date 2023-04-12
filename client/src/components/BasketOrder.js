import { observer } from "mobx-react-lite";
import React, { useContext } from "react";
import { Card, ListGroup } from "react-bootstrap";
import { Context } from "..";

const BasketOrder = observer(({itemsAmount}) => {
    const {user} = useContext(Context)
    const sum = user.basket.reduce((accumulator, object) => {
        return accumulator + object.price;
      }, 0);
    return (
        <Card style={{width:'30%',borderRadius:'15px'}} className="border-white shadow-sm mt-3 d-flex flex-column align-self-start">
            <Card.Title className="d-flex justify-content-md-center mt-3">{'Условия заказа '}</Card.Title>
            <div className="ms-3 mt-3">
                <p>{'Товары, '+itemsAmount+' шт.'}</p>
            </div>
            <div className="d-flex flex-row justify-content-between m-3 mt-0">
                <h3>Итого</h3>
                <h4>{sum+' ₽'}</h4>
            </div>
            
        </Card>
        
    )
})
export default BasketOrder; 