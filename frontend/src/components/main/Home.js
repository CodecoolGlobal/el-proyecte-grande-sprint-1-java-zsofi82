import Footer from "../Footer";
import Tables from "./Tables";
import { useEffect, useState } from "react";
import Navbar from "../Navbar";
import SearchBar from "../SearchBar";

const Home = () => {
  const [tableData, setTableData] = useState({});

  useEffect(()=> {
    async function fetchTables() {
      let res = await fetch(`/api/table`)
      let data = await res.json()
      setTableData(data)
    }

    try {
      fetchTables()
    } catch(err) {
      console.error(err)
    }
  })

  return (
    <div>
      <Navbar />
      <SearchBar />
      {tableData.length ? <Tables tables={tableData} /> : 'No tables to show'}
      <Footer />
    </div>
  )

}

export default Home