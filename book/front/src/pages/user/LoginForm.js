// 파일명: LoginForm.js

import { useState } from "react";

const LoginForm = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handlerSubmit = (event) => {
        event.preventDefault();
        
        const loginData = {
            email, password
        };

        // fetch() 요청
        // headers : 
        // body : 
        fetch('http://localhost:9090/member/login', {
            
        }).then().catch((error) => {
            console.error("에러:", error);
        });

    }

    return (
        <div>
            <h1>LoginForm</h1>
            <form onSubmit={handlerSubmit}>
                <input type="email"
                    placeholder="이메일"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)} required />
                <input type="password"
                    placeholder="비밀번호"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)} required />
                <button type="submit">로그인</button>
            </form>
        </div>
    )
}

export default LoginForm;