import Footer from "../Footer";
import Tables from "./Tables";
import { useEffect, useState } from "react";
import Navbar from "../Navbar";
import TableModal from "./TableModal";

const Home = () => {
  const [tableData, setTableData] = useState({});
  const [clickedTable, setClickedTable] = useState(null);

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
  const reserveTable = () => {
    // TODO: reserve table
  }

  return (
    <div>
      <Navbar />
      {tableData.length ? <Tables tables={tableData} showDetails={showDetails} /> : 'No tables to show'}
      {clickedTable && <TableModal table={clickedTable} onExit={exitModal} onReserve={reserveTable} />}
      <Footer />
    </div>
  )

}

export default Home