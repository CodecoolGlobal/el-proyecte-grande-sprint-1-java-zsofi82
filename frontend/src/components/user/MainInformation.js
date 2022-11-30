const MainInformation = ({user}) => {
    return(
        <div>
            <h1 className={"display-4"}> Hello {user.username}! </h1>
            <h3 className={"lead"}> Your email: {user.email}</h3>
        </div>
    )
}
export default MainInformation