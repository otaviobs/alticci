import Head from 'next/head'
import Navbar from "../components/Navbar";
import Number from "../components/Number";

export default function Home() {
  return (
    <div className="App">
      <Head>
        <title>Generate Alticci Sequence Number</title>
      </Head>
      <Navbar />

      <main>
        <Number />
      </main>
    </div>
  );
/*
  const [number, setNumber] = useState([]);

  const fetchNumber = async () => {
    const response = await fetch('http://localhost:8081/alticci/');
    const data = await response.json();
    setNumber(data);
    console.log(data);
  }

  return (
    <>
      <input
          type="number"
          value={name}
          placeholder="Name"
          onChange={(e) => setName(e.target.value)}
        />
      <button onClick={fetchNumber}>Send</button>
    </>
  );
  */
}
