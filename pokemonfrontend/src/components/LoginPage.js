import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';

function LoginPage({ setLoggedIn, setUser }) {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [loginStatus, setLoginStatus] = useState('');
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.get(`http://localhost:8080/login/${username}/${password}`);
            if (response.data !== null) {
                setLoginStatus('Login successful');
                setLoggedIn(true);
                setUser(response.data);
            } else {
                setLoginStatus('Invalid username or password');
            }
        } catch (error) {
            console.error('Error logging in:', error);
            setLoginStatus('Error logging in');
        }
    };

    useEffect(() => {
        let timeout;
        if (loginStatus === 'Login successful') {
            timeout = setTimeout(() => {
                navigate('/');
            }, 1000);
        }
        return () => clearTimeout(timeout);
    }, [loginStatus, navigate]);

    return (
        <div>
            <h2>Login</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Username:</label>
                    <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} />
                </div>
                <div>
                    <label>Password:</label>
                    <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
                </div>
                <button type="submit">Login</button>
            </form>
            {loginStatus && <p>{loginStatus}</p>}
            <p>Don't have an account? <Link to="/signup">Make new account</Link></p>
        </div>
    );
}

export default LoginPage;
