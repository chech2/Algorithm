-- 코드를 입력하세요
SELECT r.REST_ID, i.REST_NAME, i.FOOD_TYPE, i.FAVORITES, i.ADDRESS, round(avg(REVIEW_SCORE), 2) as SCORE
from REST_REVIEW r, (select REST_NAME, REST_ID, FOOD_TYPE, FAVORITES , ADDRESS
 from REST_INFO
 where ADDRESS like '서울%') as i
where r.REST_ID = i.REST_ID
group by REST_NAME
order by SCORE desc, FAVORITES desc
