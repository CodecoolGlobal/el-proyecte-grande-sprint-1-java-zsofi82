const ProfilePageHeader = ({user}) => {
    return(
        <div>
            <h1 className={"display-4"} id={"profile-name"}> Hello {user.username}! </h1>
            <h3 className={"lead"} id={"profile-email"}> Your email: {user.email}</h3>
        </div>
    )
}
export default ProfilePageHeader