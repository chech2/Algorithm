-- 코드를 작성해주세요

select a.id
from ECOLI_DATA a 
join ECOLI_DATA b on a.PARENT_ID = b.id
join ECOLI_DATA c on b.PARENT_ID = c.id
where c.PARENT_ID is null    
order by a.ID