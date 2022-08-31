-- Advanced database design (CET341) PPW 2 (Oracle)
-- Created by: Samuel William Mason
-- Case study: Resteraunt Service

-- Drop Types and tables
Drop Table Resteraunt_order;
Drop Table Resteraunt_customer;
Drop Table Resteraunt_staff;
Drop Table Food;
Drop Table Resteraunt;

Drop Type Not_waiting_customer_type;
Drop type Waiting_customer_type;
Drop Type Customer_type;
Drop Type Staff_type;
Drop Type Food_type;
Drop Type Resteraunt_type;
Drop Type Card_type;
Drop Type Address_type;

COMMIT;

-- Create Address type
Create Type Address_type AS OBJECT
(
    Door_number Number(4),
    Street_name Varchar2(30),
    Town_name Varchar2(30),
    Postcode Varchar2(10)
);
/

-- Create Card details type
Create Type Card_type AS OBJECT
(
    Card_name Varchar2(15),
    Card_No Number(15),
    Expiry_date VarChar2(10)
);
/
    
-- Create Customer type
Create Type Customer_type AS OBJECT
(
    Customer_No Number(4),
    Customer_forename Varchar2(15),
    Customer_surname Varchar2(15),
    Address Address_type,
    Bank_details Card_type
) NOT FINAL;
/

-- Create customer waiting type
Create type Waiting_customer_type under Customer_type
(
    Currently_waiting Char(1)
);
/

-- Create customer NOT waiting type
Create type Not_waiting_customer_type under Customer_type
(
    Currently_waiting Char(1)
);
/

-- Create resteraunt type
Create type Resteraunt_type AS OBJECT
(
    Resteraunt_No Number(4),
    Resteraunt_name Varchar2(15),
    Cuisine Varchar2(30),
    Health_checked Char(1),
    Address Address_type,
    Annual_revenue Number(5)
);
/

-- Create staff type
Create type Staff_type AS OBJECT
(
    Staff_No Number(4),
    Place_of_work Number(4),
    Staff_title Varchar2(15),
    Staff_forename Varchar2(15),
    Staff_surname Varchar2(15),
    Staff_adderess Address_type,
    Staff_salary Number(8)
);
/

-- Create Food type
Create type Food_type AS OBJECT
(
    Food_No Number(4),
    Resteraunt_Id Number(4),
    Food_name Varchar2(30),
    Food_cost Number(6)
);
/

-- Create Customer table
Create Table Resteraunt_customer OF Customer_type (Customer_No Primary Key);

-- Inserting values into Resteraunt customer
Insert into Resteraunt_customer Values
(Waiting_customer_type(001, 'Sam', 'Mason', Address_type('5', 'Tulip court', 'Sunderland', 'DH47JL'), Card_type('Loyds bank', '0101010101', '01/29'), 'Y'));
Insert into Resteraunt_customer Values
(Waiting_customer_type(002, 'Eric', 'Clapton', Address_type('10', 'Willow road', 'Sunderland', 'DH49JF'), Card_type('Santander', '0101010102', '03/27'), 'Y'));
Insert into Resteraunt_customer Values
(Waiting_customer_type(003, 'Jimi', 'Hendrix', Address_type('1', 'Edinburgh street', 'Newcastle', 'NC49CC'), Card_type('Santander', '0101010103', '06/29'), 'Y'));
Insert into Resteraunt_customer Values
(Waiting_customer_type(004, 'Graham', 'Coxon', Address_type('1', 'Picadilly lane', 'Newcastle', 'NC49MV'), Card_type('TSB', '0101010104', '01/29'), 'Y'));
Insert into Resteraunt_customer Values
(Waiting_customer_type(005, 'Bernard', 'Butler', Address_type('4', 'Buttsfield crescent', 'Sunderland', 'SU34VVV'), Card_type('Loyds bank', '0101050107', '01/32'), 'Y'));

-- Create Resteraunt table
Create Table Resteraunt OF Resteraunt_type (Resteraunt_No Primary Key);

-- Inserting values into resteraunt table
Insert into Resteraunt Values
(001, 'Merrills', 'Fish and chips', 'Y', Address_type('1', 'Book court', 'Sunderland', 'DH47LM'), 10000);
Insert into Resteraunt Values
(002, 'Luciano', 'Italian', 'Y', Address_type('27', 'Lavender road', 'Sunderland', 'DH47FF'), 30000);
Insert into Resteraunt Values
(003, 'Akbar', 'Indian', 'Y', Address_type('27', 'Tulip lane', 'Newcastle', 'NU47FF'), 27500);

 
-- Create staff table   
Create Table Resteraunt_staff OF Staff_type (Staff_No Primary Key, Foreign Key (Place_of_work) References Resteraunt(Resteraunt_No));

--Inserting values into staff table
Insert into Resteraunt_staff Values
(001, 001, 'Chef', 'Darren', 'Brown', Address_type('20', 'Northumberland road', 'Newcastle', 'NC47FF'), 30000);
Insert into Resteraunt_staff Values
(002, 001, 'Assistant chef', 'Abbie', 'Brown', Address_type('20', 'Northumberland road', 'Newcastle', 'NC47FF'), 20000);
Insert into Resteraunt_staff Values
(003, 002, 'Chef', 'Chris', 'Gary', Address_type('2', 'Panns road', 'Newcastle', 'NC47LI'), 50000);
Insert into Resteraunt_staff Values
(004, 002, 'Assistant chef','Matt', 'Bunson', Address_type('20', 'Circus road', 'Newcastle', 'NC47TT'), 25000);
Insert into Resteraunt_staff Values
(005, 003, 'Chef', 'Sophie', 'Windlsow', Address_type('2', 'Penshaw road', 'Newcastle', 'NC47LI'), 57500);
Insert into Resteraunt_staff Values
(006, 003, 'Assistant chef','Matt', 'Doodle', Address_type('20', 'Circus avenue', 'Newcastle', 'NC47RT'), 35000);

-- Create Food table
Create table Food OF Food_type (Food_No Primary key, Foreign key (Resteraunt_Id) References Resteraunt(Resteraunt_No));

-- Inserting values into food table
Insert into Food Values
(001, 001, 'A portion of fish and chips', 10);
Insert into Food Values
(002, 001, 'A portion of chips', 5);
Insert into Food Values
(003, 002, 'Pasta Carbonara', 12);
Insert into Food Values
(004, 002, 'Mushroom Risotto', 12);
Insert into Food Values
(005, 003, 'Curry and Rice', 18);
Insert into Food Values
(006, 003, 'Popadoms', 8);

-- Create order table
Create Table Resteraunt_order
(
    Order_No Number(4) Primary key,
    Resteraunt_Id Number(4),
    Customer_Id Number(4),
    Order_information Number(4),
    Expected_waiting_time Number(5),
    Expected_delivery_time Timestamp,
    Foreign key (Resteraunt_Id) References Resteraunt(Resteraunt_No),
    Foreign key (Customer_Id) References Resteraunt_customer(Customer_No),
    Foreign Key (Order_information) References Food(Food_No)
);
/

-- Inserting values into customer order
Insert into Resteraunt_order Values
(001, 001, 001, 001, 10, '01-apr-2021:12:30:25.'); 
Insert into Resteraunt_order Values
(002, 001, 002, 002, 5, '01-apr-2021:12:30:25.');
Insert into Resteraunt_order Values
(003, 002, 003, 003, 15, '01-apr-2021:12:30:25.');
Insert into Resteraunt_order Values
(004, 002, 004, 004, 15, '01-apr-2021:12:30:25.');
Insert into Resteraunt_order Values
(005, 001, 005, 001, 10, '01-apr-2021:12:30:25.');
    
    
    
    


  
