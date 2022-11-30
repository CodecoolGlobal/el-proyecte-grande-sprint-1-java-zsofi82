import Footer from "../Footer"
import Navbar from "../Navbar"
import LoginForm from "./LoginForm"
import "./Login.css"

const Login = ({ setSession, setCookie, cookies, loggedIn, setLoggedIn }) => {

  return (
    <div className="loginContainer">
      <Navbar />
      <h1>Login:</h1>
      <LoginForm setSession={setSession} setCookie={setCookie} cookies={cookies} loggedIn={loggedIn} setLoggedIn={setLoggedIn}/>
      <Footer />
    </div>
  )
}

export default Login