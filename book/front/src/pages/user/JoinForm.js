// 파일명: JoinForm.js

import { useState } from "react";
import { Button, Container } from "react-bootstrap";
import { Form } from "react-router-dom";

const JoinForm = () => {
    // 회원가입하는 페이지를 생성
    // DB는 member 기준으로 비동기 통신을 이용해서 회원가입 완성하기

    // 입력값 저장 변수
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    // submit 버튼 클릭 함수
    const joinSubmit = async (event) => {
        event.preventDefault();

        console.log("이름:", name)
        console.log("이메일:", email)
        console.log("비밀번호:", password);

        const member = {
            name: name,
            email: email,
            password: password
        };

        try {
            const response = await fetch('http://localhost:9090/member', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(member)
            });

            if (response.ok) {
                alert('회원가입이 정상적으로 완료되었습니다.')
                setName('');
                setEmail('');
                setPassword('');
            } else {
                alert('회원가입에 실패하였습니다.')
            }
        } catch (error) {
            console.error('error:', error);
        }
    };

    return (
        <div>
            <h1>JoinForm</h1>
            <form onSubmit={handlerSubmit}>
                <input type="email" placeholder="이메일" value={email} onChange={(e) => setEmail(e.target.value)} required />
                <input type="text" placeholder="이름" value={name} onChange={(e) => setName(e.target.value)} required />
                <input type="password" placeholder="비밀번호" value={password} onChange={(e) => setPassword(e.target.value)} required />
                <button type="submit">회원가입</button>
            </form>
        </div>
    )
}

export default JoinForm;