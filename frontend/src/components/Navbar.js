import Button from "./reusable_elements/Button"

const Navbar = () => {
  return (
    <nav className="navbar sticky-top navbar-expand-lg bg-dark text-light">
      <div class="container-fluid">
        <span class="navbar-brand mb-0 h1 text-light">Pick Your Spot</span>
        <ul className="flex-row-reverse navbar-nav">
          <li className="nav-item col m-1">
            <Button text={"Register"} ></Button></li>
          <li className="nav-item col m-1">
            <Button text={"Login"}></Button></li>
        </ul>
      </div>
    </nav>
  )
}

export default Navbar