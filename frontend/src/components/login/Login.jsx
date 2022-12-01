import Footer from "../Footer"
import Navbar from "../Navbar"
import LoginForm from "./LoginForm"
import "./Login.css"

const Login = () => {

  return (
    <div className="loginContainer">
      <Navbar />
      <h1>Login:</h1>
      <LoginForm />
      <Footer />
    </div>
  )
}

export default Login