const API_URL = "http://localhost:8080"; 

export const AuthService = {
  login: async (email, password) => {
    const response = await fetch(`${API_URL}/auth/login`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({ email, password })
    });

    if (!response.ok) {
      throw new Error("Login failed");
    }

    const data = await response.json();

    localStorage.setItem("token", data.token);

    return data;
  },

  logout: () => {
    localStorage.removeItem("token");
  },

  getToken: () => localStorage.getItem("token"),

  isAuthenticated: () => !!localStorage.getItem("token")
};