import jwtDecode from "jwt-decode";
import { useContext, useEffect, useState } from "react";
import { Navigate } from "react-router-dom";
import { TokenContext } from "../../App";
import UsersDataTable from "./UsersDataTable";

const Admin = () => {
    const { token } = useContext(TokenContext)
    const [users, setUsers] = useState({});
    const [isLoading, setLoading] = useState(true);

    useEffect(() => {
        if (token && checkIfUserIsAdmin(token)) {
            async function fetchUsers() {
                let res = await fetch(`/api/user`,
                    {
                        headers: {
                            "Authorization": "Bearer " + token
                        }
                    })
                let data = await res.json()
                setUsers(data)
                setLoading(false)
            }
            fetchUsers()
        }
    }, [token])

    function parseRole(token) {
        const decodedToken = jwtDecode(token)
        return decodedToken.role[0].authority
    }

    function checkIfUserIsAdmin() {
        return token !== null && parseRole(token) === "ADMIN"
    }

    return (
        <>
            {!checkIfUserIsAdmin() ?
                <Navigate to="/" replace />
                :
                (isLoading ?
                    <p>Loading...</p>
                    :
                    <UsersDataTable users={users} />
                )
            }
        </>
    )
}

export default Admin