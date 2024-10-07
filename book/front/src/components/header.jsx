import React from 'react';
import Container from 'react-bootstrap/esm/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Link } from 'react-router-dom';

export default function header() {
  return (
    <div><Navbar bg="dark" data-bs-theme="dark">
    <Container>
      <Link to="/">홈</Link>

      <Nav className="me-auto">
        <Link to="/saveForm" className='nav-link'>글쓰기</Link>
        <Link to="/loginForm" className='nav-link'>로그인</Link>
        <Link to="/joinForm" className='nav-link'>회원가입</Link>
      </Nav>
    </Container>
  </Navbar></div>
  )
}
