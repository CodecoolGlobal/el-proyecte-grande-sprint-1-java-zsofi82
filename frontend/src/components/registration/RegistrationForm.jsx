import { useEffect, useState } from "react"
import Button from '../reusable_elements/Button.js'
import RegistrationFeedback from "./RegistrationFeedback.jsx"

const RegistrationForm = () => {
    const [userData, setUserData] = useState()
    const [serverRes, setServerRes] = useState()

    function grabFormData(e) {
        e.preventDefault()
        const userName = e.target['name'].value
        const userPassword = e.target['password'].value
        const userEmail = e.target['email'].value
        const data = { "username": userName, "password": userPassword, "email": userEmail }
        e.target.reset()
        const update = () => { setUserData(data) }
        update()
    }

    useEffect(() => {
        if (userData) {
            try {
                const backendUrl = `/api/registration`
                fetch(backendUrl, {
                    method: 'POST',
                    headers: {
                        'Content-type': 'application/json',
                    },
                    body: JSON.stringify(userData)
                }).then(res => res.json())
                .then(res => setServerRes(res))
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
                    <input type="text" name="name" required>
                    </input>
                    <label>Password:</label>
                    <input type="password" name="password" required>
                    </input>
                    <label>Email:</label>
                    <input type="email" name="email" required>
                    </input>
                    <Button type='submit' text='Submit' />
                    <RegistrationFeedback serverRes={serverRes} />
                </form>
            </div>
        </>
    )
}

export default RegistrationForm