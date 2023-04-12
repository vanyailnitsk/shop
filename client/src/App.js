import { observer } from 'mobx-react-lite';
import { object } from 'prop-types';
import React, { useContext, useState, useEffect } from 'react';
import { Spinner } from 'react-bootstrap';
import { BrowserRouter } from 'react-router-dom';
import { Context } from '.';
import AppRouter from './components/AppRouter';
import NavBar from './components/NavBar';
import { fetchBasketItems } from './http/deviceAPI';
import { check } from './http/userAPI';

const App = observer(() => {
    const {user} = useContext(Context)
	const {device} = useContext(Context)
	const [loading,setLoading] = useState(true)
    useEffect(() => {
		if (localStorage.getItem("token")==null) {
			setLoading(false)
			return
		}
        fetchBasketItems().then(data => {
			user.setIsAuth(true)
        }).finally(() => setLoading(false))
    }, [])

	if (loading) {
		return <Spinner animation="border"/>
	}

	document.body.style.backgroundColor = '#f6f6f9';
    return (
        <BrowserRouter>
            <NavBar />
            <AppRouter />
        </BrowserRouter>
    );
});

export default App;
