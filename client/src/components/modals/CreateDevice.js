import React, { useContext, useState } from "react";
import { Button, Col, Dropdown, Form, FormControl, Modal, Row } from "react-bootstrap";
import { Context } from "../..";
const CreateDevice = ({show, onHide}) => {
    const {device} = useContext(Context)
    const [info,setInfo] = useState([])

    const addInfo = () => {
        setInfo([...info,{title:'',description:'',number:Date.now()}])
    }

    const removeInfo = (number) => {
        setInfo(info.filter(i => i.number !== number))
    }
    return (
        <Modal
        show = {show}
        onHide = {onHide}
        size="lg"
        centered
        >
      <Modal.Header closeButton>
        <Modal.Title id="contained-modal-title-vcenter">
          Добавить устройство
        </Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <Form>
            <Dropdown className="mt-2 mb-2">
                <Dropdown.Toggle>Выбрать тип</Dropdown.Toggle>
                <Dropdown.Menu>
                    {device.types.map(type =>
                        <Dropdown.Item
                            onClick={() => device.setSelectedType(type)}
                            key={type.id}
                        >
                            {type.name}
                        </Dropdown.Item>
                    )}
                </Dropdown.Menu>
            </Dropdown>
            <Dropdown className="mt-2 mb-2">
                <Dropdown.Toggle>Выбрать бренд</Dropdown.Toggle>
                <Dropdown.Menu>
                    {device.brands.map(brand =>
                        <Dropdown.Item
                        >
                            {brand.name}
                        </Dropdown.Item>
                    )}
                </Dropdown.Menu>
            </Dropdown>
            <Form.Control
                className="mt-3"
                placeholder="Название устройства"
            />
            <Form.Control
                className="mt-3"
                placeholder="Стоимость устройства"
                type="number"
            />
            <Button
                variant={"outline-dark"}
                onClick={addInfo}
                className="mt-3"
            >
                Добавить свойство
            </Button>
            {info.map( i=>
                <Row className="mt-3" key={i.number}>
                    <Col md={4}>
                        <Form.Control placeholder="Название свойства"/>
                    </Col>
                    <Col md={4}>
                        <Form.Control placeholder="Описание свойства"/>
                    </Col>
                    <Col md={4} >
                        <Button variant={"outline-danger"} onClick={() => removeInfo(i.number)}>Удалить</Button>
                    </Col>
                </Row>
            )}
                   
        </Form>
      </Modal.Body>
      <Modal.Footer>
        <Button variant = {"outline-danger"} onClick={onHide}>Закрыть</Button>
        <Button variant = {"outline-success"} onClick={onHide}>Сохранить</Button>
      </Modal.Footer>
    </Modal>
    );
}

export default CreateDevice;