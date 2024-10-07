
// App 컴포넌트
import { Container } from "react-bootstrap";
import { Route, Routes } from "react-router-dom";
import Header from "./components/header";

// - 여러 페이지 라우팅을 설정하는 역할
function App() {
  return (
   <div>
    <Container>
      {/* 헤더메뉴 */}
      <Header />
      
      <Routes>
        {/* 홈 경로로 이동할 때 어떤 컴포넌트가 실행이 될 지 설정
          path="경로"
          element={컴포넌트}

          현재 설정은 6버전 최신 버전에 맞춰서 설정을 한 것!
          만약 5버전이면 속성값이 변경된다.

          component={} 해당 컴포넌트로 랜더링
          exact={true} 경로가 정확하게 일치할 때만 해당 컴포넌트로 이동해서 랜더링
        */}
        <Route path="/" element={<div>Home</div>} />
        <Route path="/saveForm" element={<div>글쓰기</div>} />
        {/* url에서 /book/1, /book/2 */}
        <Route path="/book/:id" element={<div>글 상세 페이지</div>} />
        <Route path="/loginForm" element={<div>로그인</div>} />
        <Route path="/joinForm" element={<div>회원가입</div>} />
        <Route path="/updateForm" element={<div>글 수정</div>} />
      </Routes>
    </Container>
   </div>
  );
}

export default App;