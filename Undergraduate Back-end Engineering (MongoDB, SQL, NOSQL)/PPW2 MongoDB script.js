"Advanced database design (CET341) PPW 2 (MongoDB)"
"Created by: Samuel William Mason"
"Case study: Resteraunt Service"

"Create customer table"

db.Customer.insert({
    Customer_No: "001",
    Customer_forename: "Sam",
    Customer_surname: "Mason",
    Address: {Street: "5 Tulip court",  Town: "Penshaw", City: "Sunderland", Postcode: "DH47JL"},
    Bank_details: {Bank: "Loyds bank", Card_No: "0101050107", Expiry_date: "01/32"}
});

db.Customer.insert({
    Customer_No: "002",
    Customer_forename: "Eric",
    Customer_surname: "Clapton",
    Address: {Street: "10 Willow road",  Town: "Hastings hill", City: "Sunderland", Postcode: "SU57UM"},
    Bank_details: {Bank: "Santander", Card_No: "0101010102", Expiry_date: "03/27"}
});

db.Customer.insert({
    Customer_No: "003",
    Customer_forename: "Jimi",
    Customer_surname: "Hendrix",
    Address: {Street: "1 Edinburgh street",  Town: "Ousburn", City: "Newcastle", Postcode: "NU91JK"},
    Bank_details: {Bank: "Santander", Card_No: "0101010103", Expiry_date: "06/29"}
});

db.Customer.insert({
    Customer_No: "004",
    Customer_forename: "Graham",
    Customer_surname: "Coxon",
    Address: {Street: "1 Picadilly lane",  Town: "City centre", City: "Newcastle", Postcode: "NU11OP"},
    Bank_details: {Bank: "TSB", Card_No: "0101010104", Expiry_date: "01/29"}
});

db.Customer.insert({
    Customer_No: "005",
    Customer_forename: "Bernard",
    Customer_surname: "Butler",
    Address: {Street: "4 'Buttsfield crescent",  Town: "Penshaw", City: "Sunderland", Postcode: "DH48JT"},
    Bank_details: {Bank: "Loyds bank", Card_No: "0101050107", Expiry_date: "01/32"}
});

"Create resteraunt table"

db.Resteraunt.insert({
    Resteraunt_No: "001",
    Resteraunt_name: "Merrils",
    Cuisine: "Fish and chips",
    Health_checked: "Yes",
    Address: {Street: "1 Book court", Town: "Whitburn", City: "Sunderland", Postcode: "SU47LM"},
    Annual_revenue: "10000"
});

db.Resteraunt.insert({
    Resteraunt_No: "002",
    Resteraunt_name: "Luciano",
    Cuisine: "Italian",
    Health_checked: "Yes",
    Address: {Street: "27 Lavender road", Town: "City centre", City: "Sunderland", Postcode: "SU47FF"},
    Annual_revenue: "30000"
});

db.Resteraunt.insert({
    Resteraunt_No: "003",
    Resteraunt_name: "Akbar",
    Cuisine: "Indian",
    Health_checked: "Yes",
    Address: {Street: "27 Tulip lane", Town: "City centre", City: "Newcastle", Postcode: "NU27FF"},
    Annual_revenue: "38000"
});

"Create resteraunt staff table"

db.Resteraunt_staff.insert({
    Staff_No: "001",
    Place_of_work: {Resteraunt_Id: "001", Resteraunt_name: "Merills"},
    Staff_title: "Chef",
    Staff_forename: "Darren",
    Staff_surname: "Brown",
    Address: {Street: "20 Northumberland road", Town: "City centre", City: "Newcastle", Postcode: "NU09FI"},
    Annual_salary: "30000"
});

db.Resteraunt_staff.insert({
    Staff_No: "002",
    Place_of_work: {Resteraunt_Id: "001", Resteraunt_name: "Merills"},
    Staff_title: "Assistant chef",
    Staff_forename: "Abbie",
    Staff_surname: "Brown",
    Address: {Street: "20 Northumberland road", Town: "City centre", City: "Newcastle", Postcode: "NU09FI"},
    Annual_salary: "30000"
});

db.Resteraunt_staff.insert({
    Staff_No: "003",
    Place_of_work: {Resteraunt_Id: "002", Resteraunt_name: "Luciano"},
    Staff_title: "Chef",
    Staff_forename: "Chris",
    Staff_surname: "Gary",
    Address: {Street: "2 Panns road", Town: "Byker", City: "Newcastle", Postcode: "NU56WW"},
    Annual_salary: "40000"
});
   
db.Resteraunt_staff.insert({
    Staff_No: "004",
    Place_of_work: {Resteraunt_Id: "002", Resteraunt_name: "Luciano"},
    Staff_title: "Assistant chef",
    Staff_forename: "Matt",
    Staff_surname: "Bunson",
    Address: {Street: "20 Circus road", Town: "Heaton", City: "Newcastle", Postcode: "NU32BH"},
    Annual_salary: "37500"
});

db.Resteraunt_staff.insert({
    Staff_No: "005",
    Place_of_work: {Resteraunt_Id: "003", Resteraunt_name: "Akbar"},
    Staff_title: "Chef",
    Staff_forename: "Sophie",
    Staff_surname: "Windslow",
    Address: {Street: "2 Penshaw road", Town: "Houghton-le-spring", City: "Sunderland", Postcode: "DH56WW"},
    Annual_salary: "45000"
});

db.Resteraunt_staff.insert({
    Staff_No: "006",
    Place_of_work: {Resteraunt_Id: "003", Resteraunt_name: "Akbar"},
    Staff_title: "Assistant chef",
    Staff_forename: "Matt",
    Staff_surname: "Doodle",
    Address: {Street: "20 Circus avenue", Town: "Heaton", City: "Newcastle", Postcode: "NU89RH"},
    Annual_salary: "37500"
});

"Create food table"

db.Food.insert({
    Food_No: "001",
    Resteraunt: {Resteraunt_Id: "001", Resteraunt_name: "Merills"},
    Food_name: "A portion of fish and chips",
    Food_cost: "10.00"
});

db.Food.insert({
    Food_No: "002",
    Resteraunt: {Resteraunt_Id: "001", Resteraunt_name: "Merills"},
    Food_name: "A portion of chips",
    Food_cost: "5.00"
});

db.Food.insert({
    Food_No: "003",
    Resteraunt: {Resteraunt_Id: "002", Resteraunt_name: "Luciano"},
    Food_name: "Pasta carbonara",
    Food_cost: "12.00"
});

db.Food.insert({
    Food_No: "004",
    Resteraunt: {Resteraunt_Id: "002", Resteraunt_name: "Luciano"},
    Food_name: "Mushroom risotto",
    Food_cost: "12.00"
});

db.Food.insert({
    Food_No: "005",
    Resteraunt: {Resteraunt_Id: "003", Resteraunt_name: "Akbar"},
    Food_name: "Curry and rice",
    Food_cost: "18.00"
});

db.Food.insert({
    Food_No: "006",
    Resteraunt: {Resteraunt_Id: "003", Resteraunt_name: "Akbar"},
    Food_name: "Popodoms",
    Food_cost: "8.00"
});

"Create order table"

db.Order.insert({
    Order_No: "001",
    Resteraunt: {Resteraunt_Id: "001", Resteraunt_name: "Merills"},
    Customer: {Customer_Id: "001", Customer_name: "Sam"},
    Order_information: {Food_Id: "001", Food_name: "A portion of fish and chips"},
     Expected_waiting_time: "10",
     Expected_delivery_time: ISODate("2016-05-18T16:00:00Z")
});
    
db.Order.insert({
    Order_No: "002",
    Resteraunt: {Resteraunt_Id: "001", Resteraunt_name: "Merills"},
    Customer: {Customer_Id: "002", Customer_name: "Eric"},
    Order_information: {Food_Id: "002", Food_name: "A portion of chips"},
     Expected_waiting_time: "5",
     Expected_delivery_time: ISODate("2016-05-18T16:00:00Z")
});

db.Order.insert({
    Order_No: "003",
    Resteraunt: {Resteraunt_Id: "002", Resteraunt_name: "Luciano"},
    Customer: {Customer_Id: "003", Customer_name: "Jimi"},
    Order_information: {Food_Id: "003", Food_name: "Pasta carbonara"},
     Expected_waiting_time: "15",
     Expected_delivery_time: ISODate("2016-05-18T16:00:00Z")
});

db.Order.insert({
    Order_No: "004",
    Resteraunt: {Resteraunt_Id: "002", Resteraunt_name: "Luciano"},
    Customer: {Customer_Id: "004", Customer_name: "Graham"},
    Order_information: {Food_Id: "004", Food_name: "Mushroom risotto"},
     Expected_waiting_time: "15",
     Expected_delivery_time: ISODate("2016-05-18T16:00:00Z")
});

db.Order.insert({
    Order_No: "005",
    Resteraunt: {Resteraunt_Id: "001", Resteraunt_name: "Merills"},
    Customer: {Customer_Id: "005", Customer_name: "Bernard"},
    Order_information: {Food_Id: "001", Food_name: "A portion of fish and chips"},
     Expected_waiting_time: "10",
     Expected_delivery_time: ISODate("2016-05-18T16:00:00Z")
});
