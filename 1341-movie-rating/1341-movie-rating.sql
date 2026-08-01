# Write your MySQL query statement below
(select u.name as results
from Users u join MovieRating m
on u.user_id = m.user_id
group by u.user_id
having count(*)>=
All(
    select count(*)
    from Users u join MovieRating m
    on u.user_id = m.user_id
    group by u.user_id
)
order by u.name
limit 1
)

union All

(
select m.title as results
from Movies m join MovieRating r
on m.movie_id = r.movie_id
where date_format(r.created_at, '%Y-%m')= '2020-02'
group by r.movie_id
order by avg(r.rating) desc, m.title asc
limit 1)