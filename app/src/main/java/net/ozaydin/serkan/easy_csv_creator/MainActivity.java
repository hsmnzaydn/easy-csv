package net.ozaydin.serkan.easy_csv_creator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import net.ozaydin.serkan.easy_csv.EasyCsv;
import net.ozaydin.serkan.easy_csv.FileCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final int WRITE_PERMISSON_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EasyCsv easyCsv = new EasyCsv(MainActivity.this);

        List<String> headerList = new ArrayList<>();
        headerList.add("Name.Surname.Age-");


        List<String> dataList = new ArrayList<>();
        dataList.add("Serkan.Ozaydin.23-");

        easyCsv.setSeparatorColumn(".");
        easyCsv.setSeperatorLine("-");

        easyCsv.createCsvFile("Easycsv", headerList, dataList, WRITE_PERMISSON_REQUEST_CODE, new FileCallback() {
            @Override
            public void onSuccess(File file) {

            }

            @Override
            public void onFail(String err) {


            }
        });

    }
}
