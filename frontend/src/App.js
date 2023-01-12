import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import './App.css';
import Home from './components/main/Home';
import Login from './components/login/Login';
import Registration from './components/registration/Registration';
import About from "./components/About";
import React, {createContext, useState} from "react";
import User from "./components/user/User";
import Layout from "./components/Layout";
import Admin from "./components/admin/Admin";

export const TokenContext = createContext(null)

function App() {
    document.title = "Pick your spot"
    const [token, setToken] = useState(localStorage.getItem("token"))

    return (
        <div className="App">
            <TokenContext.Provider value={{token, setToken}}>
                <Router>
                    <Routes>
                        <Route path="/" element={<Layout/>}>
                            <Route path="/" element={<Home/>}/>
                            <Route path="/login" element={<Login/>}/>
                            <Route path="/registration" element={<Registration/>}/>
                            <Route path="/about" element={<About/>}/>
                            <Route path="/user/:userId" element={<User/>}/>
                            <Route path="/admin" element={<Admin/>}/>
                        </Route>
                    </Routes>
                </Router>
            </TokenContext.Provider>
        </div>
    );
}

export default App;
