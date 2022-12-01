import Navbar from "../Navbar"
import RegistrationForm from "./RegistrationForm"
import './Registration.css'
import Footer from "../Footer"

const Registration = ({ loggedIn, userName, userId }) => {
  return (
    <div className="registrationContainer">
      <Navbar />
      <h1>Registration:</h1>
      <RegistrationForm />
      <Footer />
    </div>
  )
}

export default Registration