import Footer from "../Footer"
import Navbar from "../Navbar"
import LoginForm from "./LoginForm"
import "./Login.css"

const Login = ({ setSession, setCookie, cookies }) => {
 
  return (
    <div className="loginContainer">
      <Navbar />
      <h1>Login:</h1>
      <LoginForm setSession={setSession} setCookie={setCookie} cookies={cookies} />
      <Footer />
    </div>
  )
}

export default Login