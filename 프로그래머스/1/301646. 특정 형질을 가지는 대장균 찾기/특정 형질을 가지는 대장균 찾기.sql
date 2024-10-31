-- 코드를 작성해주세요
select count(*) as COUNT
# select *, BIN(GENOTYPE) & 5
from ECOLI_DATA
where GENOTYPE & 2 != 2 && GENOTYPE & 5 != 0