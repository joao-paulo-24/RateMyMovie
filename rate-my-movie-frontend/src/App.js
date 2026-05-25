import { BrowserRouter, Routes, Route } from "react-router-dom";

import MovieList from "./components/MovieList";
import MovieForm from "./components/CreateMovie";
import Login from "./components/Login";
import Register from "./components/Register";
import Navbar from "./components/Navbar";
import ProtectedRoute from "./components/ProtectedRoute";
import ReviewMovie from "./components/MovieReview";
import ReviewsList from "./components/ReviewsList";

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
      <Navbar />

      <Routes>
        <Route path="/" element={<MovieList />} />

        {/* 🔒 ROTA PROTEGIDA */}
        <Route
          path="/create"
          element={
            <ProtectedRoute>
              <MovieForm onMovieCreated={handleCreateMovie} />
            </ProtectedRoute>
          }
        />

        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route
          path="/review/:id"
          element={
            <ProtectedRoute>
              <ReviewMovie />
            </ProtectedRoute>
          }
        />
        <Route path="/reviews/:id" element={<ReviewsList />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
