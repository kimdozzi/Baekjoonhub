select A.flavor FLAVOR 
from first_half A 
INNER JOIN icecream_info B
on A.flavor = B.flavor
where A.total_order > 3000 and B.ingredient_type = 'fruit_based'
order by A.total_order desc
