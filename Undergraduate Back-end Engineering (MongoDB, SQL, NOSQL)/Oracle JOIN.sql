-- SQl inner left join statement (determines the members of staff who worked on either order 1 or order 2 and identifies the food they prepared for that particular order)

-- Relation algebra
-- ? staff_title, staff_forename, staff_surname, resteraunt_no, order_no, food_name (resteraunt_staff, resteraunt)
-- resteraunt_staff ? resteraunt_staff.place_of_work = resteraunt.resteraunt_no (resteraunt)
-- resteraunt_staff ? resteraunt_staff.place_of_work = resteraunt_order.resteraunt_Id (resteraunt_order)
-- resteraunt_order ? resteraunt_order.order_information = food.food_no (food)
-- ? order_no = 1 OR order_no = 2 (resteraunt_order)

select resteraunt_staff.staff_title, resteraunt_staff.staff_forename, resteraunt_staff.staff_surname, resteraunt.resteraunt_no AS place_of_work, resteraunt_order.order_no, food.food_name
from resteraunt_staff
inner join resteraunt on resteraunt_staff.place_of_work = resteraunt.resteraunt_no
inner join resteraunt_order on resteraunt_staff.place_of_work = resteraunt_order.resteraunt_Id
left join Food on resteraunt_order.order_information = food.food_no
where resteraunt_order.order_no = 1 OR resteraunt_order.order_no = 2
order by resteraunt_order.order_no asc;