// ProductDetail.js

import React from 'react';
import { useParams } from 'react-router-dom';

function ProductDetail() {
  const { id } = useParams();  // URL의 :id 부분을 가져옴

  return (
    <div>
      <h1>Product Detail</h1>
      <p>Showing details for product ID: {id}</p>
    </div>
  );
}

// const ProductDetail = () => {
//     return (
//         <div>
//             <h1>ProductDetail</h1>
//         </div>
//     );
// }

export default ProductDetail;