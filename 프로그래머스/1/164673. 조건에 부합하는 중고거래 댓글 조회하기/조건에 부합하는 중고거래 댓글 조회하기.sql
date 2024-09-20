SELECT B.title, B.board_id, R.reply_id, R.writer_id, R.contents, TO_CHAR(R.created_date, 'YYYY-MM-DD') created_date
from used_goods_board B
JOIN used_goods_reply R
on B.board_id = R.board_id
where TO_CHAR(B.created_date, 'YYYY-MM-DD') like '2022-10%'
order by TO_CHAR(R.created_date, 'YYYY-MM-DD') asc, B.title asc