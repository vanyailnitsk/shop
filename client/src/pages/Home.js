import { observer } from "mobx-react-lite";
import React, { useContext, useEffect } from "react";
import { Col, Container, ListGroup, Nav, Row } from "react-bootstrap";
import { Context } from "..";
import SideBar from "../components/SideBar";
import { fetchTypes } from "../http/deviceAPI";
import { SHOP_ROUTE } from "../utils/consts";
import '../style/sidebar.css'
const Home = observer(() => {
    const { device } = useContext(Context)
    return (
        <Container fluid>
            <Row>
                <Col xs={2}>
                    <SideBar/>
                </Col>
                <Col xs={10} className="mt-3 ">
                    this is a test
                </Col>
            </Row>

        </Container>
    )
})

export default Home;