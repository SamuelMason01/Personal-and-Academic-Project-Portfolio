SELECT f.food_name AS Food_order, COUNT(r.Customer_id)AS Number_of_customers  
FROM resteraunt_order r, food f
where r.order_information = f.food_no
GROUP BY CUBE(f.food_name);