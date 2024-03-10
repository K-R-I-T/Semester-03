SELECT location_id, country_id, street_address, city FROM locations
	WHERE country_id IN ('US', 'CA')
	ORDER BY location_id DESC