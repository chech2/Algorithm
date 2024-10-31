-- 코드를 작성해주세요
with recursive generation as (
    select id, 1 as generation
    from ECOLI_DATA
    where PARENT_ID is null
    union all
    select e.id, g.generation + 1
    from ECOLI_DATA e join generation g
    on e.PARENT_ID = g.id
)
select count(*) as COUNT, g.generation
from generation g left join ECOLI_DATA e
on g.id = e.PARENT_ID
where e.id is null
group by g.generation
order by g.generation;