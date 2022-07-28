# Write your MySQL query statement below
# update Salary
# set sex = if (sex = 'f','m', 'f')

 UPDATE salary
 SET sex = CASE WHEN sex = "m" 
                 THEN "f" 
                ELSE "m"
           END
                             
# UPDATE salar  y SET sex = REPLACE ('fm', sex, '');