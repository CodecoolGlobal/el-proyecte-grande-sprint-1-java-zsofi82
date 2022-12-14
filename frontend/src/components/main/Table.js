const Table = ({ table, showDetails }) => {

    const qParam = 'Budapest, Zichy utca 1'
    const API_KEY = process.env.REACT_APP_GMAP_API_KEY
    const zoom = '17'

    const url = `https://www.google.com/maps/embed/v1/place?key=${API_KEY}&q=${table.name}&zoom=${zoom}`


    return (
        <div className="tables-col col" onClick={() => { showDetails(table) }}>
            <div className="card tables-card bg-info" >
                <div className="card-body tables-card-body modal-style">
                    <h5 className="card-title">{table.name}</h5>
                    <p className="card-text"> {table.address} </p>
                    <iframe className="myMap" loading="lazy" allowFullScreen title='test'
                        src={url}></iframe>
                </div>
            </div>
        </div>
    )

}

export default Table