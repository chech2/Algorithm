-- 코드를 작성해주세요
select count(*) FISH_COUNT
from FISH_INFO info join FISH_NAME_INFO name
on info.FISH_TYPE = name.FISH_TYPE
where name.FISH_NAME = 'BASS' ||  name.FISH_NAME =  'SNAPPER'