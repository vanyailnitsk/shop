import { observer } from 'mobx-react-lite';
import { object } from 'prop-types';
import React, { useContext, useState, useEffect } from 'react';
import { BrowserRouter } from 'react-router-dom';
import { Context } from '.';
import AppRouter from './components/AppRouter';
import NavBar from './components/NavBar';
import { fetchBasketItems } from './http/deviceAPI';
import { check } from './http/userAPI';

const App = observer(() => {
    const {user} = useContext(Context)
	const {device} = useContext(Context)
    useEffect(() => {
		if (localStorage.getItem("token")==null) return
        fetchBasketItems().then(data => {
			user.setIsAuth(true)
        })
    }, [])

    return (
        <BrowserRouter>
            <NavBar />
            <AppRouter />
        </BrowserRouter>
    );
});

export default App;
