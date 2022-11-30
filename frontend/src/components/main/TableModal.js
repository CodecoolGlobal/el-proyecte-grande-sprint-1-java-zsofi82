import Button from "../reusable_elements/Button"

const TableModal = ({ table, onExit, onReserve }) => {
  return (
    <div className="card position-absolute top-50 start-50 translate-middle p-2">
      <div className="card-body">
        <div className="card-title d-flex flex-row">
          <div className="card-title col"><h4>{table.name}</h4></div>
          <div className="btn-close col" onClick={() => { onExit() }} >
          </div>
        </div>
        <div className="mb-3">
          <a
            href={`https://www.google.com/maps/search/${table.address}/`}
            target="_blank">{table.address}</a>
        </div>
        <div className="flex-row">
          <Button
            text={"Reserve"}
            bootstrapClassname={"btn-success"}
            onClick={onReserve}
            type={"button"} />
        </div>
      </div>
    </div>
  )
}

TableModal.propTypes = {
  table: PropTypes.string,
  onExit: PropTypes.func,
  onReserve: PropTypes.func,
}

export default TableModal