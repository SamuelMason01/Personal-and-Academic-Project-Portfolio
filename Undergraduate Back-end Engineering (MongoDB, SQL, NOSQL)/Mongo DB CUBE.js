db.Order.aggregate( [ 

{ $group : { 
    _id : "$Order_information.Food_Id",
    "Food_name" : {"$first" : "$Order_information.Food_name"},
    "No_of_orders" : {$sum : 1}
    } },

] )