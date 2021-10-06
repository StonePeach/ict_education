-- sql 구문에서의 한 줄 주석 기호임.
-- sql 구문은 대/소문자 구분 안 함. 단, 저장된 값(데이터)은 대/소문자 구분함.

-- 일반 사용자(개발자)가 데이터베이스를 사용하려면
-- 1. 관리자로 부터 사용자계정과 암호를 받아야 함.
-- 관리자가 사용자계정과 암호를 만드는 구문 : 
-- CREATE USER 사용자계정 IDENTIFIED BY 암호;

-- 수업 진행을 위한 사용자계정 만들기
-- 18C XE 에서는 사용자계정 글자 앞에 반드시 c##을 붙여줘야 함
CREATE USER c##student IDENTIFIED BY c##student;

-- 2. 관리자가 만든 사용자계정에 대해 데이터베이스 접속 권한과 
-- 데이터베이스 자원을 사용할 수 있는 권한을 부여해야 함.
-- 권한 부여 구문 : 
-- GRANT 권한종류 | ROLE이름 TO 사용자계정;
GRANT CONNECT TO c##student;
GRANT RESOURCE TO c##student;

-- 3. 18C 에서는 권한 부여 후에 데이터 기록을 위한 테이블 스페이스 할당을 해야함.
-- 이전 버전에서는안해도 됨
ALTER USER c##student QUOTA 1024M ON USERS;