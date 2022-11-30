import Table from "./Table";

const Tables = ({ tables, showDetails }) => {
    return (
        <div className={"row row-cols-1 row-cols-md-3 g-4"} style={{ padding: "2em", marginRight: "0px" }}>
            {tables.map((table) => (
                <Table
                    key={table.id}
                    table={table}
                    showDetails={showDetails}
                />))}
        </div>
    )
}

export default Tables