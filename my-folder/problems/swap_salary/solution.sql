/* Write your PL/SQL query statement below */
-- UPDATE salary
-- SET sex = CASE WHEN sex = "m" 
--                 THEN "f" 
--                 ELSE "m"
--            END

update salary set sex = case when sex = 'm' then 'f'
                             else 'm'
                             end