import React, { useState } from 'react';
import { Container, Row, Col, Card } from 'react-bootstrap';
import Carousel from 'react-bootstrap/Carousel';
import 'bootstrap/dist/css/bootstrap.min.css';
import image from '../../images/movie_banner_1.jpg';

const Home = () => {
    const [index, setIndex] = useState(0);

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
            <br></br><br></br>
            <Row className="mb-3">
                <h1>
                    Action
                </h1>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 1"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 2"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 3"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 4"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 5"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 5"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
            </Row>

            <Row className="mb-3">
                <h1>
                    Thriller
                </h1>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 1"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 2"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 3"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 4"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 5"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 5"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
            </Row>

            <Row className="mb-3">
                <h1>
                    Comedy
                </h1>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 1"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 2"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 3"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 4"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 5"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 5"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
            </Row>

            <Row className="mb-3">
                <h1>
                    Drama
                </h1>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 1"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 2"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 3"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 4"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 5"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 5"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
            </Row>

            <Row className="mb-3">
                <h1>
                    Science Fiction
                </h1>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 1"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 2"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 3"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 4"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 5"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
                <Col xs={6} sm={2}>
                    <img
                        src="https://via.placeholder.com/150"
                        alt="Image 5"
                        style={{ width: '100%', height: 'auto', borderRadius: '20px' }}
                    />
                </Col>
            </Row>
            <br></br><br></br>
        </Container>
    );
};

export default Home;
