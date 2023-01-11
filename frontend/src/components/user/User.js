import { useNavigate, useParams } from 'react-router-dom';
import {useContext, useEffect, useState} from "react";
import MainInformation from "./MainInformation";
import ReservedTables from "./ReservedTables";
import {TokenContext} from "../../App";

const User = () => {
    const [userData, setUserData] = useState({});
    const [tablesData, setTablesData] = useState({});
    const [loadingData, isLoadingData] = useState(true)
    const [isDelete, setDelete] = useState(false)
    const navigate = useNavigate()
    const params = useParams();
    const userId = params.userId
    const {token} = useContext(TokenContext)

    useEffect(() => {
        async function fetchUser() {
            let res = await fetch(`/api/user/${userId}`)
            let data = await res.json()
            setUserData(data)
        }
        async function fetchTable() {
            let res = await fetch(`/api/user/${userId}/reservation`)
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

    function getCorrectRoute() {
        if (!token) {
            navigate("/")
        } else {
            return (
                <div>
                    <MainInformation user={userData} />
                    <ReservedTables tables={tablesData} setDelete={setDelete} />
                </div>)
        }
    }


    if (!loadingData) {
        return (
            <>
                {getCorrectRoute()}
            </>
        )
    }


}
export default User