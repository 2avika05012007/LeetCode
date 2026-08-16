# Write your MySQL query statement below
SELECT EM.UNIQUE_ID, E.NAME
FROM EMPLOYEES E LEFT JOIN EmployeeUNI EM
ON EM.ID = E.ID;
 