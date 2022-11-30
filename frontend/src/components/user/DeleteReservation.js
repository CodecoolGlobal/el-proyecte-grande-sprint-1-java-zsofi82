const DeleteReservation = ({tableId, reservation}) => {
    async function fetchDeleteReservation() {
        let res = await fetch(`/api/table/${tableId}/reservation`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(reservation)
        })

    }
    return(
        <button className={"btn bg-info shadow-none"} onClick={fetchDeleteReservation}>&#10060;</button>
    )


}
export default DeleteReservation