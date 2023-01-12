import {useContext, useEffect, useState} from "react";
import {TokenContext} from "../../App";

const Admin = () => {
    const {token} = useContext(TokenContext)
    const [users, setUsers] = useState({});
    const [isLoading, setLoading] = useState(true);
    useEffect(() => {
        async function fetchUsers() {
            let res = await fetch(`/api/user`,
                {
                    headers: {
                        "Authorization": "Bearer " + token
                    }
                })
            let data = await res.json()
            setUsers(data)
            setLoading(false)
        }
        fetchUsers()

    },[])

    if (!isLoading){
        return(
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
                    {users.map((user)=>{
                        return(<tr key={user.id}>
                            <th style={{width: "30%"}}>{user.id}</th>
                            <td>{user.username}</td>
                            <td>{user.email}</td>
                            <td>{user.role}</td>
                        </tr>)
                    })}
                </tbody>
            </table>
        )
    }
    else{
        return(
            <p>Loading</p>
        )
    }


}

export default Admin