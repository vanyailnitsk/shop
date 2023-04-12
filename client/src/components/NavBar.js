import { observer } from "mobx-react-lite";
import React, { useContext, useEffect, useState } from "react";
import { Button, Container, Image, Nav, Navbar, NavDropdown, Spinner } from "react-bootstrap";
import { useNavigate } from "react-router";
import { Context } from "..";
import cart from '../assets/cart.png';
import usericon from '../assets/usericon.png';
import logout from '../assets/logout.png';
import { fetchTypes } from "../http/deviceAPI";
import header from '../style/header.css'
import { ADMIN_ROUTE, BASKET_ROUTE, LOGIN_ROUTE, ORDERS_ROUTE, SHOP_ROUTE } from "../utils/consts";

const NavBar = observer(() => {
    const { user } = useContext(Context)
    const { device } = useContext(Context)
    const [auth, setAuth] = useState(user.isAuth)

    const navigate = useNavigate()
    useEffect(() => {
        fetchTypes().then(data => device.setTypes(data))
    }, [])

    const [show, setShow] = useState(false);

    const showDropdown = (e) => {
        setShow(!show);
    }
    const hideDropdown = e => {
        setShow(false);
    }
    const loginHref = () => {
        return user.isAuth ? '' : LOGIN_ROUTE
    }


    const logOut = () => {
        user.setUser({})
        user.setIsAuth(false)
        localStorage.clear()
        navigate(SHOP_ROUTE)
    }
    return (
        <Navbar collapseOnSelect expand="lg" bg="" style={header} variant="dark" p-0 >
            <Container className="">
                <Navbar.Brand href={SHOP_ROUTE} style={{ fontSize: '35px' }}>BEST BUY</Navbar.Brand>
                <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                <Navbar.Collapse id="responsive-navbar-nav">
                    <Nav className="me-auto">
                        <Nav.Link href="#features">Акции</Nav.Link>
                        {/* <Nav.Link href="#pricing">Pricing</Nav.Link> */}
                        <NavDropdown title="Категории" id="collasible-nav-dropdown"
                            show={show}
                            onMouseEnter={showDropdown}
                            onMouseLeave={hideDropdown}
                        >
                            {device.types.map(type =>
                                <NavDropdown.Item
                                    href={SHOP_ROUTE + '/' + type.url}
                                    onClick={() => device.setSelectedType(type.id)}
                                >
                                    {type.name}
                                </NavDropdown.Item>
                            )}
                        </NavDropdown>
                    </Nav>

                    <Nav classname="ml-auto">
                        {user.isAuth ?
                            <Nav.Link onClick={() => navigate(ADMIN_ROUTE)}>Admin</Nav.Link>
                            : <p></p>
                        }
                        <Nav.Link href={BASKET_ROUTE} className="d-flex flex-column align-items-center">
                            <Image height={30} src={cart}></Image>
                            <p>Корзина</p>
                        </Nav.Link>

                        {user.isAuth ?
                            <Nav.Link
                                className="d-flex flex-column align-items-center"
                                href={ORDERS_ROUTE}
                            >
                                <Image height={30} src={usericon}></Image>
                                <p>Профиль</p>
                            </Nav.Link>
                            :
                            <Nav.Link
                                className="d-flex flex-column align-items-center"
                                href={LOGIN_ROUTE}
                            >
                                <Image height={30} src={usericon}></Image>
                                <p>Войти</p>
                            </Nav.Link>
                        }
                        {user.isAuth &&
                            <Nav.Link onClick={() => logOut()} className="d-flex flex-column align-items-center"
                            >
                                <Image height={30} src={logout}></Image>
                                <p>Выйти</p>
                            </Nav.Link>
                        }

                    </Nav>

                </Navbar.Collapse>
            </Container>
        </Navbar>
    )
})
export default NavBar; 