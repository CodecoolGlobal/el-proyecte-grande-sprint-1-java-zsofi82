import Footer from "../Footer";
import Tables from "./Tables";
import { useEffect, useState } from "react";
import Navbar from "../Navbar";
import TableModal from "./TableModal";
import SearchBar from "../SearchBar";

const Home = () => {
  const [tableData, setTableData] = useState({});
  const [clickedTable, setClickedTable] = useState(null);
  const [date, setDate] = useState(null)

  useEffect(() => {
    async function fetchTables() {
      let res = await fetch(`/api/table`)
      let data = await res.json()
      setTableData(data)
    }

    try {
      fetchTables()
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
  // when the Reserve button is pressed on the table modal
  const reserveTable = (tableId) => {
    let payload = {
      'reservationTime': date,
      'user': {
        "id":sessionStorage.getItem("userid")
      }
    }
    fetch(`/api/table/${tableId}/reservation`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body:
        JSON.stringify(payload)
    })
    exitModal()
  }
  const filterTable = (spot, date) => {
    //TODO: update Table data from SearchBar
    setDate(date)
  }

  return (
    <div>
      <SearchBar filterTable={filterTable} />
      {tableData.length ? <Tables tables={tableData} showDetails={showDetails} /> : 'No tables to show'}
      {clickedTable && <TableModal table={clickedTable} onExit={exitModal} onReserve={reserveTable} selectedDate={date}/>}
    </div>
  )

}

export default Home