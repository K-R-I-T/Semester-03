SELECT departments.department_id, departments.department_name, MIN(employees.salary) AS [MIN(salary)] FROM departments
	LEFT JOIN employees ON departments.department_id = employees.department_id
	GROUP BY departments.department_id, departments.department_name
	ORDER BY [MIN(salary)]