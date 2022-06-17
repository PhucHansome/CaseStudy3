CREATE DATABASE caseStudyModule3;
USE casestudymodule3;
CREATE TABLE casestudymodule3.`products`(
		 `productId` BIGINT NOT NULL,
		 `nameProduct` VARCHAR(255) NOT NULL,
		 `priceProduct` DOUBLE NOT NULL,
		 `quantityProduct` INT NOT NULL,
		 `typeProduct` VARCHAR(255) NOT NULL,
		 `creatDate` DATETIME NOT NULL,
		 `updateDate` DATETIME NULL DEFAULT NULL,
         `img` LONGTEXT NOT NULL,
		 PRIMARY KEY(productId)
 );
 
 CREATE TABLE casestudymodule3.`user`(
		`userId` BIGINT NOT NULL,
		`username` VARCHAR(255),
		`password` VARCHAR(255),
		`fullName` VARCHAR(255),
		`phone` INT NOT NULL,
		`email` VARCHAR(255),
		`address` VARCHAR(255),
		`roles` VARCHAR(255),
		`createDate` DATETIME NOT NULL,
		`updateDate` DATE,
          `img` LONGTEXT NOT NULL,
		PRIMARY KEY(userId)
 );
 
 
 CREATE TABLE casestudymodule3.`order`(
		`userId`BIGINT NOT NULL,
        `productId` BIGINT NOT NULL,
	    `orderId` BIGINT NOT NULL,
	    `fullname` VARCHAR(255),
	    `mobile` INT NOT NULL,
		`address` VARCHAR(255),
		`creatDate` DATE,
          `img` LONGTEXT NOT NULL,
		PRIMARY KEY(orderId),
        FOREIGN KEY (productId) references `products`(productId),
		FOREIGN KEY (userId) references `user`(userId)
		
 );

 
 
 CREATE TABLE casestudymodule3.`orderItems`(
		`orderItemsId` BIGINT NOT NULL,
		`productId` BIGINT,
        `userId` BIGINT,
		`orderId` BIGINT,
		`productName` VARCHAR(255),
		`price` DOUBLE,
        `total` BIGINT ,
		`quantity` INT,
		`creatDate` DATETIME NOT NULL,
           `img` LONGTEXT NOT NULL,
		PRIMARY KEY (`orderItemsId`),
		FOREIGN KEY (`productId`) references products(`productId`),
		FOREIGN KEY (`orderId`) references `order`(`orderId`),
        FOREIGN KEY(`userId`) references `user`(`userId`),
		CHECK (`price` >= 0 AND `price`	<= 100000000),
		CHECK (`quantity` >= 0)
 );

INSERT INTO caseStudyModule3.`user` VALUES(1653197600,'admin','admin','PhucHandSome','0349108527','phucnguyen@gmail.com','Quang Tri','ADMIN','2022-05-22','2022-05-22',"https://static1.cbrimages.com/wordpress/wp-content/uploads/2022/04/One-Piece-Luffy.jpg");
INSERT INTO caseStudyModule3.products VALUES(1653123762,'IPhone 11',11249000,3,'SmartPhone','2022-05-10',now(),"https://static1.cbrimages.com/wordpress/wp-content/uploads/2022/04/One-Piece-Luffy.jpg");
INSERT INTO caseStudyModule3.products VALUES(1653123895,'IPhone 13 ProMax',30249000,3,'SmartPhone','2022-05-11',now(),"https://static1.cbrimages.com/wordpress/wp-content/uploads/2022/04/One-Piece-Luffy.jpg");
INSERT INTO caseStudyModule3.order VALUES(1653197600,1653123762,1,'PhucHandSome','0349108527','Quang Tri',now(),"https://static1.cbrimages.com/wordpress/wp-content/uploads/2022/04/One-Piece-Luffy.jpg");
INSERT INTO  caseStudyModule3.orderItems VALUES(1653357204,1653123895,1653197600,1,'IPhone 13 ProMax',30249000,60498000,2,now(),"https://static1.cbrimages.com/wordpress/wp-content/uploads/2022/04/One-Piece-Luffy.jpg")
 
--  USE casestudymodule2;
 DELIMITER //
CREATE PROCEDURE `sp_input_product`(
 IN `product_Id` BIGINT ,
 IN `name_Product` VARCHAR(255),
 IN `type_Product` VARCHAR(255),
 IN `price_Product` BIGINT,
 IN `quantity_Product` BIGINT,
 IN `imgs` LONGTEXT,
 OUT `message` VARCHAR(255)
 )
BEGIN 
DECLARE EXIT HANDLER FOR SQLEXCEPTION ROLLBACK;
START TRANSACTION;
	IF(EXISTS(SELECT `productId` FROM `products` WHERE  productId = product_Id)) 
		THEN
			SET message = "Da ton tai id nay";
	ELSEIF(product_Id < 0)
	THEN 
			SET message = "Id khong duoc nho hon 0";
	ELSE
			
	INSERT INTO casestudymodule3.`products`(productId, nameProduct, priceProduct, quantityProduct, typeProduct, creatDate, updateDate) 
	VALUES (product_Id,name_Product, price_Product, quantity_Product, type_Product, now(), now());
			SET message = "them san pham thanh cong";
 END IF;

 END
 //
 DELIMITER ;
 
 DELIMITER //
 
 CREATE PROCEDURE `sp_update_products`(
 IN product_Id BIGINT,
 IN name_Product varchar(255),
 IN price BIGINT,
 IN quantity BIGINT,
 OUT message varchar(255)
 )
 
 BEGIN
	DECLARE count_id BIGINT;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION ROLLBACK;
START TRANSACTION;
	SET count_id = (SELECT COUNT(*) FROM products AS p WHERE p.productId = product_Id);
    
	IF (count_id = 0)
		THEN  
		SET message = 'Unknown id';
	ELSE
		UPDATE products AS p
		SET p.nameProduct = name_Product,
         p.priceProduct = price,
         p.quantityProduct = quantity,
         p.updateDate = now()
        WHERE p.productId = product_Id;
		SET message = "update complete";
	END IF;
END; //
DELIMITER ;	 

DELIMITER //
CREATE PROCEDURE sp_delete_product (
	IN product_Id BIGINT(20)
    ,OUT message VARCHAR(50))
BEGIN
DECLARE EXIT HANDLER FOR SQLEXCEPTION ROLLBACK;
START TRANSACTION;
	IF(EXISTS(SELECT * FROM products WHERE productId = product_Id))
    THEN
		IF(EXISTS(SELECT * FROM `order` WHERE `order`.productId = product_Id)) > 0 OR (EXISTS(SELECT * FROM orderitems WHERE orderitems.productId = product_Id)) > 0
        THEN
            DELETE FROM orderitems
            WHERE orderitems.productId = product_Id;
            DELETE FROM `order`
            WHERE productId = product_Id;
            DELETE FROM products
            WHERE productId = product_Id;
            SET message = "Xoa san pham thanh cong!";
        ELSE
            DELETE FROM products
            WHERE productId = product_Id;
            SET message = "Xoa san pham thanh cong!";
			END IF;
	ELSE
		SET message = "Nguoi dung khong ton tai!";
    END IF;    
 END;
 //
 DELIMITER ;
 
 DELIMITER //
 CREATE PROCEDURE `sp_input_user`(
		IN `user_Id` BIGINT ,
		IN `user_name` VARCHAR(255),
		IN `pass_word` VARCHAR(255),
		IN `full_Name` VARCHAR(255),
		IN `phones` BIGINT,
		IN `emails` VARCHAR(255),
		IN `addresss` VARCHAR(255),
		IN`roless` VARCHAR(255),
        IN `imgs` LONGTEXT,
        OUT message VARCHAR(255)
 )
 BEGIN
 DECLARE EXIT HANDLER FOR SQLEXCEPTION ROLLBACK;
START TRANSACTION;
 IF(EXISTS(SELECT `userId` FROM `user` WHERE  userId = user_Id)) 
		THEN
			SET message = "Da ton tai id nay";
	ELSEIF(user_Id < 0)
	THEN 
			SET message = "Id khong duoc nho hon 0";
	ELSE
			
	INSERT INTO casestudymodule3.`user`(userId,userName,password,fullname,phone,email,address,roles,createDate,updateDate,img) 
	VALUES (user_Id,user_name, pass_word, full_Name, phones, emails, addresss,roless,now(),now(),imgs);
			SET message = "them san pham thanh cong";
 END IF;

 END
 //
 DELIMITER ;

DELIMITER //
 
 CREATE PROCEDURE `sp_update_user`(
 IN `user_Id` BIGINT,
 IN `full_Name` VARCHAR(255),
 IN `phones` VARCHAR(255),
 IN `emails` VARCHAR(255),
 IN `addresss`VARCHAR(255),
 IN `roless` VARCHAR(255),
 OUT message VARCHAR(255)
 )
 
 BEGIN
	DECLARE count_id INT;
DECLARE EXIT HANDLER FOR SQLEXCEPTION ROLLBACK;
START TRANSACTION;
	SET count_id = (SELECT COUNT(*) FROM `user` AS u WHERE u.userId = user_Id);
    
	IF (count_id = 0)
		THEN  
		SET message = 'ID khong ton tai';
	ELSE
		UPDATE `user` AS u
		SET u.fullname = full_Name,
         u.phone = phone,
         u.email = emails,
         u.address = addresss,
         u.roles = roless,
         u.updateDate = now()
        WHERE u.userId = user_Id;
		SET message = "update complete";
	END IF;
END; //
DELIMITER ;	 
