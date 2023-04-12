import { observer } from "mobx-react-lite";
import React, { useContext, useEffect } from "react";
import { Card, Col, Container, Row } from "react-bootstrap";
import { Context } from "..";
import BasketList from "../components/BasketList";
import OrdersList from "../components/OrdersList";
import { fetchOrders } from "../http/deviceAPI";
const Profile = observer(() => {
    const { user } = useContext(Context)
    useEffect(() => {
        fetchOrders().then(data => {
            user.setOrders(data)
        })
    }, [])
    return (
        <Container className="d-flex justify-content-between mt-3">
            <Card className="d-flex flex-column mt-3 border-white shadow-sm" style={{ width: '65%', borderRadius: '16px' }}>
                <h3 className="p-3">Заказы</h3>
                <Row>

                    <Col className="ms-3 me-3">
                        {user.orders.map(order =>
                            <OrdersList key={order.orderId} items={order} />
                        )}
                    </Col>
                </Row>
            </Card>
        </Container>
    )
})
export default Profile;