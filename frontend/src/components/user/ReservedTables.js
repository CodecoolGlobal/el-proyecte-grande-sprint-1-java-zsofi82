import Reservations from "./Reservations";

const ReservedTables = ({tables, setDelete}) => {
    return(
        <div>
        <h4 className="text-left display-4" style={{marginTop:"2em"}}>Your reservations: </h4>
        <div className={"row row-cols-1 row-cols-md-3 g-4"} style={{ padding: "2em", marginRight: "0px" }}>
            {tables.map((table) => (<Reservations key={table.id} table={table} setDelete={setDelete} />))}
        </div>
        </div>
    )
}
export default ReservedTables