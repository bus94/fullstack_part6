import { Link, Outlet } from 'react-router-dom';
import './App.css';
import Header from './components/Header';

// import { Container, Image, Nav, Navbar } from 'react-bootstrap';
// import NewProduct from './pages/NewProduct';
// import ProductDetail from './pages/ProductDetail';
// import Home from './pages/Home';
// import AllProducts from './pages/AllProducts';
// import Cart from './pages/Cart';

function App() {
  return (
    <div>
      <Header />
      <nav>
        <ul>
          <li><Link to="/">Home</Link></li>
          <li><Link to="/products">All</Link></li>
          <li><Link to="/products/new">New</Link></li>
          <li><Link to="/carts">Cart</Link></li>
          <li><Link to="/loginForm">Login</Link></li>
          <li><Link to="/joinForm">Join</Link></li>
        </ul>
      </nav>
      <hr />

      {/* 라우팅 설정한 element의 컴포넌트를 표시 */}
      <Outlet />
    </div>

    // <div className="App">
    //   <div>
    //     <Navbar bg="light" data-bs-theme="light">
    //       <Container className='d-flex justify-content-between'>
    //         <div>
    //           <Link to="/" className='nav-link fs-2 fw-bold'><Image src=''></Image>Shoppy</Link>
    //         </div>
    //         <div>
    //           <Nav className="me-auto">
    //             <Link to="/products" className='nav-link fw-bold'>Products</Link>
    //             <Link to="/carts" className='nav-link fw-bold'>Carts</Link>
    //             <Link to="/products/new" className='nav-link fw-bold'>아이콘</Link>
    //             <Link to="/login" className='nav-link fw-bold'>Login</Link>
    //           </Nav>
    //         </div>
    //       </Container>
    //     </Navbar>
    //   </div>

    //   <Container>
    //     <Routes>
    //       <Route path='/' element={<Home />} />
    //       <Route path='/products' element={<AllProducts />} />
    //       <Route path='/products/:id' element={<ProductDetail />} />
    //       <Route path='/products/new' element={<NewProduct />} />
    //       <Route path='/carts' element={<Cart />} />
    //     </Routes>
    //   </Container>
    // </div>
  );
}

export default App;