// import logo from './logo.svg';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import './App.css';
import Home from './components/main/Home';
import Login from './components/login/Login';
import Logout from './components/logout/Logout';
import Registration from './components/registration/Registration';
import About from "./components/About";
import React, { useState } from "react";
import User from "./components/user/User";
// import User from './components/User';

function App() {
  const [loggedIn, setLoggedIn] = useState(false)

  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/" element={<Home loggedIn={loggedIn} />} />
          <Route path="/login" element={<Login loggedIn={loggedIn} setLoggedIn={setLoggedIn} />} />
          <Route path="/logout" element={<Logout loggedIn={loggedIn} setLoggedIn={setLoggedIn} />} />
          <Route path="/registration" element={<Registration loggedIn={loggedIn} />} />
          <Route path="/about" element={<About loggedIn={loggedIn} />} />
          <Route path="/user/:userId" element={<User loggedIn={loggedIn} />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
