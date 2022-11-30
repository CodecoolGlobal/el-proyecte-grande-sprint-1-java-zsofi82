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
