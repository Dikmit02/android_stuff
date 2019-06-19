package com.example.diksh.multilanguage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        String languageToLoad="en";

        switch (item.getItemId()) {
            case R.id.eng:
                languageToLoad = "en";
                break;
            case R.id.hn:
                languageToLoad = "hi";
                break;

            case R.id.te:
                languageToLoad = "te";
                break;

            case R.id.ta:
                languageToLoad = "ta";
                break;

            case R.id.ka:
                languageToLoad = "kan";
                break;

            case R.id.ml:
                languageToLoad = "ml";
                break;

            case R.id.mr:
                languageToLoad = "mr";
                break;

            default:
                break;
        }
}
