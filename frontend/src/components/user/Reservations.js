import {useEffect, useState} from "react";
import {Route, Link, Routes, useParams} from 'react-router-dom';
import Reservation from "./Reservation";

const Reservations = ({table}) => {
    const [reservationData, setReservationData] = useState({});
    const [loadingData, isLoadingData] = useState(true)
    const params = useParams();
    const userId = params.userId
    useEffect(()=> {
        async function fetchReservation() {
            let res = await fetch(`/api/user/${userId}/reservation/${table.id}`)
            let data = await res.json()
            setReservationData(data)
            isLoadingData(false)
        }
        try {
            Promise.all([fetchReservation()])
        } catch(err) {
            console.error(err)
        }
    },[reservationData])
    if(!loadingData){
        return(
            <div className="col" >
                <div className="card bg-info" >
                    <div className="card-header">{table.name}</div>
                    <div className="card-body">
                        <p className="card-text"> {table.address} </p>
                        {reservationData.map((reservation)=> <Reservation key={reservation.reservationTime} reservation={reservation} tableId={table.id}/> )}
                    </div>
                </div>
            </div>
        )
    }

}
export default Reservations