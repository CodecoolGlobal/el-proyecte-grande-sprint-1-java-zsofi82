import Reservation from "./Reservation";

const Reservations = ({ table, setDelete }) => {

    function fromUTCtoLocale(date) {
        const newDate = new Date(date)
        return new Date(Date.UTC(newDate.getFullYear(), newDate.getMonth(), newDate.getDate(), newDate.getHours(), newDate.getMinutes(), newDate.getSeconds())).toLocaleString('en-GB', { timeZone: 'CET' });
    }

    return (
        <div className="col" >
            <div className="card bg-info" >
                <div className="card-header"> <h4 className={"my-0 font-weight-normal"} id={table.name}>{table.name}</h4></div>
                <div className="card-body">
                    <p className="card-text" id={table.address}> {table.address} </p>
                    {table.reservations.map((reservation) => <Reservation date={fromUTCtoLocale(reservation.reservationTime)} key={fromUTCtoLocale(reservation.reservationTime)} reservation={reservation} tableId={table.id} setDelete={setDelete} />)}
                </div>
            </div>
        </div>
    )

}
export default Reservations