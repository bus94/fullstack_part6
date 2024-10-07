// Product.js

import { Card } from "react-bootstrap";
import { Link } from "react-router-dom";

const Product = ({ id, name, price, category, content, brand }) => {
    return (
            <Card>
                <Card.Body>
                    <Card.Title>제품명: {name}</Card.Title>
                    <p>가격: {price}</p>
                    <p>카테고리: {category}</p>
                    <p>제품설명: {content}</p>
                    <p>브랜드: {brand}</p>
                    <Link to={`/products/${id}`} className='btn btn-primary'>상세보기</Link>
                </Card.Body>
            </Card>
    );
};

export default Product;