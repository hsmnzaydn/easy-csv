package net.ozaydin.serkan.easy_csv;

import android.Manifest;
import android.app.Activity;
import android.os.Environment;

import net.ozaydin.serkan.easy_csv.Utility.PermissionUtility;
import net.ozaydin.serkan.easy_csv.Utility.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class EasyCsv {
    private Activity activity;
    private File file;
    private OutputStream outputStream;

    private String separatorColumn=",";
    private String seperatorLine="\r\n";


    public EasyCsv(Activity activity) {
        this.activity = activity;
    }


    /**
     * It is used to create a csv file by processing the data received from the user.
     * @param fileName Name of will create file
     * @param headerList Header list of csv file
     * @param data List of csv data
     * @param permissionRequestCode requested write file code for catch at in activity
     * @param fileCallback Callback of file
     */
    public void createCsvFile(String fileName, List<String> headerList, List<String> data, int permissionRequestCode, final FileCallback fileCallback) {
        if (PermissionUtility.askPermissionForActivity(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE, permissionRequestCode)) {
            fileName = fileName.replace(" ", "_").replace(":", "_");

            file = new File(Environment.getExternalStorageDirectory() + File.separator + fileName + ".csv");
            outputStream = null;

            try {
                file.createNewFile();
            } catch (IOException e) {
                fileCallback.onFail(e.getMessage());
            }


            List<String> headerListWithComma=Utils.separatorReplace(separatorColumn,seperatorLine,headerList);
            List<String> dataListWithComma=Utils.separatorReplace(separatorColumn,seperatorLine,data);



            file=writeDataToFile(file,containAllData(headerListWithComma,dataListWithComma),fileCallback);

            fileCallback.onSuccess(file);


        } else {
            fileCallback.onFail("Write Permission Error");
        }
    }


    /**
     *
     * @param file Created csv file's object
     * @param dataList List of csv data
     * @param fileCallback Callback of file
     * @return
     */
    private File writeDataToFile(final File file, List<String> dataList, final FileCallback fileCallback) {

        if (file.exists()) {
            try {
                outputStream = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                fileCallback.onFail(e.getMessage());
            }

            final OutputStream finalFo = outputStream;


            String[] headerArray = new String[dataList.size() - 1];
            headerArray = dataList.toArray(headerArray);

            Observable
                    .fromArray(headerArray)
                    .subscribe(new Observer() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }

                        @Override
                        public void onNext(Object o) {
                            String dataWithLineBreak = (String) o;
                            try {
                                finalFo.write(dataWithLineBreak.getBytes());
                            } catch (IOException e) {
                                fileCallback.onFail(e.getMessage());
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            fileCallback.onFail(e.getMessage());
                        }

                        @Override
                        public void onComplete() {
                            try {
                                finalFo.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });

            return file;

        }else {
            fileCallback.onFail("Couldn't create CSV file");
        }

        return file;
    }

    /**
     * Merge headerlist and datalist
     * @param headerList Header list of csv
     * @param dataList Data list of csv
     * @return
     */
    private List<String> containAllData(List<String> headerList,List<String> dataList){
        List<String> stringList=new ArrayList<>();
        for(String value:headerList){
            stringList.add(value);
        }
        for(String value:dataList){
            stringList.add(value);
        }

        return stringList;
    }

    /**
     * Sets the column delimiter character(s) to be used (default: {@link EasyCsv#separatorColumn}).
     */
    public void setSeparatorColumn(String separatorColumn) {
        this.separatorColumn = separatorColumn;
    }

    /**
     * Sets the line delimiter character(s) to be used (default: {@link EasyCsv#seperatorLine}).
     */
    public void setSeperatorLine(String seperatorLine) {
        this.seperatorLine = seperatorLine;
    }
}
