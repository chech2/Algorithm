-- 코드를 입력하세요
SELECT count(*) as USERS
from USER_INFO
where year(JOINED) = 2021 && 20 <= AGE && AGE <= 29;