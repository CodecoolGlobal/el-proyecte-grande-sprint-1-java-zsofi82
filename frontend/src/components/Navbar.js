import { useNavigate } from "react-router-dom";
import Button from "./reusable_elements/Button"


const Navbar = ({ loggedIn, userName, userId }) => {
  const navigate = useNavigate();

  return (
    <nav className="navbar sticky-top navbar-expand-lg bg-dark text-light">
      <div className="container-fluid">
        <span className="navbar-brand mb-0 h1 text-light backToHome" onClick={() => { navigate("/") }}>Pick Your Spot</span>
        <ul className="flex-row navbar-nav">
          <div>{"logged in: " + loggedIn + " user: " + userName + " id: " + userId}</div>
          {!loggedIn && <li className="nav-item col navbarButton">
            <Button text={"Register"} onClick={() => { navigate("/registration") }}></Button>
          </li>}
          {!loggedIn && <li className="nav-item col navbarButton" >
            <Button text={"Login"} onClick={() => { navigate("/login") }}></Button>
          </li>}
          {loggedIn && <li className="nav-item col navbarButton">
            <Button text={"Logout"} classname={"btn-link"} onClick={() => { navigate("/logout") }} ></Button>
          </li>}
           {/* TODO Profile button comes here */}
          <li className="nav-item col navbarButton">
            <Button text={"About"} classname={"btn-link"} onClick={() => { navigate("/about") }} ></Button>
          </li>
        </ul>
      </div>
    </nav>
  )
}

export default Navbar