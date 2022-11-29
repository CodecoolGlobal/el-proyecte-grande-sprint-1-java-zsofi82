import Table from "./Table";

const Tables = ({tables}) => {
    return(
        <div className={"row row-cols-1 row-cols-md-3 g-4"} style={{padding: "2em"}}>
            {
                tables.map((table)=> (<Table table={table}/> ))
            }
        </div>
    )
}

export default Tables