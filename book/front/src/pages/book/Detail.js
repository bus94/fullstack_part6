import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

//파일명: Detail.js
const Detail = () => {
    // URL /book/3 값을 가져오는 명령문
    //  /book/:id
    const {id} = useParams();

    // 책 정보를 저장할 수 있는 변수
    const [book, setBook] = useState(null);

    // 페이지를 실행할 때 해당 책의 상세 정보를 가져오는 useEffect
    // 컴포넌트가 페이지 실행할 때 특정작업을 하고 싶을 경우에는 사용하는 훅!
    useEffect(() => {
      fetch(`http://localhost:9090/book/${id}`).then(response => response.json()).then(data => {
        setBook(data);
      }).catch(error => {
        console.error("에러:", error);
      });
    }, [id]);
    // id가 변경될 때마다 서버에서 데이터를 받아오는 작업을 실행!

    // 만약에 데이터가 오지 않았다면 메시지를 로딩중 입니다. 추가!
    if(!book) {
      return <p>데이터 안옴!</p>
    }

    // 데이터가 로드 되면 화면에 출력

    return (
      <div>
        <h1>책 상세페이지</h1>
        <h2>{book.title}</h2>
        <p>{book.author}</p>
      </div>
    );
  };
  
export default Detail;

// 실행순서
// 1. 책 상세페이지 이동하면 Detail 컴포넌트 실행!
// 2. URL에서 id값을 가져온다.
// 3. 책 정보 요청(fetch)
// 4. 컨트롤러가 요청을 받아서 응답이 온다.
// 5. 서버에서 응답이 오면 then 메서드 실행된다.
// 6. 응답 받은 JSON으로 변환하여 data에 저장한다.
// 7. 화면에 데이터를 출력! (랜더링)