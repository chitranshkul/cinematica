import React, { useState, useEffect } from "react";
import { Container, Row, Col, Button } from "react-bootstrap";
import { Player } from 'video-react';
import post from '../../images/free-images.jpg'
import "../../../node_modules/video-react/dist/video-react.css";
import axios from "axios";

function Movie() {
    const [movieData, setMovieData] = useState(null);

    useEffect(() => {
        async function fetchMovieData() {
            try {
                const response = await axios.get("YOUR_API_ENDPOINT_HERE");
                setMovieData(response.data);
            } catch (error) {
                console.error("Error fetching movie data: ", error);
            }
        }
        fetchMovieData();
    }, []);

    return (
        <Container fluid style={{ backgroundColor: '#070F2B', color: '#FFFFFF' }}>
            {movieData && (
                <>
                    <Row>
                        <h1>{movieData.name}</h1>
                    </Row>
                    <Row>
                        <Col>
                            <Player
                                playsInline
                                poster={movieData.posterlink}
                                src={movieData.movielink}
                                fluid={false}
                                height={900}
                                width={1890}
                            />
                        </Col>
                    </Row>
                    <br /><br />
                    <Row>
                        <Col md={9}>
                            <Row>
                                <h1>{movieData.name}</h1>
                            </Row>
                            <br /><br />
                            <Row>
                                <h5>
                                    Description of the Movie:
                                    <br /><br />
                                    {movieData.Description}
                                </h5>
                            </Row>
                        </Col>
                        <Col>
                            <Row>
                                <Col><h4>Genre: </h4></Col>
                                <Col>{movieData.genre}</Col>
                            </Row>
                            <br />
                            <Row>
                                <Col><h4>Language:</h4></Col>
                                <Col>{movieData.language}</Col>
                            </Row>
                            <br />
                            <Row>
                                <Col><h4>Release Year: </h4></Col>
                                <Col>{movieData.releaseDate}</Col>
                            </Row>
                            <br />
                            <Row>
                                <Col><h4>Certificate:</h4></Col>
                                <Col>{movieData.rating}</Col>
                            </Row>
                            <Row>
                                <Button variant="outline-warning">Add to Watch List</Button>{' '}
                            </Row>
                            <br /><br /><br />
                        </Col>
                    </Row>
                </>
            )}
        </Container>
    );
}

export default Movie;
