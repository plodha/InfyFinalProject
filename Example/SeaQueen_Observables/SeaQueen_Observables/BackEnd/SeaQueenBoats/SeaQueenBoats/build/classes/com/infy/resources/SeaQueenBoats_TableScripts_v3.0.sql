-- sqlplus ER705152/infy@10.123.79.58/georli03

drop sequence booking_txn_sequence_pk;
create sequence booking_txn_sequence_pk start with 6660 increment by 1;

drop sequence users_sequence_pk;
create sequence users_sequence_pk start with 1000 increment by 1;

drop sequence boats_sequence_pk;
create sequence boats_sequence_pk start with 6000 increment by 1;

drop table Boat_Details cascade constraints;
CREATE TABLE Boat_Details(
    boatId VARCHAR2(10) NOT NULL,
    boatType VARCHAR2(50) NOT NULL,
    location VARCHAR2(50) NOT NULL,
    description VARCHAR2(500),
    basePrice NUMBER NOT NULL,
    allowedDays NUMBER,
    discount NUMBER,
    bookingStart DATE,
    CONSTRAINT pk_Boat_Details_tId PRIMARY KEY(boatId),
	CONSTRAINT chk_Boat_Details_type CHECK (boatType IN ('Houseboat','Cruiser','Bass Boat','Speed Boat','Power Catamaran')));
	
	
INSERT INTO Boat_Details VALUES ('1001','Houseboat','Alappuzha','These boats offer the luxury of living on water and provide excellent recreational and holiday accommodation facilities.',6666,1,0.05,SYSDATE+6);
INSERT INTO Boat_Details VALUES ('1002','Cruiser','Alappuzha','These boats are apt for relaxed sailing and include a galley and a berth. All modern comforts like heaters, air conditioners, and power generators are enclosed in the arrangement.',66666,5,null,SYSDATE+6);
INSERT INTO Boat_Details VALUES ('1003','Bass Boat','Kumarkom','Bass boats are generally 14 to 23 feet, and typically used for freshwater fishing.',999,5,0.05,SYSDATE+10);
INSERT INTO Boat_Details VALUES ('1004','Cruiser','Kumarkom','These boats are apt for relaxed sailing and include a galley and a berth. All modern comforts like heaters, air conditioners, and power generators are enclosed in the arrangement.',66666,5,0.10,SYSDATE+9);
INSERT INTO Boat_Details VALUES ('1005','Speed Boat','Srinagar','Performance powerboats, built for speed.',10000,null,0.05,SYSDATE+3);
INSERT INTO Boat_Details VALUES ('1006','Houseboat','Srinagar','These boats offer the luxury of living on water and provide excellent recreational and holiday accommodation facilities.',999,3,0.0667,SYSDATE+1);
INSERT INTO Boat_Details VALUES ('1007','Power Catamaran','Srinagar','The power or sailing style catamarans comprise of multiple hulls and are excellent for fishing purposes and even for leisurely cruising abilities.',999,6,null,SYSDATE+5);
	


drop table Ginger_King_Users cascade constraints;
CREATE TABLE Ginger_King_Users(
	userId VARCHAR2(10) NOT NULL,
	password VARCHAR2(50) NOT NULL,
	userName VARCHAR2(50) NOT NULL,
	userType VARCHAR2(50) NOT NULL,
	email VARCHAR2(50) NOT NULL,
	mobileNo VARCHAR2(10) NOT NULL,
	userStatus VARCHAR2(10) DEFAULT 'Active' NOT NULL,
	CONSTRAINT pk_User_tId PRIMARY KEY(userId),
	CONSTRAINT chk_User_Type CHECK (userType IN ('Admin','User')),
	CONSTRAINT chk_User_Status CHECK (userStatus IN ('Active','De-Active')));
		

	
drop table Boat_Booking_Details cascade constraints;
CREATE TABLE Boat_Booking_Details(
	txnId VARCHAR2(10) NOT NULL,
	boatId VARCHAR2(10) NOT NULL,
	userId VARCHAR2(10) NOT NULL,
	startDate DATE,
	endDate DATE,
	totalCost NUMBER,
	mobileNo VARCHAR2(10),
	discount NUMBER,
	CONSTRAINT pk_Boat_Txn_Details_tId PRIMARY KEY(txnId),
	CONSTRAINT fk_Boat_Txn_Details_1 FOREIGN KEY(boatId) REFERENCES Boat_Details(boatId),
	CONSTRAINT fk_Boat_Txn_Details_2 FOREIGN KEY(userId) REFERENCES Ginger_King_Users(userId));
	



INSERT INTO Ginger_King_Users VALUES ('2001','Angad@123','Angad Singh Bindra','Admin','angad.bindra@infosys.com','9900787845','Active');
INSERT INTO Ginger_King_Users VALUES ('2002','Punya@123','Punyapriya Pradhan','Admin','punyapriya.pradhan@infosys.com','8899112233','Active');
INSERT INTO Ginger_King_Users VALUES ('2003','Abhi@123','Abhishek Sadanand','User','abhishek.c25@infosys.com','7788991234','Active');
INSERT INTO Ginger_King_Users VALUES ('2004','Sum@123','Sumeet Kumar Barua','User','sumeet_kumar08@infosys.com','9945451230','Active');
INSERT INTO Ginger_King_Users VALUES ('2005','Shakti@123','Shakti Lenka','User','shakti.lenka@infosys.com','9898457612','Active');
INSERT INTO Ginger_King_Users VALUES ('2006','Sunil@123','Sunil Das','User','sunil.das01@infosys.com','7788678901','Active');
INSERT INTO Ginger_King_Users VALUES ('2007','Deepa@123','Deepa Singh','User','deepa01@infosys.com','9876123400','Active');
INSERT INTO Ginger_King_Users VALUES ('2008','Aahil@123','Aahil Khan','User','aahil.khan01@infosys.com','8989006745','Active');

INSERT INTO Boat_Booking_Details VALUES ('5001','1005','2003','05-MAR-2017','09-MAR-2017',3996,7788991234,null);
INSERT INTO Boat_Booking_Details VALUES ('5002','1002','2004','06-MAR-2017','08-MAR-2017',1998,9945451230,0.05);
INSERT INTO Boat_Booking_Details VALUES ('5003','1005','2005','09-MAR-2017','10-MAR-2017',999,9898457612,0.10);
INSERT INTO Boat_Booking_Details VALUES ('5004','1006','2006','12-MAY-2017','16-MAY-2017',3996,7788678901,0.10);
INSERT INTO Boat_Booking_Details VALUES ('5005','1003','2007','10-MAY-2017','13-MAY-2017',2997,9087147820,null);
INSERT INTO Boat_Booking_Details VALUES ('5006','1001','2008','05-JUN-2017','06-JUN-2017',1199,9933123089,0.10);
INSERT INTO Boat_Booking_Details VALUES ('5007','1007','2001','05-SEP-2017','06-SEP-2017',699,7760981423,null);
INSERT INTO Boat_Booking_Details VALUES ('5008','1004','2002','08-SEP-2016','10-SEP-2017',2398,7788993322,0.10);

select * from Boat_Details;
select * from Ginger_King_Users;
select * from Boat_Booking_Details;

commit;