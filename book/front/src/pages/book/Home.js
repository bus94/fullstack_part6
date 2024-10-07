// 파일명: Home.js
import { useEffect, useState } from "react";
import BookItem from "../../components/BookItem";

// DB에서 데이터를 가지고 와서 화면에 그리는 작업
// 리액트에서 변경되는 데이터를 저장하는 키워드
// useState()
const Home = () => {
    // books 라는 변수랑 setBooks 변수를 변경하는 메서드 선언
    // 빈 배열로 설정을 해서 Book 객체의 데이터를 저장
    const [books, setBooks] = useState([]);

    // 함수 실행 시 최초 한 번만 실행될 수 있도록 useEffect() 메서드를 이용해서 비동기 함수 호출해서 get 요청으로 데이터를 받아온다.
    useEffect(() => {
        // 1. 비동기 통신
        // fetch(url) API 요청 보내는 함수
        // 기본적으로 get 요청으로 보낸다.

        // fetch() 서버에서 응답이 오면 실행  // 그 응답을 json 형식으로 변경
        fetch('http://localhost:9090/book').then(response => response.json()).then(data => {
            // 서버에서 받은 데이터를 콘솔에 출력
            console.log(data);
            // 가져온 데이터를 books에 저장
            setBooks(data);
        }).catch(error => {
            console.error("에러: ", error);
        });
    }, []);

    return (
      <div>
        <h1>책 리스트 보기</h1>
        {/*
            리액트에서는 여러 개의 데이터를 출력할 때는 각각의 고유한 id값을 부여해서 구별해줘야된다.
            key 속성을 이용해서 key = {변수명.key}
            추가하거나 삭제할 때 여러 개의 데이터를 제대로 구별하기 위해 사용! (리스트)
        */}
        {books.map((book) => (
            <BookItem key={book.id} id={book.id} title={book.title} author={book.author} />
        ))}
      </div>
    );
  };
  
  export default Home;