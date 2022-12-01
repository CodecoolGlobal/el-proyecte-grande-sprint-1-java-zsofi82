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
  const reserveTable = async (tableId) => {
    let payload = {
      'reservationTime' : '2022-12-02T10:00:00',
      'userId': sessionStorage.getItem("userid")
    }
    console.log(sessionStorage.getItem("userid"))
    console.log(tableId)
    console.log(date)
      let res = await fetch(`/api/table/${tableId}/reservation`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body:
          JSON.stringify(payload)
      })
  }
  //TODO: update Table data from SearchBar
  const filterTable = (spot, date) => {
    setDate(date)
  }

  return (
    <div>
      <Navbar />
      <SearchBar filterTable={filterTable} />
      {tableData.length ? <Tables tables={tableData} showDetails={showDetails} /> : 'No tables to show'}
      {clickedTable && <TableModal table={clickedTable} onExit={exitModal} onReserve={reserveTable} />}
      <Footer />
    </div>
  )

}

export default Home