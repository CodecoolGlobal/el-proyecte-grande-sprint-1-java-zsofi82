const MainInformation = ({user}) => {
    return(
        <div>
            <h1> Hello {user.username}! </h1>
            <h3> Your email: {user.email}</h3>
        </div>
    )
}
export default MainInformation