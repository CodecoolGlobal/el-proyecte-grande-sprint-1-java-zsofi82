import { useEffect } from "react";
import { useNavigate } from "react-router-dom"

const Logout = ({ removeCookie, loggedIn, setLoggedIn }) => {
  const navigate = useNavigate()

  function logoutUser() {
    removeCookie('userID', { path: '/' });
    removeCookie('userName', { path: '/' });
    setLoggedIn(false)
  }

  useEffect(() => {
    if (loggedIn) {
      navigate("/")
    }
  }, [loggedIn])


  return (
    <>{logoutUser()}</>
  )
}

export default Logout