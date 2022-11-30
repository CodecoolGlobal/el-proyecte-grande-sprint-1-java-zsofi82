import Navbar from "../Navbar";
import Footer from "../Footer";
import {Route, Link, Routes, useParams} from 'react-router-dom';
import {useEffect, useState} from "react";
import MainInformation from "./MainInformation";

const User = () => {
    const [userData, setUserData] = useState({});
    const [tableData, setTableData] = useState({});
    const [reservationData, setReservationData] = useState({});
    const params = useParams();
    const userId = params.userId


    useEffect(()=> {
        async function fetchUser() {
            let res = await fetch(`/api/user/${userId}`)
            let data = await res.json()
            setUserData(data)
        }
        try {
            fetchUser()
        } catch(err) {
            console.error(err)
        }
    })

    return(
        <div>
            <Navbar/>
            <MainInformation user={userData} />
            <Footer/>
        </div>
    )

}
export default User