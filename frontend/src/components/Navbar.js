import Button from "./reusable_elements/Button"

const Navbar = () => {
  return (
    <nav className="navbar navbar-expand-lg bg-dark text-light">
      <div class="container-fluid">
        <span class="navbar-brand mb-0 h1 text-light">Pick Your Spot</span>
        <ul className="d-flex">
          <li><Button text={"Register"}></Button></li>
          <li><Button text={"Login"}></Button></li>
        </ul>
      </div>
    </nav>
  )
}

export default Navbar