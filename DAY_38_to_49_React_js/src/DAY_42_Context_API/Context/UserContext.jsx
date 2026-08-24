import { createContext, useState } from "react";



export const UserContext = createContext(null);

export const UserProvider= ({children}) => {

    const [user] = useState({
        name: "Jaganmohan",
        role: "Full Stack Dev",
        location: "Coimbatore",
    });

    const [isLoggedIn, setIsLoggedIn] = useState(false);

    const login = () =>{
        setIsLoggedIn(true);
    }

    const logout = () =>{
        setIsLoggedIn(false);
    }


  return (
    <UserContext.Provider 
    value={{
        user, 
        isLoggedIn,
        login,
        logout, 
    }}>
      {children}
    </UserContext.Provider>
  )
}

