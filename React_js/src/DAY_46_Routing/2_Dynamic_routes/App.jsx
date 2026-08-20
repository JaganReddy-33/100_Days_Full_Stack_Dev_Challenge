
import { Route, Routes } from 'react-router-dom';
import Users from './Components/Users';
import UserDetails from './Components/UserDetails';
import Products from './Components/Products';
import ProductDetails from './Components/ProductDetails';


const App = () => {
  return (
    <div>
        <Routes>
            <Route path="/" element={<Users />} />
            <Route path="/user/:id" element={<UserDetails />} />
            <Route path="/products" element={<Products />} />
            <Route path="/products/:category/:id" element={<ProductDetails />} />
        </Routes>
    </div>
  )
}

export default App
