import {useContext} from "react";
import {TokenContext} from "../../App";

const DeleteReservation = ({tableId, reservation, setDelete}) => {
    const {token} = useContext(TokenContext)

    async function fetchDeleteReservation() {
        await fetch(`/api/table/${tableId}/reservation`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + token

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