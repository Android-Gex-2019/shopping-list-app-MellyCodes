package ca.nbcc.shoppinglist;


import android.util.Log;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ShoppingList implements Serializable {

    private static final String LOG_TAG = ShoppingList.class.getSimpleName();
    private Map itemsList = new HashMap();

    public void addItem(String item){
        //itemsList.isEmpty() ||
        if(itemsList.containsKey(item)){
            this.itemsList.replace(item, (int)itemsList.get(item)+1);
            Log.d(LOG_TAG, "one item replaced");
        }
        else{
            this.itemsList.put(item, 1);
            Log.d(LOG_TAG, "one item added");
        }
    }

    public Map<String, Integer> getAllItems(){
        Log.d(LOG_TAG, "ShoppingList: Returning Map of items and count");
        return this.itemsList;
    }

    public void clearItems(){
        Log.d(LOG_TAG, "ShoppingList: clearItems");
        this.itemsList.clear();
    }

}
