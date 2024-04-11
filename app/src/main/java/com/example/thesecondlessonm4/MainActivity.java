package com.example.thesecondlessonm4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText input;
    private Button button;
    private TextView output;
    private int listSize;
    private List<Integer> arrayList = new ArrayList<>();
    private List<Integer> linkedList = new LinkedList<>();

    private long timeOne, timeTwo, timeThree;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        input = findViewById(R.id.input);
        button = findViewById(R.id.button);
        output = findViewById(R.id.output);


        button.setOnClickListener(listener);
    }


    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            try {
                listSize = Integer.parseInt(input.getText().toString());
            } catch (NumberFormatException numberFormatException) {
                Toast.makeText(MainActivity.this, "Необходимо ввести размер списков в виде числа", Toast.LENGTH_SHORT).show();
            }


            timeOne = SystemClock.uptimeMillis();
            arrayList = addProgressionList(arrayList);
            timeTwo = SystemClock.uptimeMillis();
            linkedList = addProgressionList(linkedList);
            timeThree = SystemClock.uptimeMillis();


            output.setText("Время заполнения ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВремя заполнения " + (timeThree - timeTwo) + " мс");


            timeOne = SystemClock.uptimeMillis();
            arrayList.add(1, 10);
            timeTwo = SystemClock.uptimeMillis();
            linkedList.add(1, 10);
            timeThree = SystemClock.uptimeMillis();


            output.append("\n\nВремя добавления элементов:\nВ начало ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ начало LinkedList " + (timeThree - timeTwo) + " мс");


            timeOne = SystemClock.uptimeMillis();
            arrayList.add(listSize/2, 10);
            timeTwo = SystemClock.uptimeMillis();
            linkedList.add(listSize/2, 10);
            timeThree = SystemClock.uptimeMillis();


            output.append("\nВ середину ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ середину  LinkedList " + (timeThree - timeTwo) + " мс");


            timeOne = SystemClock.uptimeMillis();
            arrayList.add(listSize+1, 10);
            timeTwo = SystemClock.uptimeMillis();
            linkedList.add(listSize+1, 10);
            timeThree = SystemClock.uptimeMillis();

            output.append("\nВ конец ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ конец LinkedList " + (timeThree - timeTwo) + " мс");


            timeOne = SystemClock.uptimeMillis();
            arrayList.set(1, 1000);
            timeTwo = SystemClock.uptimeMillis();
            linkedList.set(1, 1000);
            timeThree = SystemClock.uptimeMillis();


            output.append("\n\nВремя замены элементов:\nВ начале ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ начале LinkedList " + (timeThree - timeTwo) + " мс");


            timeOne = SystemClock.uptimeMillis();
            arrayList.set(listSize/2, 1000);
            timeTwo = SystemClock.uptimeMillis();
            linkedList.set(listSize/2, 1000);
            timeThree = SystemClock.uptimeMillis();


            output.append("\nВ середине ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ середине  LinkedList " + (timeThree - timeTwo) + " мс");

            timeOne = SystemClock.uptimeMillis();
            arrayList.set(listSize, 1000);
            timeTwo = SystemClock.uptimeMillis();
            linkedList.set(listSize, 1000);
            timeThree = SystemClock.uptimeMillis();


            output.append("\nВ конце ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ конце LinkedList " + (timeThree - timeTwo) + " мс");


            timeOne = SystemClock.uptimeMillis();
            arrayList.remove(1);
            timeTwo = SystemClock.uptimeMillis();
            linkedList.remove(1);
            timeThree = SystemClock.uptimeMillis();


            output.append("\n\nВремя удаления элементов:\nВ начале ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ начале  LinkedList " + (timeThree - timeTwo) + " мс");


            timeOne = SystemClock.uptimeMillis();
            arrayList.remove(listSize/2);
            timeTwo = SystemClock.uptimeMillis();
            linkedList.remove(listSize/2);
            timeThree = SystemClock.uptimeMillis();


            output.append("\nВ середине ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ середине  LinkedList " + (timeThree - timeTwo) + " мс");


            timeOne = SystemClock.uptimeMillis();
            arrayList.remove(listSize);
            timeTwo = SystemClock.uptimeMillis();
            linkedList.remove(listSize);
            timeThree = SystemClock.uptimeMillis();


            output.append("\nВ конце ArrayList " + (timeTwo - timeOne) + " мс"
                    + "\nВ конце LinkedList " + (timeThree - timeTwo) + " мс");
        }
    };


    private List<Integer> addProgressionList(List<Integer> list) {

        for (int i = 0; i < listSize; i++) {
            list.add(i + 10);
        }
        return list;
    }
}