// LoginForm.js

import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function LoginForm() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [message, setMessage] = useState('');
  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();

    const loginData = {
      email : email,
      password : password
    };

    fetch('http://localhost:9090/products/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(loginData),
    })
      .then(response => {
      })
      .then(data => {
        setMessage(data);
        alert('로그인 성공!');
        navigate('/') // Home.js 이동함
      })
      .catch(error => setMessage(error.message));
  };

  return (
    <div>
      <h1>Login</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Email:</label>
          <input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>
        <div>
          <label>Password:</label>
          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>
        <button type="submit">Login</button>
      </form>

      {/* 리액트를 이용해서 구글 로그인이 가능하도록 실습, 페이스북 로그인 실습 */}
      
      <p>{message}</p>
    </div>
  );

}

export default LoginForm;