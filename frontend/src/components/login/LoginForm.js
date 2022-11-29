import { useEffect, useState } from "react"
import Button from "../reusable_elements/Button"

const LoginForm = () => {
    const [loginData, setLoginData] = useState()

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
                })
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
                    <input type="text" name="name">
                    </input>
                    <label>Password:</label>
                    <input type="password" name="password">
                    </input>
                    <Button type='submit' text='Submit' />
                </form>
            </div>
        </>
    )
}

export default LoginForm