db.Resteraunt_staff.aggregate([

    {
        $lookup:{
            from: "Resteraunt",   
            localField: "Place_of_work.Resteraunt_Id", 
            foreignField: "Resteraunt_No",
            as: "Resteraunt_info"
        }
    },
    {   $unwind:"$Resteraunt_info" }, 
   
    {
        $lookup:{
            from: "Order", 
            localField: "Place_of_work.Resteraunt_Id",
            foreignField: "Resteraunt.Resteraunt_Id",
            as: "Order_info"
        }
    },
    {   $unwind:"$Order_info" },
    
      {
        $lookup:{
            from: "Food", 
            localField: "Place_of_work.Resteraunt_Id",
            foreignField: "Food_No",
            as: "Food_info"
        }
    },
    {   $unwind:"$Food_info" },
    
    {   
        $project:{
            Staff_title : "$Staff_title",
            Staff_forename : "$Staff_forename",
            Staff_surname : "$Staff_surname",
            Resteraunt_Id : "$Resteraunt_info.Resteraunt_No",
            Order_No : "$Order_info.Order_No",
            Food_No : "$Food_info.Food_name"

        } 
    }
]);  
    
    