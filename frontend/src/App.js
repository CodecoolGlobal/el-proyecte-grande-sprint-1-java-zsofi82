import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import './App.css';
import Home from './components/main/Home';
import Login from './components/login/Login';
import Registration from './components/registration/Registration';
import About from "./components/About";
import React from "react";
import User from "./components/user/User";

function App() {
  document.title = "Pick your spot"

  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/registration" element={<Registration />} />
          <Route path="/about" element={<About />} />
          <Route path="/user/:userId" element={<User />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
