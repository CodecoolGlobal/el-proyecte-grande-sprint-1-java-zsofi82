import PropTypes from "prop-types";

const Button = ({ onClick, type, text, bootstrapClassname }) => {
  return (
    <button
      className={"btn " + bootstrapClassname}
      onClick={onClick}
      type={type}
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