SELECT  date_format(SALES_DATE, "%Y-%m-%d") SALES_DATE, 
        PRODUCT_ID, USER_ID, SALES_AMOUNT
from ONLINE_SALE 
where year(SALES_DATE) = 2022 && month(SALES_DATE) = 3

union all

SELECT date_format(SALES_DATE, "%Y-%m-%d") SALES_DATE, PRODUCT_ID, null USER_ID, SALES_AMOUNT
from OFFLINE_SALE 
where year(SALES_DATE) = 2022 && month(SALES_DATE) = 3

order by 1, 2, 3