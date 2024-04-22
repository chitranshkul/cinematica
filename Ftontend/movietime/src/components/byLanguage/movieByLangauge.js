import React, { useState, useEffect } from 'react';
import { Container, Row, Col, Card, Button } from 'react-bootstrap';
import axios from 'axios';
import { useLanguage } from '../../context/LanguageContext';
import { Link } from 'react-router-dom';

function MovieByLanguage() {
    const [movies, setMovies] = useState([]);
    const { language, changeLanguage } = useLanguage();

    useEffect(() => {
        async function fetchMoviesByLanguage() {
            try {
                const response = await axios.get(`/api/v1/movies/fetchMovieBylanguage/${language}`);
                setMovies(response.data);
            } catch (error) {
                console.error('Error fetching movies by language:', error);
            }
        }
        fetchMoviesByLanguage();
    }, [language]);

    const removeFromWatchlist = (id) => {
        const updatedMovies = movies.filter(movie => movie.id !== id);
        setMovies(updatedMovies);
    };

    return (
        <div style={{ backgroundColor: '#070F2B' }}>
            <Container>
                <br />
                <br />
                <Row style={{ color:'white'}}>
                    My Watchlist with language {language}
                </Row>
                <br></br>
                <Row>
                    {movies.map((movie) => (
                        <Col key={movie.id} sm={6} md={4} lg={3}>
                            <Card className="mb-3">
                                <Card.Img variant="top" src={movie.posterlink} />
                                <Card.Body>
                                    <Card.Title>{movie.movie_title}</Card.Title>
                                    <Link to={"/movie/"+movie.movie_title}><Button variant="primary">Watch</Button></Link>
                                </Card.Body>
                            </Card>
                        </Col>
                    ))}
                </Row>
            </Container>
        </div>
    )
}

export default MovieByLanguage;
