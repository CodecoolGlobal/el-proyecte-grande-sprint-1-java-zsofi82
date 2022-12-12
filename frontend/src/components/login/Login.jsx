
import LoginForm from "./LoginForm"
import "./Login.css"
import { useNavigate } from "react-router-dom"

const Login = ({ loggedIn, setLoggedIn }) => {
    const navigate = useNavigate()

    function getCorrectRoute() {
        if (loggedIn) {
            navigate("/")
        } else {
            return (
            <div className="loginContainer">
                <h1>Login:</h1>
                <LoginForm loggedIn={loggedIn} setLoggedIn={setLoggedIn} />
            </div>)
        }
    }

    return (
        <>
            {getCorrectRoute()}
        </>
    )
}

export default Login