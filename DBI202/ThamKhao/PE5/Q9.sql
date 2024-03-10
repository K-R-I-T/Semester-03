CREATE FUNCTION Get_ManagerID (@id int)
RETURNS INT
AS
	BEGIN
		DECLARE @manager_id INT
		SELECT @manager_id = manager_id FROM employees
			WHERE employee_id = @id
		RETURN @manager_id
	END
GO