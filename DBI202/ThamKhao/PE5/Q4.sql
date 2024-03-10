SELECT employee_id, CONCAT(first_name, ' ', last_name),	job_title, phone_number AS full_name FROM employees
	LEFT JOIN jobs ON employees.job_id = jobs.job_id
	WHERE job_title = 'Programmer' AND phone_number LIKE '590%'
	ORDER BY phone_number