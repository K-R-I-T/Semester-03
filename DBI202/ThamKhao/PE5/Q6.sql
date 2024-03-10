SELECT TOP 10 e1.first_name, e1.last_name FROM employees e1
	LEFT JOIN employees e2 ON e1.manager_id = e2.employee_id
	WHERE e1.employee_id NOT IN (
		e2.employee_id
	)
	ORDER BY e1.last_name