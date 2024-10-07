//파일명: DeleteForm.js

import { useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";

const DeleteForm = () => {
    const { id } = useParams();

    // 페이지 이동(네비게이션)
    // 특정 경로로 이동할 수 있는 기능
    const navigate = useNavigate();

    // 삭제 후 리다이렉트를 위한 기능!
    // http 요청 시 DELETE 요청을 이용해서 컨트롤러 실행 시키기!
    useEffect(() => {
        fetch(`http://localhost:9090/book/${id}`, { method: 'DELETE' }).then(resp => {
            if (resp.ok) {
                alert('책이 성공적으로 삭제 되었습니다.');
                // 삭제 후 홈으로 리다이렉트할 수 있도록 설정
                navigate("/");
            }
        }).catch(error => {
            console.error("에러:", error);
        });
    }, [id, navigate]);

    // 만약에 굳이 페이지가 필요없는 컴포넌트 있을 수 있다.
    // return null;

    return (
        <div>
            <h1>삭제페이지</h1>
        </div>
    );
}

export default DeleteForm;