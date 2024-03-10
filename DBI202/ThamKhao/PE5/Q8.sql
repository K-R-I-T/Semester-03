CREATE TRIGGER Salary_Min_Max ON Employees AFTER INSERT, UPDATE AS
	DECLARE @min DECIMAL(8,2)
	DECLARE @max DECIMAL(8,2)
	DECLARE @salary DECIMAL(8,2)
	SELECT @max = jobs.max_salary FROM jobs, inserted
		WHERE jobs.job_id = inserted.job_id
	SELECT @min = jobs.min_salary FROM jobs, inserted
		WHERE jobs.job_id = inserted.job_id
	SELECT @salary = salary FROM inserted
	IF (@salary < @min OR @salary > @max)
		BEGIN
			UPDATE employees
				SET salary = deleted.salary
					FROM deleted, inserted
				WHERE inserted.employee_id = deleted.employee_id
		END
GO

UPDATE employees
	SET salary = 37000
	WHERE employee_id = 102
SELECT * FROM employees WHERE employee_id = 102