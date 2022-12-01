import foosball_table from '../Foosball_table.jpg'

const About = ({ loggedIn, userName, userId }) => {
    return (
        <div className="about">
            <div style={{ backgroundImage: `url(${foosball_table})` }}>
                <h1 className="font-weight-light">About</h1>
                <p>
                    Pick your spot is a foosball reservation application.
                </p>
                <ol>
                    <li>Pick a location</li>
                    <li>Reserve table</li>
                    <li>Invite your friends</li>
                </ol>
            </div>
        </div>
    );
}

export default About;
