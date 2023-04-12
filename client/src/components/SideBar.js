import { observer } from "mobx-react-lite";
import React, { useContext } from "react";
import { ListGroup, Nav } from "react-bootstrap";
import { Context } from "..";
import '../style/sidebar.css'
import { SHOP_ROUTE } from "../utils/consts";

const SideBar = observer(() => {
    const {device} = useContext(Context)
    return (
        <ListGroup className="d-flex flex-column mt-3 ms-3" variant="flush">
            {device.types.map(type =>
                <ListGroup.Item
                    style={{cursor:'pointer'}}
                    action href={SHOP_ROUTE + '/' + type.url}
                    className="fw-bold"
                >
                    {type.name}
                </ListGroup.Item>    
            )}
        </ListGroup>
    )
})
export default SideBar; 