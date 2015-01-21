package com.charles.notepad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


public class Settings extends Activity {

    private interface Keys
    {
        public String text = "text";
    }

    public static void showSettings(Activity sender, String currentText)
    {
        Intent intent = new Intent(sender, Settings.class);
        intent.putExtra(Keys.text, currentText);

        sender.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        findViewById(R.id.settings_button).setOnClickListener(new MyButtonClickListener());

        Intent intent = getIntent();
        String currentText = intent.getStringExtra(Keys.text);

        Log.i("Settings", currentText);
    }


    private class MyButtonClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View view) {
            Toast.makeText(Settings.this, "I clicked a button", Toast.LENGTH_SHORT).show();
        }
    }
}
