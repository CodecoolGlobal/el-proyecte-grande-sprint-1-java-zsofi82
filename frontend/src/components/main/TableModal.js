
const TableModal = ({ table, onExit }) => {
  return (
    <div>
      <p onClick={() => { onExit() }}>X</p>
      <p>{table.reservations}</p>
      {console.log(table)}
    </div>
  )
}

export default TableModal