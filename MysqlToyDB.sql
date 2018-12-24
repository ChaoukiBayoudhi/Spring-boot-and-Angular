--GRANT ALL PRIVILEGES ON *.* TO 'user12'@'localhost' IDENTIFIED BY 's$cret'; -- after connect with root (sudo mysql -u root)

CREATE DATABASE ToyStoreDB;
USE ToyStoreDB;
DROP TABLE IF EXISTS Toy;
CREATE TABLE Toy(code INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), type VARCHAR(100),
miAge INT, maxAge INT, price float);

INSERT INTO Toy(name,type,miAge,maxAge,price)  VALUES("Car Toy", "Electronic", 3, 9, 15);
INSERT INTO Toy(name,type,miAge,maxAge,price)  VALUES("Doll Toy", "other", 3, 9, 20);
INSERT INTO Toy(name,type,miAge,maxAge,price)  VALUES("Moto", "Electronic", 3, 9, 20);
INSERT INTO Toy(name,type,miAge,maxAge,price)  VALUES("Chess", "Brain", 7, 17, 25);
INSERT INTO Toy(name,type,miAge,maxAge,price)  VALUES("Ball", "Sport", 7, 17, 25);
INSERT INTO Toy(name,type,miAge,maxAge,price)  VALUES("Guitar", "Electronic", 7, 17, 25);
INSERT INTO Toy(name,type,miAge,maxAge,price)  VALUES("Plane", "Electronic", 7, 17, 25);

