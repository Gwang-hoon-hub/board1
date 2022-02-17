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


### FLOW
```mermaid
graph LR
A(게시글) --> B(게시글 등록)
B --> C(게시글 수정)
B --> D(게시글 삭제)
A --> E(게시글 조회)
B --> F(댓글)
F --> G(댓글 등록)
F --> H(댓글조회)
G --> I(댓글 수정)
G --> J(댓글 삭제)
```
