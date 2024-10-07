import { useState } from 'react';
import { Container } from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { useNavigate } from 'react-router-dom';

//파일명: SaveForm.js
const SaveForm = () => {
  // 페이지 이동
  const navigate = useNavigate();

  // 입력값을 저장하는 변수들
  const [title, setTitle] = useState('');
  const [author, setAuthor] = useState('');

  // submit 버튼을 클릭하면 실행되는 함수
  const handlerSubmit = async (event) => {
    // 폼의 기본 동작 멈추기 (바로 서버로 가는 것을 막는 것)
    event.preventDefault();

    console.log('제목:', title);
    console.log('저자:', author);

    // 입력 받은 데이터를 객체로 생성
    const book = {
      title: title,
      author: author
    };

    
    try {
      // API 통신 날리기 POST로!
      // await 동기적 통신으로 변경해서 DB에서 저장하고 저장된 내용을 반환하는 사이에 이미 response.ok if문 실행을 하기 때문에 데이터는 정상적으로 들어가지만 에러가 발생했다는 alert창이 뜬다.
      // 함수 실행하는 앞에 async를 같이 써줘야한다.
      const response = await fetch('http://localhost:9090/book', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(book)
      });

      // 응답확인
      if (response.ok) {
        alert('책이 성공적으로 저장되었습니다.');
        // 폼 초기화
        setTitle('');
        setAuthor('');
        // 책 추가한 후 홈으로 이동!
        navigate("/");
      } else {
        alert('저장에 실패했습니다!');
      }
    } catch (error) {
      console.error('error:', error);
    }
  };

  return (
    <Container>
      <h1>글쓰기</h1>
      <Form onSubmit={handlerSubmit}>
        <Form.Group className="mb-3" controlId="formTitle">
          <Form.Label>제목</Form.Label>
          <Form.Control type="text" placeholder="책 제목을 입력하세요" value={title} onChange={(e)=>{setTitle(e.target.value)}} />
        </Form.Group>

        <Form.Group className="mb-3" controlId="formAuthor">
          <Form.Label>저자</Form.Label>
          <Form.Control type="text" placeholder="저자를 입력하세요" value={author} onChange={(e)=>{setAuthor(e.target.value)}} />
        </Form.Group>

        <Button variant="primary" type="submit">
          저장
        </Button>
      </Form>
    </Container>
  );
};

export default SaveForm;