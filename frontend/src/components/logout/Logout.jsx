import { useEffect } from "react";
import { useNavigate } from "react-router-dom"

const Logout = ({ loggedIn, setLoggedIn, userId, setUserId, userName, setUserName }) => {
  const navigate = useNavigate()

  function logoutUser() {
    setLoggedIn(false)
    setUserName(undefined)
    setUserId(undefined)
  }

  useEffect(() => {
    navigate("/")
  }, [loggedIn, navigate])


  return (
    <>{logoutUser()}</>
  )
}

export default Logout