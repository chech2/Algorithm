# -- 코드를 입력하세요
SELECT USER_ID, NICKNAME, concat(CITY, " ",STREET_ADDRESS1," ", STREET_ADDRESS2) as '전체주소', CONCAT(SUBSTR(TLNO, 1, 3), '-',SUBSTR(TLNO, 4, 4), '-', SUBSTR(TLNO, 8, 4)) as '전화번호'
from USED_GOODS_USER
where USER_ID in (select WRITER_ID from USED_GOODS_BOARD group by WRITER_ID HAVING COUNT(WRITER_ID) >= 3)
order by USER_ID desc;

# select WRITER_ID, COUNT(WRITER_ID)
# from USED_GOODS_BOARD
# group by WRITER_ID

#select * from USED_GOODS_BOARD;