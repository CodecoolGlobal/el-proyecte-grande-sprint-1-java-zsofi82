import DeleteReservation from "./DeleteReservation";

const Reservation = ({reservation, tableId, setDelete}) => {
    return(
        <p className="card-text"> {reservation.reservationTime} <DeleteReservation key={reservation.reservationTime} reservation={reservation} tableId={tableId} setDelete={setDelete}/> </p>
    )
}
export default Reservation