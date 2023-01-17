INSERT INTO Angajati Values  ('Adrian','Mihai',1,'2001-10-22','M','5011022345678','071234567')
INSERT INTO Angajati Values  ('Fatu','Cristian',2,'2001-02-03','M','5010203345233','071234124')
INSERT INTO Angajati Values  ('Popescu','Alex',1,'2001-09-01','M','5010901345678','073434567')
INSERT INTO Angajati Values  ('Georgescu','Iulian',3,'2001-11-18','M','5011118233678','072334567')
INSERT INTO Angajati Values  ('Ion','Andra',2,'2001-12-01','F','6011201319678','078734567')
INSERT INTO Angajati Values  ('Bobeica','Gabriela',3,'1998-05-08','F','6980508127878','072394567')
INSERT INTO Angajati Values  ('Cobzariu','Brianna',4,'2002-05-01','M','6020501123678','072434569')
DELETE FROM Angajati

INSERT INTO Hale VALUES (1,10)
INSERT INTO Hale VALUES (2,20)
INSERT INTO Hale VALUES (3,30)
INSERT INTO Hale VALUES (4,40)

SELECT  * FROM Hale

SELECT *FROM Angajati

INSERT INTO [Categorie Marfa] VALUES (1,'Agricole')
INSERT INTO [Categorie Marfa] VALUES (2,'Electrocasnice')
INSERT INTO [Categorie Marfa] VALUES (3,'Fashion')
INSERT INTO [Categorie Marfa] VALUES (4,'Electronice')

SELECT  * FROM [Categorie Marfa]

INSERT INTO Furnizor VALUES ('Samsung','str Floriilor','0765429221')
INSERT INTO Furnizor VALUES ('Lenovo','str Vasii','0723429221')
INSERT INTO Furnizor VALUES ('Avon','str Decebal','0713323221')
INSERT INTO Furnizor VALUES ('Tastino','sat Pleasa nr 5','0725424226')
INSERT INTO Furnizor VALUES ('Arctic','str Latina','0725459671')
INSERT INTO Furnizor VALUES ('Sony','str Independentei','0235627321')

SELECT  * FROM Furnizor
SELECT * FROM Marfa
DELETE FROM Marfa
INSERT INTO Marfa VALUES (1,4,'GALAXY S22','Cel mai bun telefon' , 125 , 20 , '2022-10-23')
INSERT INTO Marfa VALUES (1,4,'ONEPLUS 10T','Cel mai bun telefon ieftin' , 200 , 40 , '2022-09-21')
INSERT INTO Marfa VALUES (4,1,'Paine Integrala','Paine neagra' , 5 , 1000 , '2022-11-30')
INSERT INTO Marfa VALUES (3,3,'Parfum Sauvage','Eau de toilette' , 15 , 100 , '2022-10-25')
INSERT INTO Marfa VALUES (3,3,'Parfum The one','Eau de parfum' , 15 , 50 , '2022-10-25')
INSERT INTO Marfa VALUES (3,3,'Parfum Prada','Eau de toilette' , 15 , 200 , '2022-10-25')
INSERT INTO Marfa VALUES (4,1,'Paine Alba','Paine Alba' , 5 , 1000 , '2022-11-30')
INSERT INTO Marfa VALUES (2,4,'IDEAPAD S340','Notebook 13" ' , 300 , 56 , '2022-08-23')
INSERT INTO Marfa VALUES (2,4,'IDEAPAD 5 pro','Notebook 16" ' , 300 , 20 , '2022-11-26')
INSERT INTO Marfa VALUES (5,2,'Frigider smart','Congelator + Electronica" ' , 500 , 20 , '2022-10-13')
INSERT INTO Marfa VALUES (6,2,'Bravia 200','Diagoanala 102 cm" ' , 300 , 15 , '2022-10-13')

Select * from hale_marfa
DELETE FROM hale_marfa
INSERT INTO hale_marfa VALUES (1,1)

INSERT INTO hale_marfa VALUES (2,2)

INSERT INTO hale_marfa VALUES (3,2)

INSERT INTO hale_marfa VALUES (3,3)

INSERT INTO hale_marfa VALUES (5,3)

INSERT INTO hale_marfa VALUES (2,4)

INSERT INTO hale_marfa VALUES (2,5)
INSERT INTO hale_marfa VALUES (5,6)

INSERT INTO hale_marfa VALUES (5,7)

INSERT INTO hale_marfa VALUES (1,8)

INSERT INTO hale_marfa VALUES (2,9)
INSERT INTO hale_marfa VALUES (1,10)
INSERT INTO hale_marfa VALUES (2,10)
INSERT INTO hale_marfa VALUES (4,11)

