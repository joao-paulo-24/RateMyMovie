const API_URL = "http://localhost:8080/movies";

export const getMovies = async () => {
    const response = await fetch(API_URL);
    return response.json();
}
