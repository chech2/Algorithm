-- 코드를 작성해주세요
-- 1. 물고기 타입별로 그룹핑
-- 2. 평균 길이 구하기 (NULL일 경우, 10으로 대체하여 계산)
-- 3. 정렬
-- 평균 길이가 33cm이상인 물고기

SELECT COUNT(*) FISH_COUNT, MAX(LENGTH) MAX_LENGTH, FISH_TYPE
FROM FISH_INFO
GROUP BY FISH_TYPE
HAVING 32 < AVG(IFNULL(LENGTH, 10))
ORDER BY FISH_TYPE