package com.example.LibraryProject.payload.message;

public class ErrorMessages {

    private ErrorMessages(){};
    public static final String NOT_FOUND_PUBLISHER = "Error:  Publisher not found with id %s";
    public static final String NOT_FOUND_PUBLISHERNAME = "Error:  Publisher not found";

    public static final String ALREADY_EXIST_AUTHOR = "Error: Author is already exist with name %s";

    public static final String NOT_FOUND_AUTHOR = "Error:  Author is not found with id %s";

    public static final String NOT_FOUND_USER = "Error:  User not found with id %s";

    public static final String NOT_FOUND_LOAN = "Error:  Loan not found with id %s";

    public static final String NOT_FOUND_BOOK = "Error:  Book not found with id %s";

    public static final String NOT_PERMITTED = "You do not have any permission to do this operation";

    public static final String CATEGORY_ALREADY_EXIST = "Error:  Category is already exist with name %s";

    public static final String NOT_FOUND_CATEGORY = "Error:  Category is not found with id %s" ;



}
