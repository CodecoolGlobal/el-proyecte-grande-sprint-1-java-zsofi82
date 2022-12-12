import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import './App.css';
import Home from './components/main/Home';
import Login from './components/login/Login';
import Registration from './components/registration/Registration';
import About from "./components/About";
import React, { useEffect, useState } from "react";
import User from "./components/user/User";
import Layout from "./components/Layout";

function App() {
    document.title = "Pick your spot"
    const [loggedIn, setLoggedIn] = useState()

    useEffect(() => {
        const userName = sessionStorage.getItem("username")
        const userId = sessionStorage.getItem("userid")
    
        setLoggedIn(userName && userId)
      }, [loggedIn, setLoggedIn])

    return (
        <div className="App">
            <Router>
                <Routes>
                    <Route path="/" element={<Layout loggedIn={loggedIn} setLoggedIn={setLoggedIn}/>}>
                        <Route path="/" element={<Home />} />
                        <Route path="/login" element={<Login loggedIn={loggedIn} setLoggedIn={setLoggedIn}/>} />
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
