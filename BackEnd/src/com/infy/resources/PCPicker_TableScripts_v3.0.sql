-- sqlplus ER705152/infy@10.123.79.58/georli03

drop sequence purchase_txn_sequence_pk;
create sequence purchase_txn_sequence_pk start with 0 increment by 1;

drop sequence users_sequence_pk;
create sequence users_sequence_pk start with 1000 increment by 1;

drop sequence computer_sequence_pk;
create sequence computer_sequence_pk start with 5000 increment by 1;

drop table PC_Details cascade constraints;
CREATE TABLE PC_Details(
    computerId VARCHAR2(10) NOT NULL,
    computerType VARCHAR2(50) NOT NULL,
    computerPrice NUMBER NOT NULL,
    CONSTRAINT pk_PC_Details_tId PRIMARY KEY(computerId),
	
	
	
INSERT INTO PC_Details VALUES ('0','Business','400');
INSERT INTO PC_Details VALUES ('1','Gaming','350');
INSERT INTO PC_Details VALUES ('2','Personal','200');
INSERT INTO PC_Details VALUES ('3','Business','1002');
INSERT INTO PC_Details VALUES ('4','Gaming','1250');
INSERT INTO PC_Details VALUES ('5','Personal','935');
INSERT INTO PC_Details VALUES ('6','Personal','653');
	


drop table PCUser cascade constraints;
CREATE TABLE PCUser(
	userId VARCHAR2(10) NOT NULL,
	password VARCHAR2(50) NOT NULL,
	userName VARCHAR2(50) NOT NULL,
	email VARCHAR2(50) NOT NULL,
	mobileNo VARCHAR2(10) NOT NULL,
	creditScore VARCHAR2(3) NOT NULL,
	CONSTRAINT pk_PCUser_tId PRIMARY KEY(userId),
		

	
drop table Computer_Purchase_Details cascade constraints;
CREATE TABLE Computer_Purchase_Details(
	purchaseId VARCHAR2(10) NOT NULL,
	computerId VARCHAR2(10) NOT NULL,
	userId VARCHAR2(10) NOT NULL,
	purchaseDate DATE,
	totalCost NUMBER,
	mobileNo VARCHAR2(10),
	CONSTRAINT pk_Computer_Txn_Details_tId PRIMARY KEY(purchaseId),
	CONSTRAINT fk_Computer_Txn_Details_1 FOREIGN KEY(computerId) REFERENCES PC_Details(computerId),
	CONSTRAINT fk_Computer_Txn_Details_2 FOREIGN KEY(userId) REFERENCES PCUser(userId));
	



INSERT INTO PCUser VALUES ('1001','Jane#Cat','Jane Catfish','jane.cat@infosys.com','8695748321','230');
INSERT INTO PCUser VALUES ('1002','Bale#Don','Bale Donut','bale.don@infosys.com','9584738576','745');
INSERT INTO PCUser VALUES ('1003','Gale#Glo','Gale Glow','gale.gloc25@infosys.com','5860396849','386');
INSERT INTO PCUser VALUES ('1004','Sunj#Pra','Sunjay Pranav','sunj.pra08@infosys.com','2960439628','850');
INSERT INTO PCUser VALUES ('1005','Chri#Pal','Christine Pale','chri.pal@infosys.com','9584766751','1');
INSERT INTO PCUser VALUES ('1006','Dest#Joh','Destiny John','dest.joh@infosys.com','1069228395','100');
INSERT INTO PCUser VALUES ('1007','Hele#Hac','Helen Hack','hele.hac@infosys.com','5504987362','804');
INSERT INTO PCUser VALUES ('1008','Chet#Poo','Chetan Pool','chet.poo@infosys.com','6079382758','669');

INSERT INTO Boat_Booking_Details VALUES ('5001','1005','2003','05-MAR-2017','09-MAR-2017',3996,7788991234,null);
INSERT INTO Boat_Booking_Details VALUES ('5002','1002','2004','06-MAR-2017','08-MAR-2017',1998,9945451230,0.05);
INSERT INTO Boat_Booking_Details VALUES ('5003','1005','2005','09-MAR-2017','10-MAR-2017',999,9898457612,0.10);
INSERT INTO Boat_Booking_Details VALUES ('5004','1006','2006','12-MAY-2017','16-MAY-2017',3996,7788678901,0.10);
INSERT INTO Boat_Booking_Details VALUES ('5005','1003','2007','10-MAY-2017','13-MAY-2017',2997,9087147820,null);
INSERT INTO Boat_Booking_Details VALUES ('5006','1001','2008','05-JUN-2017','06-JUN-2017',1199,9933123089,0.10);
INSERT INTO Boat_Booking_Details VALUES ('5007','1007','2001','05-SEP-2017','06-SEP-2017',699,7760981423,null);
INSERT INTO Boat_Booking_Details VALUES ('5008','1004','2002','08-SEP-2016','10-SEP-2017',2398,7788993322,0.10);

select * from PC_Details;
select * from PCUser;
select * from Computer_Purchase_Details;
