-- 코드를 입력하세요
select NAME, DATETIME
from ANIMAL_INS i
where ANIMAL_ID in 
(
    SELECT ANIMAL_ID
    from ANIMAL_INS i
except
    SELECT ANIMAL_ID
    from ANIMAL_OUTS o
)
order by DATETIME
limit 3