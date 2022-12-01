import Footer from "../Footer";
import Tables from "./Tables";
import { useEffect, useState } from "react";
import Navbar from "../Navbar";
import SearchBar from "../SearchBar";

const Home = ({ loggedIn }) => {
  const [tableData, setTableData] = useState({});

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

  //TODO: update Table data from SearchBar
  const filterTable = (spot, date) => {
    alert('This spot and time has been submitted: ' + spot + date);
  }

  return (
    <div>
      <Navbar loggedIn={loggedIn} />
      <SearchBar filterTable={filterTable} />
      {tableData.length ? <Tables tables={tableData} /> : 'No tables to show'}
      <Footer />
    </div>
  )

}

export default Home