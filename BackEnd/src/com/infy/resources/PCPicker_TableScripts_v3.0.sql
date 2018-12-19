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
	
	
	
INSERT INTO Boat_Details VALUES ('1001','Houseboat','Alappuzha','These boats offer the luxury of living on water and provide excellent recreational and holiday accommodation facilities.',6666,1,0.05,SYSDATE+6);
INSERT INTO Boat_Details VALUES ('1002','Cruiser','Alappuzha','These boats are apt for relaxed sailing and include a galley and a berth. All modern comforts like heaters, air conditioners, and power generators are enclosed in the arrangement.',66666,5,null,SYSDATE+6);
INSERT INTO Boat_Details VALUES ('1003','Bass Boat','Kumarkom','Bass boats are generally 14 to 23 feet, and typically used for freshwater fishing.',999,5,0.05,SYSDATE+10);
INSERT INTO Boat_Details VALUES ('1004','Cruiser','Kumarkom','These boats are apt for relaxed sailing and include a galley and a berth. All modern comforts like heaters, air conditioners, and power generators are enclosed in the arrangement.',66666,5,0.10,SYSDATE+9);
INSERT INTO Boat_Details VALUES ('1005','Speed Boat','Srinagar','Performance powerboats, built for speed.',10000,null,0.05,SYSDATE+3);
INSERT INTO Boat_Details VALUES ('1006','Houseboat','Srinagar','These boats offer the luxury of living on water and provide excellent recreational and holiday accommodation facilities.',999,3,0.0667,SYSDATE+1);
INSERT INTO Boat_Details VALUES ('1007','Power Catamaran','Srinagar','The power or sailing style catamarans comprise of multiple hulls and are excellent for fishing purposes and even for leisurely cruising abilities.',999,6,null,SYSDATE+5);
	


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
	



INSERT INTO PCUser VALUES ('1001','Jane#Cat','Jane Catfish','jane.cat@infosys.com','8695748321','430');
INSERT INTO PCUser VALUES ('1002','Bale#Don','Bale Donut','bale.don@infosys.com','9584738576','745');
INSERT INTO PCUser VALUES ('1003','Gale#Glo','Gale Glow','gale.gloc25@infosys.com','5860396849','386');
INSERT INTO PCUser VALUES ('1004','Sunj#Pra','Sunjay Pranav','sunj.pra08@infosys.com','2960439628','850');
INSERT INTO PCUser VALUES ('1005','Chri#Pal','Christine Pale','chri.pal@infosys.com','9584766751','510');
INSERT INTO PCUser VALUES ('1006','Dest#Joh','Destiny John','dest.joh@infosys.com','1069228395','500');
INSERT INTO PCUser VALUES ('1007','Hele#Hac','Helen Hack','hele.hac@infosys.com','5504987362','804');
INSERT INTO PCUser VALUES ('1008','Chet#Poo','Chetan Pool','chet.poo@infosys.com','6079382758','669');

INSERT INTO Computer_Purchase_Details VALUES ('1','0','1003','16-APR-2018', 400, 5860396849);
INSERT INTO Computer_Purchase_Details VALUES ('2','1','1004','06-MAR-2018', 350, 2960439628);
INSERT INTO Computer_Purchase_Details VALUES ('3','2','1005','09-MAR-2018', 200, 9584766751);
INSERT INTO Computer_Purchase_Details VALUES ('4','3','1006','12-MAY-2016', 1002, 1069228395);
INSERT INTO Computer_Purchase_Details VALUES ('5','4','1007','10-MAY-2018', 1250, 5504987362);
INSERT INTO Computer_Purchase_Details VALUES ('6','5','1008','05-JUN-2016', 935, 6079382758);
INSERT INTO Computer_Purchase_Details VALUES ('7','6','1001','05-SEP-2016', 653, 8695748321);
INSERT INTO Computer_Purchase_Details VALUES ('8','5','1002','08-SEP-2017', 935, 9584738576);

select * from PC_Details;
select * from PCUser;
select * from Computer_Purchase_Details;
