import React, { useEffect } from 'react'

const LoginFeedback = ({ serverRes, setCookie, cookies, loggedIn, setLoggedIn }) => {

    function setSessionCookie(res) {
        setCookie("userID", res.id, {
            path: "/"
        });

        setCookie("userName", res.username, {
            path: "/"
        });
        setLoggedIn(true)
    }

    useEffect(()=> {
        if(cookies.userID) {
            setLoggedIn(true)
        }
    },[cookies.userID, setLoggedIn])

    function checkLogin() {
        if (!serverRes && !cookies.userID) {
            return "Please log in."
        } else if ((serverRes && serverRes.status === 200) || loggedIn) {
            async function setData() {
                try {
                    const data = await serverRes.json();
                    console.log(data)
                    setSessionCookie(data)
                } catch (err) {
                    console.error(err)
                }
            }
            if (serverRes && !serverRes.bodyUsed) {
                setData()
            }
            return "Success! User loged in!"
        } else if (serverRes && serverRes.status === 400) {
            return "Invalid username or password!"
        }
    }

    return (
        <>
            <div>{"logged in " + loggedIn}</div>
            <div>{checkLogin()}</div>
        </>
    )
}

export default LoginFeedback