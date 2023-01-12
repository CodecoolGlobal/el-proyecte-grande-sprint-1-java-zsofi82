import LoginForm from "./LoginForm"
import "./Login.css"
import { Navigate } from "react-router-dom"
import { useContext } from "react";
import { TokenContext } from "../../App";

const Login = () => {
    const { token } = useContext(TokenContext)

    return (
        <>
            {token ?
                <Navigate to="/" replace />
                :
                <div className="loginContainer">
                    <h1>Login:</h1>
                    <LoginForm />
                </div>
            }
        </>
    )
}

export default Login