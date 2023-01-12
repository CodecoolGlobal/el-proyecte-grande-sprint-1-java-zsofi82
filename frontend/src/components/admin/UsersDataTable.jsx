import React from 'react'

const UsersDataTable = ({ users }) => {
    return (
        <>
            <h3>Admin page</h3>
            <table className="table table-borderless">
                <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Username</th>
                        <th scope="col">Email</th>
                        <th scope="col">Role</th>
                    </tr>
                </thead>
                <tbody>
                    {users.map((user) => {
                        return (<tr key={user.id}>
                            <th style={{ width: "30%" }}>{user.id}</th>
                            <td>{user.username}</td>
                            <td>{user.email}</td>
                            <td>{user.role}</td>
                        </tr>)
                    })}
                </tbody>
            </table>
        </>
    )
}

export default UsersDataTable