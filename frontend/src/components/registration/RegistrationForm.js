
const RegistrationForm = () => {

    function grabFormData(e) {
        e.preventDefault()
        const userName = e.target['registrationText'].value
        const userPassword = e.target['registrationPassword'].value

        console.log(`name: ${userName}, psw: ${userPassword}`)
    }

    return (
        <>
            <div className="registrationFormDiv">
                <form className="registrationForm" onSubmit={(e) => grabFormData(e)}>
                    <label>Name:</label>
                    <input type="text" name="registrationText">
                    </input>
                    <label>Password:</label>
                    <input type="password" name="registrationPassword">
                    </input>
                    <button type='submit'>Submit</button>
                </form>
            </div>
        </>
    )
}

export default RegistrationForm