import Footer from "../Footer";
import Tables from "./Tables";

const Home = () => {
    const tables = [{
        id: "647478383",
        name: "My favourite table",
        address: "1189, Béla utca 6",
        reservations: null
    }, {
        id: "647474545483",
        name: "My Macko table",
        address: "1109, Buli utca 23",
        reservations: null
    }, {
        id: "64747232383",
        name: "My tables",
        address: "1234, Béla utca 33",
        reservations: null
    }, {
        id: "64747232383",
        name: "My tables",
        address: "1234, Béla utca 33",
        reservations: null
    }, {
        id: "64747232383",
        name: "My tables",
        address: "1234, Béla utca 33",
        reservations: null
    }]
  return (
    <div>Home
        <Tables tables={tables}/>
      <Footer />
    </div>

  )
}

export default Home