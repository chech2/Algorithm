-- 코드를 입력하세요
SELECT concat('/home/grep/src/', B.BOARD_ID, '/', B.FILE_ID, B.FILE_NAME,  B.FILE_EXT) as FILE_PATH
from USED_GOODS_BOARD as A INNER JOIN USED_GOODS_FILE B ON A.BOARD_ID = B.BOARD_ID
where A.VIEWS = (select MAX(VIEWS) from USED_GOODS_BOARD)
order by B.FILE_ID desc;