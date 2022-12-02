import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import './App.css';
import Home from './components/main/Home';
import Login from './components/login/Login';
import Registration from './components/registration/Registration';
import About from "./components/About";
import React from "react";
import User from "./components/user/User";
import Layout from "./pages/Layout.jsx";

function App() {
  React.useEffect(() => {
    document.title = "Pick your spot"
  }, []);

  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/" element={<Layout />}>
            <Route path="/" element={<Home />} />
            <Route path="/login" element={<Login />} />
            <Route path="/registration" element={<Registration />} />
            <Route path="/about" element={<About />} />
            <Route path="/user/:userId" element={<User />} />
          </Route>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
