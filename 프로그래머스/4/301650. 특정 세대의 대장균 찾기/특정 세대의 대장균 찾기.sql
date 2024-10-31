-- 코드를 작성해주세요

select cc.id
from ECOLI_DATA cc join 
    (    
        select c.id
        from ECOLI_DATA c join ECOLI_DATA p
        on c.PARENT_ID = p.id
        where p.PARENT_ID is null	
    ) pp
on cc.PARENT_ID = pp.id
order by cc.ID