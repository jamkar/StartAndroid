package com.example.karen.files;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends Activity {

    final String LOG_TAG = "myLogs";

    final String FILENAME = "myFfile";

    final String DIR_SD = "MyFiles";
    final String FILENAME_SD = "fileSD";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclick(View v) {
        switch (v.getId()) {
            case R.id.btnWrite:
                writeFile();
                break;
            case R.id.btnRead:
                readFile();
                break;
            case R.id.btnWriteSD:
                writeFileSD();
                break;
            case R.id.btnReadSD:
                readFileSD();
                break;
        }
    }

    void writeFile() {
        try {
            File fil = new File(getFilesDir(), FILENAME);
            // �������� ����� ��� ������
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    openFileOutput(FILENAME, MODE_PRIVATE)));
            // ����� ������
            bw.write("���������� �����");
            // ��������� �����
            bw.close();
            Log.d(LOG_TAG, "���� �������");
            Toast.makeText(this,getFilesDir().toString(),Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "File not written, FNFE", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "File written, IOE", Toast.LENGTH_SHORT).show();
        }
    }

    void readFile() {
        try {
            // ��������� ����� ��� ������
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    openFileInput(FILENAME)));
            String str = "";
            // ������ ����������
            while ((str = br.readLine()) != null) {
                Log.d(LOG_TAG, str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void writeFileSD() {
        // ��������� ����������� SD
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            Log.d(LOG_TAG, "SD-����� �� ��������: " + Environment.getExternalStorageState());
            return;
        }
        // �������� ���� � SD
        File sdPath = Environment.getExternalStorageDirectory();
        // ��������� ���� ������� � ����
        sdPath = new File(sdPath.getAbsolutePath() + "/" + DIR_SD);
        // ������� �������
        sdPath.mkdirs();
        // ��������� ������ File, ������� �������� ���� � �����
        File sdFile = new File(sdPath, FILENAME_SD);
        try {
            // ��������� ����� ��� ������
            BufferedWriter bw = new BufferedWriter(new FileWriter(sdFile));
            // ����� ������
            bw.write("���������� ����� �� SD");
            // ��������� �����
            bw.close();
            Log.d(LOG_TAG, "���� ������� �� SD: " + sdFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void readFileSD() {
        // ��������� ����������� SD
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            Log.d(LOG_TAG, "SD-����� �� ��������: " + Environment.getExternalStorageState());
            return;
        }
        // �������� ���� � SD
        File sdPath = Environment.getExternalStorageDirectory();
        // ��������� ���� ������� � ����
        sdPath = new File(sdPath.getAbsolutePath() + "/" + DIR_SD);
        // ��������� ������ File, ������� �������� ���� � �����
        File sdFile = new File(sdPath, FILENAME_SD);
        try {
            // ��������� ����� ��� ������
            BufferedReader br = new BufferedReader(new FileReader(sdFile));
            String str = "";
            // ������ ����������
            while ((str = br.readLine()) != null) {
                Log.d(LOG_TAG, str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}