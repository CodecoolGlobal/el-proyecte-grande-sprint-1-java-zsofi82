import Footer from "../Footer";
import Tables from "./Tables";
import {useEffect, useState} from "react";

const Home =  () => {
    const [tableData, setTableData] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        fetch("api/table")
            .then(res => res.json())
            .then(
                (result) => {
                    setLoading(false)
                    setTableData(result)
                },
                // Note: it's important to handle errors here
                // instead of a catch() block so that we don't swallow
                // exceptions from actual bugs in components.
                (error) => {
                    setLoading(false);
                    setError(error);
                }
            )
    }, [])
    if(loading === false){
        return (
            <div>Home
                <p>{tableData.length? <Tables  tables={tableData}/> : 'No tables to show' }</p>

                <Footer/>
            </div>

        )
    }

}

export default Home