import Navbar from "../Navbar";
import Footer from "../Footer";
import { Route, Link, Routes, useParams } from 'react-router-dom';
import { useEffect, useState } from "react";
import MainInformation from "./MainInformation";
import ReservedTables from "./ReservedTables";

const User = () => {
    const [userData, setUserData] = useState({});
    const [tablesData, setTablesData] = useState({});
    const [loadingData, isLoadingData] = useState(true)
    const params = useParams();
    const userId = params.userId
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
    }, [tablesData])
    if (!loadingData) {
        return (
            <div>
                <Navbar />
                <MainInformation user={userData} />
                <ReservedTables tables={tablesData} />
                <Footer />
            </div>
        )
    }


}
export default User