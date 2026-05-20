import { Link, useNavigate } from "react-router-dom";
import { AuthService } from "../services/AuthService";
import { useState, useEffect } from "react";

export default function Navbar() {
  const navigate = useNavigate(); // 🔥 FALTAVA ISTO

  const [isAuth, setIsAuth] = useState(AuthService.isAuthenticated());

  useEffect(() => {
    const updateAuth = () => {
      setIsAuth(AuthService.isAuthenticated());
    };

    window.addEventListener("authChange", updateAuth);

    return () => {
      window.removeEventListener("authChange", updateAuth);
    };
  }, []);

  const handleLogout = () => {
    AuthService.logout();
    setIsAuth(false);
    navigate("/login");
  };

  return (
    <nav style={styles.nav}>
      <div>
        <Link to="/">Movies</Link>
        {" | "}
        <Link to="/create">Create Movie</Link>
      </div>

      <div>
        {!isAuth ? (
          <>
            <Link to="/login">Login</Link>
            {" | "}
            <Link to="/register">Register</Link>
          </>
        ) : (
          <button onClick={handleLogout}>Logout</button>
        )}
      </div>
    </nav>
  );
}

const styles = {
  nav: {
    display: "flex",
    justifyContent: "space-between",
    padding: "10px",
    borderBottom: "1px solid #ccc",
  },
};
