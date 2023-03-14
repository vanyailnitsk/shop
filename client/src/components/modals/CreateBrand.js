import React from "react";
import { Button, Form, FormControl, Modal } from "react-bootstrap";
const CreateBrand = ({show, onHide}) => {
    return (
        <Modal
        show = {show}
        onHide = {onHide}
        size="lg"
        centered
        >
      <Modal.Header closeButton>
        <Modal.Title id="contained-modal-title-vcenter">
          Добавить бренд
        </Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <Form>
            <FormControl placeholder="Название бренда"/>
        </Form>
      </Modal.Body>
      <Modal.Footer>
        <Button variant = {"outline-danger"} onClick={onHide}>Закрыть</Button>
        <Button variant = {"outline-success"} onClick={onHide}>Сохранить</Button>
      </Modal.Footer>
    </Modal>
    );
}

export default CreateBrand;