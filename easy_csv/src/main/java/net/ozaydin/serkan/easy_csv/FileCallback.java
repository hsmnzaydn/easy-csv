package net.ozaydin.serkan.easy_csv;

import java.io.File;

public interface FileCallback {
    void onSuccess(File file);
    void onFail(String err);
}
