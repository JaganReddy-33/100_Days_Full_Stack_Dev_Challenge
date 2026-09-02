package day02;

public class Employee {

    private int employeeId;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private String email;
    private String phone;
    private int departmentId;
    private double salary;
    private java.sql.Date joiningDate;
    private String city;
    private int experienceYears;

    
    public Employee( int employeeId, String firstName, String lastName, int departmentId, double salary,  String city, int experienceYears ) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.salary = salary;
        this.city = city;
        this.experienceYears = experienceYears;
    }

    public Employee( int employeeId, String firstName, String lastName, String gender, int age, String email, 
    		String phone, int departmentId, double salary, java.sql.Date joiningDate, String city, int experienceYears ) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.departmentId = departmentId;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.city = city;
        this.experienceYears = experienceYears;
    }
    
    public Employee(double salary, int employeeId) {
    	this.salary = salary;
    	this.employeeId = employeeId;
    }
    
    public Employee(String city, String phone, int employeeId) {
    	this.city = city;
    	this.phone = phone;
    	this.employeeId = employeeId;
    }
    
    
    


    
    public int getEmployeeId() { 
        return employeeId; 
    }
    
    public void setEmployeeId(int employeeId) { 
        this.employeeId = employeeId; 
    }

    public String getFirstName() { 
        return firstName; 
    }
    
    public void setFirstName(String firstName) { 
        this.firstName = firstName; 
    }

    public String getLastName() { 
        return lastName; 
    }
    
    public void setLastName(String lastName) { 
        this.lastName = lastName; 
    }

    public String getGender() { 
        return gender; 
    }
    
    public void setGender(String gender) { 
        this.gender = gender; 
    }

    public int getAge() { 
        return age; 
    }
    
    public void setAge(int age) { 
        this.age = age; 
    }

    public String getEmail() { 
        return email; 
    }
    
    public void setEmail(String email) { 
        this.email = email; 
    }

    public String getPhone() { 
        return phone; 
    }
    
    public void setPhone(String phone) { 
        this.phone = phone; 
    }

    public int getDepartmentId() { 
        return departmentId; 
    }
    
    public void setDepartmentId(int departmentId) { 
        this.departmentId = departmentId; 
    }

    public double getSalary() { 
        return salary; 
    }
    
    public void setSalary(double salary) { 
        this.salary = salary; 
    }

    public java.sql.Date getJoiningDate() { 
        return joiningDate; 
    }
    
    public void setJoiningDate(java.sql.Date joiningDate) { 
        this.joiningDate = joiningDate; 
    }

    public String getCity() { 
        return city; 
    }
    
    public void setCity(String city) { 
        this.city = city; 
    }

    public int getExperienceYears() { 
        return experienceYears; 
    }
    
    public void setExperienceYears(int experienceYears) { 
        this.experienceYears = experienceYears; 
    }
    
    @Override
    public String toString() {
        return "Employee {" +
               "employeeId=" + employeeId + 
               ", firstName='" + firstName + '\'' + 
               ", lastName='" + lastName + '\'' + 
               ", gender='" + gender + '\'' + 
               ", age=" + age + 
               ", email='" + email + '\'' + 
               ", phone='" + phone + '\'' + 
               ", departmentId=" + departmentId + 
               ", salary=" + salary + 
               ", joiningDate=" + joiningDate + 
               ", city='" + city + '\'' + 
               ", experienceYears=" + experienceYears + 
               "}";
    }
}
