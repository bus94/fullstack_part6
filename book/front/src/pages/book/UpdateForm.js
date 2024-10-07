import { useEffect, useState } from "react";
import { Button, Form } from "react-bootstrap";
import { useParams } from "react-router-dom";

//파일명: UpdateForm.js
const UpdateForm = () => {
  // id 값 가져오기
  const { id } = useParams();

  // 제목, 저자 저장하는 변수
  const [title, setTitle] = useState('');
  const [author, setAuthor] = useState('');

  // 비동기처리로 데이터 요청
  useEffect(() => {
    fetch(`http://localhost:9090/book/${id}`).then(response => response.json()).then(data => {
      console.log(data);
      // 가져온 데이터를 form에 태그 안에 넣기
      setTitle(data.title)
      setAuthor(data.author)
    }).catch(error => {
      console.error("에러:", error);
      alert('데이터를 불러올 수 없습니다.')
    });
  }, [id]);

  // 응답받은 data를 form 태그의 값으로 집어 넣어 화면 출력

  // title, author 데이터를 변경 후 submit해서 결과를 저장하고 제대로 결과가 저장되면 alert()를 이용해서 정상적으로 수정하였습니다. 
  // 만약 에러시 에러메시지 출력!

  // 폼 클릭시 서버에 수정된 데이터를 전송하는 함수
  const handlerSubmit = (event) => {
    // 폼 동작 멈추기!
    event.preventDefault();
    const updateBook = {
      title: title,
      author: author
    };

    // 수정된 데이터를 서버로 전송(PUT)
    fetch(`http://localhost:9090/book/${id}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(updateBook)
    }).then((response) => {
      if(response.ok) {
        alert('책 정보가 성공적으로 수정되었습니다.');
      }
    }).catch((error) => {
      console.error('수정 에러:', error);
      alert('책 정보 수정 도중 에러가 발생하였습니다.');
    });
  };

  return (
    <div>
      <h1>글 수정</h1>
      <Form onSubmit={handlerSubmit}>
        <Form.Group className="mb-3">
          <Form.Label>제목</Form.Label>
          <Form.Control type="text" placeholder="책 제목을 입력하세요" id="title" value={title} onChange={(e) => { setTitle(e.target.value) }} />
        </Form.Group>

        <Form.Group className="mb-3">
          <Form.Label>저자</Form.Label>
          <Form.Control type="text" placeholder="저자를 입력하세요" id="author" value={author} onChange={(e) => { setAuthor(e.target.value) }} />
        </Form.Group>

        <Button variant="primary" type="submit">
          수정하기
        </Button>
      </Form>
    </div>
  );
};

export default UpdateForm;

// 실행순서
// 1. 사용자가 책 수정페이지로 이동하면 UpdateForm
//    컴포넌트가 실행(*화면을 보여줌)
// 2. id 값이 변경되었기 때문에 useEffect 실행된다.
//    url의 id값을 서버에 책 데이터를 요청한다.
// 3. 서버로부터 책 데이터를 받아와 form 필드에 집어넣는다.
// 4. 사용자가 데이터를 수정 후 form에서 submit 버튼을 클릭한다.
// 5. handlerSubmit 함수가 호출된다.
// 6. 수정된 데이터가 put 요청을 한다.
// 7. 서버 응답에 따라서 수정 성공, 실패, 오류 메시지를 출력한다.