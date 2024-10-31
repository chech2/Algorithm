-- 코드를 입력하세요
(select ANIMAL_ID, NAME
    from ANIMAL_OUTS
except
    select ANIMAL_ID, NAME
    from ANIMAL_INS)
