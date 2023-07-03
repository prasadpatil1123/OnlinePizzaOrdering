import axios from 'axios';
import React, { useState, useEffect } from 'react';
import { useHistory, useLocation, useParams } from 'react-router-dom';
// import { getAdress, selectAddress } from '../actions/address';
// import { placeOrder } from '../actions/orders';
import logo from '../assests/pizzaSilce.png'
// import Message from '../components/Message';
// import Spinner from '../components/Spinner';
const OrderSummry = () => {
    const params = useParams()
    const { id } = params;
    const location = useLocation();
    const path = location.pathname
    const history = useHistory()
    const [cartItems, setCartItems] = useState([])
    const [cart, setCart] = useState({ id: 3 })
    const [user, setUser] = useState();
    const paymentMethod = sessionStorage.getItem("paymentType")
    // const orderCreate =useSelector(state=>state.order)
    const cartPrice = parseFloat(sessionStorage.getItem("cartPrice"))
    const deleviryPrice = parseFloat(sessionStorage.getItem("deliveryPrice"))
    const discount = 0;
    const totalPrice = (cartPrice + deleviryPrice) - discount;
    const [address, setAdress] = useState();

    const hostName = `http://localhost:8080/pizzaordering`;

    useEffect(() => {
        loadCart();

    }, [])


    const loadCart = async () => {

        await axios.get(`${hostName}/order/${id}`).then((res) => {
            setAdress(res.address)
            setUser(res.cartOwner)
            loadItems();
        })
    };

    const loadItems = async () => {
        await axios.get(`${hostName}/orderitemsbyorder/${id}`).then((res) => {
            setCartItems(res.data)
            console.log("Inside CartItems")
            console.log("res.data")
            console.log(res.data)
            console.log("res")
            console.log(res)
            console.log("CartItems")
            console.log(cartItems)
        })
    };

    const handlePlaceOrder = () => {
        placeOrder();
    }

    const placeOrder = async () => {
        try {
            await axios.post(`${hostName}/checkout`, {
                cartOwner: user,
                address: address,
                deliveryPrice: deleviryPrice,
                discount: discount,
                paymentType: paymentMethod,
                taxAmount: 0.0,
            }
            ).then((res) => {
                if (res != null) {
                    alert("Order Placed Successfully");
                    history.push(`/order/${res.data.id}`)
                } else {
                    alert("Order could not be placed, Null Response From Server");
                }
            });
        } catch (error) {
            console.error(error);
            alert("Order could not be placed, Error Occourred");
        }

    }



    const PaymentHandler = (paymentResult) => {
        console.log("Payment method selected")
        alert("Payment method selected")

    }


    if (paymentMethod == null) {
        history.push('/payment')
    }


    const getPaymentButton = () => {
        if (paymentMethod === 'COD') {
            return <button onClick={handlePlaceOrder} disabled={totalPrice === 0 ? true : false}>
                Place Order
            </button>

        }
        if (paymentMethod === 'razorpay') {
            return (
                <div className='razorpay' onClick={alert("Razorpay Selected")}>
                    <img src="https://razorpay.com/blog-content/uploads/2020/10/rzp-glyph-positive.png" alt="" />
                    <p>Razorpay</p>
                </div>
            )
        }
    }

    const getPaymentMethodText = () => {
        if (paymentMethod === 'COD') {
            return 'CASH ON DELIVERY'
        }
        if (paymentMethod === 'razorpay') {
            return 'RAZORPAY'
        }
    }

    return (
        <>
            <div className='shipping'>
                <div className="progress">
                    <div className="status">
                        <p>Bag</p>
                        <div className={`divider`}></div>
                        <p className={` ${path === '/shipping' && 'active'}`}>Shipping</p>
                        <div className="divider"></div>
                        <p className={` ${path === '/payment' && 'active'}`}>Payment</p>
                        <div className="divider"></div>
                        <p className={` ${path === '/order' && 'active'}`}>Order</p>
                    </div>
                </div>
                <div className="shipping-details">
                    <div className="address">
                        <h3>ORDER SUMMRY</h3>
                        <div className="add-sec-area">
                            <h4>Shipping</h4>
                            {address && (
                                <div className={`og-add`}>
                                    <p>{user.first_name}</p>
                                    <span>{address.house_no},{address.street}</span>
                                    <span>{address.city},{address.state} -{address.pincode} </span>
                                    <span>{address.country}</span>
                                    <span><b>Mobile No:</b>{address.mobNo}</span>
                                </div>
                            )}
                        </div>
                        <h4>Products</h4>
                        <div className="cart-area">

                            <div className="all-items">
                                {cartItems.map((item) => (
                                    <div className='cart-card' key={item.id}>
                                        <div className="img">
                                            <img src={"https://www.thespruceeats.com/thmb/OTNPfbDD2jKXFHgCwYMYJkuI7IM=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/12-inch-pizza-crust-427787-hero-5bdccb7446e0fb0026724ce1.jpg"} alt={item.name} />
                                        </div>
                                        <div className="des">
                                            <h3>{item.pizza.name}</h3>
                                            <p>qty:{item.quantity}</p>
                                            <p className='des'>{item.pizza.summary ? item.pizza.summary : 'Treat your taste buds with Double Pepper Barbecue Chicken, Peri-Peri Chicken, Chicken Tikka & Grilled Chicken Rashers'}</p>
                                        </div>
                                        <div className="price">
                                            <h2><span>Rs.</span>{item.totalPrice}</h2>
                                        </div>
                                    </div>
                                ))}
                            </div>
                        </div>
                        <h4>Payment Method</h4>
                        <div className="payments-opts">
                            <div className="payment-method">
                                <div className='select-opt'>
                                    <label htmlFor="cod">{getPaymentMethodText()}</label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="checkout-area">
                        <div className="billing">
                            <h4>PRICE DETAILS</h4>
                            <div className="details">
                                <div className="item">
                                    <p>Price</p>
                                    <p><span>₹</span>{cartPrice}</p>
                                </div>

                                <div className="item">
                                    <p>Delivery Charges</p>
                                    <p>{deleviryPrice === 0 ? <span className='free'>Free</span> : <span>₹{deleviryPrice}</span>}</p>
                                </div>
                            </div>
                            <div className="total">
                                <h3>Total</h3>
                                <h3><span>₹</span>{totalPrice.toFixed(2)}</h3>
                            </div>
                        </div>
                        {
                            getPaymentButton()
                        }
                    </div>
                </div>

            </div>
        </>
    );
};

export default OrderSummry;
