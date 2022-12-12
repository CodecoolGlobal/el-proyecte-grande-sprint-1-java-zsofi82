import Navbar from "../Navbar"
import RegistrationForm from "./RegistrationForm"
import './Registration.css'
import Footer from "../Footer"

const Registration = () => {
  return (
    <div className="registrationContainer">
      <h1>Registration:</h1>
      <RegistrationForm />
    </div>
  )
}

export default Registration