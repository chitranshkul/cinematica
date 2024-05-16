import React, { useState, useEffect } from 'react';
import { Container, Row, Col, Card, Button } from 'react-bootstrap';
import axios from 'axios';
import { Link } from 'react-router-dom';

function Watchlist() {
    const [movies, setMovies] = useState([]);

    useEffect(() => {
        async function fetchWatchlistMovies() {
            try {
                const response = await axios.get('/api/v1/wishlist/ListMoviesinWishlist', {
                    headers: {
                        Authorization: `Bearer ${localStorage.getItem('access_toke')}`
                    }
                });
                setMovies(response.data);
                console.log(response.data);
            } catch (error) {
                console.error('Error fetching watchlist movies:', error);
            }
        }
        fetchWatchlistMovies();
    }, []);

    const removeFromWatchlist = async (id) => {
        try {
            await axios.delete(`http://localhost:8081/api/v1/watchlist/${id}`, {
                headers: {
                    Authorization: `Bearer ${localStorage.getItem('access_token')}`
                }
            });
            const updatedMovies = movies.filter(movie => movie.id !== id);
            setMovies(updatedMovies);
            alert('Movie removed from watchlist successfully!');
        } catch (error) {
            console.error('Error removing movie from watchlist:', error);
            alert('Failed to remove movie from watchlist!');
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
                                    <Card.Title>{movie.movie_title}</Card.Title>
                                    <Link to={"/movie/"+movie.movie_title}><Button variant="primary" className="me-2">Watch</Button></Link>
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
