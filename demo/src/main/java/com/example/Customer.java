package com.example;

public class Customer{
    //attributes
    private static int customerID;
    private static String Fname;
    private static String Lname;
    private static String cEmail;
    private static String cAddress;
    //methods
    public static int getCustomerID(){
        return customerID;
    }
   /* public static String getName(){
        //return Fname and Lname, may split into getFname, getLname
    }
   */
    public static String getEmail(){
        return cAddress;
    }
}