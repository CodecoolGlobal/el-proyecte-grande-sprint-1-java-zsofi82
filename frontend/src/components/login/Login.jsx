import Footer from "../Footer"
import Navbar from "../Navbar"
import LoginForm from "./LoginForm"
import "./Login.css"

const Login = ({ loggedIn, setLoggedIn, userId, setUserId, userName, setUserName }) => {

  return (
    <div className="loginContainer">
      <Navbar loggedIn={loggedIn} />
      <h1>Login:</h1>
      <LoginForm loggedIn={loggedIn} setLoggedIn={setLoggedIn} setUserId={setUserId} setUserName={setUserName}/>
      <Footer />
    </div>
  )
}

export default Login