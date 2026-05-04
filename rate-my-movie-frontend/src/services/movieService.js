const API_URL = "http://localhost:8080/movies";

export const getMovies = async () => {
  const response = await fetch(API_URL);
  return response.json();
};

export const createMovie = async (movie) => {
  const response = await fetch(API_URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(movie),
  });

  return response.json();
};