import React, { useState } from "react";
import { Form, Button, Alert } from "react-bootstrap";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import "./login.css";
import Logo from "../../images/Disney+_Hotstar_logo.svg.png";

const Login = () => {
    const navigate = useNavigate();

    const [inputEmail, setInputEmail] = useState("");
    const [inputPassword, setInputPassword] = useState("");

    const [show, setShow] = useState(false);
    const [loading, setLoading] = useState(false);

    const handleSubmit = async (event) => {
        event.preventDefault();
        setLoading(true);
        await delay(500);
        console.log(`Email :${inputEmail}, Password :${inputPassword}`);
        try {
            const response = await axios.post("http://localhost:8081/api/v1/auth/authenticate", {
                email: inputEmail,
                password: inputPassword
            });
            console.log(response.data); // Use this data as per your requirement
            setLoading(false);
            navigate("/home");
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
                <div className="h4 mb-2 text-center">Sign In</div>
                {/* Alert */}
                {show ? (
                    <Alert
                        className="mb-2"
                        variant="danger"
                        onClose={() => setShow(false)}
                        dismissible
                    >
                        Incorrect email or password.
                    </Alert>
                ) : (
                    <div />
                )}
                <Form.Group className="mb-2" controlId="email">
                    <Form.Label>Email</Form.Label>
                    <Form.Control
                        type="email"
                        value={inputEmail}
                        placeholder="Email"
                        onChange={(e) => setInputEmail(e.target.value)}
                        required
                    />
                </Form.Group>
                <Form.Group className="mb-2" controlId="password">
                    <Form.Label>Password</Form.Label>
                    <Form.Control
                        type="password"
                        value={inputPassword}
                        placeholder="Password"
                        onChange={(e) => setInputPassword(e.target.value)}
                        required
                    />
                </Form.Group>
                <Form.Group className="mb-2" controlId="checkbox">
                    <Form.Check type="checkbox" label="Remember me" />
                </Form.Group>
                {!loading ? (
                    <Button className="w-100" variant="primary" type="submit">
                        Log In
                    </Button>
                ) : (
                    <Button className="w-100" variant="primary" type="submit" disabled>
                        Logging In...
                    </Button>
                )}
                <div className="d-grid justify-content-end">
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

export default Login;
