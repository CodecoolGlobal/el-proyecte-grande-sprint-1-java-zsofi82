import logo from './logo.svg';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import './App.css';
import Home from './components/main/Home';
import Login from './components/login/Login';
import Logout from './components/logout/Logout';
import Registration from './components/registration/Registration';
import About from "./components/About";
import User from "./components/user/User";
// import User from './components/User';

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/logout" element={<Logout />} />
          <Route path="/registration" element={<Registration />} />
          <Route path="/about" element={<About />} />
          <Route path="/user" element={<User />} />
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
    </div>
  );
}

export default App;
