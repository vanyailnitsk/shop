import { observer } from "mobx-react-lite";
import React, { useContext, useEffect } from "react";
import { Button, Container, Nav, Navbar, NavDropdown } from "react-bootstrap";
import { Context } from "..";
import { fetchTypes } from "../http/deviceAPI";
import { ADMIN_ROUTE, BASKET_ROUTE, LOGIN_ROUTE, SHOP_ROUTE } from "../utils/consts";

const NavBar = observer(() => {
    const {user} = useContext(Context)
    const {device} = useContext(Context)

    useEffect(() => {
      fetchTypes().then(data => device.setTypes(data))
    }, [])
    return (
        <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark">
      <Container>
        <Navbar.Brand href={SHOP_ROUTE}>Best Buy</Navbar.Brand>
        <Navbar.Toggle aria-controls="responsive-navbar-nav" />
        <Navbar.Collapse id="responsive-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link href="#features">Акции</Nav.Link>
            {/* <Nav.Link href="#pricing">Pricing</Nav.Link> */}
            <NavDropdown title="Категории" id="collasible-nav-dropdown">
            {device.types.map(type =>
                <NavDropdown.Item
                    href={SHOP_ROUTE+'/'+type.url}
                    onClick={() => device.setSelectedType(type.id)}
                >
                    {type.name}
                </NavDropdown.Item>    
            )}
            </NavDropdown>
          </Nav>
          {user.isAuth ?
            <Nav classname="ml-auto">
                <Nav.Link href={ADMIN_ROUTE}>Admin</Nav.Link>
                <Nav.Link href={BASKET_ROUTE}>Корзина</Nav.Link>
                <Button variant={"outline-light"} onClick={() => user.setIsAuth(true)} className="ml-3">
                    Профиль
                </Button>
            </Nav>
            :
            <Nav classname="ml-auto">
            <Button href={LOGIN_ROUTE}  variant={"outline-light"}  className="ml-2">
                Авторизация
            </Button>
            </Nav>
          }
          
        </Navbar.Collapse>
      </Container>
    </Navbar>
    )
})
export default NavBar; 