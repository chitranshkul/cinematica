import React, { useState } from 'react';
import { Container, Form, Button } from 'react-bootstrap';
import axios from 'axios';

function AddMovie() {
    const [movieData, setMovieData] = useState({
        title: '',
        description: '',
        rating: 0,
        genre: '',
        language: '',
        duration: '',
        releaseDate: '',
        moviefilename: '',
        posterfilename: '',
        trending: false
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setMovieData({
            ...movieData,
            [name]: value
        });
    };


    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const formData = new FormData();
            formData.append('title', movieData.title);
            formData.append('description', movieData.description);
            formData.append('rating', movieData.rating);
            formData.append('genre', movieData.genre);
            formData.append('language', movieData.language);
            formData.append('duration', movieData.duration);
            formData.append('releaseDate', movieData.releaseDate);
            formData.append('moviefilename', movieData.moviefilename);
            formData.append('posterfilename', movieData.posterfilename);
            formData.append('trending', movieData.trending);

            await axios.post('/api/v1/movies/addMovie', formData);
            alert('Movie added successfully!');
            setMovieData({
                title: '',
                description: '',
                rating: 0,
                genre: '',
                language: '',
                duration: '',
                releaseDate: '',
                moviefilename: '',
                posterfilename: '',
                trending: false
            });
        } catch (error) {
            console.error('Error adding movie:', error);
            alert('Failed to add movie!');
        }
    };

    return (
        <Container style={{color:"white"}}>
            <h1>Add Movie</h1>
            <Form onSubmit={handleSubmit}>
                <Form.Group controlId="title">
                    <Form.Label>Title</Form.Label>
                    <Form.Control
                        type="text"
                        placeholder="Enter title"
                        name="title"
                        value={movieData.title}
                        onChange={handleChange}
                    />
                </Form.Group>

                <Form.Group controlId="description">
                    <Form.Label>Description</Form.Label>
                    <Form.Control
                        as="textarea"
                        rows={3}
                        placeholder="Enter description"
                        name="description"
                        value={movieData.description}
                        onChange={handleChange}
                    />
                </Form.Group>

                <Form.Group controlId="rating">
                    <Form.Label>Rating</Form.Label>
                    <Form.Control
                        type="number"
                        placeholder="Enter rating"
                        name="rating"
                        value={movieData.rating}
                        onChange={handleChange}
                    />
                </Form.Group>

                <Form.Group controlId="genre">
                    <Form.Label>Genre</Form.Label>
                    <Form.Control
                        type="text"
                        placeholder="Enter genre"
                        name="genre"
                        value={movieData.genre}
                        onChange={handleChange}
                    />
                </Form.Group>

                <Form.Group controlId="language">
                    <Form.Label>Language</Form.Label>
                    <Form.Control
                        type="text"
                        placeholder="Enter language"
                        name="language"
                        value={movieData.language}
                        onChange={handleChange}
                    />
                </Form.Group>

                <Form.Group controlId="duration">
                    <Form.Label>Duration</Form.Label>
                    <Form.Control
                        type="text"
                        placeholder="Enter duration"
                        name="duration"
                        value={movieData.duration}
                        onChange={handleChange}
                    />
                </Form.Group>

                <Form.Group controlId="releaseDate">
                    <Form.Label>Release Date</Form.Label>
                    <Form.Control
                        type="text"
                        placeholder="Enter release date"
                        name="releaseDate"
                        value={movieData.releaseDate}
                        onChange={handleChange}
                    />
                </Form.Group>

                <Form.Group controlId="releaseDate">
                    <Form.Label>Release Date</Form.Label>
                    <Form.Control
                        type="text"
                        placeholder="Enter release date"
                        name="releaseDate"
                        value={movieData.releaseDate}
                        onChange={handleChange}
                    />
                </Form.Group>

                <Form.Group controlId="releaseDate">
                    <Form.Label>Movie Path</Form.Label>
                    <Form.Control
                        type="text"
                        placeholder="Enter release date"
                        name="moviefilename"
                        value={movieData.moviefilename}
                        onChange={handleChange}
                    />
                </Form.Group>

                <Form.Group controlId="releaseDate">
                    <Form.Label>Poster Path</Form.Label>
                    <Form.Control
                        type="text"
                        placeholder="Enter release date"
                        name="posterfilename"
                        value={movieData.posterfilename}
                        onChange={handleChange}
                    />
                </Form.Group>

                <Button variant="primary" type="submit">
                    Submit
                </Button>
            </Form>
        </Container>
    );
}

export default AddMovie;
