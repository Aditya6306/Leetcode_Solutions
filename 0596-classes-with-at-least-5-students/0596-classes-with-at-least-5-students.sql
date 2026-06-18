# Write your MySQL query statement below
select distinct class
from Courses c
where (select sum(c.class = class) from Courses) >= 5
