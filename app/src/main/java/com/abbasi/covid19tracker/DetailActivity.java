package com.abbasi.covid19tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private int countryPosition;
    TextView tvCountry, tvCases, tvTodayCases, tvCritical, tvActive, tvRecovered, tvDeaths, tvDeathsToday;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        countryPosition = intent.getIntExtra("position",0);

        getSupportActionBar().setTitle("Details of "+AffectedCountries.countryModelList.get(countryPosition).getCountry());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tvCases = findViewById(R.id.tvCases);
        tvCountry = findViewById(R.id.tvCountryName);
        tvTodayCases = findViewById(R.id.tvCasesToday);
        tvCritical = findViewById(R.id.tvCritical);
        tvActive = findViewById(R.id.tvActive);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvDeaths = findViewById(R.id.tvDeaths);
        tvDeathsToday = findViewById(R.id.tvDeathsToday);

        tvCountry.setText(AffectedCountries.countryModelList.get(countryPosition).getCountry());
        tvCases.setText(AffectedCountries.countryModelList.get(countryPosition).getCases());
        tvRecovered.setText(AffectedCountries.countryModelList.get(countryPosition).getRecovered());
        tvTodayCases.setText(AffectedCountries.countryModelList.get(countryPosition).getTodaycases());
        tvDeathsToday.setText(AffectedCountries.countryModelList.get(countryPosition).getTodayDeaths());
        tvDeaths.setText(AffectedCountries.countryModelList.get(countryPosition).getDeaths());
        tvActive.setText(AffectedCountries.countryModelList.get(countryPosition).getActive());
        tvCritical.setText(AffectedCountries.countryModelList.get(countryPosition).getCritical());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
