import Button from "../reusable_elements/Button"
import PropTypes from 'prop-types'

const TableModal = ({ table, onExit, onReserve }) => {
  return (
    <div className="card container flex-grid position-absolute top-50 start-50 translate-middle p-2" style={{ width: "80%", height: "80%" }}>
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
        <div>
          At: {"[add time here]"}
        </div>
        <div className="flex-row align-items-end">
          <Button
            text={"Reserve"}
            bootstrapClassname={"btn-success col m-1"}
            onClick={onReserve}
            type={"button"} />
          <Button
            text={"Back"}
            bootstrapClassname={"btn-danger col m-1"}
            onClick={() => onExit()}
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