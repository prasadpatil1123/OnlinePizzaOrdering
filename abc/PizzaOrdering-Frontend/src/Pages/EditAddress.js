import { useState, useEffect } from 'react'
import axios from "axios";
import { useHistory, useParams } from 'react-router-dom';


const EditAddress = () => {

    const hostName = `http://localhost:8080/pizzaordering`;
    // const [id,setId]=useState('');
    const [city,setCity]=useState("");
    const [country,setCountry]=useState("");
    const [house_no,setHouse_no]=useState("");
    const [pincode,setPincode]=useState("");
    const [state,setState]=useState("");
    const [street,setStreet]=useState("");

    const history = useHistory();
    const { id } = useParams();

    const updateaddress = async (e) => {
        e.preventDefault();
        console.log(id);
        debugger;
        try {
            
            await axios.put(`${hostName}/category`, {
                id: id,
                houseNo: house_no,
                street: street,
                city: city,
                state: state,
                country: country,
                pincode: pincode,
            }).then((res) => {
                if (res.data != null) {
                    debugger;
                    alert("address updated successfull ");
                    console.log("addres updated successfully");
                } else {
                    alert("Could not be updated address ");
                    console.log("Could not be updated address");
                }
            })

        } catch (e) {
            console.log(e);
        }
        history.push("/addresses");
    }

    useEffect(() => {
        getAddressById();
    }, []);

    const getAddressById = async () => {
        debugger;
        const response = await axios.get(`${hostName}/address/${id}`);
        setCity(response.data.city);
        setCountry(response.data.country);
        setHouse_no(response.data.houseNo);
        setPincode(response.data.pincode);
        setState(response.data.state);
        setStreet(response.data.street);
    }

    return (
        <div className='shadow' style={{ margin: "70px", padding: "50px" }}>
            <h2>Updated Address</h2>
            <form onSubmit={updateaddress}>
                <div clssName="field">
                    <label className="label">City</label>
                    <input
                        className="field"
                        type="text"
                        placeholder="city"
                        value={city}
                        onChange={(e) => setCity(e.target.value)}
                    />
                </div>

                <div clssName="field">
                    <label className="label">Country</label>
                    <input
                        className="country"
                        type="text"
                        placeholder="country"
                        value={country}
                        onChange={(e) => setCountry(e.target.value)}
                    />
                </div>

                <div clssName="field">
                    <label className="label">House no</label>
                    <input
                        className="houseno"
                        type="text"
                        placeholder="houseno"
                        value={houseno}
                        onChange={(e) => setHouse_no(e.target.value)}
                    />
                </div>

                <div clssName="field">
                    <label className="label">Pincode</label>
                    <input
                        className="pincode"
                        type="text"
                        placeholder="pincode"
                        value={pincode}
                        onChange={(e) => setPincode(e.target.value)}
                    />
                </div>

                <div className="field">
                    <label className="label">State</label>
                    <input
                        className="state"
                        type="text"
                        placeholder="state"
                        value={pincode}
                        onChange={(e) => setState(e.target.value)}
                    />
                </div>

                <div className="field">
                    <label className="label">Street</label>
                    <input
                        className="street"
                        type="text"
                        placeholder="street"
                        value={state}
                        onChange={(e) => setStreet(e.target.value)}
                    />
                </div>

                <div className="field">
                    <button className="btn btn-primary">Update</button>
                </div>

            </form>
        </div>
    )
}

export default EditAddress;