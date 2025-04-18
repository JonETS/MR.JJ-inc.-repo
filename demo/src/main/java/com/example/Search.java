package com.example;

import java.util.Arrays;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale.Category;
/**
 * Search.java
 * 4/17/25
 * @author John Soriano
 * Filters out products based on user's search input. Able to filter by name or by category.
 * Creates a list of products to be displayed. 
 */
public class Search {
    //attributes
    private ArrayList<String> productCategories = new ArrayList<>(); //list of all categories
    private ArrayList<ArrayList> productListCategories = new ArrayList<>(); //list of lists of products in a category
    private ArrayList<Product> productList = new ArrayList<>(); //list of all products
/**
 * Takes user's input from searchbar and searches for Products. Returns an ArrayList of Products to be displayed.
 * @param User_Searched
 * @return ProductsToBeDisplayed
 */
public ArrayList StartSearch(String User_Searched){
    //base case ("   ")
    if(User_Searched.isBlank() == true){
        return productList; //returns whole list, unfiltered
    }

    //otherwise
    ArrayList<String> SearchFor = ConvertUserSearch(User_Searched);
    ArrayList<Product> ProductsMatched = SearchByName(SearchFor);
    Int[] ProductsScore = ScoreSearchByName(ProductsMatched, SearchFor);
    ArrayList<Product> ProductsToBeDisplayed = RankedSearchByName(ProductsMatched, ProductsScore);
    return ProductsToBeDisplayed;
}
/**
 * Splits User_Searched and puts it into an ArrayList, SearchFor.
 * @param User_Searched
 * @return SearchFor
 */
private ArrayList ConvertUserSearch(String User_Searched){
    String[] Search_Array = User_Searched.split("\\s+");// "\\s+" - split by whitespace
    ArrayList<String> SearchFor = new ArrayList(Arrays.asList(Search_Array));
    return SearchFor;
}
/**
 * Checks if the Product's name contains any of the searched words. Returns a list of products with matches found.
 * @param SearchFor
 * @return ProductsMatched
 */
private ArrayList SearchByName(ArrayList<String> SearchFor){
    ArrayList<Product> ProductsMatched = new ArrayList<>();
    for(int i=0; i<productList.size(); i++){//current product
        for(int j=0; j<SearchFor.size(); j++){//current searched word
            if(productList.get(i).getProductName().contains(SearchFor.get(j))){//match found
                ProductsMatched.add(productList.get(i));
                break; //move onto next product
            }
        }
    }
    return ProductsMatched;
}
/**
 * Checks the list of products with matches and how many of the searched words are found in the Product's name. Here, a Product will have a minium score of 1. Returns an array of # of matches found per Product.
 * @param ProductsMatched
 * @param SearchFor
 * @return ProductsScore
 */
private Int[] ScoreSearchByName(ArrayList<Product> ProductsMatched, ArrayList<String> SearchFor){
    Int[] ProductsScore = new Int[ProductsMatched.size()];
    for(int i=0; i<ProductsMatched.size(); i++){//current product
        for(int j=0; j<SearchFor.size(); j++){//current searched word
            if(ProductsMatched.get(i).getProductName().contains(SearchFor.get(j))){//match found
                ProductsScore[i]++;
            }
        }
    }
    return ProductsScore;
}
/**
 *Arranges the Products with matches by # of matches and puts it into a ArrayList. The first Product in the ArrayList has the most matches. Returns an ArrayList with the Products ranked in order.
 * @param ProductsMatched
 * @param ProductsScore
 * @return ProductsRanked
 */
private ArrayList RankedSearchByName(ArrayList<Product> ProductsMatched, Int[] ProductsScore){
    ArrayList<Product> ProductsRanked = new ArrayList<>();
    for(int i=0; i<ProductsMatched.size(); i++){//current product
        if(ProductsRanked.isEmpty()){//first product
            ProductsRanked.add(ProductsMatched.get(i));
        }
        else{
            for(int j=0; j<ProductsRanked.size(); j++){//previous products
                if(ProductsScore[i]>ProductsScore[j]){//new product has higher rank
                    ProductsRanked.add(j, ProductsMatched.get(i));//shifts products right and inserts new product
                }
            }
            if(ProductsRanked.contains(ProductsMatched.get(i))==false){//new product is last
                ProductsRanked.add(ProductsMatched.get(i));
            }
        }
    }
    return ProductsRanked;
}

/**
 * Takes user's input from category tab and searches for Products. Returns an ArrayList of Products to be displayed.
 * @param User_Category
 * @return CategoryList
 */
public ArrayList CategoryRequested(String User_Category){
    int CategoryFound = SearchbyCategory(User_Category);
    ArrayList<Product> CategoryList = productListCategories.get(CategoryFound);
    return CategoryList;
}

/**
 * Determines which category is being requested. Returns an integer, the index of where the category's list will be found.
 * @param User_Category
 * @return CategoryFound
 */
private Int SearchByCategory(String User_Category){
    //determine which category is requested
    for(int i=0 ; i<productCategories.size(); i++){
        if(User_Category == productCategories.get(i)){//category found
            int CategoryFound = i;//get index
            break;
        }
    }
    return CategoryFound;
}

/**
 * Set the list of Products to be used in the Search class.
 * @param list
 */
public void setProductListForSearch(Arraylist<Product> plist){
    productList = plist;
}
/**
 * Set the list of Categories to be used in the Search Class.
 * @param clist
 */
public void setCategoriesForSearch(ArrayList<String> clist){
    productCategories = clist;
}
/**
 * Set the list of lists of products in each category to be used in the Search Class.
 * @param pclist
 */
public setCategoryListForSearch(Arraylist<ArrayList> pclist){
    productListCategories = pclist;
}
}
