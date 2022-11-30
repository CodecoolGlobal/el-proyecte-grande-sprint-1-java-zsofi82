import React from 'react'

const LoginFeedback = ({ serverRes, setServerRes, setCookie, cookies }) => {

    function setSessionCookie(res) {
        setCookie("userID", res.id, {
            path: "/"
        });
    }


    function chechkLogin() {
        if (!serverRes && !cookies.userID) {
            return "Please log in."
        } else if ((serverRes && serverRes.status === 200) || cookies.userID) {
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
        <div>{chechkLogin()}</div>
    )
}

export default LoginFeedback