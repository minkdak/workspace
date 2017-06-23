/* alias
=> 컬럼의 값을 추출할 때 이름을 지정하지 않으면 컬럼 이름을 그대로 사용한다.
=> 만약 컬럼 이름을 다른 이름으로 바꾸고 싶다면, 별명을 지정하라
=> 문법
select 컬럼명 as 별명, ...
*/

/* 컬럼에 별명을 부여하기
=> 별명에 공백이 있으면 따옴표 ('' 또는 "")로 감싸야 한다.
*/

select lno, crmno as classRoomNo, mrno managerNo, titl 'class name'
from lect;



/* 칼럼이 이름이 적합하지 않은 경우
   코드에서 사용하기 쉽도록 이름을 저장한다. */

select count(*) cnt from lect;
-- as생략가능
select concat('(',lno, ':', titl, '-', mrno,')') lectureInfo from lect;
-- lectureInfo 빠져도 되나, 그럴경우 concat~ 전체가 컬럼명으로 들어간다
