# 커뮤니티 게시판 만들기📝
사람들과 소통할 수 있는 글을 작성하고, 해당 글에 댓글을 달 수 있는 커뮤니티 사이트 생성 개인 프로젝트


## 개발 환경🔑
- IntelliJ
- JDK (11)
- Gradle (build)
- MYSQL (DB)
- Swagger (Test)

## 목표 Todo

1. [x] 회원 가입
    - 간단하게 아이디, 비밀번호만 작성하여도 회원가입이 가능하게 구현 ( 익명 게시판 )
    - 각자에 고유 ID 넘버를 부여해서 유저 구분 ( Unique )


2. [x] 로그인
    - 회원 가입시 입력한 아이디, 비밀번호로 JWT 토큰 생성 후 로그인 가능할 수 있도록 구현


3. [ ] 게시글 작성
    - 로그인한 유저만 게시글 작성 가능
    - 작성 후 글을 등록했을 때, 현재 시간으로 게시글 작성 시간을 표시


4. [ ] 게시글 수정
    - 게시글을 작성한 본인만 수정이 가능
    - 수정했을 시 수정 시간을 최신화


5. [ ] 게시글 삭제
    - 게시글을 작성한 본인만 삭제가 가능
    - 삭제한 글을 조회하려고 할 때, "이미 삭제된 게시글입니다." 문구 및 삭제 시간 표시


6. [ ] 게시글 목록 조회
    - 로그인하지 않은 유저도 게시글 목록 및 게시글 조회 가능 ( 로그인 필요 X )
    - 등록되어있는 글들을 최신순 ( 기본 )으로 조회하는 기능
    - 필요에 따라 댓글 많은 순, 댓글 적은 순으로 정렬 기능
    - 페이징을 통해 20개씩 조회가 가능하도록 구현


7. [ ] 특정 게시글 검색
    - 게시글의 제목 또는 작성한 유저 아이디로 특정 게시글을 검색할 수 있는 기능


8. [ ] 특정 게시글 조회
    - 제목만 볼 수 있었던 게시글의 내용 조회 기능


9. [ ] 댓글 목록 조회
    - 게시글에 달려 있는 댓글 조회 기능
    - 댓글 내용, 댓글 작성자, 댓글 작성 시간 표시


10. [ ] 댓글 작성
    - 로그인한 유저만 댓글 작성 가능
    - 댓글 작성 후 현재 시간으로 댓글 작성 시간 표시


11. [ ] 댓글 수정
    - 댓글을 작성한 유저만 댓글 수정 가능
    - 수정했을 시 수정 시간을 최신화


12. [ ] 댓글 삭제
    - 댓글을 작성한 유저만 댓글 삭제 가능
    - 삭제된 댓글은 "삭제된 댓글입니다." 문구 및 삭제 시간 표시
    
## ERD

<img src="./img/community ERD.png">
