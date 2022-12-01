import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Button from "./reusable_elements/Button"


const Navbar = () => {
  const navigate = useNavigate();
  const [loggedIn, setLoggedIn] = useState()

  useEffect(() => {
    const userName = sessionStorage.getItem("username")
    const userId = sessionStorage.getItem("userid")

    if (userName && userId) {
      setLoggedIn(true)
    } else {
      setLoggedIn(false)
    }
  },[setLoggedIn])


  return (
    <nav className="navbar sticky-top">
      <div className="container-fluid">
        <span className="navbar-brand mb-0 h1 backToHome" onClick={() => { navigate("/") }}>Pick Your Spot</span>
        <ul className="flex-row navbar-nav">
          {!loggedIn && <li className="nav-item col navbarButton">
            <Button bootstrapClassname={"navbar-button-style"} text={"Register"} onClick={() => { navigate("/registration") }}></Button>
          </li>}
          {!loggedIn && <li className="nav-item col navbarButton" >
            <Button bootstrapClassname={"navbar-button-style"} text={"Login"} onClick={() => { navigate("/login") }}></Button>
          </li>}
          {loggedIn && <li className="nav-item col navbarButton">
            <Button bootstrapClassname={"navbar-button-style"} text={"Profile"} classname={"btn-link"} className="navbar-button-style" onClick={() => { navigate(`/user/${sessionStorage.getItem("userid")}`) }} ></Button>
          </li>}
          {loggedIn && <li className="nav-item col navbarButton">
            <Button bootstrapClassname={"navbar-button-style"} text={"Logout"} classname={"btn-link"} onClick={() => { navigate("/logout") }} ></Button>
          </li>}
          <li className="nav-item col navbarButton">
            <Button bootstrapClassname={"navbar-button-style"} text={"About"} classname={"btn-link"} onClick={() => { navigate("/about") }} ></Button>
          </li>
        </ul>
      </div>
    </nav>
  )
}

export default Navbar