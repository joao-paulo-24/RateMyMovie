import { useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { createReview } from "../services/ReviewService";

export default function ReviewMovie() {
  const { id } = useParams();
  const navigate = useNavigate();

  const [text, setText] = useState("");
  const [rating, setRating] = useState("");

  const handleSubmit = async () => {
    try {
      const user = JSON.parse(localStorage.getItem("user"));

      await createReview({
        movieId: Number(id),
        userId: user.id,
        text,
        rating: Number(rating),
      });

      alert("Review created!");
      navigate("/");
    } catch (err) {
      console.error(err);
      alert("Error creating review");
    }
  };

  return (
    <div>
      <h2>Review Movie</h2>

      <textarea
        placeholder="Write your review..."
        onChange={(e) => setText(e.target.value)}
      />

      <input
        type="number"
        placeholder="Rating (1-10)"
        min="1"
        max="10"
        onChange={(e) => setRating(e.target.value)}
      />

      <button onClick={handleSubmit}>
        Submit Review
      </button>
    </div>
  );
}