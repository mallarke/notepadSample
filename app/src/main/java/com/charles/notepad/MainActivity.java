package com.charles.notepad;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


public class MainActivity extends Activity {

    private static final String SHARED_PREFERENCES_KEY = "notepad_key";
    private static final String SAVE_KEY = "save_key";

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // this actually creates and sets the view to show
        setContentView(R.layout.activity_main);

        // get a ptr to the edit text we defined in activity_main
        editText = (EditText) findViewById(R.id.notepad);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // create our menu in the action bar
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle button clicks
        switch (item.getItemId()) {
            // you clicked settings
            case R.id.action_settings:
                showSettings();
                return true;

            // you clicked save
            case R.id.action_save:
                save();
                return true;

            // you clicked restore
            case R.id.action_restore:
                restore();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showSettings()
    {
        Settings.showSettings(this, getText());
    }

    private void save()
    {
        SharedPreferences.Editor editor = getSharedPrefs().edit();
        editor.putString(SAVE_KEY, getText());
        editor.apply();
    }

    private void restore()
    {
        editText.setText(getSharedPrefs().getString(SAVE_KEY, ""));
    }

    private SharedPreferences getSharedPrefs()
    {
        return getSharedPreferences(SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE);
    }

    private String getText()
    {
        return editText.getText().toString();
    }
}
