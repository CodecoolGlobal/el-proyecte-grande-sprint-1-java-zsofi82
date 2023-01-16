import EmbeddedMap from "../reusable_elements/EmbeddedMap"

const Table = ({ table, showDetails }) => {
    return (
        <div className="tables-col col" id={table.id} onClick={() => { showDetails(table) }}>
            <div className="card tables-card bg-info" >
                <div className="card-body tables-card-body modal-style">
                    <h5 className="card-title">{table.name}</h5>
                    <p className="card-text"> {table.address} </p>
                    <EmbeddedMap className={"mainPageMap"} source={table.name}/>
                </div>
            </div>
        </div>
    )

}

export default Table