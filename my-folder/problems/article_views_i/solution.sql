# Write your MySQL query statement below
select DISTINCT AUTHOR_ID  as id
from views
where author_id =  viewer_id
order by id