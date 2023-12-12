
tomcat taglib에서 받은 jar 4개 위치는

- webapp/WEB-INF/lib: 프로젝트에서만 사용
- Tomcat:/lib: 모든 프로젝트가 사용

(table)
create table ysboard  (
	rcdNO		NUMBER(3) PRIMARY KEY,	-- 번호	
	rcdGrpNO	NUMBER(3) NOT NULL,		-- 그룹 번호
	userName	VARCHAR2(20) NOT NULL,	-- 작성자 이름
	userMail	VARCHAR2(30),			-- 작성자 메일
	rcdSubject	VARCHAR2(200) NOT NULL,	-- 제목
	rcdContent	CLOB,					-- 내용
	rcdPass		VARCHAR2(30) NOT NULL,	-- 패스워드
	rcdDate		DATE DEFAULT SYSDATE,	-- 작성일자
	rcdRefer	NUMBER(3) NOT NULL,		-- 참조회수
	rcdIndent	NUMBER(3) NOT NULL,		-- 답변 레코드 제목 앞 공백 문자 지정
	rcdOrder	NUMBER(3) NOT NULL		-- 그룹 내의 레코드 출력 순서
);