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
