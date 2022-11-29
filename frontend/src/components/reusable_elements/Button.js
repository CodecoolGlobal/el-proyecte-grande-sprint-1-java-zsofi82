import PropTypes from "prop-types";

const Button = ({onClick, text, bootstrapClassname}) => {
  return (
    <button 
    className={["btn", bootstrapClassname]}
    onClick={onClick} 
    text={text}
    style={{backgroundColor: color}}
    ></button>
  )
}
// https://getbootstrap.com/docs/5.2/components/buttons/
Button.defaultProps = {
  bootstrapClassname: "btn-primary",
};

Button.propTypes = {
  text: PropTypes.string,
  bootstrapClassname: PropTypes.string,
  onClick: PropTypes.func,
};

export default Button