import Reservations from "./Reservations";

const ProfilePageContent = ({ tables, setDelete }) => {
    return (
        <>
            <h4 className="text-left display-4" style={{ marginTop: "2em" }}>Your reservations: </h4>
            {tables.length === 0 ?
                <div id={"no-reservation"}>There are no reservations</div>
                :
                <div className={"row row-cols-1 row-cols-md-3 g-4"} style={{ padding: "2em", marginRight: "0px" }}>
                    {tables.map((table) => (<Reservations key={table.id} id={table.id} table={table} setDelete={setDelete} />))}
                </div>
            }
        </>
    )
}
export default ProfilePageContent