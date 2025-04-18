package com.example;

import java.util.ArrayList;

/*SearchDisplay gets the indicies for the products that need to be displayed. 
SearchController calls this class, SearchController does the checking before calling this class.
Ex. if there are no more products left (ie. first page-> wont call PreviousPage or last page-> wont call NextPage)
(StartDisplay is done when user first requested Search, intial display[ie. first page])
*/
/**
 * SearchDisplay Info
 */
public class SearchDisplay {
    //attributes
    ArrayList<Product> ProductDisplayList = new ArrayList<>();

    //methods
    /**
     * Called upon new user search. Gets the indicies of the first page. Returns set of indicies as ArrayList<integer>.
     * @param ProductsToBeDisplayed
     * @return NewIndexList
     */
    public ArrayList StartDisplay(ArrayList<Product> ProductsToBeDisplayed){//first page
        ArrayList<Integer> NewIndexList = new ArrayList<>();//list of indicies of products being displayed
        ProductDisplayList = ProductsToBeDisplayed;
        //create first page (index: 0-7)
        int count = 0;
        while(ProductDisplayList.get(count) != null && count < 8){
            NewIndexList.add(count);//insert index
            count++;
        }
        return NewIndexList;
    }


    /*NextPage and PreviousPage could be improved if all the pages were calculated at once 
    then simply returning the next requested set instead of calculating if next set exists over and over
    However, this code is reuseable and does the same actions as calculating the pages, 
    by only calculating the next page requested
     */

     /**
      * Calculates the indicies of the next page's set of products to be displayed. Returns the set of indicies as ArrayList<integer>.
      * @param CurrentIndexList
      * @return NewIndexList
      */
    public ArrayList NextPage(ArrayList<Integer> CurrentIndexList){//CurrentIndexList is a size of 8 products, wont do Next if Cur is not a full page & >0 remaining products exist (.ie last page)
        ArrayList<Integer> NewIndexList = new ArrayList<>();
        int CurEndingIndex = CurrentIndexList.get(CurrentIndexList.size()-1);//get index of last product currently displayed
        int NewStartingIndex = CurEndingIndex+1; //always the next one after the last
        if(ProductDisplayList.get(CurEndingIndex+8) != null){//check if there are 8 more products
            //add 8 to every index in Current and return
            int NewEndingIndex = CurEndingIndex+8;
        }
        else{//check how many products remain (1-7)
            int NewEndingIndex = CurEndingIndex+7;
            while(NewEndingIndex != CurEndingIndex+1){//check if product exists
                if(ProductDisplayList.get(NewEndingIndex)!= null){//product found
                    break;
                }
                NewEndingIndex--;
            }
        }//NewEndingIndex found
        //set new indicies
        for(int i=NewStartingIndex; i<NewEndingIndex; i++){
            NewIndexList.add(i);
        }
        return NewIndexList;
    }

    /**
     * Calculates the indicies of the previous page's set of products to be displayed. Returns the set of indicies as ArrayList<integer>.
     * @param CurrentIndexList
     * @return NewIndexList
     */
    public ArrayList PreviousPage(ArrayList<Product> CurrentIndexList){//CurrentIndexList is either full or the last page(varying size), wont do Previous if Cur is first page
        ArrayList<Integer>NewIndexList = new ArrayList();
        int CurStartingIndex = CurrentIndexList.get(0);//starting is always 0
        int NewEndingIndex = CurStartingIndex-1;
        if(CurStartingIndex - 8 > 0){//previous is not the first page
            int NewStartingIndex = CurStartingIndex - 8;
        }
        else{//previous is first page
            int NewStartingIndex = 0;//first page is 0-7
        }//NewStartingIndex found
        for(int i=NewStartingIndex; i<NewEndingIndex; i++){
            NewIndexList.add(i);
        }
        return NewIndexList();
    }

    //POTENTIAL REFACTORING WITH FOR LOOP IN NEXT AND PREVIOUS, have parameters be starting and ending index
}
