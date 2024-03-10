SELECT proid, proname FROM tblProducts
	RIGHT JOIN tblSuppliers ON tblProducts.supcode = tblSuppliers.supcode
	WHERE tblSuppliers.supcode = 'MT'