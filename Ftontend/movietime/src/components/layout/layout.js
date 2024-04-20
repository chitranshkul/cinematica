import React from "react";

import { Routes, Route, Navigate } from "react-router-dom";
import Login from '../signin/login';
import Home from "../home/home";
import Movie from "../movie/movie";
import CustomeNavbar from "../navbar/navbar";
import Watchlist from "../watchlist/watchlist";
import Register from "../signup/siginup";

function Layout() {

    return (
        <>
            <CustomeNavbar />
            {/* <Login/> */}
            <div>
                <Routes>
                    <Route path="/" element={<Navigate to="login" />} />
                    <Route path="login" element={<Login />} />
                    <Route path="signup" element = {<Register/>}/>
                    <Route path="home" element={<Home/>}/>
                    <Route path="movie" element ={<Movie/>}/>
                    <Route path="watchlist" element = {<Watchlist/>}/>
                </Routes>
            </div>
            {/* <Footer /> */}
        </>
    )
}

export default Layout;