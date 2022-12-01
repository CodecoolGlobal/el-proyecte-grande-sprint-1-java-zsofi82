import Footer from "../Footer"
import Navbar from "../Navbar"
import LoginForm from "./LoginForm"
import "./Login.css"

const Login = ({ loggedIn, setLoggedIn }) => {

  return (
    <div className="loginContainer">
      <Navbar loggedIn={loggedIn} />
      <h1>Login:</h1>
      <LoginForm loggedIn={loggedIn} setLoggedIn={setLoggedIn} />
      <Footer />
    </div>
  )
}

export default Login