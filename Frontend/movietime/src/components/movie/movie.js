import React, { useState, useEffect } from "react";
import { Container, Row, Col, Button } from "react-bootstrap";
import { Player } from 'video-react';
import post from '../../images/free-images.jpg'
import "../../../node_modules/video-react/dist/video-react.css";
import axios from "axios";
import { useParams } from 'react-router-dom';


function Movie() {
    const [movieData, setMovieData] = useState(null);
    const { id } = useParams();
    
    useEffect(() => {

        
        async function fetchMovieData() {
            try {
                const response = await axios.get(`/api/v1/movies/fetchMovieName/${id}`, {
                    
                });
                setMovieData(response.data[0]);
            } catch (error) {
                console.error("Error fetching movie data: ", error);
            }
        }
        fetchMovieData();
    }, [id]);

    const addToWatchlist = async () => {

        console.log("Token is :", localStorage.getItem('access_toke'));
        try {
            await axios.post(`/api/v1/wishlist/AddtoWishList/${movieData.movie_id}`, null, {
                headers: {
                    Authorization: `Bearer ${localStorage.getItem('access_toke')}`
                }
            });
            alert("Added to Watchlist successfully!");
        } catch (error) {
            console.error("Error adding to Watchlist: ", error);
            alert("Failed to add to Watchlist!");
        }
    };

    return (
        <Container fluid style={{ backgroundColor: '#070F2B', color: '#FFFFFF' }}>
            {movieData && (
                <>
                    <Row>
                        <h1>{movieData.movie_title}</h1>
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
                                <h1>{movieData.movie_title}</h1>
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
                                <Col>{movieData.Language}</Col>
                            </Row>
                            <br />
                            <Row>
                                <Col><h4>Release Year: </h4></Col>
                                <Col>{movieData.release_date}</Col>
                            </Row>
                            <br />
                            <Row>
                                <Col><h4>Ratings:</h4></Col>
                                <Col>{movieData.rating}</Col>
                            </Row>
                            <Row>
                                <Button variant="outline-warning" onClick={addToWatchlist}>Add to Watch List</Button>{' '}
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
