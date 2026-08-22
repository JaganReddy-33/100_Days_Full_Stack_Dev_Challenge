import { useState } from "react"


const RegistrationForm = () => {

    const [formData, setFormData] = useState({
        firstName: "",
        lastName: "",
        email: "",
        phone: ""
    });
    

    const handleChange = (e)=>{
        const {name, value} = e.target;
        setFormData(prev => ({
            ...prev, [name] : value
        }));
    };

    const handleSubmit = (e)=>{
        e.preventDefault();

        if(!formData.firstName || !formData.lastName || !formData.email || !formData.phone){
            alert("Please enter required details");
            return;
        }
        console.log(formData);

        setFormData({
            firstName: "",
            lastName: "",
            email: "",
            phone: ""
        });
    };

  return (
    <div>
      <h2>Event Registration Form</h2>
      <form action="" onSubmit={handleSubmit}>
        <div>
            <label htmlFor="firstName">First Name: </label>
            <input type="text" placeholder="Enter your first name" id="firstName" value={formData.firstName} 
            onChange={handleChange} name="firstName"/>
        </div>
        <br />

        <div>
            <label htmlFor="lastName">Last Name: </label>
            <input type="text" placeholder="Enter your last name" id="lastName" value={formData.lastName} 
            onChange={handleChange} name="lastName"/>
        </div>
        <br />

        <div>
            <label htmlFor="email">Email: </label>
            <input type="email" placeholder="Enter your email" id="email" 
            value={formData.email} 
            onChange={handleChange} name="email"/>
        </div>
        <br />

        <div>
            <label htmlFor="phone">Phone: </label>
            <input type="tel" placeholder="Enter your phone phone" id="phone" value={formData.phone} 
            onChange={handleChange} name="phone"/>
        </div>
        <br />
        <button type="submit">Submit</button>
      </form>
    </div>
  )
}

export default RegistrationForm
