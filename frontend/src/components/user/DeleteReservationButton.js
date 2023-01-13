import {useContext} from "react";
import {TokenContext} from "../../App";

const useAuthFetch = () => {
    const {token} = useContext(TokenContext)

    const authFetch = (url, fetchConfig) =>
          fetch(url, {
              ...fetchConfig,
              headers: {
                  ...fetchConfig.headers,
                  'Authorization': 'Bearer ' + token
              }
          });

    return {authenticatedFetch: authFetch};
}

const DeleteReservationButton = ({tableId, reservation, setDelete}) => {
    const {authenticatedFetch} = useAuthFetch();

    async function fetchDeleteReservation() {
        await authenticatedFetch(`/api/table/${tableId}/reservation`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(reservation)
        })
        setDelete(prev => !prev);
    }
    return(
            <button className={"btn bg-info shadow-none"} onClick={fetchDeleteReservation}>{`🗑`}</button>
    )


}
export default DeleteReservationButton
