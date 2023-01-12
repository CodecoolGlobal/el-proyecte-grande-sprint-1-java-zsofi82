import RegistrationForm from "./RegistrationForm"
import './Registration.css'
import { Navigate } from "react-router-dom"
import { useContext } from "react";
import { TokenContext } from "../../App";

const Registration = () => {
    const { token } = useContext(TokenContext)

    return (
        <>
            {token ?
                <Navigate to="/" replace />
                :
                <div className="registrationContainer">
                    <h1>Registration:</h1>
                    <RegistrationForm />
                </div>
            }
        </>
    )
}

export default Registration