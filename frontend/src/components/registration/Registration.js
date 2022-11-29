import Navbar from "../Navbar"
import RegistrationForm from "./RegistrationForm"
import Title from "./Title"
import './registration.css'

const Registration = () => {
  return (
    <div className="registratinoContainer">
      <Navbar />
      <Title />
      <RegistrationForm />
      {/* <Footer /> */}
    </div>
  )
}

export default Registration