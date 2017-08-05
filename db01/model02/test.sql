-- ����
DROP TABLE IF EXISTS `MY_SCHEMA`.`LECT` RESTRICT;

-- �л�
DROP TABLE IF EXISTS `MY_SCHEMA`.`STUD` RESTRICT;

-- ����
DROP TABLE IF EXISTS `MY_SCHEMA`.`TCHER` RESTRICT;

-- �Ŵ���
DROP TABLE IF EXISTS `MY_SCHEMA`.`MGR` RESTRICT;

-- ����
DROP TABLE IF EXISTS `MY_SCHEMA`.`SUBJ` RESTRICT;

-- ����
DROP TABLE IF EXISTS `MY_SCHEMA`.`CROOM` RESTRICT;

-- �Խ���
DROP TABLE IF EXISTS `MY_SCHEMA`.`BOARD` RESTRICT;

-- �ڷ��
DROP TABLE IF EXISTS `MY_SCHEMA`.`FBOARD` RESTRICT;

-- QnA
DROP TABLE IF EXISTS `MY_SCHEMA`.`QNA` RESTRICT;

-- ��������
DROP TABLE IF EXISTS `MY_SCHEMA`.`CURR` RESTRICT;

-- ���ǻ���
DROP TABLE IF EXISTS `MY_SCHEMA`.`CR_PIC` RESTRICT;

-- �ּ�
DROP TABLE IF EXISTS `MY_SCHEMA`.`ADDR` RESTRICT;

-- ������������
DROP TABLE IF EXISTS `MY_SCHEMA`.`TABLE19` RESTRICT;

-- ���Ǽ�����
DROP TABLE IF EXISTS `MY_SCHEMA`.`LECT_STUD` RESTRICT;

-- ���ǹ���
DROP TABLE IF EXISTS `MY_SCHEMA`.`LECT_TCHER` RESTRICT;

-- ȸ��
DROP TABLE IF EXISTS `MY_SCHEMA`.`MEMB` RESTRICT;

-- ����
CREATE TABLE `MY_SCHEMA`.`LECT` (
	`LNO`      INTEGER NOT NULL COMMENT '���ǹ�ȣ', -- ���ǹ�ȣ
	`SDT`      DATE    NOT NULL COMMENT '������', -- ������
	`EDT`      DATE    NOT NULL COMMENT '������', -- ������
	`QTY`      INTEGER NOT NULL COMMENT '�����ο�', -- �����ο�
	`TOTL_HRS` INTEGER NOT NULL COMMENT '�Ѱ��ǽð�', -- �Ѱ��ǽð�
	`DAY_HRS`  INTEGER NOT NULL COMMENT '�ϰ��ǽð�', -- �ϰ��ǽð�
	`PAY`      INTEGER NULL     COMMENT '���Ƿ�', -- ���Ƿ�
	`GOV_SUPP` CHAR(1) NOT NULL COMMENT '������������', -- ������������
	`EDU_NO`   INTEGER NOT NULL COMMENT '����������ȣ', -- ����������ȣ
	`CRNO`     INTEGER NULL     COMMENT '���ǹ�ȣ', -- ���ǹ�ȣ
	`MNO`      INTEGER NULL     COMMENT '�Ŵ�����ȣ' -- �Ŵ�����ȣ
)
COMMENT '����';

-- ����
ALTER TABLE `MY_SCHEMA`.`LECT`
	ADD CONSTRAINT `PK_LECT` -- ���� �⺻Ű
		PRIMARY KEY (
			`LNO` -- ���ǹ�ȣ
		);

ALTER TABLE `MY_SCHEMA`.`LECT`
	MODIFY COLUMN `LNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '���ǹ�ȣ';

-- �л�
CREATE TABLE `MY_SCHEMA`.`STUD` (
	`MNO`     INTEGER NOT NULL COMMENT '�л���ȣ', -- �л���ȣ
	`BTDH_DT` DATE    NULL     COMMENT '�������', -- �������
	`WORK`    CHAR(1) NOT NULL COMMENT '��������' -- ��������
)
COMMENT '�л�';

-- �л�
ALTER TABLE `MY_SCHEMA`.`STUD`
	ADD CONSTRAINT `PK_STUD` -- �л� �⺻Ű
		PRIMARY KEY (
			`MNO` -- �л���ȣ
		);

-- ����
CREATE TABLE `MY_SCHEMA`.`TCHER` (
	`MNO`    INTEGER      NOT NULL COMMENT '�����ȣ', -- �����ȣ
	`PAY_HR` INTEGER      NOT NULL COMMENT '�ð���', -- �ð���
	`RESM`   VARCHAR(255) NULL     COMMENT '�̷¼�' -- �̷¼�
)
COMMENT '����';

-- ����
ALTER TABLE `MY_SCHEMA`.`TCHER`
	ADD CONSTRAINT `PK_TCHER` -- ���� �⺻Ű
		PRIMARY KEY (
			`MNO` -- �����ȣ
		);

-- �Ŵ���
CREATE TABLE `MY_SCHEMA`.`MGR` (
	`MNO`  INTEGER     NOT NULL COMMENT '�Ŵ�����ȣ', -- �Ŵ�����ȣ
	`COL4` VARCHAR(40) NULL     COMMENT '����' -- ����
)
COMMENT '�Ŵ���';

-- �Ŵ���
ALTER TABLE `MY_SCHEMA`.`MGR`
	ADD CONSTRAINT `PK_MGR` -- �Ŵ��� �⺻Ű
		PRIMARY KEY (
			`MNO` -- �Ŵ�����ȣ
		);

-- ����
CREATE TABLE `MY_SCHEMA`.`SUBJ` (
	`SBNO`     INTEGER      NOT NULL COMMENT '�����ȣ', -- �����ȣ
	`TITN`     VARCHAR(255) NOT NULL COMMENT '�����', -- �����
	`RPO_LANG` VARCHAR(40)  NULL     COMMENT '���', -- ���
	`TINTFO`   TEXT         NULL     COMMENT '����' -- ����
)
COMMENT '����';

-- ����
ALTER TABLE `MY_SCHEMA`.`SUBJ`
	ADD CONSTRAINT `PK_SUBJ` -- ���� �⺻Ű
		PRIMARY KEY (
			`SBNO` -- �����ȣ
		);

-- ���� ����ũ �ε���
CREATE UNIQUE INDEX `UIX_SUBJ`
	ON `MY_SCHEMA`.`SUBJ` ( -- ����
		`TITN` ASC -- �����
	);

ALTER TABLE `MY_SCHEMA`.`SUBJ`
	MODIFY COLUMN `SBNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '�����ȣ';

-- ����
CREATE TABLE `MY_SCHEMA`.`CROOM` (
	`CRNO` INTEGER     NOT NULL COMMENT '���ǹ�ȣ', -- ���ǹ�ȣ
	`NAME` VARCHAR(40) NOT NULL COMMENT '���Ǹ�', -- ���Ǹ�
	`LOC`  VARCHAR(40) NOT NULL COMMENT '����' -- ����
)
COMMENT '����';

-- ����
ALTER TABLE `MY_SCHEMA`.`CROOM`
	ADD CONSTRAINT `PK_CROOM` -- ���� �⺻Ű
		PRIMARY KEY (
			`CRNO` -- ���ǹ�ȣ
		);

ALTER TABLE `MY_SCHEMA`.`CROOM`
	MODIFY COLUMN `CRNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '���ǹ�ȣ';

-- �Խ���
CREATE TABLE `MY_SCHEMA`.`BOARD` (
	`BNO`  INTEGER      NOT NULL COMMENT '�Խù���ȣ', -- �Խù���ȣ
	`TITL` VARCHAR(255) NOT NULL COMMENT '����', -- ����
	`CONT` MIDIUMTEXT   NULL     COMMENT '����', -- ����
	`VWS`  INTEGER      NOT NULL COMMENT '��ȸ��', -- ��ȸ��
	`CDT`  DATETIME     NOT NULL COMMENT '�����', -- �����
	`MNO`  INTEGER      NOT NULL COMMENT 'ȸ����ȣ' -- ȸ����ȣ
)
COMMENT '�Խ���';

-- �Խ���
ALTER TABLE `MY_SCHEMA`.`BOARD`
	ADD CONSTRAINT `PK_BOARD` -- �Խ��� �⺻Ű
		PRIMARY KEY (
			`BNO` -- �Խù���ȣ
		);

ALTER TABLE `MY_SCHEMA`.`BOARD`
	MODIFY COLUMN `BNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '�Խù���ȣ';

-- �ڷ��
CREATE TABLE `MY_SCHEMA`.`FBOARD` (
	`FNO`     INTEGER      NOT NULL COMMENT '�ڷ��ȣ', -- �ڷ��ȣ
	`TITL`    VARCHAR(255) NOT NULL COMMENT '���ϸ�', -- ���ϸ�
	`FL_PATH` VARCHAR(255) NOT NULL COMMENT '���ϰ��', -- ���ϰ��
	`CONT`    TEXT         NULL     COMMENT '����', -- ����
	`DNS`     INTEGER      NULL     COMMENT '�ٿ�ε��', -- �ٿ�ε��
	`CDT`     DATETIME     NOT NULL COMMENT '�����', -- �����
	`MNO`     INTEGER      NOT NULL COMMENT 'ȸ����ȣ' -- ȸ����ȣ
)
COMMENT '�ڷ��';

-- �ڷ��
ALTER TABLE `MY_SCHEMA`.`FBOARD`
	ADD CONSTRAINT `PK_FBOARD` -- �ڷ�� �⺻Ű
		PRIMARY KEY (
			`FNO` -- �ڷ��ȣ
		);

ALTER TABLE `MY_SCHEMA`.`FBOARD`
	MODIFY COLUMN `FNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '�ڷ��ȣ';

-- QnA
CREATE TABLE `MY_SCHEMA`.`QNA` (
	`QANO` INTEGER  NOT NULL COMMENT '������ȣ', -- ������ȣ
	`QST`  TEXT     NOT NULL COMMENT '����', -- ����
	`CDT`  DATETIME NOT NULL COMMENT '�����', -- �����
	`ANR`  TEXT     NULL     COMMENT '�亯', -- �亯
	`ADT`  DATETIME NULL     COMMENT '�亯��', -- �亯��
	`MNO`  INTEGER  NOT NULL COMMENT 'ȸ����ȣ' -- ȸ����ȣ
)
COMMENT 'QnA';

-- QnA
ALTER TABLE `MY_SCHEMA`.`QNA`
	ADD CONSTRAINT `PK_QNA` -- QnA �⺻Ű
		PRIMARY KEY (
			`QANO` -- ������ȣ
		);

ALTER TABLE `MY_SCHEMA`.`QNA`
	MODIFY COLUMN `QANO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '������ȣ';

-- ��������
CREATE TABLE `MY_SCHEMA`.`CURR` (
	`EDU_NO` INTEGER      NOT NULL COMMENT '����������ȣ', -- ����������ȣ
	`TITL`   VARCHAR(255) NOT NULL COMMENT '������', -- ������
	`CONT`   MIDIUMTEXT   NOT NULL COMMENT '����' -- ����
)
COMMENT '��������';

-- ��������
ALTER TABLE `MY_SCHEMA`.`CURR`
	ADD CONSTRAINT `PK_CURR` -- �������� �⺻Ű
		PRIMARY KEY (
			`EDU_NO` -- ����������ȣ
		);

-- �������� ����ũ �ε���
CREATE UNIQUE INDEX `UIX_CURR`
	ON `MY_SCHEMA`.`CURR` ( -- ��������
		`TITL` ASC -- ������
	);

ALTER TABLE `MY_SCHEMA`.`CURR`
	MODIFY COLUMN `EDU_NO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '����������ȣ';

-- ���ǻ���
CREATE TABLE `MY_SCHEMA`.`CR_PIC` (
	`CRPNO` INTEGER      NOT NULL COMMENT '���ǻ�����ȣ', -- ���ǻ�����ȣ
	`PATH`  VARCHAR(255) NOT NULL COMMENT '����1', -- ����1
	`CRONO` INTEGER      NOT NULL COMMENT '���ǹ�ȣ' -- ���ǹ�ȣ
)
COMMENT '���ǻ���';

-- ���ǻ���
ALTER TABLE `MY_SCHEMA`.`CR_PIC`
	ADD CONSTRAINT `PK_CR_PIC` -- ���ǻ��� �⺻Ű
		PRIMARY KEY (
			`CRPNO` -- ���ǻ�����ȣ
		);

ALTER TABLE `MY_SCHEMA`.`CR_PIC`
	MODIFY COLUMN `CRPNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '���ǻ�����ȣ';

-- �ּ�
CREATE TABLE `MY_SCHEMA`.`ADDR` (
	`ARNO`     INTEGER      NOT NULL COMMENT '�ּҹ�ȣ', -- �ּҹ�ȣ
	`PST_NO`   VARCHAR(10)  NOT NULL COMMENT '�����ȣ', -- �����ȣ
	`BAS_ADDR` VARCHAR(255) NOT NULL COMMENT '�⺻�ּ�' -- �⺻�ּ�
)
COMMENT '�ּ�';

-- �ּ�
ALTER TABLE `MY_SCHEMA`.`ADDR`
	ADD CONSTRAINT `PK_ADDR` -- �ּ� �⺻Ű
		PRIMARY KEY (
			`ARNO` -- �ּҹ�ȣ
		);

ALTER TABLE `MY_SCHEMA`.`ADDR`
	MODIFY COLUMN `ARNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '�ּҹ�ȣ';

-- ������������
CREATE TABLE `MY_SCHEMA`.`TABLE19` (
	`EDU_NO` INTEGER NOT NULL COMMENT '����������ȣ', -- ����������ȣ
	`SBNO`   INTEGER NOT NULL COMMENT '�����ȣ' -- �����ȣ
)
COMMENT '������������';

-- ������������
ALTER TABLE `MY_SCHEMA`.`TABLE19`
	ADD CONSTRAINT `PK_TABLE19` -- ������������ �⺻Ű
		PRIMARY KEY (
			`EDU_NO`, -- ����������ȣ
			`SBNO`    -- �����ȣ
		);

-- ���Ǽ�����
CREATE TABLE `MY_SCHEMA`.`LECT_STUD` (
	`LNO` INTEGER NOT NULL COMMENT '���ǹ�ȣ', -- ���ǹ�ȣ
	`MNO` INTEGER NOT NULL COMMENT '�л���ȣ' -- �л���ȣ
)
COMMENT '���Ǽ�����';

-- ���Ǽ�����
ALTER TABLE `MY_SCHEMA`.`LECT_STUD`
	ADD CONSTRAINT `PK_LECT_STUD` -- ���Ǽ����� �⺻Ű
		PRIMARY KEY (
			`LNO`, -- ���ǹ�ȣ
			`MNO`  -- �л���ȣ
		);

-- ���ǹ���
CREATE TABLE `MY_SCHEMA`.`LECT_TCHER` (
	`LNO` INTEGER NOT NULL COMMENT '���ǹ�ȣ', -- ���ǹ�ȣ
	`MNO` INTEGER NOT NULL COMMENT '�����ȣ' -- �����ȣ
)
COMMENT '���ǹ���';

-- ���ǹ���
ALTER TABLE `MY_SCHEMA`.`LECT_TCHER`
	ADD CONSTRAINT `PK_LECT_TCHER` -- ���ǹ��� �⺻Ű
		PRIMARY KEY (
			`LNO`, -- ���ǹ�ȣ
			`MNO`  -- �����ȣ
		);

-- ȸ��
CREATE TABLE `MY_SCHEMA`.`MEMB` (
	`MNO`       INTEGER      NOT NULL COMMENT 'ȸ����ȣ', -- ȸ����ȣ
	`NAME`      VARCHAR(40)  NOT NULL COMMENT '�̸�', -- �̸�
	`TEL`       VARCHAR(30)  NOT NULL COMMENT '��ȭ', -- ��ȭ
	`EMAIL`     VARCHAR(40)  NOT NULL COMMENT '�̸���', -- �̸���
	`DEET_ADDR` VARCHAR(255) NULL     COMMENT '���ּ�', -- ���ּ�
	`PIC_PATH`  VARCHAR(255) NULL     COMMENT '����', -- ����
	`LST_SCHL`  VARCHAR(10)  NULL     COMMENT '�����з�', -- �����з�
	`SCHL_NM`   VARCHAR(40)  NULL     COMMENT '�б���', -- �б���
	`ARNO`      INTEGER      NULL     COMMENT '�ּҹ�ȣ' -- �ּҹ�ȣ
)
COMMENT 'ȸ��';

-- ȸ��
ALTER TABLE `MY_SCHEMA`.`MEMB`
	ADD CONSTRAINT `PK_MEMB` -- ȸ�� �⺻Ű
		PRIMARY KEY (
			`MNO` -- ȸ����ȣ
		);

-- ȸ�� ����ũ �ε���
CREATE UNIQUE INDEX `UIX_MEMB`
	ON `MY_SCHEMA`.`MEMB` ( -- ȸ��
		`EMAIL` ASC -- �̸���
	);

-- ȸ�� �ε���
CREATE INDEX `IX_MEMB`
	ON `MY_SCHEMA`.`MEMB`( -- ȸ��
		`NAME` ASC -- �̸�
	);

ALTER TABLE `MY_SCHEMA`.`MEMB`
	MODIFY COLUMN `MNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT 'ȸ����ȣ';

-- ����
ALTER TABLE `MY_SCHEMA`.`LECT`
	ADD CONSTRAINT `FK_CURR_TO_LECT` -- �������� -> ����
		FOREIGN KEY (
			`EDU_NO` -- ����������ȣ
		)
		REFERENCES `MY_SCHEMA`.`CURR` ( -- ��������
			`EDU_NO` -- ����������ȣ
		);

-- ����
ALTER TABLE `MY_SCHEMA`.`LECT`
	ADD CONSTRAINT `FK_CROOM_TO_LECT` -- ���� -> ����
		FOREIGN KEY (
			`CRNO` -- ���ǹ�ȣ
		)
		REFERENCES `MY_SCHEMA`.`CROOM` ( -- ����
			`CRNO` -- ���ǹ�ȣ
		);

-- ����
ALTER TABLE `MY_SCHEMA`.`LECT`
	ADD CONSTRAINT `FK_MGR_TO_LECT` -- �Ŵ��� -> ����
		FOREIGN KEY (
			`MNO` -- �Ŵ�����ȣ
		)
		REFERENCES `MY_SCHEMA`.`MGR` ( -- �Ŵ���
			`MNO` -- �Ŵ�����ȣ
		);

-- �л�
ALTER TABLE `MY_SCHEMA`.`STUD`
	ADD CONSTRAINT `FK_MEMB_TO_STUD` -- ȸ�� -> �л�
		FOREIGN KEY (
			`MNO` -- �л���ȣ
		)
		REFERENCES `MY_SCHEMA`.`MEMB` ( -- ȸ��
			`MNO` -- ȸ����ȣ
		);

-- ����
ALTER TABLE `MY_SCHEMA`.`TCHER`
	ADD CONSTRAINT `FK_MEMB_TO_TCHER` -- ȸ�� -> ����
		FOREIGN KEY (
			`MNO` -- �����ȣ
		)
		REFERENCES `MY_SCHEMA`.`MEMB` ( -- ȸ��
			`MNO` -- ȸ����ȣ
		);

-- �Ŵ���
ALTER TABLE `MY_SCHEMA`.`MGR`
	ADD CONSTRAINT `FK_MEMB_TO_MGR` -- ȸ�� -> �Ŵ���
		FOREIGN KEY (
			`MNO` -- �Ŵ�����ȣ
		)
		REFERENCES `MY_SCHEMA`.`MEMB` ( -- ȸ��
			`MNO` -- ȸ����ȣ
		);

-- �Խ���
ALTER TABLE `MY_SCHEMA`.`BOARD`
	ADD CONSTRAINT `FK_MEMB_TO_BOARD` -- ȸ�� -> �Խ���
		FOREIGN KEY (
			`MNO` -- ȸ����ȣ
		)
		REFERENCES `MY_SCHEMA`.`MEMB` ( -- ȸ��
			`MNO` -- ȸ����ȣ
		);

-- �ڷ��
ALTER TABLE `MY_SCHEMA`.`FBOARD`
	ADD CONSTRAINT `FK_MEMB_TO_FBOARD` -- ȸ�� -> �ڷ��
		FOREIGN KEY (
			`MNO` -- ȸ����ȣ
		)
		REFERENCES `MY_SCHEMA`.`MEMB` ( -- ȸ��
			`MNO` -- ȸ����ȣ
		);

-- QnA
ALTER TABLE `MY_SCHEMA`.`QNA`
	ADD CONSTRAINT `FK_MEMB_TO_QNA` -- ȸ�� -> QnA
		FOREIGN KEY (
			`MNO` -- ȸ����ȣ
		)
		REFERENCES `MY_SCHEMA`.`MEMB` ( -- ȸ��
			`MNO` -- ȸ����ȣ
		);

-- ���ǻ���
ALTER TABLE `MY_SCHEMA`.`CR_PIC`
	ADD CONSTRAINT `FK_CROOM_TO_CR_PIC` -- ���� -> ���ǻ���
		FOREIGN KEY (
			`CRONO` -- ���ǹ�ȣ
		)
		REFERENCES `MY_SCHEMA`.`CROOM` ( -- ����
			`CRNO` -- ���ǹ�ȣ
		);

-- ������������
ALTER TABLE `MY_SCHEMA`.`TABLE19`
	ADD CONSTRAINT `FK_CURR_TO_TABLE19` -- �������� -> ������������
		FOREIGN KEY (
			`EDU_NO` -- ����������ȣ
		)
		REFERENCES `MY_SCHEMA`.`CURR` ( -- ��������
			`EDU_NO` -- ����������ȣ
		);

-- ������������
ALTER TABLE `MY_SCHEMA`.`TABLE19`
	ADD CONSTRAINT `FK_SUBJ_TO_TABLE19` -- ���� -> ������������
		FOREIGN KEY (
			`SBNO` -- �����ȣ
		)
		REFERENCES `MY_SCHEMA`.`SUBJ` ( -- ����
			`SBNO` -- �����ȣ
		);

-- ���Ǽ�����
ALTER TABLE `MY_SCHEMA`.`LECT_STUD`
	ADD CONSTRAINT `FK_LECT_TO_LECT_STUD` -- ���� -> ���Ǽ�����
		FOREIGN KEY (
			`LNO` -- ���ǹ�ȣ
		)
		REFERENCES `MY_SCHEMA`.`LECT` ( -- ����
			`LNO` -- ���ǹ�ȣ
		);

-- ���Ǽ�����
ALTER TABLE `MY_SCHEMA`.`LECT_STUD`
	ADD CONSTRAINT `FK_STUD_TO_LECT_STUD` -- �л� -> ���Ǽ�����
		FOREIGN KEY (
			`MNO` -- �л���ȣ
		)
		REFERENCES `MY_SCHEMA`.`STUD` ( -- �л�
			`MNO` -- �л���ȣ
		);

-- ���ǹ���
ALTER TABLE `MY_SCHEMA`.`LECT_TCHER`
	ADD CONSTRAINT `FK_TCHER_TO_LECT_TCHER` -- ���� -> ���ǹ���
		FOREIGN KEY (
			`MNO` -- �����ȣ
		)
		REFERENCES `MY_SCHEMA`.`TCHER` ( -- ����
			`MNO` -- �����ȣ
		);

-- ���ǹ���
ALTER TABLE `MY_SCHEMA`.`LECT_TCHER`
	ADD CONSTRAINT `FK_LECT_TO_LECT_TCHER` -- ���� -> ���ǹ���
		FOREIGN KEY (
			`LNO` -- ���ǹ�ȣ
		)
		REFERENCES `MY_SCHEMA`.`LECT` ( -- ����
			`LNO` -- ���ǹ�ȣ
		);

-- ȸ��
ALTER TABLE `MY_SCHEMA`.`MEMB`
	ADD CONSTRAINT `FK_ADDR_TO_MEMB` -- �ּ� -> ȸ��
		FOREIGN KEY (
			`ARNO` -- �ּҹ�ȣ
		)
		REFERENCES `MY_SCHEMA`.`ADDR` ( -- �ּ�
			`ARNO` -- �ּҹ�ȣ
		);