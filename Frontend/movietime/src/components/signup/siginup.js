import React, { useState } from "react";
import { Form, Button, Alert } from "react-bootstrap";
import axios from "axios";
import { Link,useNavigate } from "react-router-dom";
import "./signup.css";
import Logo from "../../images/Disney+_Hotstar_logo.svg.png";

const Register = () => {
    

    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const [show, setShow] = useState(false);
    const [loading, setLoading] = useState(false);

    const handleSubmit = async (event) => {
        event.preventDefault();
        setLoading(true);
        await delay(500);
        console.log(`First Name: ${firstName}, Last Name: ${lastName}, Email: ${email}, Password: ${password}`);
        try {
            const response = await axios.post("/api/v1/auth/register", {
                firstname: firstName,
                lastname: lastName,
                email: email,
                password: password,
                role: "USER"
            });
            console.log(response.data); // Use this data as per your requirement
            setLoading(false);
        } catch (error) {
            setShow(true);
            setLoading(false);
        }
    };

    const handlePassword = () => {};

    function delay(ms) {
        return new Promise((resolve) => setTimeout(resolve, ms));
    }

    return (
        <div
            className="sign-in__wrapper"
            style={{ backgroundColor: '#070F2B' }}
        >
            {/* Overlay */}
            <div className="sign-in__backdrop"></div>
            {/* Form */}
            <Form className="shadow p-4 bg-white rounded" onSubmit={handleSubmit}>
                {/* Header */}
                <img
                    className="img-thumbnail mx-auto d-block mb-2"
                    src={Logo}
                    alt="logo"
                />
                <div className="h4 mb-2 text-center">Register</div>
                {/* Alert */}
                {show ? (
                    <Alert
                        className="mb-2"
                        variant="danger"
                        onClose={() => setShow(false)}
                        dismissible
                    >
                        Error occurred while registering.
                    </Alert>
                ) : (
                    <div />
                )}
                <Form.Group className="mb-2" controlId="firstName">
                    <Form.Label>First Name</Form.Label>
                    <Form.Control
                        type="text"
                        value={firstName}
                        placeholder="First Name"
                        onChange={(e) => setFirstName(e.target.value)}
                        required
                    />
                </Form.Group>
                <Form.Group className="mb-2" controlId="lastName">
                    <Form.Label>Last Name</Form.Label>
                    <Form.Control
                        type="text"
                        value={lastName}
                        placeholder="Last Name"
                        onChange={(e) => setLastName(e.target.value)}
                        required
                    />
                </Form.Group>
                <Form.Group className="mb-2" controlId="email">
                    <Form.Label>Email</Form.Label>
                    <Form.Control
                        type="email"
                        value={email}
                        placeholder="Email"
                        onChange={(e) => setEmail(e.target.value)}
                        required
                    />
                </Form.Group>
                <Form.Group className="mb-2" controlId="password">
                    <Form.Label>Password</Form.Label>
                    <Form.Control
                        type="password"
                        value={password}
                        placeholder="Password"
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                </Form.Group>
                <Button className="w-100" variant="primary" type="submit" disabled={loading}>
                    {loading ? "Registering..." : "Register"}
                </Button>
                <div className="d-grid justify-content-between mt-2">
                    <Link to="/login">Already have an account? Sign in</Link>
                    <Button
                        className="text-muted px-0"
                        variant="link"
                        onClick={handlePassword}
                    >
                        Forgot password?
                    </Button>
                </div>
            </Form>
        </div>
    );
};

export default Register;
