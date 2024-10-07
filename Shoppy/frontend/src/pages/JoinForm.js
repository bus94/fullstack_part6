// JoinForm.js

import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom'; // 페이지 이동을 위한 useNavigate 훅 사용

function JoinForm() {
  const [message, setMessage] = useState('');
  const navigate = useNavigate(); // useNavigate 훅 초기화

  // 하나의 객체로 입력
  const [formData, setFormData] = useState(
    {
      email: '',
      name: '',
      password: ''
    }
  );

  // 입력 필드가 변경 될 때마다 이벤트 발생!
  const handleChange = (e) => {
    // 이벤트 발생하는 name, value
    const { name, value } = e.target;
    console.log("name:", name);
    console.log("value:", value);

    // 현재 변경된 데이터 빼고 나머지값들은 변경되지 않았다. 그러므로 기존에 있는 값들을 복사해야된다.
    setFormData((prevData) => ({
      ...prevData,
      [name]: value
    }));
  };

  // 회원가입 버튼을 클릭했을 때 실행함수
  const handleSubmit = (e) => {
    e.preventDefault();

    fetch('http://localhost:9090/products/register', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(formData), // formData 객체 전송
    })
      .then(response => {
        if (response.ok) {
          return response.text();
        } else {
          throw new Error('회원가입 실패');
        }
      })
      .then(data => {
        alert('회원가입 성공!'); // 회원가입 성공 알림
        navigate('/loginForm'); // 회원가입 후 login 페이지로 이동
      })
      .catch(error => setMessage(error.message));
  };

  return (
    <div>
      <h1>회원가입</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Email:</label>
          <input
            type="email"
            name="email" // name 속성 추가
            value={formData.email}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label>Name:</label>
          <input
            type="text"
            name="name" // name 속성 추가
            value={formData.name}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label>Password:</label>
          <input
            type="password"
            name="password" // name 속성 추가
            value={formData.password}
            onChange={handleChange}
            required
          />
        </div>
        <button type="submit">회원가입</button>
      </form>
      <p>{message}</p>
    </div>
  );
}

export default JoinForm;