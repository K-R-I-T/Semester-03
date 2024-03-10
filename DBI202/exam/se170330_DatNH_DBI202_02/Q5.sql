SELECT p.proid, proname FROM tblProducts p
	LEFT JOIN tblInv_Detail d ON p.proid = d.proid
	WHERE P.proid NOT IN (SELECT proid FROM tblInv_Detail)