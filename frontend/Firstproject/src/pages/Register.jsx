import { useState } from 'react'
import './Register.css'
import { Link, useNavigate } from 'react-router-dom';
export default function Register() {
    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();
    const [error, setError] = useState("");

    const handleRegister = async () => {
        const myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");

        const raw = JSON.stringify({
            "name": username,
            "email": email,
            "password": password
        });

        const requestOptions = {
            method: "POST",
            headers: myHeaders,
            body: raw
        };

        const response = await fetch("http://localhost:8086/register", requestOptions)
        const body = await response.json()
        if (!response.ok) {

            console.log(body)
            setError(body.message)
            throw new Error("Request Failed With Status", response.status)

        }
        console.log(body)
        navigate("/login")

    }
    return <>
        <div className="box">
            <h1>Register</h1>
            <input type="text" placeholder="username" value={username} onChange={(e) => setUsername(e.target.value)} />
            <input type="email" placeholder="Email" value={email} onChange={(e) => setEmail(e.target.value)} />
            <input type="password" placeholder="password" value={password} onChange={(e) => setPassword(e.target.value)} />
            <button onClick={handleRegister} type="button">Register</button>
            <button type="reset">Cancel</button>
            <p>Already Have An Account? <Link to='/login'>Login</Link></p>
            < p className='error' >{error}</p>


        </div>

    </>
}