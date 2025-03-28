package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Search {
    //attributes
    private static String[] Categories;
    private static List<String> productNames = new ArrayList<>();//index are IDs
    //methods
    private static void SearchByName(String name){
        //empty search
        if (name == ""){
            return; //have it load search without any filters
        }
        //prep user's search
        name = name.toLowerCase();//contains is case-sensitive
        String[] UserSearch = name.split(" ");
        List<String> UserSearchList = Arrays.asList(UserSearch);

        //filter by user's search
        List<Integer> MatchProductID = new ArrayList<>();//id of product
        List<Integer> MatchProductHits = new ArrayList<>();//# of matches for a product
        int CurrentProductID=0;
        while(CurrentProductID < productNames.size()){
            int CurrentUserSearch=0;
            boolean InsertedID = false;
            int hits = 0;
            while(CurrentUserSearch < UserSearchList.size()){
                if(productNames.get(CurrentProductID).contains(UserSearchList.get(CurrentUserSearch))){//match found
                    if(InsertedID==false){
                        MatchProductID.add(CurrentProductID);//only add product id once
                        InsertedID = true;
                    }
                    hits++;
                }
                CurrentUserSearch++;
            }
            if(hits != 0 && InsertedID == true){//redundancy
                MatchProductHits.add(hits);
            }//index of lists has product's id and # of matches
            CurrentProductID++;
        }

        // no matches found
        if(MatchProductID.isEmpty()){
            return;
        }

        //combine id and matches
        int TotalMatchedProducts = MatchProductID.size();
        Integer[][] ProductsToBeRanked = new Integer[TotalMatchedProducts][2]; // id,hits
        int CurrentMatchProduct = 0;
        while(CurrentMatchProduct < TotalMatchedProducts){
            ProductsToBeRanked[CurrentMatchProduct][0]= MatchProductID.get(CurrentMatchProduct);
            ProductsToBeRanked[CurrentMatchProduct][1]= MatchProductHits.get(CurrentMatchProduct);
            CurrentMatchProduct++;
        }//product id and matches combined

        //rank ids by matches
        for(int j=1; j<TotalMatchedProducts; j++){
            int tmpHits = ProductsToBeRanked[j][1];
            int tmpID = ProductsToBeRanked[j][0];
            int i = j-1;
            while(i>=0 && ProductsToBeRanked[i][1]>tmpHits){//matches of i is greater than j's
                ProductsToBeRanked[i+1][0] = ProductsToBeRanked[i][0];
                ProductsToBeRanked[i+1][1] = ProductsToBeRanked[i][1];
                i--;
            }
            ProductsToBeRanked[i+1][1] = tmpHits;
            ProductsToBeRanked[i+1][0] = tmpID;
        }

        //Make List for IDs to be returned
        List<Integer> RankedIDList = new ArrayList<>();
        int RankCounter = TotalMatchedProducts-1;//0 to n-1 = n elements
        while(RankCounter >= 0){
            RankedIDList.add(ProductsToBeRanked[RankCounter][0]);
            RankCounter--;
        }//IDs listed, 0=most
    }
    private static void SearchByCategory(String category){//used by all category buttons, this could be done before hand and just pass pre-categorized results
        int TotalCategories = Categories.length;
        int i = 0;
        String CategorySearched = "";
        while(i < TotalCategories){//find which category it is
            if(category == Categories[i]){
                CategorySearched = Categories[i];
                break;
            }
        }
        //call ProductsCategorized and return the list of the CategorySearched
            //What ProductsCategorized does: During assembly of products, check their tags and add their ids to the category lists of those tags
    }

}
