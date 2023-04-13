import DeleteReservationButton from "./DeleteReservationButton";

const Reservation = ({ date, reservation, tableId, setDelete }) => {
    return (
        <p className="card-text" id={reservation.id}>
            {date}
            <DeleteReservationButton
                id={"delete-reservation-"+reservation.reservationTime}
                key={reservation.reservationTime}
                reservation={reservation}
                tableId={tableId}
                setDelete={setDelete}
            />
        </p>
    )
}
export default Reservation