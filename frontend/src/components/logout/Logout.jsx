import { useEffect } from "react";
import { useNavigate } from "react-router-dom"

const Logout = () => {
  const navigate = useNavigate()

  function logoutUser() {
    sessionStorage.clear()
  }

  useEffect(() => {
    navigate("/")
  }, [navigate])


  return (
    <>{logoutUser()}</>
  )
}

export default Logout