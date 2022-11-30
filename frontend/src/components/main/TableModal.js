
const TableModal = ({ table, onExit }) => {
  return (
    <div className="card position-absolute top-50 start-50 translate-middle">
      {console.log(table)}
      <div className="card-body">
        <div className="card-title d-flex flex-row">
          <div className="card-title col"><h4>{table.name}</h4></div>
          <div className="btn-close col" onClick={() => { onExit() }} >
          </div>
        </div>
        <div>
          {table.address}
        </div>
        <div>

        </div>
      </div>
    </div>
  )
}

export default TableModal