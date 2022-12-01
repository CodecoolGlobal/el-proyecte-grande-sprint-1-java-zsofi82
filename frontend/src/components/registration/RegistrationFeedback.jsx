
const RegistrationFeedback = ({ serverRes }) => {

    function checkUser() {
        if(!serverRes) {
            return "Please register."
        } else if (serverRes.status === 200){
            return "Success! User registered!"
        } else if (serverRes.status === 400) {
            return "Invalid user data!"
        } else if (serverRes.status === 409) {
            return "User already exists!"
        }
    }

    return (
        <p>{checkUser()}</p>
    )
}

export default RegistrationFeedback