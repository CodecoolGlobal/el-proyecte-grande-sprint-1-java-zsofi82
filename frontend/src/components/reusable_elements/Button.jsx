import PropTypes from "prop-types";

const Button = ({ onClick, type, text, bootstrapClassname, id }) => {
  return (
    <button
      className={"btn " + bootstrapClassname}
      onClick={onClick}
      type={type}
      id={id}
    >
      {text}
    </button>
  )
}
// https://getbootstrap.com/docs/5.2/components/buttons/
Button.defaultProps = {
  bootstrapClassname: "btn-primary",
  text: "Button",
};

Button.propTypes = {
  text: PropTypes.string,
  bootstrapClassname: PropTypes.string,
  onClick: PropTypes.func,
};

export default Button