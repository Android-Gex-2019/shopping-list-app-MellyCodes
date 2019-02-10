/**
 * @file ItemsActivity.java
 * @author Melanie Roy-Plommer
 * @version 1.0
 *
 * @section DESCRIPTION
 * <  >
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

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;



public class ItemsActivity extends AppCompatActivity {

    private static final String LOG_TAG = ItemsActivity.class.getSimpleName();
    public static final String EXTRA_REPLY = "ca.nbcc.shoppinglist.itemsactivity.extra.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "Items Activity: onCreate");

        setContentView(R.layout.activity_items);
    }

    public void addToShoppingList(View view){
        //String item = (String)view.getTag();
        String item = view.getTag().toString();

        //create new Intent for reply to send to main activity
        Intent reply = new Intent();
        reply.putExtra(EXTRA_REPLY, item);
        setResult(RESULT_OK, reply);
        finish();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId()==android.R.id.home){
            Intent intent = NavUtils.getParentActivityIntent(this);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            NavUtils.navigateUpTo(this, intent);
            return true;
        }
        return super.onOptionsItemSelected(item);


    }
}
