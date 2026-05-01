import { useEffect, useState } from "react";
import { getMovies } from "./services/movieService";

function App() {
  const [movies, setMovies] = useState([]);

  useEffect(() => {
    getMovies().then((data) => setMovies(data));
  }, []);

  return (
    <div>
      <h1>Movies 🎬</h1>

      <div>
        {movies.map((movie) => (
          <div key={movie.id}>
            <h2>{movie.title}</h2>
            <img src={movie.poster} width="150" />
            <p>⭐ {movie.rating}</p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;
