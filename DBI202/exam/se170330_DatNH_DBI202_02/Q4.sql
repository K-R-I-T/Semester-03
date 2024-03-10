SELECT tblInvoices.invid, invdate, SUM(quantity * price) AS [Total amount] FROM tblInvoices
	RIGHT JOIN tblInv_Detail ON tblInvoices.invid = tblInv_Detail.invid
	GROUP BY tblInvoices.invid, invdate
	ORDER BY invdate DESC