--2
select ps.SubcategoryID, ps.Category, ps.Name from ProductSubcategory ps
where ps.Category = 'Accessories';
--3
select pi.ProductID, pi.LocationID,pi.Quantity from ProductInventory pi
where pi.LocationID = 7 and pi.Quantity > 250
order by pi.Quantity desc;
--4
select  p.ProductID, p.Name as ProductName, p.Color, p.Cost, p.Price, pi.LocationID, l.Name as LocationName, pi.Shelf, pi.Bin, pi.Quantity
from Product p
left join ProductInventory pi
on p.ProductID = pi.ProductID
left join Location l
on pi.LocationID = l.LocationID
where p.Cost < 400 and p.Color = 'Yellow'
--5
select pm.ModelID, pm.Name as ModelName, Count(distinct pm.Name ) as NumberOfProducts  from ProductModel pm 
join Product p
on p.ModelID = pm.ModelID
where pm.Name like 'Mountain%' or  pm.Name like 'ML Mountain%'
GROUP By pm.ModelID, pm.Name
order by NumberOfProducts desc, pm.Name
--6
SELECT p.ProductID, p.Name, SUM(i.Quantity) as TotalQuantity
FROM ProductInventory i
right join Product p on p.ProductID = i.ProductID
GROUP BY p.ProductID, p.Name
HAVING SUM(i.Quantity) = (
   SELECT MAX(TotalQuantity) 
   FROM (
      SELECT SUM(Quantity) as TotalQuantity
      FROM ProductInventory
      GROUP BY ProductID
) as SubQuery )
--7
select l.LocationID, l.Name as LocationName, p.ProductID, p.Name as ProductName, pi.Quantity 
from Location l
join ProductInventory pi on pi.LocationID = l.LocationID
join Product p on p.ProductID = pi.ProductID
where pi.Quantity = (
Select MAX(Quantity) 
from ProductInventory 
where LocationID = l.LocationID
)
ORDER by l.Name, p.Name asc
--8
DELETE FROM ProductInventory
WHERE LocationID IN (
SELECT LocationID
FROM Location
WHERE Name LIKE '%Tool Crib%'