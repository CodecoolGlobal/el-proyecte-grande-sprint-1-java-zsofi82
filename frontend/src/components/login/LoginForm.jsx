import { useEffect, useState } from "react"
import Button from "../reusable_elements/Button"
import LoginFeedback from "./LoginFeedback"

const LoginForm = () => {
    const [loginData, setLoginData] = useState()
    const [serverRes, setServerRes] = useState()

    function grabFormData(e) {
        e.preventDefault()
        const userName = e.target['name'].value
        const userPassword = e.target['password'].value
        const data = { "username": userName, "password": userPassword }
        e.target.reset()
        const update = () => { setLoginData(data) }
        update()
    }

    useEffect(() => {
        if (loginData) {
            try {
                const backendUrl = `/api/login`
                fetch(backendUrl, {
                    method: 'POST',
                    headers: {
                        'Content-type': 'application/json',
                    },
                    body: JSON.stringify(loginData)
                }).then(res => setServerRes(res))
            } catch (err) {
                console.error(err)
            }
        }
    }, [loginData])

    return (
        <>
            <div className="loginFormDiv">
                <form className="loginForm" onSubmit={(e) => grabFormData(e)}>
                    <label>Name:</label>
                    <input type="text" name="name" required>
                    </input>
                    <label>Password:</label>
                    <input type="password" name="password" required>
                    </input>
                    <Button type='submit' text='Submit' />
                    <LoginFeedback serverRes={serverRes}/>
                </form>
            </div>
        </>
    )
}

export default LoginForm