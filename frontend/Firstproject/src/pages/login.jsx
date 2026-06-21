import { useState } from 'react'
import './Register.css'
import { Link, useNavigate } from 'react-router-dom';
export default function Login() {

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState("");
    const navigate = useNavigate();

    const handleLogin = async () => {
        const myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");

        const raw = JSON.stringify({
            "email": email,
            "password": password
        });

        const requestOptions = {
            method: "POST",
            headers: myHeaders,
            body: raw,
        };

        const response = await fetch("http://localhost:8086/login", requestOptions)
        const body = await response.text()
        console.log(body);
        localStorage.setItem("token", body);
        if (!response.ok) {
            console.log(body)
            setError(body.message)
            throw new Error(body.message, response.status)
        }
        navigate("/")
    }

    return <>
        <div className="box">
            <h1>Login</h1>

            <input type="email" placeholder="Email" value={email} onChange={(e) => setEmail(e.target.value)} />
            <input type="password" placeholder="password" value={password} onChange={(e) => setPassword(e.target.value)} />
            <button onClick={handleLogin} type="button">Login</button>
            <button type="reset">Cancel</button>
            <p>Don't Have An Account? <Link to='/register'>Register</Link></p>
            < p className='error' >{error}</p>

        </div>

    </>
}