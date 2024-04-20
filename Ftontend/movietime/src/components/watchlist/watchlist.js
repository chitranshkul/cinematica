import React, { useState, useEffect } from 'react';
import { Container, Row, Col, Card, Button } from 'react-bootstrap';
import axios from 'axios';

function Watchlist() {
    const [movies, setMovies] = useState([]);

    useEffect(() => {
        async function fetchWatchlistMovies() {
            try {
                const response = await axios.get('http://localhost:8081/api/v1/watchlist');
                setMovies(response.data);
            } catch (error) {
                console.error('Error fetching watchlist movies:', error);
            }
        }
        fetchWatchlistMovies();
    }, []);

    const removeFromWatchlist = async (id) => {
        try {
            await axios.delete(`http://localhost:8081/api/v1/watchlist/${id}`);
            const updatedMovies = movies.filter(movie => movie.id !== id);
            setMovies(updatedMovies);
        } catch (error) {
            console.error('Error removing movie from watchlist:', error);
        }
    };

    return (
        <div style={{ backgroundColor: '#070F2B' }}>
            <Container>
                <br />
                <br />
                <Row style={{ color:'white'}}>
                    My Watchlist
                </Row>
                <br></br>
                <Row>
                    {movies.map((movie) => (
                        <Col key={movie.id} sm={6} md={4} lg={3}>
                            <Card className="mb-3">
                                <Card.Img variant="top" src={movie.posterlink} />
                                <Card.Body>
                                    <Card.Title>{movie.movielink}</Card.Title>
                                    <Button variant="primary" className="me-2">Watch</Button>
                                    <Button variant="danger" onClick={() => removeFromWatchlist(movie.id)}>Remove</Button>
                                </Card.Body>
                            </Card>
                        </Col>
                    ))}
                </Row>
            </Container>
        </div>
    )
}

export default Watchlist;
