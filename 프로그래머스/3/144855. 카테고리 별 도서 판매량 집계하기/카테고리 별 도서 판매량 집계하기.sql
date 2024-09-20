-- 코드를 입력하세요
SELECT A.category category, sum(B.sales) total_sales
from book A JOIN book_sales B
on A.book_id = B.book_id
where to_char(B.sales_date, 'YYYY-MM') like '2022-01%'
group by A.category
ORDER BY A.CATEGORY;