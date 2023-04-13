import { Navigate } from 'react-router-dom';
import { useContext, useEffect, useState } from "react";
import ProfilePageHeader from "./ProfilePageHeader";
import ProfilePageContent from "./ProfilePageContent";
import { TokenContext } from "../../App";
import jwtDecode from "jwt-decode";

const UserProfilePage = () => {
    const [userData, setUserData] = useState({});
    const [tablesData, setTablesData] = useState({});
    const [loadingData, isLoadingData] = useState(true)
    const [isDelete, setDelete] = useState(false)
    const { token } = useContext(TokenContext)

    useEffect(() => {
        const username = parseUsernameFromToken(token)
        async function fetchUser() {
            let res = await fetch(`/api/user/${username}`,
                {
                    headers: {
                        "Authorization": "Bearer " + token
                    }
                })
            let data = await res.json()
            setUserData(data)
        }
        async function fetchTable() {
            let res = await fetch(`/api/user/${username}/reservation`,
                {
                    headers: {
                        "Authorization": "Bearer " + token
                    }
                })
            let data = await res.json()
            setTablesData(data)
            isLoadingData(false)
        }
        try {
            Promise.all([fetchUser(), fetchTable()])
        } catch (err) {
            console.error(err)
        }
    }, [isDelete])

    function parseUsernameFromToken(token) {
        const decodedToken = jwtDecode(token)
        return decodedToken.sub
    }

    return (
        <>
            {!loadingData &&
                (token ?
                    <div>
                        <ProfilePageHeader user={userData} />
                        <ProfilePageContent tables={tablesData} setDelete={setDelete} />
                    </div>
                    :
                    <Navigate to="/" replace />)
            }
        </>
    )


}
export default UserProfilePage