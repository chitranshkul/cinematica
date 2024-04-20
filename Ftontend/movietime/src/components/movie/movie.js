import React from "react";
import { Container, Row, Col, Button } from "react-bootstrap";
import { Player } from 'video-react';
import post from '../../images/free-images.jpg'
import "../../../node_modules/video-react/dist/video-react.css";

function Movie() {
    return (
        <Container fluid style={{ backgroundColor: '#070F2B', color: '#FFFFFF' }}>
            <Row>
                <h1></h1>
            </Row>
            <Row>
                <Col>
                    <Player
                        playsInline
                        poster="/assets/poster.png"
                        src="https://cinematica.s3.eu-north-1.amazonaws.com/1713532706137_Despicable%20Me%204%20Official%20Trailer.mp4?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20240419T131832Z&X-Amz-SignedHeaders=host&X-Amz-Expires=86399&X-Amz-Credential=AKIAW3MEFBHYBMEYF2NG%2F20240419%2Feu-north-1%2Fs3%2Faws4_request&X-Amz-Signature=f64473dae07f2823586cbc52904a4d6460d611f3267e102658db6d4e68a65803"
                        fluid={false}
                        height={900}
                        width={1890}
                    />
                </Col>
            </Row>
            <br></br><br></br>
            <Row>
                <Col md={9}>
                    <Row>
                        <h1>Name of the Movie</h1>

                    </Row>
                    <br></br><br></br>
                    <Row>
                        <h5>
                            Descrption of the Movie:
                            <br></br><br></br>
                            Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the
                            industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type
                            and scrambled it to make a type specimen book. It has survived not only five centuries, but also the
                            leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s
                            with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop
                            publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                        </h5>
                    </Row>
                </Col>
                <Col>
                    <Row>
                        <Col><h4>Genre: </h4></Col>
                        <Col>Action</Col>
                    </Row>
                    <br></br>
                    <Row>
                        <Col><h4>Language:</h4></Col>
                        <Col>Hindi</Col>
                    </Row>
                    <br></br>
                    <Row>
                        <Col><h4>Release Year: </h4></Col>
                        <Col>2012</Col>
                    </Row>
                    <br></br>
                    <Row>
                        <Col><h4>Certificate:</h4></Col>
                        <Col>UA</Col>
                    </Row>
                    <Row>
                        <Button variant="outline-warning">Add to Watch List</Button>{' '}

                    </Row>
                    <br></br><br></br><br></br>
                </Col>
            </Row>

        </Container>
    )
}

export default Movie;
