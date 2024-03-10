SELECT TOP 1 proname, SUM(quantity*price) AS [Total amount] FROM tblProducts
	LEFT JOIN tblInv_Detail ON tblProducts.proid = tblInv_Detail.proid
	GROUP BY tblProducts.proname
	ORDER BY [Total amount] DESC