
#  easy-csv

Creates csv file for android

![alt text](./img/ss.png)
  

##  Download

**Add it in your root build.gradle at the end of repositories:**

<pre>

allprojects {

repositories {
...
    maven { url 'https://jitpack.io' }
    }
}

</pre>

  

**Add the dependency**

<pre>

dependencies {
implementation 'com.github.hsmnzaydn:easy-csv:1.0.0'
}

</pre>

  

##  Use Steps

**Step 1: Create EasyCsv Object**

``` java

EasyCsv easyCsv = new EasyCsv(MainActivity.this);

```

  

**Step 2: Create your headerlist and datalist**

``` java
List<String> headerList = new ArrayList<>();
headerList.add("Name.Surname.Age-");

List<String> dataList = new ArrayList<>();
dataList.add("Serkan.Ozaydin.23-");

```

**Step 3: Select separators for column and line**

``` java
easyCsv.setSeparatorColumn(".");
easyCsv.setSeperatorLine("-");
```

**Step 4: Select separators for column and line**

``` java

/**
* @param fileName Name of the file to be created
* @param WRITE_PERMISSON_REQUEST_CODE EasyCsv request runtime permission for Write permission to user. When user "Accept" or "Decline" for you can handler
*/
easyCsv.createCsvFile(fileName, headerList, dataList WRITE_PERMISSON_REQUEST_CODE, new FileCallback() {
@Override
public void onSuccess(File file) {
}

@Override
public void onFail(String err) {
}
});

```