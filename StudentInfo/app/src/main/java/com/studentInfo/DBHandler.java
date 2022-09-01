package com.studentInfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "StudentDetails";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "students";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our course name column
    private static final String NAME_COL = "name";

    // below variable id for our course duration column.
    private static final String ROLL_NO = "roll_no";

    // below variable for our course description column.
    private static final String YEAR = "year";

    // below variable is for our course tracks column.
    private static final String BRANCH = "branch";

    private static final String AGE = "age";
    private static final String PHONE_COL = "phone_no";
    private static final String ADDRESS = "address";

    List<studentModel> studentList;

    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + ROLL_NO + " TEXT,"
                + YEAR + " TEXT,"
                + BRANCH + " TEXT,"
                + AGE + " TEXT,"
                + PHONE_COL + "TEXT,"
                + ADDRESS + "TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    public List<studentModel> getStudent(String sRoll) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + ROLL_NO + " FROM " + TABLE_NAME;
        Cursor c = db.rawQuery(query, null);
        studentList = new ArrayList<studentModel>();

        if (c.moveToFirst()) {
            do {
                // Passing values
                String column1 = c.getString(0);
                String column2 = c.getString(1);
                String column3 = c.getString(2);


                studentModel studentModel = new studentModel();

                studentModel.setStr_name(c.getString(1));
                studentModel.setStr_age(c.getString(2));
                studentModel.setStr_branch(c.getString(3));
                studentModel.setStr_address(c.getString(4));
                studentModel.setStr_phone((c.getString(5)));

                studentList.add(studentModel);
                // Do something Here with values
            } while (c.moveToNext());
        }
        c.close();
        db.close();

        return studentList;

    }

    // this method is use to add new course to our sqlite database.
    public void addNewStudent(String sName, String sRoll, String sYear, String sBranch, String sAge, String sPhone, String sAddress) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, sName);
        values.put(ROLL_NO, sRoll);
        values.put(YEAR, sYear);
        values.put(BRANCH, sBranch);
        values.put(AGE, sAge);
        values.put(PHONE_COL, sPhone);
        values.put(ADDRESS, sAddress);


        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
