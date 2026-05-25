import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getReviewsByMovie } from "../services/ReviewService";

export default function MovieReviews() {
  const { id } = useParams();
  const [reviews, setReviews] = useState([]);

  useEffect(() => {
    fetchReviews();
  }, []);

  const fetchReviews = async () => {
    try {
      const data = await getReviewsByMovie(id);
      setReviews(data);
    } catch (err) {
      console.error("Error loading reviews:", err);
    }
  };

  return (
    <div>
      <h2>Movie Reviews</h2>

      {reviews.length === 0 && <p>No reviews yet.</p>}

      {reviews.map((review) => (
        <div
          key={review.id}
          style={{
            border: "1px solid #ccc",
            padding: "10px",
            marginBottom: "10px",
          }}
        >
          <p><strong>User:</strong> {review.user?.username}</p>
          <p><strong>Rating:</strong> {review.rating}</p>
          <p>{review.text}</p>
        </div>
      ))}
    </div>
  );
}