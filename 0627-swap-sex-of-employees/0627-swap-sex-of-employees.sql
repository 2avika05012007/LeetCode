# Write your MySQL query statement below
UPDATE Salary
SET SEX = CASE
    WHEN SEX = 'm' THEN 'f'
    ELSE 'm'
END;