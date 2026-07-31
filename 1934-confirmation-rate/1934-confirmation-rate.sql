# Write your MySQL query statement below

select s.user_id, ifnull(round(
    (select count(*) from Confirmations c where s.user_id = c.user_id and c.action = 'confirmed' group by c.user_id)/(select count(*) from Confirmations c where s.user_id = c.user_id group by c.user_id), 2
), 0.00) as confirmation_rate 
from Signups s;