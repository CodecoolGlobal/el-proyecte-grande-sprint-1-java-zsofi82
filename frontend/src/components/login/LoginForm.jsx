import { useContext, useEffect, useState } from "react"
import { useNavigate } from "react-router-dom"
import Button from "../reusable_elements/Button"
import { TokenContext } from "../../App";

const LoginForm = () => {
    const [dataToServer, setDataToServer] = useState()
    const [isFetchFailed, setIsFetchFailed] = useState(false)
    const navigate = useNavigate()
    const { setToken } = useContext(TokenContext)

    useEffect(() => {
        if (dataToServer) {
            async function loginUser() {
                try {
                    const response = await fetch(`/api/login`, {
                        method: 'POST',
                        headers: {
                            'Content-type': 'application/json',
                        },
                        body: JSON.stringify(dataToServer)
                    })
                    const data = await response.json();
                    handleData(response, data);
                } catch (err) {
                    console.error(err)
                    setIsFetchFailed(true)
                }
            }
            loginUser();
        }
    }, [dataToServer, navigate])


    function grabFormData(e) {
        e.preventDefault()
        const userName = e.target['username'].value
        const userPassword = e.target['password'].value
        const data = { "username": userName, "password": userPassword }
        e.target.reset()
        setDataToServer(data)
    }

    function handleData(response, data) {
        if (response.ok && data) {
            localStorage.setItem("token", data.token)
            setToken(data.token)
            navigate("/")
        } else {
            throw new Error("Login of user failed.");
        }
    }

    return (
        <>
            <div className="loginFormDiv">
                <form className="loginForm" onSubmit={(e) => grabFormData(e)}>
                    <label>Name:</label>
                    <input type="text" name="username" id={"login-name"} required>
                    </input>
                    <label>Password:</label>
                    <input type="password" name="password" id={"login-password"} style={{ minWidth: "20vw" }} required>
                    </input>
                    <Button type='submit' text='Submit' id={"login-submit"} />
                    <label><div id={"login-response"}>{(isFetchFailed) && "Username or password incorrect!"}</div></label>
                </form>
            </div>
        </>
    )
}

export default LoginForm