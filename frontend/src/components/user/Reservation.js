import DeleteReservationButton from "./DeleteReservationButton";

const Reservation = ({ date, reservation, tableId, setDelete }) => {
    return (
        <p className="card-text"> {date} <DeleteReservationButton key={reservation.reservationTime} reservation={reservation} tableId={tableId} setDelete={setDelete} /> </p>
    )
}
export default Reservation