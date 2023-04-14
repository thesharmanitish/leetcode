#{"data":{"question":{"content":"<p>Table: <code>Employees</code></p>\n\n<pre>\n+-------------+---------+\n| Column Name | Type    |\n+-------------+---------+\n| employee_id | int     |\n| name        | varchar |\n| salary      | int     |\n+-------------+---------+\nemployee_id is the primary key for this table.\nEach row of this table indicates the employee ID, employee name, and salary.\n</pre>\n\n<p>&nbsp;</p>\n\n<p>Write an SQL query to calculate the bonus of each employee. The bonus of an employee is <code>100%</code> of their salary if the ID of the employee is <strong>an odd number</strong> and <strong>the employee name does not start with the character </strong><code>&#39;M&#39;</code>. The bonus of an employee is <code>0</code> otherwise.</p>\n\n<p>Return the result table ordered by <code>employee_id</code>.</p>\n\n<p>The query result format is in the following example.</p>\n\n<p>&nbsp;</p>\n<p><strong class=\"example\">Example 1:</strong></p>\n\n<pre>\n<strong>Input:</strong> \nEmployees table:\n+-------------+---------+--------+\n| employee_id | name    | salary |\n+-------------+---------+--------+\n| 2           | Meir    | 3000   |\n| 3           | Michael | 3800   |\n| 7           | Addilyn | 7400   |\n| 8           | Juan    | 6100   |\n| 9           | Kannon  | 7700   |\n+-------------+---------+--------+\n<strong>Output:</strong> \n+-------------+-------+\n| employee_id | bonus |\n+-------------+-------+\n| 2           | 0     |\n| 3           | 0     |\n| 7           | 7400  |\n| 8           | 0     |\n| 9           | 7700  |\n+-------------+-------+\n<strong>Explanation:</strong> \nThe employees with IDs 2 and 8 get 0 bonus because they have an even employee_id.\nThe employee with ID 3 gets 0 bonus because their name starts with &#39;M&#39;.\nThe rest of the employees get a 100% bonus.\n</pre>\n","mysqlSchemas":["Create table If Not Exists Employees (employee_id int, name varchar(30), salary int)","Truncate table Employees","insert into Employees (employee_id, name, salary) values ('2', 'Meir', '3000')","insert into Employees (employee_id, name, salary) values ('3', 'Michael', '3800')","insert into Employees (employee_id, name, salary) values ('7', 'Addilyn', '7400')","insert into Employees (employee_id, name, salary) values ('8', 'Juan', '6100')","insert into Employees (employee_id, name, salary) values ('9', 'Kannon', '7700')"]}}}
/**
 * @param {number} n
 * @return {Function} counter
 */
var createCounter = function(n) {
    return function() {
        return n++;
    };
};

/** 
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */