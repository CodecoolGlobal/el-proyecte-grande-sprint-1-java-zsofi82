import {useContext, useEffect, useState} from "react"
import { useNavigate } from "react-router-dom"
import Button from "../reusable_elements/Button"
import jwtDecode from "jwt-decode";
import {TokenContext} from "../../App";

const LoginForm = () => {
    const [dataToServer, setDataToServer] = useState()
    const [serverResponse, setServerResponse] = useState()
    const [rawResponse, setRawResponse] = useState()
    const navigate = useNavigate()
    const {setToken} = useContext(TokenContext)


    function grabFormData(e) {
        e.preventDefault()
        const userName = e.target['username'].value
        const userPassword = e.target['password'].value
        const data = { "username": userName, "password": userPassword }
        e.target.reset()
        setDataToServer(data)
    }


    useEffect(() => {
        if (dataToServer) {
            try {
                const backendUrl = `/api/login`
                fetch(backendUrl, {
                    method: 'POST',
                    headers: {
                        'Content-type': 'application/json',
                    },
                    body: JSON.stringify(dataToServer)
                })
                    .then(res => {
                        setRawResponse(res)
                        return res
                    })
                    .then(res => res.json())
                    .then(res => setServerResponse(res))
                if (serverResponse  && rawResponse.status === 200) {
                    localStorage.setItem("token", serverResponse.token)
                    const token = localStorage.getItem("token")
                    setToken(token)
                    setDataToServer(null)
                    setRawResponse(null)
                    navigate("/")
                }
            } catch (err) {
                console.error(err)
            }
        }
    }, [dataToServer, serverResponse, navigate])

    return (
        <>
            <div className="loginFormDiv">
                <form className="loginForm" onSubmit={(e) => grabFormData(e)}>
                    <label>Name:</label>
                    <input type="text" name="username" required>
                    </input>
                    <label>Password:</label>
                    <input type="password" name="password" required>
                    </input>
                    <Button type='submit' text='Submit' />
                    <div>{(rawResponse && rawResponse.status !== 200) && "Username or password incorrect!" }</div>
                </form>
            </div>
        </>
    )
}

export default LoginForm