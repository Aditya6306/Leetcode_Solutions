# Write your MySQL query statement below
-- select distinct count(customer_id) from delivery
select round(100*count(*)/(
    select count(distinct customer_id) from delivery
), 2) as immediate_percentage  from Delivery 
where (customer_id, order_date) in (
select customer_id, min(order_date)
from Delivery 
group by customer_id
)
and order_date = customer_pref_delivery_date 