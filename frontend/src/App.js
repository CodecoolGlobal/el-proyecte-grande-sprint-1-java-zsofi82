import logo from './logo.svg';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import './App.css';
import Home from './components/main/Home';
import Login from './components/login/Login';
import Logout from './components/logout/Logout';
import Registration from './components/registration/Registration';
import About from "./components/About";
import React from "react";
import { CookiesProvider, useCookies } from "react-cookie";
import User from "./components/user/User";
// import User from './components/User';

function App() {
  const [cookies, setCookie] = useCookies(["user"]);

  return (
    <div className="App">
      <CookiesProvider>
        <Router>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/login" element={<Login setCookie={setCookie} cookies={cookies}/>} />
            <Route path="/logout" element={<Logout />} />
            <Route path="/registration" element={<Registration />} />
            <Route path="/about" element={<About />} />
          </Routes>
        </Router>
      </CookiesProvider>
    </div>
  );
}

export default App;
