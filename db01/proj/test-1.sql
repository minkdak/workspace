-- 회원
DROP TABLE IF EXISTS NEW_SCHEMA.TABLE RESTRICT;

-- 주문
DROP TABLE IF EXISTS NEW_SCHEMA.TABLE2 RESTRICT;

-- 상품
DROP TABLE IF EXISTS NEW_SCHEMA.TABLE3 RESTRICT;

-- 배송
DROP TABLE IF EXISTS NEW_SCHEMA.TABLE4 RESTRICT;

-- 장바구니
DROP TABLE IF EXISTS NEW_SCHEMA.TABLE5 RESTRICT;

-- 택배
DROP TABLE IF EXISTS NEW_SCHEMA.TABLE9 RESTRICT;

-- 고객센터&콜센터
DROP TABLE IF EXISTS NEW_SCHEMA.TABLE11 RESTRICT;

-- 판매자
DROP TABLE IF EXISTS NEW_SCHEMA.TABLE12 RESTRICT;

-- 영자
DROP TABLE IF EXISTS NEW_SCHEMA.TABLE14 RESTRICT;

-- 결제방법
DROP TABLE IF EXISTS NEW_SCHEMA.TABLE16 RESTRICT;

-- 비회원
DROP TABLE IF EXISTS NEW_SCHEMA.TABLE17 RESTRICT;

-- 관심상품
DROP TABLE IF EXISTS NEW_SCHEMA.TABLE19 RESTRICT;

-- 회원
CREATE TABLE NEW_SCHEMA.TABLE (
	COL11 INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	COL   VARCHAR(50)  NULL     COMMENT '사용자아이디', -- 사용자아이디
	COL2  INTEGER      NULL     COMMENT '주민번호', -- 주민번호
	COL10 VARCHAR(50)  NULL     COMMENT '회원이름', -- 회원이름
	COL3  VARCHAR(255) NULL     COMMENT '패스워드', -- 패스워드
	COL4  VARCHAR(255) NULL     COMMENT '우편번호', -- 우편번호
	COL5  VARCHAR(255) NULL     COMMENT '주소', -- 주소
	COL6  varchar(30)  NULL     COMMENT '전화번호', -- 전화번호
	COL7  varchar(30)  NULL     COMMENT '핸드폰번호', -- 핸드폰번호
	COL8  VARCHAR(255) NULL     COMMENT '결재방법', -- 결재방법
	COL9  INTEGER      NULL     COMMENT '구매포인트', -- 구매포인트
	COL12 VARCHAR(255) NULL     COMMENT '판매자유무', -- 판매자유무
	COL14 VARCHAR(255) NULL     COMMENT '관리자유무' -- 관리자유무
)
COMMENT '회원';

-- 회원
ALTER TABLE NEW_SCHEMA.TABLE
	ADD CONSTRAINT PK_TABLE -- 회원 기본키
		PRIMARY KEY (
			COL11 -- 회원번호
		);

-- 회원 유니크 인덱스
CREATE UNIQUE INDEX UIX_TABLE
	ON NEW_SCHEMA.TABLE ( -- 회원
		COL ASC,  -- 사용자아이디
		COL2 ASC  -- 주민번호
	);

-- 주문
CREATE TABLE NEW_SCHEMA.TABLE2 (
	COL2  INTEGER      NOT NULL COMMENT '주문번호', -- 주문번호
	COL3  DATE         NULL     COMMENT '주문일자', -- 주문일자
	COL   VARCHAR(255) NULL     COMMENT '주문상태', -- 주문상태
	COL4  VARCHAR(255) NULL     COMMENT '배송지주소', -- 배송지주소
	COL5  varchar(30)  NULL     COMMENT '배송지연락처', -- 배송지연락처
	COL6  VARCHAR(255) NULL     COMMENT '배송방법', -- 배송방법
	COL9  VARCHAR(255) NULL     COMMENT '메모', -- 메모
	COL10 INTEGER      NOT NULL COMMENT '장바구니번호', -- 장바구니번호
	COL12 INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	COL8  INTEGER      NOT NULL COMMENT '비회원코드', -- 비회원코드
	id    INTEGER      NOT NULL COMMENT '관심상품코드', -- 관심상품코드
	id    INTEGER      NOT NULL COMMENT '판매자코드', -- 판매자코드
	id2   VARCHAR(255) NULL     COMMENT '결재방법', -- 결재방법
	COL7  INTEGER      NULL     COMMENT '상품코드' -- 상품코드
)
COMMENT '주문';

-- 주문
ALTER TABLE NEW_SCHEMA.TABLE2
	ADD CONSTRAINT PK_TABLE2 -- 주문 기본키
		PRIMARY KEY (
			COL2 -- 주문번호
		);

-- 상품
CREATE TABLE NEW_SCHEMA.TABLE3 (
	id    INTEGER     NOT NULL COMMENT '판매자코드', -- 판매자코드
	COL   INTEGER     NOT NULL COMMENT '상품코드', -- 상품코드
	COL11 INTEGER     NULL     COMMENT '회원번호', -- 회원번호
	COL4  INTEGER     NULL     COMMENT '상품수량', -- 상품수량
	COL6  INTEGER     NULL     COMMENT '배송번호', -- 배송번호
	COL2  VARCHAR(50) NULL     COMMENT '상품이름', -- 상품이름
	COL5  INTEGER     NULL     COMMENT '상품단가' -- 상품단가
)
COMMENT '상품';

-- 상품
ALTER TABLE NEW_SCHEMA.TABLE3
	ADD CONSTRAINT PK_TABLE3 -- 상품 기본키
		PRIMARY KEY (
			id,  -- 판매자코드
			COL  -- 상품코드
		);

-- 배송
CREATE TABLE NEW_SCHEMA.TABLE4 (
	COL  INTEGER NOT NULL COMMENT '배송번호', -- 배송번호
	COL2 INTEGER NULL     COMMENT '택배업체번호', -- 택배업체번호
	COL3 INTEGER NULL     COMMENT '배송금액', -- 배송금액
	COL4 INTEGER NULL     COMMENT '주문번호' -- 주문번호
)
COMMENT '배송';

-- 배송
ALTER TABLE NEW_SCHEMA.TABLE4
	ADD CONSTRAINT PK_TABLE4 -- 배송 기본키
		PRIMARY KEY (
			COL -- 배송번호
		);

-- 장바구니
CREATE TABLE NEW_SCHEMA.TABLE5 (
	COL2  INTEGER NOT NULL COMMENT '장바구니번호', -- 장바구니번호
	COL11 INTEGER NOT NULL COMMENT '회원번호', -- 회원번호
	COL8  INTEGER NOT NULL COMMENT '비회원코드', -- 비회원코드
	id    INTEGER NOT NULL COMMENT '관심상품코드', -- 관심상품코드
	id2   INTEGER NULL     COMMENT '판매자코드', -- 판매자코드
	COL9  INTEGER NULL     COMMENT '상품코드' -- 상품코드
)
COMMENT '장바구니';

-- 장바구니
ALTER TABLE NEW_SCHEMA.TABLE5
	ADD CONSTRAINT PK_TABLE5 -- 장바구니 기본키
		PRIMARY KEY (
			COL2 -- 장바구니번호
		);

-- 택배
CREATE TABLE NEW_SCHEMA.TABLE9 (
	COL  VARCHAR(50)  NULL COMMENT '택배업체명', -- 택배업체명
	COL2 varchar(30)  NULL COMMENT '택배연락처', -- 택배연락처
	COL3 VARCHAR(255) NULL COMMENT '택배사주소', -- 택배사주소
	COL4 INTEGER      NULL COMMENT '배송번호' -- 배송번호
)
COMMENT '택배';

-- 고객센터&콜센터
CREATE TABLE NEW_SCHEMA.TABLE11 (
	COL10 INTEGER      NOT NULL COMMENT '게시물번호', -- 게시물번호
	COL   VARCHAR(255) NULL     COMMENT '주문', -- 주문
	COL2  VARCHAR(255) NULL     COMMENT '결제', -- 결제
	COL3  VARCHAR(255) NULL     COMMENT '배송', -- 배송
	COL4  VARCHAR(255) NULL     COMMENT '취소 환불', -- 취소 환불
	COL5  VARCHAR(255) NULL     COMMENT '기타', -- 기타
	COL6  VARCHAR(50)  NULL     COMMENT '등록자', -- 등록자
	COL7  DATETIME     NULL     COMMENT '등록일', -- 등록일
	COL8  VARCHAR(50)  NULL     COMMENT '답변자', -- 답변자
	COL9  DATETIME     NULL     COMMENT '답변일', -- 답변일
	COL11 INTEGER      NULL     COMMENT '회원번호' -- 회원번호
)
COMMENT '고객센터&콜센터';

-- 고객센터&콜센터
ALTER TABLE NEW_SCHEMA.TABLE11
	ADD CONSTRAINT PK_TABLE11 -- 고객센터&콜센터 기본키
		PRIMARY KEY (
			COL10 -- 게시물번호
		);

-- 판매자
CREATE TABLE NEW_SCHEMA.TABLE12 (
	id    INTEGER     NOT NULL COMMENT '판매자코드', -- 판매자코드
	COL11 INTEGER     NOT NULL COMMENT '회원번호', -- 회원번호
	COL   VARCHAR(50) NULL     COMMENT '사업자명', -- 사업자명
	COL2  INTEGER     NULL     COMMENT '배송번호' -- 배송번호
)
COMMENT '판매자';

-- 판매자
ALTER TABLE NEW_SCHEMA.TABLE12
	ADD CONSTRAINT PK_TABLE12 -- 판매자 기본키
		PRIMARY KEY (
			id,    -- 판매자코드
			COL11  -- 회원번호
		);

-- 영자
CREATE TABLE NEW_SCHEMA.TABLE14 (
	COL11 INTEGER      NOT NULL COMMENT '관리자코드', -- 관리자코드
	COL3  VARCHAR(255) NULL     COMMENT '패스워드', -- 패스워드
	COL4  VARCHAR(255) NULL     COMMENT '직위', -- 직위
	COL11 INTEGER      NULL     COMMENT '상품코드', -- 상품코드
	COL10 INTEGER      NULL     COMMENT '장바구니번호', -- 장바구니번호
	COL12 INTEGER      NULL     COMMENT '회원번호', -- 회원번호
	COL8  INTEGER      NULL     COMMENT '비회원코드', -- 비회원코드
	id    INTEGER      NULL     COMMENT '관심상품코드', -- 관심상품코드
	id    INTEGER      NULL     COMMENT '판매자코드' -- 판매자코드
)
COMMENT '영자';

-- 영자
ALTER TABLE NEW_SCHEMA.TABLE14
	ADD CONSTRAINT PK_TABLE14 -- 영자 기본키
		PRIMARY KEY (
			COL11 -- 관리자코드
		);

-- 결제방법
CREATE TABLE NEW_SCHEMA.TABLE16 (
	id   VARCHAR(255) NOT NULL COMMENT '결재방법', -- 결재방법
	COL  VARCHAR(255) NULL     COMMENT '카드', -- 카드
	COL2 VARCHAR(255) NULL     COMMENT '핸드폰', -- 핸드폰
	COL3 VARCHAR(255) NULL     COMMENT '계좌이체', -- 계좌이체
	COL4 VARCHAR(255) NULL     COMMENT '무통장입금' -- 무통장입금
)
COMMENT '결제방법';

-- 결제방법
ALTER TABLE NEW_SCHEMA.TABLE16
	ADD CONSTRAINT PK_TABLE16 -- 결제방법 기본키
		PRIMARY KEY (
			id -- 결재방법
		);

-- 비회원
CREATE TABLE NEW_SCHEMA.TABLE17 (
	COL6 INTEGER      NOT NULL COMMENT '비회원코드', -- 비회원코드
	COL  VARCHAR(50)  NULL     COMMENT '이름', -- 이름
	COL2 varchar(30)  NULL     COMMENT '전화번호', -- 전화번호
	COL3 VARCHAR(40)  NULL     COMMENT '이메일', -- 이메일
	COL4 VARCHAR(255) NULL     COMMENT '주소', -- 주소
	COL5 VARCHAR(255) NULL     COMMENT '배송지주소' -- 배송지주소
)
COMMENT '비회원';

-- 비회원
ALTER TABLE NEW_SCHEMA.TABLE17
	ADD CONSTRAINT PK_TABLE17 -- 비회원 기본키
		PRIMARY KEY (
			COL6 -- 비회원코드
		);

-- 관심상품
CREATE TABLE NEW_SCHEMA.TABLE19 (
	id   INTEGER      NOT NULL COMMENT '관심상품코드', -- 관심상품코드
	COL  VARCHAR(255) NULL     COMMENT '찜목록', -- 찜목록
	COL2 VARCHAR(255) NULL     COMMENT '찜해지 목록', -- 찜해지 목록
	COL3 VARCHAR(255) NULL     COMMENT '결제 목록' -- 결제 목록
)
COMMENT '관심상품';

-- 관심상품
ALTER TABLE NEW_SCHEMA.TABLE19
	ADD CONSTRAINT PK_TABLE19 -- 관심상품 기본키
		PRIMARY KEY (
			id -- 관심상품코드
		);

-- 주문
ALTER TABLE NEW_SCHEMA.TABLE2
	ADD CONSTRAINT FK_TABLE3_TO_TABLE2 -- 상품 -> 주문
		FOREIGN KEY (
			id,   -- 판매자코드
			COL7  -- 상품코드
		)
		REFERENCES NEW_SCHEMA.TABLE3 ( -- 상품
			id,  -- 판매자코드
			COL  -- 상품코드
		);

-- 주문
ALTER TABLE NEW_SCHEMA.TABLE2
	ADD CONSTRAINT FK_TABLE5_TO_TABLE2 -- 장바구니 -> 주문
		FOREIGN KEY (
			COL10 -- 장바구니번호
		)
		REFERENCES NEW_SCHEMA.TABLE5 ( -- 장바구니
			COL2 -- 장바구니번호
		);

-- 주문
ALTER TABLE NEW_SCHEMA.TABLE2
	ADD CONSTRAINT FK_TABLE16_TO_TABLE2 -- 결제방법 -> 주문
		FOREIGN KEY (
			id2 -- 결재방법
		)
		REFERENCES NEW_SCHEMA.TABLE16 ( -- 결제방법
			id -- 결재방법
		);

-- 주문
ALTER TABLE NEW_SCHEMA.TABLE2
	ADD CONSTRAINT FK_TABLE5_TO_TABLE22 -- 장바구니 -> 주문2
		FOREIGN KEY (
			COL10 -- 장바구니번호
		)
		REFERENCES NEW_SCHEMA.TABLE5 ( -- 장바구니
			COL2 -- 장바구니번호
		);

-- 상품
ALTER TABLE NEW_SCHEMA.TABLE3
	ADD CONSTRAINT 
		FOREIGN KEY (
			id -- 판매자코드
		)
		REFERENCES NEW_SCHEMA.TABLE12 ( -- 판매자
			id,    -- 판매자코드
			COL11  -- 회원번호
		);

-- 상품
ALTER TABLE NEW_SCHEMA.TABLE3
	ADD CONSTRAINT FK_TABLE12_TO_TABLE3 -- 판매자 -> 상품
		FOREIGN KEY (
			id,    -- 판매자코드
			COL11  -- 회원번호
		)
		REFERENCES NEW_SCHEMA.TABLE12 ( -- 판매자
			id,    -- 판매자코드
			COL11  -- 회원번호
		);

-- 배송
ALTER TABLE NEW_SCHEMA.TABLE4
	ADD CONSTRAINT FK_TABLE2_TO_TABLE4 -- 주문 -> 배송
		FOREIGN KEY (
			COL4 -- 주문번호
		)
		REFERENCES NEW_SCHEMA.TABLE2 ( -- 주문
			COL2 -- 주문번호
		);

-- 장바구니
ALTER TABLE NEW_SCHEMA.TABLE5
	ADD CONSTRAINT FK_TABLE17_TO_TABLE5 -- 비회원 -> 장바구니
		FOREIGN KEY (
			COL8 -- 비회원코드
		)
		REFERENCES NEW_SCHEMA.TABLE17 ( -- 비회원
			COL6 -- 비회원코드
		);

-- 장바구니
ALTER TABLE NEW_SCHEMA.TABLE5
	ADD CONSTRAINT FK_TABLE_TO_TABLE5 -- 회원 -> 장바구니
		FOREIGN KEY (
			COL11 -- 회원번호
		)
		REFERENCES NEW_SCHEMA.TABLE ( -- 회원
			COL11 -- 회원번호
		);

-- 장바구니
ALTER TABLE NEW_SCHEMA.TABLE5
	ADD CONSTRAINT FK_TABLE3_TO_TABLE5 -- 상품 -> 장바구니
		FOREIGN KEY (
			id2,  -- 판매자코드
			COL9  -- 상품코드
		)
		REFERENCES NEW_SCHEMA.TABLE3 ( -- 상품
			id,  -- 판매자코드
			COL  -- 상품코드
		);

-- 장바구니
ALTER TABLE NEW_SCHEMA.TABLE5
	ADD CONSTRAINT FK_TABLE19_TO_TABLE5 -- 관심상품 -> 장바구니
		FOREIGN KEY (
			id -- 관심상품코드
		)
		REFERENCES NEW_SCHEMA.TABLE19 ( -- 관심상품
			id -- 관심상품코드
		);

-- 택배
ALTER TABLE NEW_SCHEMA.TABLE9
	ADD CONSTRAINT FK_TABLE4_TO_TABLE9 -- 배송 -> 택배
		FOREIGN KEY (
			COL4 -- 배송번호
		)
		REFERENCES NEW_SCHEMA.TABLE4 ( -- 배송
			COL -- 배송번호
		);

-- 고객센터&콜센터
ALTER TABLE NEW_SCHEMA.TABLE11
	ADD CONSTRAINT FK_TABLE_TO_TABLE11 -- 회원 -> 고객센터&콜센터
		FOREIGN KEY (
			COL11 -- 회원번호
		)
		REFERENCES NEW_SCHEMA.TABLE ( -- 회원
			COL11 -- 회원번호
		);

-- 판매자
ALTER TABLE NEW_SCHEMA.TABLE12
	ADD CONSTRAINT FK_TABLE_TO_TABLE12 -- 회원 -> 판매자
		FOREIGN KEY (
			COL11 -- 회원번호
		)
		REFERENCES NEW_SCHEMA.TABLE ( -- 회원
			COL11 -- 회원번호
		);

-- 판매자
ALTER TABLE NEW_SCHEMA.TABLE12
	ADD CONSTRAINT FK_TABLE4_TO_TABLE12 -- 배송 -> 판매자
		FOREIGN KEY (
			COL2 -- 배송번호
		)
		REFERENCES NEW_SCHEMA.TABLE4 ( -- 배송
			COL -- 배송번호
		);

-- 영자
ALTER TABLE NEW_SCHEMA.TABLE14
	ADD CONSTRAINT FK_TABLE_TO_TABLE14 -- 회원 -> 영자
		FOREIGN KEY (
			COL11 -- 관리자코드
		)
		REFERENCES NEW_SCHEMA.TABLE ( -- 회원
			COL11 -- 회원번호
		);

-- 영자
ALTER TABLE NEW_SCHEMA.TABLE14
	ADD CONSTRAINT FK_TABLE4_TO_TABLE14 -- 배송 -> 영자
		FOREIGN KEY (
		)
		REFERENCES NEW_SCHEMA.TABLE4 ( -- 배송
			COL -- 배송번호
		);