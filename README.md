# Blog

java 17 version

spring boot 2.7.8 version

gradle 

 ### dependencies
 - mysql
 - thymeleaf
 - spring security
 - lombok
 - spring data JPA
 - spring web

### 기능구현
 * 회원가입
 * 로그인
    * 메인 페이지, 글 상세페이지, 댓글은 로그인이 없어도 이용가능
    * 나머지는 로그인 후 이용가능
 * 게시글 페이징
   * 1개의 페이지당 10개 씩
 * 게시글 검색
   * @query 어노테이션 사용
 * 게시글 정렬
   * 오름차순, 내림차순
 
### ERD


### 프로젝트 진행중 변경, 에러사항
도메인 생성 문제 -> 빌드 오류

view 전면 /new 로 변경

로그인시 302 에러 문제 발생 -> 시큐리티 csrf.disable 을 하지 않은 문제

댓글과 대댓글을 하나의 테이블로 만들까 고민하였으나 대댓글의 대댓글을 작성하는것이 아니라서 x

