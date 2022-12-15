const DeleteReservation = ({tableId, reservation, setDelete}) => {
    async function fetchDeleteReservation() {
        await fetch(`/api/table/${tableId}/reservation`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(reservation)
        })
        setDelete(prev => !prev);
    }
    return(
        <button className={"btn bg-info shadow-none"} onClick={fetchDeleteReservation}>&#10060;</button>
    )


}
export default DeleteReservation