import React from 'react';
import { Button, Container, Form, Nav, Navbar, NavDropdown } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import { useLanguage, LanguageProvider } from '../../context/LanguageContext';

function CustomeNavbar() {
    const { language, changeLanguage } = useLanguage(); // Update to useLanguage hook instead of useState

    const brandStyle = {
        fontWeight: 'bold',
        fontFamily: 'Arial, sans-serif',
        fontSize: '1.5rem'
    };

    const buttonStyle = {
        marginRight: '10px' // Adjust the value as needed
    };

    const handleLanguageChange = (selectedLanguage) => {
        changeLanguage(selectedLanguage); // Update the language using the provided context function
    };

    return (
        <Navbar bg="dark" data-bs-theme="dark">
            <Container fluid>
                <Navbar.Brand href="#" style={brandStyle}>CINEMATICA</Navbar.Brand>
                <Navbar.Toggle aria-controls="navbarScroll" />
                <Navbar.Collapse id="navbarScroll">
                    <Nav
                        className="me-auto my-2 my-lg-0"
                        style={{ maxHeight: '100px' }}
                        navbarScroll
                    >
                        <Nav.Link href="/home">Home</Nav.Link>
                        <Nav.Link href="watchlist">My WatchList</Nav.Link>
                        <NavDropdown title="Genere" id="navbarScrollingDropdown">
                        <NavDropdown.Item href="#Action">Action</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item href="#Thriller">Thriller</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item href="#Comedy">Comedy</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item href="#Drama">Drama</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item href="#ScienceFiction">Science Fiction</NavDropdown.Item>
                        </NavDropdown>
                        <NavDropdown title="Language" id="navbarScrollingDropdown">
                            <NavDropdown.Item onClick={() => handleLanguageChange("Hindi")}>Hindi</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item onClick={() => handleLanguageChange("English")}>English</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item onClick={() => handleLanguageChange("Marathi")}>Marathi</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item onClick={() => handleLanguageChange("Gujrati")}>Gujrati</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item onClick={() => handleLanguageChange("Tamil")}>Tamil</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item onClick={() => handleLanguageChange("Telagu")}>Telagu</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item onClick={() => handleLanguageChange("Kannada")}>Kannada</NavDropdown.Item>
                        </NavDropdown>
                    </Nav>
                    <Form className="d-flex">
                        <Form.Control
                            type="search"
                            placeholder="Search"
                            className="me-2"
                            aria-label="Search"
                        />
                        <Button variant="light" style={buttonStyle}>Login</Button>
                        <Button variant="outline-info" className='mr-2'>SignUp</Button>
                    </Form>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
}

export default CustomeNavbar;
