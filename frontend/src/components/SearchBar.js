import {useState} from "react";

const SearchBar = ({spots}) => {
    const [searchInput, setSearchInput] = useState("");
    const date = new Date();

    const handleChange = (e) => {
        e.preventDefault();
        setSearchInput(e.target.value);
    };

    if (searchInput > 0) {
        spots.filter((spot) => {
            return spot.name.match(searchInput);
        });
    }

    return (
        <div className="input-group rounded">
            <input type="search" className="input-group-prepend" placeholder="Pick a spot" onChange={handleChange} value={searchInput}/>
            <label htmlFor="meeting-time"></label>
            <input type="datetime-local" id="meeting-time"
                   name="meeting-time" value={date.getDate()}
            />
            <div className="input-group-append">
                <button className="btn btn-outline-secondary" type="button">Reserve</button>
            </div>
        </div>
    );
};


export default SearchBar;