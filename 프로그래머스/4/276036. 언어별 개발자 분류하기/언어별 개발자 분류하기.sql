-- 코드를 작성해주세요
SELECT GRADE, D.ID, D.EMAIL
FROM DEVELOPERS D
JOIN (
    SELECT 
        CASE
            WHEN S.SKILL like '%Python%' and S.NEW_CATEGORY like '%Front End%' then 'A'
            WHEN S.SKILL like '%C#%' then 'B'
            WHEN S.NEW_CATEGORY like '%Front End%' then 'C'
        END AS GRADE,
        D.ID
    FROM DEVELOPERS D
    JOIN 
        (SELECT 
            GROUP_CONCAT(S.NAME SEPARATOR ', ') AS SKILL,
            GROUP_CONCAT(S.CATEGORY SEPARATOR ', ') AS NEW_CATEGORY,
            D.ID
        FROM DEVELOPERS D
        JOIN SKILLCODES S
          ON S.CODE & D.SKILL_CODE != 0
        GROUP BY D.ID
        ) AS S
    ON D.ID = S.ID
) AS S
ON D.ID = S.ID
WHERE GRADE IS NOT NULL
ORDER BY GRADE, D.ID