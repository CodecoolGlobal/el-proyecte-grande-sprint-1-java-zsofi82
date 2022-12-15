// import { useEffect, useState } from "react";
// import { useParams } from 'react-router-dom';
import Reservation from "./Reservation";

const Reservations = ({ table, setDelete }) => {
    // const [reservationData, setReservationData] = useState({});
    // const [loadingData, isLoadingData] = useState(true)
    // const params = useParams();
    // const userId = params.userId
    // useEffect(() => {
    //     async function fetchReservation() {
    //         let res = await fetch(`/api/user/${userId}/reservation/${table.id}`)
    //         let data = await res.json()
    //         setReservationData(data)
    //         isLoadingData(false)
    //     }
    //     try {
    //         Promise.all([fetchReservation()])
    //     } catch (err) {
    //         console.error(err)
    //     }
    // }, [reservationData])

    function fromUTCtoLocale(date) {
        const newDate = new Date(date)
        return new Date(Date.UTC(newDate.getFullYear(), newDate.getMonth(), newDate.getDate(), newDate.getHours(), newDate.getMinutes(), newDate.getSeconds())).toLocaleString('en-GB', { timeZone: 'CET' });
    }

    return (
        <div className="col" >
            <div className="card bg-info" >
                <div className="card-header"> <h4 className={"my-0 font-weight-normal"}>{table.name}</h4></div>
                <div className="card-body">
                    <p className="card-text"> {table.address} </p>
                    {table.reservations.map((reservation) => <Reservation date={fromUTCtoLocale(reservation.reservationTime)} key={fromUTCtoLocale(reservation.reservationTime)} reservation={reservation} tableId={table.id} setDelete={setDelete} />)}
                </div>
            </div>
        </div>
    )
    // if (loadingData) {
    // }

}
export default Reservations