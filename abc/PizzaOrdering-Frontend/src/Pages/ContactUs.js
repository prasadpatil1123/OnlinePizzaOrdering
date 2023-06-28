import React from 'react';
import smk from '../images/smk.jpg';
// import "../styles/HomeStyles.css";

const ContactUs = () => {
    return (
        <>
            {/* <div style ={{backgroundImage: `url(${smk})`}}> */}

            <div style={{ margin: "100px", alignContent: "center"  }}>
                <div className="container shadow bordered" >
                    <div style={{ padding: "100px", textAlign:"center" }}>
                        <h1>Contact Us</h1>
                        <p>Online Pizza Store</p>
                        Email: pizzaItalia@mail.com<br></br>
                        Phone: 99999999<br></br>
                        Address: ElproCity, PCMC, Pune, India<br></br>
                    </div>
                </div>
            </div>
            {/* </div> */}
        </>
    )
}

export default ContactUs