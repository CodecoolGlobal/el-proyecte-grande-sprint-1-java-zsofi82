
const TableModal = ({ table, onExit }) => {
  return (
    <div className="card">
      <div className="card-body">
        <div className="card-title d-flex flex-row">
          <h5 className="card-title col">asd</h5>
          
          <div className="btn-close col" onClick={() => { onExit() }} >
            
          </div>
        </div>
        <p>asd</p>
        {console.log(table)}
      </div>
    </div>
  )
}

export default TableModal