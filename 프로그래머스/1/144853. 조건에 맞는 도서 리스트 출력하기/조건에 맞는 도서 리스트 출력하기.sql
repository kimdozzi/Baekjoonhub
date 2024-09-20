-- 코드를 입력하세요
SELECT book_id, TO_CHAR(published_date, 'YYYY-MM-DD') published_date
from book
where TO_CHAR(published_date, 'YYYY-MM-DD') like '2021%' 
and category = '인문'
order by published_date