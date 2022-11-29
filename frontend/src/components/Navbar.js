import { useNavigate } from "react-router-dom";
import Button from "./reusable_elements/Button"


const Navbar = () => {
  const navigate = useNavigate();

  return (
    <nav className="navbar sticky-top navbar-expand-lg bg-dark text-light">
      <div class="container-fluid">
        <span class="navbar-brand mb-0 h1 text-light" onClick={() => { navigate("/") }}>Pick Your Spot</span>
        <ul className="flex-row navbar-nav">
          <li className="nav-item col m-1">
            <Button text={"Register"} onClick={() => { navigate("/registration") }}></Button></li>
          <li className="nav-item col m-1">
            <Button text={"Login"} onClick={() => { navigate("/login") }}></Button></li>
          <li className="nav-item col m-1">
            <Button text={"About"} bootstrapClassname={"btn-link"} onClick={() => { navigate("/about") }} ></Button></li>
        </ul>
      </div>
    </nav>
  )
}

export default Navbar