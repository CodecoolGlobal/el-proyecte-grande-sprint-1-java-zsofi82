import DateTimePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

const SearchBar = ({date, location, setDate, setLocation}) => {
    //TODO: get spots as properties from the backend
    const spots = [
        {value: '', text: '-- Pick a spot --'},
        {value: 'Budapest', text: 'Budapest'},
        {value: 'Székesfehérvár', text: 'Székesfehérvár'},
        {value: 'Miskolc', text: 'Miskolc'},
        {value: 'Tihany', text: 'Tihany'},
        {value: 'Sopron', text: 'Sopron'},
        {value: 'Meggyes', text: 'Meggyes'},
        {value: 'Siófok', text: 'Siófok'},
    ];

    return (
        <div className="container-fluid">
            <form className="row g-3 m-2">
                <div className="col">
                    <select className="form-select" value={location} onChange={(e)=>setLocation(e.target.value)}>
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
                {/* placeholder div to push the searchbar to the left */}
                <div className="col" style={{textAlign: "left"}}>
                                
                </div>
            </form>
        </div>
    );
};


export default SearchBar;