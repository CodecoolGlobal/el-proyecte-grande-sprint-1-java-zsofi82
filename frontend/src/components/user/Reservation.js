import DeleteReservation from "./DeleteReservation";

const Reservation = ({ date, reservation, tableId, setDelete }) => {
    return (
        <p className="card-text"> {date} <DeleteReservation key={reservation.reservationTime} reservation={reservation} tableId={tableId} setDelete={setDelete} /> </p>
    )
}
export default Reservation