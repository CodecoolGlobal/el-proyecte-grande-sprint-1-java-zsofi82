import {useState} from "react";
import DateTimePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

const SearchBar = () => {

    const spots = [
        {value: '', text: '-- Pick a spot --'},
        {value: 'alpaka', text: 'Alpaka'},
        {value: 'tableSpot', text: 'TableSpot'},
        {value: 'here', text: 'Here'},
    ];

    const [selected, setSelected] = useState(spots[0].value);
    const [date, setDate] = useState(new Date());

    const handleChange = (e) => {
        setSelected(e.target.value);
    };

    // TODO: finish method
    const handleSubmit = () => {
        alert('This spot and time has been submitted: ' + selected + date)
    }

    return (
        <div className="container-fluid">
            <form onSubmit={handleSubmit} className="row g-3 m-2">
                <div className="col">
                <select className="form-select" value={selected} onChange={handleChange}>
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
                            onChange={date => setDate(date)}
                            showTimeSelect
                            dateFormat="y MMMM d. HH:mm"
                            timeFormat="HH:mm"
                            timeIntervals={60}
                />
                </div>
                <div className="col" style={{textAlign:"left"}}>
                    <button className="btn btn-primary" type="submit">Pick</button>
                </div>
            </form>
        </div>
    );
};


export default SearchBar;