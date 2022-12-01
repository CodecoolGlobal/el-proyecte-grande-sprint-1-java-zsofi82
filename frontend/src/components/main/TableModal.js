import Button from "../reusable_elements/Button"
import PropTypes from 'prop-types'

const TableModal = ({ table, onExit, onReserve }) => {
  return (
    <div
      className="modal fade show"
      id="exampleModal"
      tabindex="-1"
      aria-labelledby="exampleModalLabel"
      aria-hidden="true"
      style={{ display: "block" }}
      aria-modal="true"
      role="dialog">
      <div className="modal-dialog">
        <div className="modal-content">
          <div className="modal-header">
            <h1 className="modal-title fs-5" id="modal-title">{table.name}</h1>
            <Button text={""} onClick={onExit} bootstrapClassname={"btn-close"} />
          </div>
          <div className="modal-body">
            <div>
            <a
            href={`https://www.google.com/maps/search/${table.address}/`}
            target="_blank">{table.address}</a></div>
            <div>At: {"[TODO: put currently selected reservation time here]"}</div>
          </div>
          <div className="modal-footer">
            <Button
              text={"Reserve"}
              bootstrapClassname={"btn-success"}
              onClick={()=>onReserve(table.id)}
              type={"button"} />
            <Button
              text={"Close"}
              bootstrapClassname={"btn-secondary"}
              onClick={() => onExit()}
              type={"button"} />
          </div>
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