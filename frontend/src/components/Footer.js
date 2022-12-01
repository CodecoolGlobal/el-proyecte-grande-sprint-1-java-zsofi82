const Footer = () => {
  return (
      <footer className={"bg-light text-center text-lg-start footer fixed-bottom"}>
        <div className={"text-center p-3"} style={{backgroundColor: 'rgba(0, 0, 0, 0.2)'}}>
          © {new Date().getFullYear()} Copyright: Pick Your Spot
        </div>
      </footer>
  )
}

export default Footer