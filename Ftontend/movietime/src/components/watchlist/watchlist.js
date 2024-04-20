
import React from 'react';
import { Container, Row, Col, Card, Button } from 'react-bootstrap';

const movies = [
    {
        name: "Inception",
        poster: "https://image.tmdb.org/t/p/w500/9gk7adHYeDvHkCSEqAvQNLV5Uge.jpg"
    },
    {
        name: "Interstellar",
        poster: "https://image.tmdb.org/t/p/w500/gEU2QniE6E77NI6lCU6MxlNBvIx.jpg"
    },
    {
        name: "The Dark Knight",
        poster: "https://image.tmdb.org/t/p/w500/qJ2tW6WMUDux911r6m7haRef0WH.jpg"
    }
];

function Watchlist() {
    return (
        <Container>
            <br></br><br></br>
            <Row>
                My Watchlist
            </Row>
            <Row>
                {movies.map((movie, index) => (
                    <Col key={index} sm={6} md={4} lg={3}>
                        <Card className="mb-3">
                            <Card.Img variant="top" src={movie.poster} />
                            <Card.Body>
                                <Card.Title>{movie.name}</Card.Title>
                                <Button variant="primary">Watch</Button>
                            </Card.Body>
                        </Card>
                    </Col>
                ))}
            </Row>
        </Container>
    )
}

export default Watchlist