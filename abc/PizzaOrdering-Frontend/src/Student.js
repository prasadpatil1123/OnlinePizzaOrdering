import React from 'react'
import PropTypes from 'prop-types';

const Student = ({ name, age }) => {
    return (
        <>
            <h1>{name}</h1>
            <h1>{age}</h1>
        </>
    )
};

Student.propTypes = {
    name: PropTypes.string,
    age: PropTypes.number
};

export default Student;