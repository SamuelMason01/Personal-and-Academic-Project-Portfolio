-- SQL sub query (finds the staff with the lowest salary from each branch)

-- Relation algebra
-- ? staff_title, staff_forename, staff_salary, place of work (resteraunt_staff r1)
-- ? staff_salary = 
    -- ? MIN(staff_salary) (resteraunt_staff r2)
    -- ? r1.place_of_work = r2.place_of_work

select s1.staff_title, s1.staff_forename, s1.staff_salary, s1.place_of_work
from resteraunt_staff s1
where s1.staff_salary in
    (select min(s2.staff_salary)
    from resteraunt_staff s2
    where s1.place_of_work = s2.place_of_work);
