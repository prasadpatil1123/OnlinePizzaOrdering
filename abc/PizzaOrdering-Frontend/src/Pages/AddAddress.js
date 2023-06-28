import { useState,useEffect } from "react";
import axios from 'axios';
import {useHistory,useParams} from 'react-router-dom';

const AddAddress =()=> {
    // const[id,setId] = useState('');
    const [city,setCity] = useState('');
    const [country,setCountry] = useState('');
    const [houseno,setHouseNo] = useState('');
    const [pincode,setPincode] = useState('');
    const [state,setState] = useState('');
    const [street,setStreet] = useState('');

    const history =useHistory();
    const {id} = useParams();

    const addAddress = async (e) =>{
        e.preventDefault();
        console.log(id);
        debugger;
        try{
            await axios.post('http://localhost:8080/pizzaordering/category',{
                id:id,
                city:city,
                houseNo:houseno,
                pincode:pincode,
                state:state,
                street:street,
                country:country,
            }).then((res)=>{
                if(res.data != null){
                    debugger;
                    alert("address added successfull ");
                    console.log("addres added successfully");
                }else{
                    alert("Could not be added address ");
                    console.log("Could not be added address");
                }
            })

        }catch(e){
            console.log(e);
        }
        history.push("/addresses");
    } 

    return(
        <div className = 'shadow' style={{margin:"70px",padding:"50px" }}>
            <h2>Add Address</h2>
            <form onSubmit={addAddress}>

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
                    onChange={(e) => setHouseNo(e.target.value)}
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
                        value={ pincode }
                        onChange={ (e) => setState(e.target.value) }
                    />
                </div>

                <div className="field">
                    <label className="label">Street</label>
                    <input 
                        className="street"
                        type="text"
                        placeholder="street"
                        value={ state }
                        onChange={ (e) => setStreet(e.target.value) }
                    />
                </div>

                <div className="field">
                    <button className="btn btn-primary">Add Address</button>
                </div>

            </form>
        </div>
    )
}
export default AddAddress;