
const EmbeddedMap = ({ className, source }) => {

    const API_KEY = process.env.REACT_APP_GMAP_API_KEY
    const zoom = '17'

    const url = `https://www.google.com/maps/embed/v1/place?key=${API_KEY}&q=${source}&zoom=${zoom}`
    return (
        <iframe className={className} loading="lazy" allowFullScreen title={className}
            src={url}></iframe>
    )
}

export default EmbeddedMap