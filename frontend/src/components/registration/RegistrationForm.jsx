import { useEffect, useState } from "react"
import { useNavigate } from "react-router-dom"
import Button from '../reusable_elements/Button.js'

const RegistrationForm = () => {
    const [userData, setUserData] = useState()
    const [serverRes, setServerRes] = useState()
    const navigate = useNavigate()

    function grabFormData(e) {
        e.preventDefault()
        const userName = e.target['username'].value
        const userPassword = e.target['password'].value
        const userEmail = e.target['email'].value
        const data = { "username": userName, "password": userPassword, "email": userEmail }
        e.target.reset()
        const update = () => { setUserData(data) }
        update()
    }

    function calculateFeedback() {
        if (!serverRes) {
            return "Please register."
        } else if (serverRes.status === 200) {
            navigate("/login")
            return "Success! User registered!"
        } else if (serverRes.status === 400) {
            console.error(serverRes.status)
            return "Invalid user data!"
        } else if (serverRes.status === 409) {
            console.error(serverRes.status)
            return "User already exists!"
        }
    }

    useEffect(() => {
        if (userData) {
            setServerRes(null)
            try {
                const backendUrl = `/api/registration`
                fetch(backendUrl, {
                    method: 'POST',
                    headers: {
                        'Content-type': 'application/json',
                    },
                    body: JSON.stringify(userData)
                }).then(res => setServerRes(res))
                    .catch((err) => {
                        console.error(err)
                    })
            } catch (err) {
                console.error(err)
            }
        }
    }, [userData])

    return (
        <>
            <div className="registrationFormDiv">
                <form className="registrationForm" onSubmit={(e) => grabFormData(e)}>
                    <label>Name:</label>
                    <input type="text" name="username" required>
                    </input>
                    <label>Password:</label>
                    <input type="password" name="password" required>
                    </input>
                    <label>Email:</label>
                    <input type="email" name="email" required>
                    </input>
                    <Button type='submit' text='Submit' />
                    <div>{calculateFeedback()}</div>
                </form>
            </div>
        </>
    )
}

export default RegistrationForm