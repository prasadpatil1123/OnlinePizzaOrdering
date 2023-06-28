import React from 'react';
// import Layout from '../Layouts/Layout';
import banner from "../images/banner.jpg";
import { Link } from "react-router-dom";
import "../styles/HomeStyles.css";

const Home = ()  => {
  return (
    // <div style={{alignContent:"center" , textAlign:"center"}}>
    //   <h1>Home</h1>
    //   </div>
    
    <div className="home" style={{ backgroundImage: `url(${banner})` }}>
      <div className="headerContainer">
        <h1>Pizza Italia</h1>
        <p>Best Pizza In India</p>
        <Link to="/menu">
          <button>ORDER NOW</button>
        </Link>
      </div>
    </div>
  
  )
}

export default Home

