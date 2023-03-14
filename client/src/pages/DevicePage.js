import React, { useEffect, useState } from "react";
import { Col, Container, Image, Row,Card, Button, ListGroup } from "react-bootstrap";
import { useParams } from "react-router-dom";
import { fetchOneDevice } from "../http/deviceAPI";

const DevicePage = () => {
    const [device, setDevice] = useState({info: []})
    const {id} = useParams()
    useEffect(() => {
        fetchOneDevice(id).then(data => setDevice(data))
    }, [])
    const info = []
    return (
        <Container className="mt-3">
            <Card className="p-3 shadow-sm" style={{margin:20,paddingTop:20}}>
            <Row>
                <Col md={4}>
                    <Image height={300} src={device.image}/>
                </Col>
                <Col md={4}>
                    <Row className="d-flex flex-column align-items-center">
                        <h2>{device.name}</h2>
                        <div
                            className="d-flex align-items-center justify-content-center"
                        >
                            {device.rating}
                        </div>
                    </Row>
                </Col>
                <Col md={4}>
                    <Card
                        className="d-flex flex-column align-items-center justify-content-around"
                        style={{width: 300, height: 300, fontSize: 32, border: '3px solid lightgray'}}
                    >
                        <h3>{device.price} руб.</h3>
                        <Button variant={"outline-dark"}>Добавить в корзину</Button>
                    </Card>
                </Col>
            </Row>

            </Card>
            <Card className="p-3 mt-4 shadow-sm" style={{margin:20,paddingTop:20}}>
            <Row className="d-flex flex-row ml-1">
                <Col md={3}>
                <ListGroup >
                    <ListGroup.Item>Характеристики</ListGroup.Item>
                    <ListGroup.Item>Отзывы</ListGroup.Item>
                </ListGroup>
                </Col>
                {/* <Col md={9}>
                {device.info.map((elem) =>
                    <Row key={elem.id} style={{background:  'transparent', padding: 10,width:400}} className="d-flex flex-column">
                        {elem.title}: {elem.description}
                    </Row>
                )}
                </Col> */}
                
            </Row>
            </Card>
        </Container>
    )
}
export default DevicePage; 