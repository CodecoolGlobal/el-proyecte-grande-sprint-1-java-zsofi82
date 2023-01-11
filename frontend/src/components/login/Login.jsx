
import LoginForm from "./LoginForm"
import "./Login.css"
import { useNavigate } from "react-router-dom"
import {useContext} from "react";
import {TokenContext} from "../../App";

const Login = () => {
    const navigate = useNavigate()
    const {token} = useContext(TokenContext)


    function getCorrectRoute() {
        if (token) {
            navigate("/")
        } else {
            return (
            <div className="loginContainer">
                <h1>Login:</h1>
                <LoginForm />
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