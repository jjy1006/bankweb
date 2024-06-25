create table product(
    ProductsName varchar(60) primary key
    , BankName FLOAT DEFAULT 0
    , InterestRate varchar(20) DEFAULT 0
    , Period DATE
    , Fine INT DEFAULT 0
    , maximumLoanAmount INT
    , loanLateFees INT
);

create table Customer(
    ID varchar(20) primary key
    , Password varchar(16) DEFAULT ''
    , RegDate DATE DEFAULT sysdate
    , Name varchar(20)
    , BirthDay date
    , Tel varchar(13)
    ,RRN varchar(14)
    ,CreditScore INT
);

create table Account(
    AccountNumber number(16) primary key
    , OwnerID varchar2(20)
    , TransferPassword number(8) 
    , anAlias varchar2(10)
    , Balance number(10) DEFAULT 0
    , AccountOpeningDATE date DEFAULT sysdate
    ,ProductName varchar2(60)
);

create table Transaction(
    ID number(6) primary KEY
    ,TradeType varchar(10)
    , SenderAccountNumber number(16)
    , ReceiverAccountNumber number(16)
    , TransferAmount number(8) DEFAULT 0
    , TransactionDatetime DATE DEFAULT sysdate
);

CREATE TABLE ADMIN (
    ID varchar(30) NOT NULL PRIMARY KEY,
    Password varchar(60) NOT NULL,
    CreateDate DATE DEFAULT SYSDATE NOT NULL ,
    Name varchar(60)
);

INSERT INTO CUSTOMER(ID , Password , Name , BirthDay , Tel ,RRN ,CreditScore) 
	VALUES('ahn','ahn1234','재권',to_date('2005-01-01','YYYY-MM-DD'),'010-2882-5571','050101-3167417',600);
SELECT * FROM CUSTOMER c ;