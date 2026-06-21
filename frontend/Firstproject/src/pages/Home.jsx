import { useEffect, useState } from 'react';
import './Home.css'
import { useNavigate } from 'react-router-dom';
export default function Home() {
    // Create a state to store the movies data
    const [movies, setMovies] = useState([]);
    const navigate = useNavigate();
    const[page,setPage]=useState(0);
    const getMovies = async () => {
        const token = localStorage.getItem("token");
        const myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");
        myHeaders.append("Authorization", `Bearer ${token}`); // `` ''

        const requestOptions = {
            method: "GET",
            headers: myHeaders,
            redirect: "follow"
        };

        const response = await fetch(` http://localhost:8086/movies?page=${page}&size=10`, requestOptions)
        const data = await response.json()
        // Update the movies state with the data received from the API
        setMovies([...movies, ...data])
    }
    const Logout=()=>{
        localStorage.removeItem('token')
        navigate("/login")
    }

    useEffect(() => {
        getMovies()
    }, [page])
    return <>
        <header>
            <nav>
                <h1>IMDB</h1>
                <input type="text" placeholder="Search movies..." />
                <button onClick={Logout}>Logout</button>
            </nav>
        </header>
        <main>
            {/* Display the movies data */}
            <div className="movies">
                {movies.map((movie) => {
                    return <div key={movie.id} className="movie">
                        <img src={movie.posterUrl} alt={movie.title} />
                        <h2>{movie.title}<span>({movie.publishedYear})</span></h2>
                        <p>{movie.description.substring(0, 30)}...</p>
                    </div>
                })}
            </div>
        </main>
        <footer>
            <button onClick={() => setPage(page + 1)}>Load More</button>
        </footer>
</>
}