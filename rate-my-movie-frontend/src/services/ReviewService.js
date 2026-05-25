import { AuthService } from "./AuthService";

const API_URL = "http://localhost:8080/reviews";

// CREATE review
export const createReview = async (review) => {
  const token = AuthService.getToken();

  const response = await fetch(API_URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      Authorization: `Bearer ${token}`,
    },
    body: JSON.stringify(review),
  });

  if (!response.ok) {
    throw new Error("Failed to create review");
  }

  return response.json();
};

// GET reviews by movie
export const getReviewsByMovie = async (movieId) => {
  const response = await fetch(`${API_URL}/movie/${movieId}`);

  if (!response.ok) {
    throw new Error("Failed to fetch reviews");
  }

  return response.json();
};