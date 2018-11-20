package net.ozaydin.serkan.easy_csv_creator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

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
        headerList.add("Name.Surname.Age.Adress.Location.Education-");


        List<String> dataList = new ArrayList<>();
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");
        dataList.add("Serkan.Ozaydin.23.Fatih.Turkey.University-");


        easyCsv.setSeparatorColumn(".");
        easyCsv.setSeperatorLine("-");

        String fileName="EasyCsv";

        easyCsv.createCsvFile(fileName, headerList, dataList, WRITE_PERMISSON_REQUEST_CODE, new FileCallback() {
            @Override
            public void onSuccess(File file) {
                Toast.makeText(MainActivity.this,"Saved file",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFail(String err) {
                Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();

            }
        });

    }
}
