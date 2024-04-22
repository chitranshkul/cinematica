import React from "react";

import { Routes, Route, Navigate } from "react-router-dom";
import Login from '../signin/login';
import Home from "../home/home";
import Movie from "../movie/movie";
import CustomeNavbar from "../navbar/navbar";
import Watchlist from "../watchlist/watchlist";
import Register from "../signup/siginup";
import { LanguageProvider } from "../../context/LanguageContext";
import MovieByLanguage from "../byLanguage/movieByLangauge";
import AddMovie from "../AddMovie/add movie";

function Layout() {

    return (
        <>
            <LanguageProvider>
                <CustomeNavbar />
                {/* <Login/> */}
                <div>
                    <Routes>
                        <Route path="/" element={<Navigate to="login" />} />
                        <Route path="login" element={<Login />} />
                        <Route path="signup" element={<Register />} />
                        <Route path="home" element={<Home />} />
                        <Route path="movie/:id" element={<Movie />} />
                        <Route path="watchlist" element={<Watchlist />} />
                        <Route path="moviebylanguage" element={<MovieByLanguage/>}/>
                        <Route path="admin" element={<AddMovie/>}/>
                    </Routes>
                </div>
                {/* <Footer /> */}
            </LanguageProvider>
        </>
    )
}

export default Layout;