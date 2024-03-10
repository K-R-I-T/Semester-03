SELECT invid, proid, quantity, price, quantity * price AS amount FROM tblInv_Detail
	WHERE invid = '000001'