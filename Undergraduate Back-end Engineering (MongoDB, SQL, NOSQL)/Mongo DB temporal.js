db.Order.aggregate([
{$project: {
    _id: "$Order_No",
    Order_No:"$Order_No",
    dayOfMonth: {$dayOfMonth: "$Expected_delivery_time"}
}}]);