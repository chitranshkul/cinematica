import React, { useState, useEffect } from 'react';
import { Container, Row, Col, Card } from 'react-bootstrap';
import Carousel from 'react-bootstrap/Carousel';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
import image from '../../images/movie_banner_1.jpg';
import { Link } from 'react-router-dom';

const Home = () => {
    const [index, setIndex] = useState(0);
    const [actionMovies, setActionMovies] = useState([]);
    const [thrillerMovies, setThrillerMovies] = useState([]);
    const [comedyMovies, setComedyMovies] = useState([]);
    const [dramaMovies, setDramaMovies] = useState([]);
    const [scienceFictionMovies, setScienceFictionMovies] = useState([]);

    useEffect(() => {
        async function fetchActionMovies() {
            try {
                const response = await axios.get('/api/v1/movies/fetchGenre/action');
                setActionMovies(response.data);
            } catch (error) {
                console.error('Error fetching action movies:', error);
            }
        }

        async function fetchThrillerMovies() {
            try {
                const response = await axios.get('/api/v1/movies/fetchGenre/thriller');
                setThrillerMovies(response.data);
            } catch (error) {
                console.error('Error fetching thriller movies:', error);
            }
        }

        async function fetchComedyMovies() {
            try {
                const response = await axios.get('/api/v1/movies/fetchGenre/comedy');
                setComedyMovies(response.data);
                console.log(response.data);
            } catch (error) {
                console.error('Error fetching comedy movies:', error);
            }
        }

        async function fetchDramaMovies() {
            try {
                const response = await axios.get('/api/v1/movies/fetchGenre/drama');
                setDramaMovies(response.data);
            } catch (error) {
                console.error('Error fetching drama movies:', error);
            }
        }

        async function fetchScienceFictionMovies() {
            try {
                const response = await axios.get('/api/v1/movies/fetchGenre/scienceFiction');
                setScienceFictionMovies(response.data);
            } catch (error) {
                console.error('Error fetching science fiction movies:', error);
            }
        }

        fetchActionMovies();
        fetchThrillerMovies();
        fetchComedyMovies();
        fetchDramaMovies();
        fetchScienceFictionMovies();
    }, []);

    const handleSelect = (selectedIndex) => {
        setIndex(selectedIndex);
    };

    return (
        <Container fluid style={{ backgroundColor: '#070F2B', color: '#FFFFFF' }}>
            <Row>
                <Col>
                    <Carousel activeIndex={index} onSelect={handleSelect}>
                        <Carousel.Item style={{ height: '60vh' }}>
                            <img
                                className="d-block w-100"
                                src={image}
                                alt="Image One"
                            />
                            <Carousel.Caption>
                                <h3>First slide label</h3>
                                <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                            </Carousel.Caption>
                        </Carousel.Item>
                        <Carousel.Item style={{ height: '60vh' }}>
                            <img
                                className="d-block w-100"
                                src={image}
                                alt="Image One"
                            />
                            <Carousel.Caption>
                                <h3>Second slide label</h3>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                            </Carousel.Caption>
                        </Carousel.Item>
                        <Carousel.Item style={{ height: '60vh' }}>
                            <img
                                className="d-block w-100"
                                src={image}
                                alt="Image One"
                            />
                            <Carousel.Caption>
                                <h3>Third slide label</h3>
                                <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
                            </Carousel.Caption>
                        </Carousel.Item>
                    </Carousel>
                </Col>
            </Row>
            <br /><br />
            <div>
                <h1>Action</h1>

                <Row className="mb-3" id = "Action">

                    {actionMovies.map((movie, index) => (
                        <Link to={"/movie/"+movie.movie_title}>
                            <Col key={index} xs={6} sm={2}>
                                <Card className="mb-3">
                                    <Card.Img variant="top" src={movie.posterlink} />
                                </Card>
                            </Col>
                        </Link>
                    ))}
                </Row>
            </div>
            <div>
                <h1>Thriller</h1>
                <Row className="mb-3" id="Thriller">

                    {thrillerMovies.map((movie, index) => (
                        <Link to={"/movie/"+movie.movie_title}>
                            <Col key={index} xs={6} sm={2}>
                                <Card className="mb-3">
                                    <Card.Img variant="top" src={movie.posterlink} />
                                </Card>
                            </Col>
                        </Link>
                    ))}
                </Row>
            </div>
            <div>
                <h1>Comedy</h1>
                <Row className="mb-3" id ="Comedy">
                    {comedyMovies.map((movie, index) => (
                        <Link to={"/movie/"+movie.movie_title}>
                            <Col key={index} xs={6} sm={2}>
                                <Card className="mb-3">
                                    <Card.Img variant="top" src={movie.posterlink} />
                                </Card>
                            </Col>
                        </Link>
                    ))}
                </Row>
            </div>
            <div>
                <h1>Drama</h1>
                <Row className="mb-3" id="Drama">
                    {dramaMovies.map((movie, index) => (
                        <Link to="">
                            <Col key={index} xs={6} sm={2}>
                                <Card className="mb-3">
                                    <Card.Img variant="top" src={movie.posterlink} />
                                </Card>
                            </Col>
                        </Link>
                    ))}
                </Row>
            </div>
            <div>
                <h1>Science Fiction</h1>
                <Row className="mb-3" id="ScienceFiction">
                    {scienceFictionMovies.map((movie, index) => (
                        <Link to="">
                            <Col key={index} xs={6} sm={2}>
                                <Card className="mb-3">
                                    <Card.Img variant="top" src={movie.posterlink} />
                                </Card>
                            </Col>
                        </Link>
                    ))}
                </Row>
            </div>
            <br /><br />
        </Container>
    );
};

export default Home;
