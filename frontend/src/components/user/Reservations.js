import { useEffect, useState } from "react";
import { useParams } from 'react-router-dom';
import Reservation from "./Reservation";

const Reservations = ({ table }) => {
    const [reservationData, setReservationData] = useState({});
    const [loadingData, isLoadingData] = useState(true)
    const params = useParams();
    const userId = params.userId
    useEffect(() => {
        async function fetchReservation() {
            let res = await fetch(`/api/user/${userId}/reservation/${table.id}`)
            console.log(res)
            let data = await res.json()
            console.log(data)
            setReservationData(data)
            isLoadingData(false)
        }
        try {
            Promise.all([fetchReservation()])
        } catch (err) {
            console.error(err)
        }
    }, [reservationData])
    if (!loadingData) {
        return (
            <div className="col" >
                <div className="card bg-info" >
                    <div className="card-header"> <h4 className={"my-0 font-weight-normal"}>{table.name}</h4></div>
                    <div className="card-body">
                        <p className="card-text"> {table.address} </p>
                        {reservationData.map((reservation) => <Reservation key={reservation.reservationTime} reservation={reservation} tableId={table.id} />)}
                    </div>
                </div>
            </div>
        )
    }

}
export default Reservations