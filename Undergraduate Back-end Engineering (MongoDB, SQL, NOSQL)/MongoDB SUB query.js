db.Resteraunt_staff.aggregate( [ 

{ $group : { 
    _id : "$Place_of_work.Resteraunt_Id",
    "Staff_title" : {"$first" : "$Staff_title"},
    "Staff_forename" : {"$first" : "$Staff_forename"},
    "Staff_salary" : {$min : "$Annual_salary"},
    "Resteraunt" : {"$first" : "$Place_of_work.Resteraunt_Id"}
    } },

] )