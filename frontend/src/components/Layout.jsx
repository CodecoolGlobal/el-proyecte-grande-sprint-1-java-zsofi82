import Footer from "./Footer"
import Navbar from "./Navbar"
import { Outlet } from "react-router-dom"

const Layout = ({loggedIn, setLoggedIn}) => {
  return (

    <>
    <Navbar loggedIn={loggedIn} setLoggedIn={setLoggedIn}/>
    <Outlet />
    <Footer />
    </>
  )
}

export default Layout