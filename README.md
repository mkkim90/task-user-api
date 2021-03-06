# User Api Sample

## Tech
Java1.8, SpringBoot, JPA, H2, Swagger, gradle

## 기능사항

- 회원 테이블을 생성
    - id와 password 컬럼

- 회원 가입 기능을 구현
  제약조건
    - 이미 존재하는 ID인 경우, "이미 존재하는 ID입니다."
    - 패스원드는 8자리 이상 특수문자, 숫자, 영어 소문자 중 3가지 이상을 조합해서 작성하세요.
    - 아이디는 영문 숫자 조합 5~12 이하만 가능합니다.

- 회원의 password 변경 기능을 구현해 주세요.
    - 이미 등록된 password와 동일할 경우 "이전 비밀번호와 동일합니다."
    
- 회원 삭제 기능을 구현해주세요.
    - 없는 ID인 경우 "존재하지 않는 회원입니다.
  
## Swagger
웹 브라우저를 통해 확인 가능
http://localhost:8080/swagger-ui/ 