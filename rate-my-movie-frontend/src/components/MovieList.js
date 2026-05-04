import { useEffect, useState } from "react";
import { getMovies } from "../services/MovieService";
import { Link } from "react-router-dom";

function MovieList() {
  const [movies, setMovies] = useState([]);

  useEffect(() => {
    fetchMovies();
  }, []);

  const fetchMovies = async () => {
    try {
      const data = await getMovies();
      setMovies(data);
    } catch (err) {
      console.error("Error fetching movies:", err);
    }
  };

  return (
    <div>
      <h1>Movies</h1>

      <Link to="/create">
        <button>Add Movie</button>
      </Link>

      <ul>
        {movies.map((movie) => (
          <li key={movie.id}>
            <h3>{movie.title}</h3>

            {movie.poster && (
              <img
                src={movie.poster}
                alt={"NO IMAGE"}
                width="100"
              />
            )}

            <p>Rating: {movie.rating}</p>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default MovieList;