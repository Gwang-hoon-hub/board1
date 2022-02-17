|                |HttpMethod                          |HTML                         |
|----------------|-------------------------------|-----------------------------|
|조회			 |`GET`            |'Isn't this fun?'            |
|글 등록          |`POST"`            |"Isn't this fun?"            |
|글 수정          |`PATCH`			|-- is en-dash, --- is em-dash|
|글 삭제          |`DELETE`			|-- is en-dash, --- is em-dash|


### DB Architecture
 |Board           |Comment                         |
|-------------------------------|-----------------------------|
|`(Long) boardId [PK]`            |`(Long) commentId [PK]`           	|
|(String) title           |(String) username           |
|(String) username			|(String) comment		|
|(String) content		|(Board) board [FK]	(ManyToOne)	|


```mermaid
graph LR
A(로그인 / 회원가입) --> B(메인페이지)
B --> C(마이페이지)
B --> D(게시글등록)
B --> E(게시글 상세보기)
C -->F(개인 게시물 모음)
D -->G(URL링크 / 웹크롤링)
E -->H(댓글CRUD)
```
