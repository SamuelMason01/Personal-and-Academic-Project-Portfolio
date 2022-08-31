-- SQL sub query (finds all of the orders made before todays date)

-- Relation algebra


SELECT r.order_no, f.food_name AS Food_delivered, EXTRACT(DAY FROM r.expected_delivery_time) AS Expected_day_of_delivery 
FROM resteraunt_order r, food f
WHERE expected_delivery_time < sysdate AND f.food_no = r.order_information
Order by order_no asc;