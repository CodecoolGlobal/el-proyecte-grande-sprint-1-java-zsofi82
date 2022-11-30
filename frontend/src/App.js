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
import { CookiesProvider, useCookies } from "react-cookie";


function App() {
  const [cookies, setCookie, removeCookie] = useCookies(["user"]);
  const [loggedIn, setLoggedIn] = useState(false)

  return (
    <div className="App">
      <CookiesProvider>
        <Router>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/login" element={<Login setCookie={setCookie} cookies={cookies} loggedIn={loggedIn} setLoggedIn={setLoggedIn}/>} />
            <Route path="/logout" element={<Logout removeCookie={removeCookie} loggedIn={loggedIn} setLoggedIn={setLoggedIn}/>} />
            <Route path="/registration" element={<Registration />} />
            <Route path="/about" element={<About />} />
            <Route path="/user/:userId" element={<User />} />
            {/* <Route
          {/* <Route
            // this path will match URLs like
            // - /teams/hotspur
            // - /teams/real
            path="/user/:id"
            // the matching param will be available to the loader
            loader={({ params }) => {
              console.log(params.id); // "hotspur"
            }}
            // and the action
            action={({ params }) => { }}
            element={<User />}
          />; */}
          </Routes>
        </Router>
      </CookiesProvider>
    </div>
  );
}

export default App;
