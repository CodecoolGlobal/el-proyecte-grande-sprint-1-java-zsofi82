import { useEffect, useState } from "react"
import { useNavigate } from "react-router-dom"
import Button from "../reusable_elements/Button"

const LoginForm = ({ loggedIn, setLoggedIn }) => {
    const [loginData, setLoginData] = useState()
    const [serverRes, setServerRes] = useState()
    const navigate = useNavigate()

    function grabFormData(e) {
        e.preventDefault()
        const userName = e.target['name'].value
        const userPassword = e.target['password'].value
        const data = { "username": userName, "password": userPassword }
        e.target.reset()
        setLoginData(data)
    }

    useEffect(() => {
        // function setSessionCookie(res) {
        //     setCookie("userID", res.id, {
        //         path: "/"
        //     });
    
        //     setCookie("userName", res.username, {
        //         path: "/"
        //     });
        //     setLoggedIn(true)
        // }

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
                // .then(res => setSessionCookie(res))
                .then(res => setServerRes(res))
                setLoggedIn(true)
                navigate("/")
            } catch (err) {
                console.error(err)
            }
        }
    }, [loginData, serverRes, setLoggedIn, navigate])

    

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
                    {/* <LoginFeedback serverRes={serverRes} cookies={cookies} setCookie={setCookie} loggedIn={loggedIn} setLoggedIn={setLoggedIn}/> */}
                </form>
            </div>
        </>
    )
}

export default LoginForm