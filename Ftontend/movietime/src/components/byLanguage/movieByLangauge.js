import React, { useState } from 'react';
import { Container, Row, Col, Card, Button } from 'react-bootstrap';
import { useLanguage,LanguageProvider } from '../../context/LanguageContext';

const initialMovies = [
    {
        id: 1,
        name: "Inception",
        poster: "https://image.tmdb.org/t/p/w500/9gk7adHYeDvHkCSEqAvQNLV5Uge.jpg"
    },
    {
        id: 2,
        name: "Interstellar",
        poster: "https://image.tmdb.org/t/p/w500/gEU2QniE6E77NI6lCU6MxlNBvIx.jpg"
    },
    {
        id: 3,
        name: "The Dark Knight",
        poster: "https://image.tmdb.org/t/p/w500/qJ2tW6WMUDux911r6m7haRef0WH.jpg"
    }
];

function MovieByLanguage() {
    const [movies, setMovies] = useState(initialMovies);
    const { language, changeLanguage } = useLanguage();


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
                    My Watchlist with langage {language}
                </Row>
                <br></br>
                <Row>
                    {movies.map((movie) => (
                        <Col key={movie.id} sm={6} md={4} lg={3}>
                            <Card className="mb-3">
                                <Card.Img variant="top" src={movie.poster} />
                                <Card.Body>
                                    <Card.Title>{movie.name}</Card.Title>
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
