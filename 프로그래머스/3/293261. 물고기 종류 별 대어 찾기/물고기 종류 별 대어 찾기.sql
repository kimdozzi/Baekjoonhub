select A.id, B.fish_name, A.length
from fish_info A JOIN fish_name_info B
on A.fish_type = B.fish_type
where (A.fish_type, A.length) in (select fish_type, max(length)
from fish_info
group by fish_type)