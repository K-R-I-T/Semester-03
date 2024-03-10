CREATE PROC procTotalamount @employeeid nchar(4), @Totalamount int
AS
	BEGIN
		SELECT @Totalamount = SUM(tblInv_Detail.quantity * tblInv_Detail.price) FROM tblInvoices
			full JOIN tblInv_Detail ON tblInvoices.invid = tblInv_Detail.invid
			where tblInvoices.employeeid = @employeeid
			GROUP BY tblInvoices.employeeid
		return @Totalamount
	END
Go