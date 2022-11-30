import { useNavigate } from "react-router-dom";
import Button from "./reusable_elements/Button"
import { useCookies } from 'react-cookie';
import { useEffect, useState } from "react";


const Navbar = () => {
  const navigate = useNavigate();
  const [cookies, setCookie] = useCookies();
  const [rend, setRend] = useState(1);

  useEffect(()=> {
    setRend(prev => prev + 1)
  },[cookies])

  return (
    <nav className="navbar sticky-top navbar-expand-lg bg-dark text-light">
      <div className="container-fluid">
        <span className="navbar-brand mb-0 h1 text-light backToHome" onClick={() => { navigate("/") }}>Pick Your Spot</span>
        <ul className="flex-row navbar-nav">
          <div>{console.log(cookies.userName)}</div>
          {!cookies.userName && <li className="nav-item col navbarButton">
            <Button text={"Register"} onClick={() => { navigate("/registration") }}></Button>
          </li>}
          {!cookies.userName && <li className="nav-item col navbarButton" >
            <Button text={"Login"} onClick={() => { navigate("/login") }}></Button>
          </li>}
          {cookies.userName && <li className="nav-item col navbarButton">
            <Button text={"Logout"} classname={"btn-link"} onClick={() => { navigate("/logout") }} ></Button>
          </li>}
          <li className="nav-item col navbarButton">
            <Button text={"About"} classname={"btn-link"} onClick={() => { navigate("/about") }} ></Button>
          </li>
        </ul>
      </div>
    </nav>
  )
}

export default Navbar