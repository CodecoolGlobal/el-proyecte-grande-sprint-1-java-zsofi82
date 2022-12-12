
import LoginForm from "./LoginForm"
import "./Login.css"

const Login = ({loggedIn, setLoggedIn}) => {

  return (
    <div className="loginContainer">
      <h1>Login:</h1>
      <LoginForm loggedIn={loggedIn} setLoggedIn={setLoggedIn}/>
    </div>
  )
}

export default Login