// 파일명: BookItem.js
// 책의 내용을 출력할 때 카드 레이아웃을 계속 사용한다. 반복되는 구문을 컴포넌트로 만들어서 재사용!

import { Card } from "react-bootstrap";
import { Link } from "react-router-dom";

const BookItem = ({ id, title, author }) => {
  return (
    <Card>
      <Card.Body>
        <Card.Title>{title}</Card.Title>
        <p>{author}</p>
        <Link to={`/book/${id}`} className='btn btn-primary'>상세보기</Link>
      </Card.Body>
    </Card>
  );
};
export default BookItem;