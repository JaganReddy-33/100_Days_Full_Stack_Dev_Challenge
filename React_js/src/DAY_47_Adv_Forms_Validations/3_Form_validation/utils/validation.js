


const validationForm = (formData) => {
    const errors = {};

    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    const phonePattern = /^\d{10}$/;

    if(!formData.firstName.trim()){
        errors.firstName = "First name is required";
    }

    if(!formData.lastName.trim()){
        errors.lastName="Last name is required";
    }

    if(!formData.email.trim()){
        errors.email = "Email is required";
    } else if(!emailPattern.test(formData.email)){
        errors.email = "Enter a valid email address(eg: jmr@gmail.com)";
    }

    if(!formData.phone.trim()){
        errors.phone = "Phone number is required";
    } else if(!phonePattern.test(formData.phone)){
        errors.phone = "Phone number must contain exactly 10 digits";
    }

    if(!formData.ticketType){
        errors.ticketType = "Please select a ticket type";
    }

    if(!formData.attendance){
        errors.attendance = "Please select an attendance mode";
    }

    if(formData.workshops.length === 0){
        errors.workshops = "Please select at least one workshop";
    }

    return errors;
}

export default validationForm;
