
import React from "react";
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import NavBar from "./Layouts/NavBar";
import AboutUs from "./Pages/AboutUs";
import ContactUs from "./Pages/ContactUs";
import HomePage from "./Pages/HomePage";
import Footer from "./Layouts/Footer";
// import Login from "./Pages/Login";
// import Register from "./Pages/Register";


function App() {
 

  return (
    <>
    
    <div>
      <NavBar/>
    </div>

    <div>
      <Router>
        <Routes>
        <Route path="/" element={<HomePage />} />
          <Route path="/aboutus" element={<AboutUs />} />
          <Route path="/contactus" element={<ContactUs />} />
          {/* <Route path="/login" element={<AboutUs />} />
          <Route path="/register" element={<Register />} /> */}
        </Routes>
      </Router>
    </div>
    <div>
      <Footer/>
    </div>
    </>
  );
}

export default App;
