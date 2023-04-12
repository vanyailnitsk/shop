import { observer } from "mobx-react-lite";
import React, { useContext, useEffect } from "react";
import { Col, Container, Row } from "react-bootstrap";
import { useParams } from "react-router-dom";
import { Context } from "..";
import DeviceList from "../components/DeviceList";
import { fetchDevices, fetchTypes } from "../http/deviceAPI";

const Shop = observer(() => {
    const {device} = useContext(Context);
    const {type} = useParams()
    useEffect(() => {
        fetchDevices(type).then(data => {
            device.setDevices(data)
        })
    }, [])
    return (
        
        <Container>
            <Row className="mt-2">
            {device.types.filter(elem => elem.url == type).map (type =>
                <h2>{type.name} </h2>
            )}
                <Col md={3}>
                </Col>
                <Col md={9}>
                    {/* <BrandBar/> */}
                    <DeviceList/>
                </Col>
            </Row>
        </Container>
    )
})
export default Shop; 