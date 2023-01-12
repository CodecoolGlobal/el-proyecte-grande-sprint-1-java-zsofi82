import {useNavigate} from "react-router-dom";
import Button from "./reusable_elements/Button"
import {useContext} from "react";
import {TokenContext} from "../App";
import jwtDecode from "jwt-decode";


const Navbar = () => {
    const {token, setToken} = useContext(TokenContext)
    const navigate = useNavigate();

    function removeToken() {
        localStorage.removeItem("token")
        setToken(null)
    }

    function parseUsername(token) {
        const decodedToken = jwtDecode(token)
        return decodedToken.sub
    }

    function parseRole(token) {
        const decodedToken = jwtDecode(token)
        return decodedToken.role[0].authority
    }
    
    function checkIfUserIsAdmin(){
        if (token ==null){
            return false;
        }
        return parseRole(token) === "ADMIN"
    }

    return (
        <nav className="navbar sticky-top">
            <div className="container-fluid">
                <span className="navbar-brand mb-0 h1 backToHome" onClick={() => {
                    navigate("/")
                }}>Pick Your Spot</span>
                <ul className="flex-row navbar-nav">
                    {checkIfUserIsAdmin() && <li className="nav-item col navbarButton">
                        <Button bootstrapClassname={"navbar-button-style"} text={"Admin"} onClick={() => {
                            navigate("/admin")
                        }}></Button>
                    </li>}
                    {!token && <li className="nav-item col navbarButton">
                        <Button bootstrapClassname={"navbar-button-style"} text={"Register"} onClick={() => {
                            navigate("/registration")
                        }}></Button>
                    </li>}
                    {!token && <li className="nav-item col navbarButton">
                        <Button bootstrapClassname={"navbar-button-style"} text={"Login"} onClick={() => {
                            navigate("/login")
                        }}></Button>
                    </li>}
                    {token && <li className="nav-item col navbarButton">
                        <Button bootstrapClassname={"navbar-button-style"} text={"Profile"} classname={"btn-link"}
                                className="navbar-button-style" onClick={() => {
                            navigate(`/user/${parseUsername(token)}`)
                        }}></Button>
                    </li>}
                    {token && <li className="nav-item col navbarButton">
                        <Button bootstrapClassname={"navbar-button-style"} text={"Logout"} classname={"btn-link"}
                                onClick={() => {
                                    removeToken();
                                    navigate("/");
                                }}></Button>
                    </li>}
                    <li className="nav-item col navbarButton">
                        <Button bootstrapClassname={"navbar-button-style"} text={"About"} classname={"btn-link"}
                                onClick={() => {
                                    navigate("/about")
                                }}></Button>
                    </li>
                </ul>
            </div>
        </nav>
    )
}

export default Navbar