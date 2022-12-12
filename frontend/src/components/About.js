import Footer from "./Footer";
import Navbar from "./Navbar";

const About = () => {
    return (
        <div>
            <div className="p-5" style={{ fontSize: "20px" }}>
                <h1 className="font-weight-light">About the page</h1>
                <br />
                <p>
                    This is the one and only application where you are able to bring your peers together
                    and organize foosball games, tournaments or just find partners to a great game in your neighborhood.
                    <br />
                    Pick your spot is a foosball reservation application.
                    Just follow the below steps and reserve a foosball table with your friends.
                </p>
                <p>1. Pick a location</p>
                <p>2. Reserve table</p>
                <p>3. Invite your friends</p>
                <br />
                <img src={`${process.env.PUBLIC_URL}/assets/images/Foosball_table.jpg`} alt="Foosball table" style={{ width: "50em" }} />
                <div className="creatorsContainer">
                    Creators: Jákob Rebeka, Szabó-Gaál Zsófia, Bata Botond, Sarkadi Gergely
                </div>
            </div>
        </div>
    );
}

export default About;
