import { useState } from "react";
import DateTimePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

const SearchBar = ({ filterTable }) => {
    //TODO: get spots as properties
    const spots = [
        { value: '', text: '-- Pick a spot --' },
        { value: 'Budapest', text: 'Budapest' },
        { value: 'alpaka', text: 'Alpaka' },
        { value: 'tableSpot', text: 'TableSpot' },
        { value: 'here', text: 'Here' },
    ];

    const [selectedSpot, setSelectedSpot] = useState("");
    const [date, setDate] = useState(new Date("2017-03-04T10:15:00"));

    const handleChange = (e) => {
        setSelectedSpot(e.target.value);
    };

    return (
        <div className="container-fluid">
            <form className="row g-3 m-2">
                <div className="col">
                    <select className="form-select" value={selectedSpot} onChange={handleChange}>
                        {spots.map(spot => (
                            <option key={spot.value} value={spot.value}>
                                {spot.text}
                            </option>
                        ))}
                    </select>
                </div>
                <div className="col">
                    <DateTimePicker className="form-select"
                        selected={date}
                        onChange={(date) => {
                            setDate(date)
                        }}
                        showTimeSelect
                        dateFormat="y MMMM d. HH:mm"
                        timeFormat="HH:mm"
                        timeIntervals={60}
                    />
                </div>
                <div className="col" style={{textAlign:"left"}}>
                    <button className="btn btn-primary" style={{backgroundColor:"#004752"}} type="button" onClick={() => filterTable(selectedSpot, date)}>Pick</button>
                </div>
            </form>
        </div>
    );
};


export default SearchBar;