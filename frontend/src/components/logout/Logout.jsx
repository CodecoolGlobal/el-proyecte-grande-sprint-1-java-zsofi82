import { useEffect } from "react";
import { useNavigate } from "react-router-dom"

const Logout = ({  loggedIn, setLoggedIn }) => {
  const navigate = useNavigate()

  function logoutUser() {
    setLoggedIn(false)
    // removeCookie('userID', { path: '/' });
    // removeCookie('userName', { path: '/' });
  }

  useEffect(() => {
    navigate("/")
  }, [loggedIn, navigate])


  return (
    <>{logoutUser()}</>
  )
}

export default Logout