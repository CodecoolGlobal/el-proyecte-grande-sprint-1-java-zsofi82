import { useEffect, useState } from "react"

const RegistrationForm = () => {
    const [userData, setUserData] = useState()

    function grabFormData(e) {
        e.preventDefault()
        const userName = e.target['name'].value
        const userPassword = e.target['password'].value
        const userEmail = e.target['email'].value
        const data = { "username": userName, "password": userPassword, "email": userEmail }
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
                    <input type="text" name="name">
                    </input>
                    <label>Password:</label>
                    <input type="password" name="password">
                    </input>
                    <label>Email:</label>
                    <input type="email" name="email">
                    </input>
                    <button type='submit'>Submit</button>
                </form>
            </div>
        </>
    )
}

export default RegistrationForm