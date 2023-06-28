import React, { useState } from 'react';
import axios from 'axios';
import {
    MDBInput,
    MDBRow,
    MDBBtn,
    MDBIcon
} from 'mdb-react-ui-kit';

const Login = () => {
    const hostName = 'http://localhost:8080/pizzaordering';
    const [user, setUser] = useState({ email: '', password: '' });
    const [message, setMessage] = useState('');

    const handleChange = (event) => {
        const { name, value } = event.target;
        setUser((prevUser) => ({ ...prevUser, [name]: value }));
    };

    const signIn = async () => {
        try {
            const res = await axios.post(`${hostName}/login`, {
                email: user.email,
                password: user.password,
            });

            if (res.data.userRole === 'CUSTOMER' || res.data.userRole === 'ADMIN') {
                sessionStorage.setItem('isLoggedIn', 'True');
                sessionStorage.setItem('userName', res.data.first_name);
                sessionStorage.setItem('userId', res.data.id);
                sessionStorage.setItem('userRole', res.data.userRole);
                sessionStorage.setItem('user', JSON.stringify(res.data));
                setMessage('Login successful !!!');
            } else {
                setUser({ email: '', password: '' });
                setMessage('Something went wrong !!!');
            }
        } catch (error) {
            console.error(error);
            setMessage('Something went wrong. Please try again.');
        }
    };

    return (
        <div className="container shadow bordered" style={{ marginBottom: '35px', marginTop: '35px', width: '500px', height: '420px', borderRadius: '10px' }}>
            <br />
            <h2 style={{ margin: '10px', textAlign: 'center' }}>Login</h2>

            <form>
                <MDBRow className='mb-4'></MDBRow>

                <MDBInput
                    className='mb-4'
                    type='text'
                    id='form3Example3'
                    name='email'
                    placeholder='Email Address'
                    value={user.email}
                    onChange={handleChange}
                />

                <MDBInput
                    className='mb-4'
                    type='password'
                    id='form3Example3'
                    name='password'
                    placeholder='Password'
                    value={user.password}
                    onChange={handleChange}
                />

                <button
                    type='submit'
                    className="white-text"
                    style={{
                        width: '470px',
                        height: '37.8px',
                        border: 'none',
                        borderRadius: '5px',
                        backgroundColor: '#0275D8'
                    }}
                    onClick={signIn}
                >
                    Sign In
                </button>

                <div className='text-center'>
                    <p>
                        Not a member? <a href='http://localhost:3000/register'>Register</a>
                    </p>
                    <p>or sign up with:</p>

                    <MDBBtn floating color='secondary' className='mx-1'>
                        <MDBIcon fab icon='facebook-f' />
                    </MDBBtn>

                    <MDBBtn floating color='secondary' className='mx-1'>
                        <MDBIcon fab icon='google' />
                    </MDBBtn>

                    <MDBBtn floating color='secondary' className='mx-1'>
                        <MDBIcon fab icon='twitter' />
                    </MDBBtn>

                    <MDBBtn floating color='secondary' className='mx-1'>
                        <MDBIcon fab icon='github' />
                    </MDBBtn>
                </div>
            </form>

        </div>
    );
};

export default Login;
