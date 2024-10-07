import React from 'react';
import ReactDOM from 'react-dom/client';

import App from './App';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import AllProducts from './pages/AllProducts';
import Home from './pages/Home';
import NewProduct from './pages/NewProduct';
import ProductDetail from './pages/ProductDetail';
import MyCart from './pages/MyCart';
import NotFound from './pages/NotFound';
import NewProduct2 from './pages/NewProduct2';
import JoinForm from './pages/JoinForm';
import LoginForm from './pages/LoginForm';

// 경로 설정
// createBrowserRouter() : React Router 에서 브라우저 경로를 설정하는 함수! url의 요청으로 페이지 관리를 할 때
const router = createBrowserRouter([
  {
    path: '/',
    element: <App />,
    errorElement: <NotFound />, // 404 페이지
    children: [
      { index: true, element: <Home /> },
      { path: '/products', element: <AllProducts /> },
      {
        path: '/products/new', element: <NewProduct />, children: [
          { path: 'new2', element: <NewProduct2 /> }
        ]
      },
      { path: '/products/:id', element: <ProductDetail /> },
      { path: '/carts', element: <MyCart /> },
      { path: '/loginForm', element: <LoginForm /> },
      { path: '/joinForm', element: <JoinForm /> }
    ],
  }
]);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <RouterProvider router={router}></RouterProvider>
  </React.StrictMode>
);