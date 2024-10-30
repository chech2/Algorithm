-- 코드를 작성해주세요
select distinct ID, EMAIL, FIRST_NAME, LAST_NAME
from SKILLCODES s join DEVELOPERS d
on s.code & d.SKILL_CODE
where s.NAME = 'C#' || s.name = 'Python'
order by d.id 
