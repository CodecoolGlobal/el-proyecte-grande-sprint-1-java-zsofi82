import DeleteReservation from "./DeleteReservation";

const Reservation = ({reservation, tableId}) => {
    return(
        <p className="card-text"> {reservation.reservationTime} <DeleteReservation key={reservation.reservationTime} reservation={reservation} tableId={tableId}/> </p>
    )
}
export default Reservation