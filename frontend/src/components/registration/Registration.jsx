import RegistrationForm from "./RegistrationForm"
import './Registration.css'
import { useNavigate } from "react-router-dom"

const Registration = ({loggedIn}) => {
    const navigate = useNavigate()

    function getCorrectRoute() {
        if (loggedIn) {
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