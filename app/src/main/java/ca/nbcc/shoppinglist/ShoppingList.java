/**
 * @file ShoppingList.java
 * @author Melanie Roy-Plommer
 * @version 1.0
 *
 * @section DESCRIPTION
 * < ShoppingList class. Has methods to add new shopping items and
 * return a Map of all items>
 *
 * @section LICENSE
 * Copyright 2018 - 2019
 * Permission to use, copy, modify, and/or distribute this software for
 * any purpose with or without fee is hereby granted, provided that the
 * above copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 *
 * @section Academic Integrity
 * I certify that this work is solely my own and complies with
 * NBCC Academic Integrity Policy (policy 1111)
 */

package ca.nbcc.shoppinglist;


import android.util.Log;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ShoppingList implements Serializable {

    private static final String LOG_TAG = ShoppingList.class.getSimpleName();
    private Map itemsList = new HashMap();

    // add new items to the shopping list or increment existing items
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

    // Return all items
    public Map<String, Integer> getAllItems(){
        Log.d(LOG_TAG, "ShoppingList: Returning Map of items and count");
        return this.itemsList;
    }


}
