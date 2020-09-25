package com.revature.project2.services;

import com.revature.project2.models.Item;
import com.revature.project2.models.Order;
import com.revature.project2.models.User;

/**
 * A temporary class to hold validation methods to help avoid merge conflicts
 * We can either keep them all here or shred out back into the relevant methods
 * Currently is not connected to the accompanying methods
 */
public class ValidationService {
    public ValidationService instance = new ValidationService();
    private ValidationService() {}
    public ValidationService getInstance(){
        return instance;
    }

    //util validation methods====================
    public boolean isObjectNull(Object o){
        if(o==null){
            return true;
        }
        return false;
    }
    public boolean isIntValid(int x){
        return x > 0; //not using with item.stock
    }
    public boolean isDoubleValid(double x){
        return x >= 0;
    }
    public boolean isStringValid(String str){
        if(str.trim().equals("") || str==null){
            return false;
        }
        return true;
    }

    //user validation==============================
    public boolean isUserValid(User user){
        //only checking nullable values
        if(
                isStringValid(user.getFirstName()) &&
                isStringValid(user.getLastName()) &&
                isStringValid(user.getEmail()) &&
                isStringValid(user.getPassword()) &&
                isStringValid(user.getUsername())
        ){
            return true;
        }
        return false;
    }
    public boolean isUserCompletelyValid(User user){
        //checks ALL user fields to see if they are filled and valid
        if(
                isIntValid(user.getId()) &&
                !isObjectNull(user.getRole()) &&
                isUserValid(user)
        ){
            return true;
        }
        return false;
    }
    //item validation==============================
    public boolean isItemValid(Item item){
        //only checking nullable values
        if(
                isStringValid(item.getName()) &&
                isDoubleValid(item.getPrice()) &&
                item.getStock()>=0
        ){
            return true;
        }
        return false;
    }
    public boolean isItemCompletelyValid(Item item){
        //to see if all the item's fields are... fielded
        if(
                isIntValid(item.getId()) &&
                isStringValid(item.getDescription()) &&
                isStringValid(item.getItemImageUrl()) &&
                isIntValid(item.getGenre()) &&
                isItemValid(item)

        ){
            return true;
        }
        return false;
    }
    //order validation==============================
    public boolean isOrderValid(Order order){
        //only checking nullable values
        //not sure how to correctly check timestamps
        if(
                isIntValid(order.getId()) &&
                isIntValid(order.getItemCount()) &&
                isDoubleValid(order.getPrice()) &&
                !isObjectNull(order.getUser())
        ){
            return true;
        }
        return false;
    }




}
