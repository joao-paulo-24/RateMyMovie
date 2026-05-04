import { BrowserRouter, Routes, Route } from "react-router-dom";
import MovieList from "./components/MovieList";
import MovieForm from "./components/CreateMovie";
import { createMovie } from "./services/MovieService";

function App() {
  const handleCreateMovie = async (movie) => {
    try {
      return await createMovie(movie);
    } catch (err) {
      console.error(err);
      throw err;
    }
  };

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<MovieList />} />
        <Route
          path="/create"
          element={<MovieForm onMovieCreated={handleCreateMovie} />}
        />
      </Routes>
    </BrowserRouter>
  );
}

export default App;