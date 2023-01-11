import RegistrationForm from "./RegistrationForm"
import './Registration.css'
import { useNavigate } from "react-router-dom"
import {useContext} from "react";
import {TokenContext} from "../../App";

const Registration = () => {
    const {token} = useContext(TokenContext)
    const navigate = useNavigate()

    function getCorrectRoute() {
        if (token) {
            navigate("/")
        } else {
            return (
                <div className="registrationContainer">
                    <h1>Registration:</h1>
                    <RegistrationForm />
                </div>)
        }
    }


    return (
        <>
            {getCorrectRoute()}
        </>
    )
}

export default Registration