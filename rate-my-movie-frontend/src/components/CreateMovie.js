import { useState } from "react";
import { useNavigate } from "react-router-dom";

function MovieForm({ onMovieCreated }) {
  const navigate = useNavigate();

  const [title, setTitle] = useState("");
  const [poster, setPoster] = useState("");
  const [rating, setRating] = useState(5);
  const [error, setError] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError("");

    if (!title.trim()) {
      setError("Title is required");
      return;
    }

    const ratingNumber = Number(rating);

    if (ratingNumber < 0 || ratingNumber > 10) {
      setError("Rating must be between 0 and 10");
      return;
    }

    const newMovie = {
      title,
      poster,
      rating: ratingNumber,
    };

    try {
      const created = await onMovieCreated(newMovie);

      if (created) {
        setTitle("");
        setPoster("");
        setRating(5);

        navigate("/");
      }
    } catch {
      setError("Failed to create movie");
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Add a movie</h2>

      {error && <p style={{ color: "red" }}>{error}</p>}

      <div>
        <label>Title:</label>
        <input
          value={title}
          onChange={(e) => setTitle(e.target.value)}
        />
      </div>

      <div>
        <label>Poster:</label>
        <input
          type="url"
          value={poster}
          onChange={(e) => setPoster(e.target.value)}
        />
      </div>

      <div>
        <label>Rating:</label>
        <input
          type="number"
          min="0"
          max="10"
          value={rating}
          onChange={(e) => setRating(e.target.value)}
        />
      </div>

      <button type="submit">Create Movie</button>
    </form>
  );
}

export default MovieForm;