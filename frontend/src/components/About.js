import Footer from "./Footer";
import Navbar from "./Navbar";

const About = () => {
    return (
        <div>
            <Navbar />
            <div className="p-5">
                <h1 className="font-weight-light">About</h1>
                <br/>
                <p>
                    Pick your spot is a foosball reservation application.
                    Just follow the below steps and reserve a foosball table with your friends.
                </p>
                <br/>
                <p>1. Pick a location</p>
                <p>2. Reserve table</p>
                <p>3. Invite your friends</p>
            </div>
            <Footer />
        </div>
    );
}

export default About;
