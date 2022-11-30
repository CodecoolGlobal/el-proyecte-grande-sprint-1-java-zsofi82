import Navbar from "../Navbar";
import Footer from "../Footer";
import {Route, Link, Routes, useParams} from 'react-router-dom';

const User = () => {
    const params = useParams();
    console.log(params.userId);

    return(
        <div>
            <Navbar/>
            <p>User</p>
            <Footer/>
        </div>
    )

}
export default User