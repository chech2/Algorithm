-- 코드를 작성해주세요
select i.ID,  n.FISH_NAME, i.LENGTH
from FISH_NAME_INFO n
INNER join FISH_INFO i on n.FISH_TYPE	= i.FISH_TYPE
where (i.LENGTH, i.FISH_TYPE) in (
    select MAX(LENGTH), FISH_TYPE
    from FISH_INFO
    group by FISH_TYPE
)
order by i.id