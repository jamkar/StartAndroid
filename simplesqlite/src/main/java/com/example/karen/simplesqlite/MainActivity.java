package com.example.karen.simplesqlite;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener{

    Button btnAdd, btnRead, btnClear, btnUpd, btnDel;
    EditText etName, etEmail, etID;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnRead = (Button) findViewById(R.id.btnRead);
        btnRead.setOnClickListener(this);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        btnUpd = (Button) findViewById(R.id.btnUpd);
        btnUpd.setOnClickListener(this);

        btnDel = (Button) findViewById(R.id.btnDel);
        btnDel.setOnClickListener(this);

        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etID = (EditText) findViewById(R.id.etID);

        dbHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View v) {

        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String id = etID.getText().toString();

        ContentValues cv = new ContentValues();
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        switch (v.getId())
        {
            case R.id.btnAdd:
                Toast.makeText(this,"Insert in mytable", Toast.LENGTH_LONG).show();

                cv.put("name",name);
                cv.put("email",email);

                long rowID = db.insert("mytable", null, cv);

                Toast.makeText(this,"row is inserted, ID=" + rowID, Toast.LENGTH_LONG).show();
                break;

            case R.id.btnRead:
                Toast.makeText(this,"row in mytable", Toast.LENGTH_LONG).show();
                // делаем запрос всех данных из таблицы mytable, получаем Cursor
                Cursor c = db.query("mytable", null, null, null, null, null, null);

                // ставим позицию курсора на первую строку выборки
                // если в выборке нет строк, вернется false
                if (c.moveToFirst()) {

                    // определяем номера столбцов по имени в выборке
                    int idColIndex = c.getColumnIndex("id");
                    int nameColIndex = c.getColumnIndex("name");
                    int emailColIndex = c.getColumnIndex("email");

                    do {
                        // получаем значения по номерам столбцов и пишем все в лог
                        Toast.makeText(this,Integer.toString(c.getInt(idColIndex)),Toast.LENGTH_LONG).show();
                        Toast.makeText(this,c.getString(nameColIndex),Toast.LENGTH_LONG).show();
                        Toast.makeText(this,c.getString(emailColIndex),Toast.LENGTH_LONG).show();
                        /*Log.d(LOG_TAG,
                                "ID = " + c.getInt(idColIndex) +
                                        ", name = " + c.getString(nameColIndex) +
                                        ", email = " + c.getString(emailColIndex));*/
                        // переход на следующую строку
                        // а если следующей нет (текущая - последняя), то false - выходим из цикла
                    } while (c.moveToNext());
                } else
                    Toast.makeText(this,"0 rows",Toast.LENGTH_LONG).show();
                    //Log.d(LOG_TAG, "0 rows");
                c.close();
                break;

            case R.id.btnClear:
                Toast.makeText(this,"clear mytable",Toast.LENGTH_SHORT).show();

                int clearCount = db.delete("mytable",null,null);
                Toast.makeText(this,"deleted rows count = " + clearCount, Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnUpd:
                if(id.equalsIgnoreCase(""))
                    break;
                Toast.makeText(this,"update mytable",Toast.LENGTH_SHORT).show();
                cv.put("name",name);
                cv.put("email",email);
                int updCount = db.update("mytable", cv, "id = ?", new String[]{id});
                Toast.makeText(this,"updated rows count = " + updCount, Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnDel:
                if(id.equalsIgnoreCase(""))
                    break;
                Toast.makeText(this,"delete from mytable",Toast.LENGTH_SHORT).show();
                int delCount = db.delete("mytable" ,"id = " + id, null);
                Toast.makeText(this,"deleted rows count = " + delCount, Toast.LENGTH_SHORT).show();
                break;
        }
        dbHelper.close();
    }

    class DBHelper extends SQLiteOpenHelper{

        public DBHelper(Context context){
            super(context,"myDB",null,1);
        }

        @Override
        public void onCreate(SQLiteDatabase db){

            Toast.makeText(getApplicationContext(),"onCreate database",Toast.LENGTH_SHORT).show();

            db.execSQL("create table mytable (id integer primary key autoincrement, name text, email text);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        }
    }
}
