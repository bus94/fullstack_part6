// AllProducts.js

import React from 'react';
import { Link } from 'react-router-dom';
import { useEffect, useState } from "react";
import Product from "../components/Product";

function AllProducts() {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        fetch('http://localhost:9090/products').then(response => response.json()).then(data => {
            console.log("data:", data);
            setProducts(data);
        }).catch(error => {
            console.error("에러:", error);
        });
    }, []);

    return (
        <div>
            <h1>모든 상품</h1>
          
            {products.map((product) => (
        
                <Product key={product.id} id={product.id} name={product.name} price={product.price} category={product.category} content={product.content} brand={product.brand} />
            ))}
        </div>
    );

    // const products = [
    //   { id: 1, name: 'Product 1' },
    //   { id: 2, name: 'Product 2' },
    //   { id: 3, name: 'Product 3' },
    // ];

    // return (
    //   <div>
    //     <h1>All Products</h1>
    //     <ul>
    //       {products.map(product => (
    //         <li key={product.id}>
    //           <Link to={`/products/${product.id}`}>{product.name}</Link>
    //         </li>
    //       ))}
    //     </ul>
    //   </div>
    // );
}

// const AllProducts = () => {
//     const [products, setProducts] = useState([]);

//     useEffect(() => {
//         fetch('http://localhost:9090/products').then(response => response.json()).then(data => {
//             console.log("data:", data);
//             setProducts(data);
//         }).catch(error => {
//             console.error("에러:", error);
//         });
//     }, []);

//     return (
//         <div>
//             <h1>모든 상품</h1>
//             {products.map((product) => {
//                 <Product id={product.id} name={product.name} price={product.price} category={product.category} content={product.content} brand={product.brand} />
//             })}
//         </div>
//     );
// }

export default AllProducts;