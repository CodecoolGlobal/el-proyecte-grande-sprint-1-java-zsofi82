import Tables from "./Tables";
import {useContext, useEffect, useState} from "react";
import TableModal from "./TableModal";
import SearchBar from "../SearchBar";
import {TokenContext} from "../../App";
import jwtDecode from "jwt-decode";

const Home = () => {
    const [tableData, setTableData] = useState({});
    const [clickedTable, setClickedTable] = useState(null);
    const [date, setDate] = useState(() => currentDateRoundedToHours());
    const [location, setLocation] = useState("");
    const {token} = useContext(TokenContext)


    function currentDateRoundedToHours() {
        let currentDate = new Date();
        currentDate.setMinutes(0, 0, 0);
        return currentDate;
    }

    useEffect(() => {
        try {
            filterTable()
        } catch (err) {
            console.error(err)
        }
    }, [])
    // when clicking on a table's card, show the modal
    const showDetails = (table) => {
        setClickedTable(table)
    }
    // when clicking on x in modal, don't show modal
    const exitModal = () => {
        setClickedTable(null)
    }


    function parseOutUsername(token){
        const decodedToken = jwtDecode(token)
        return decodedToken.sub
    }


    // when the Reserve button is pressed on the table modal
    const reserveTable = async (tableId) => {
        let payload = {
            'reservationTime': date,
            'user': {
                "username": parseOutUsername(token)
            }
        }
        let res = await fetch(`/api/table/${tableId}/reservation`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + token
            },
            body:
                JSON.stringify(payload)
        })
        const responseStatus = res.headers.get("status")
        if (responseStatus === 200) {
            // TODO: show successful table reservation message
        } else {
            // TODO: show Failed reservation message
        }
        exitModal()
        await filterTable()
    }
    const filterTable = async () => {
        let payload = {
            "location": location,
            "dateTime": date
        }
        let res = await fetch(`/api/table/free-tables`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body:
                JSON.stringify(payload)
        })
        let data = await res.json();
        setTableData(data)
    }

    useEffect(() => {
        filterTable();
    }, [date, location]);


    return (
        <div>
            <SearchBar setDate={setDate} setLocation={setLocation} date={date} location={location}/>
            {tableData.length ? <Tables tables={tableData} showDetails={showDetails}/> : 'No available tables'}
            {clickedTable &&
                <TableModal table={clickedTable} onExit={exitModal} onReserve={reserveTable} selectedDate={date}/>}
        </div>
    )

}

export default Home