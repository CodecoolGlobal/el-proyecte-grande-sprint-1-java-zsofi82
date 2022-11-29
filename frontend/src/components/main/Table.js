const Table = ({table}) => {
    return(
        <div className="col" >
            <div className="card bg-info" >
                <div className="card-body">
                    <h5 className="card-title">{table.name}</h5>
                    <p className="card-text"> {table.address} </p>
                </div>
            </div>
        </div>
    )

}

export default Table