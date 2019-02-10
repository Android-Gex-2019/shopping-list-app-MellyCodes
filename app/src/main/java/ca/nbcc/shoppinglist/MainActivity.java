/**
 * @file MainActivity.java
 * @author Melanie Roy-Plommer
 * @version 1.0
 * @section DESCRIPTION
 * <  >
 * @section LICENSE
 * Copyright 2018 - 2019
 * Permission to use, copy, modify, and/or distribute this software for
 * any purpose with or without fee is hereby granted, provided that the
 * above copyright notice and this permission notice appear in all copies.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 * @section Academic Integrity
 * I certify that this work is solely my own and complies with
 * NBCC Academic Integrity Policy (policy 1111)
 */

package ca.nbcc.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Iterator;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final int TEXT_REQUEST = 1;
    private ShoppingList shoppingList = new ShoppingList();
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "Main Activity: on create");

        if (savedInstanceState != null) {
            Log.d(LOG_TAG, "SAVED INSTANCE");
            shoppingList = (ShoppingList) savedInstanceState.getSerializable("shoppingList");
        } else {
            Log.d(LOG_TAG, "NO SAVED INSTANCE");
        }

        showShoppingList();
    }

    public void launchItemsActivity(View view) {
//        Log.d(LOG_TAG, "Main Activity: launchItemsActivity");
        Intent intent = new Intent(this, ItemsActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);

    }

    private void showShoppingList() {
        Log.d(LOG_TAG, "Main Activity: showShoppingList");

        //clear fields
        for (int i = 1; i <= 10; i++) {
            String field = "textViewItem" + i;
            TextView tmpItem = (TextView) findViewById(getResources().getIdentifier(field, "id", getPackageName()));

            if (tmpItem != null) {
                tmpItem.setVisibility(View.INVISIBLE);
                tmpItem.setText("");
            }
        }

        //Iterator with shoppingList map
        Iterator<Map.Entry<String, Integer>> iter = shoppingList.getAllItems().entrySet().iterator();


        int i = 1;

        while (iter.hasNext()) {
            Map.Entry<String, Integer> item = iter.next();
            String field = "textViewItem" + i;
            TextView tmpItem = (TextView) findViewById(getResources().getIdentifier(field, "id", getPackageName()));

            if (tmpItem != null) {
                tmpItem.setVisibility(View.VISIBLE);
                tmpItem.setText(item.getKey() + " -- " + item.getValue());
            }
            i++;
        }

    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "Main Activity: onResume");

        showShoppingList();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(LOG_TAG, "Main Activity: onRestoreInstanceState");

        // get the list back from the Bundle(outState) saved in the onSavedInstanceState method
        if (savedInstanceState != null) {
            shoppingList = (ShoppingList) savedInstanceState.getSerializable("shoppingList");

        }

        showShoppingList();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(LOG_TAG, "Main Activity: onActivityResult");

        if (requestCode == TEXT_REQUEST) {

            if (resultCode == RESULT_OK) {
                String item = data.getStringExtra(ItemsActivity.EXTRA_REPLY);

                shoppingList.addItem(item);

            }
        }
        showShoppingList();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(LOG_TAG, "Main Activity: onSaveInstanceState");

        // put the shoppingList into the saved state when changing layouts
        outState.putSerializable("shoppingList", shoppingList);
    }
}
