# Write your MySQL query statement below
Select user_id, count(*) as followers_count
from followers
group by user_id
order by user_id