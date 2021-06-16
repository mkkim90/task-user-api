# User Api Sample

## Tech
Java1.8, SpringBoot, JPA, H2, Swagger, gradle

## 기능사항

- 회원 테이블을 생성
    - id와 password 컬럼

- 회원 가입 기능을 구현
  제약조건
    - 이미 존재하는 ID인 경우, "이미 존재하는 ID입니다."
    - 8자리 이상 9자리 이하 비밀번호는 특수문자, 숫자, 영어 대문자, 영어 소문자 중 3가지 이상을 조합해서 작성하세요.
    - 3자리 이상 연속된 키보드 인접 문자는 비밀번호로 적합하지 않습니다.
    - 10자 이상 영문/숫자/특수문자 중 2종류를 사용하세요.

- 회원의 password 변경 기능을 구현해 주세요.
    - 이미 등록된 password와 동일할 경우 "이전 비밀번호와 동일합니다."
    - 8자리 이상 9자리 이하 비밀번호는 특수문자, 숫자, 영어 대문자, 영어 소문자 중 3가지 이상을 조합해서 작성하세요.
    - 3자리 이상 연속된 키보드 인접 문자는 비밀번호로 적합하지 않습니다.
    - 10자 이상 영문/숫자/특수문자 중 2종류를 사용하세요.
    
- 회원 삭제 기능을 구현해주세요.
    - id와 password가 검증된 경우 삭제가능하도록 처리
    - 없는 ID인 경우 "존재하지 않는 회원입니다."
    - 비밀번호가 틀렸을 경우 "비밀번호가 틀렸습니다."
    