import React from 'react'

const LoginFeedback = ({ serverRes }) => {
    function chechkLogin() {
        if (!serverRes) {
            return "Please log in."
        } else if (serverRes.status === 200) {
            return "Success! User loged in!"
        } else if (serverRes.status === 400) {
            return "Invalid username or password!"
        }
    }

    return (
        <div>{chechkLogin()}</div>
    )
}

export default LoginFeedback