SELECT countries.country_id, countries.country_name, COUNT(employee_id) AS [number of employees] FROM employees
	LEFT JOIN departments ON employees.department_id = departments.department_id
	LEFT JOIN locations ON departments.location_id = locations.location_id
	LEFT JOIN countries ON locations.country_id = countries.country_id
	GROUP BY countries.country_id, countries.country_name HAVING COUNT(employee_id) >= 2
	ORDER BY [number of employees] DESC