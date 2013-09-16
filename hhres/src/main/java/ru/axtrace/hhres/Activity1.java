package ru.axtrace.hhres;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.content.Intent;

public class Activity1 extends android.app.Activity  {

    String[] sexdata = {"Мужчина", "Женщина"};
    EditText entFIO;
    ru.axtrace.hhres.DateDisplayPicker bDate;
    Spinner spinnerSex;
    EditText entRank; 
    EditText entSalary;
    EditText entPhone;
    EditText entEmail;
    Button sendButton;

    ArrayAdapter<String> adapter;
    String entSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_main);

        //сопоставим поля переменным
        entFIO = (EditText) findViewById(R.id.IDFio);
        bDate = (ru.axtrace.hhres.DateDisplayPicker) findViewById(R.id.IDPickerBirthDate);
        spinnerSex = (Spinner) findViewById(R.id.IDspinnerSex);
        entRank = (EditText) findViewById(R.id.IDRank);
        entSalary = (EditText) findViewById(R.id.IDSalary);
        entPhone = (EditText) findViewById(R.id.IDPhone);
        entEmail = (EditText)findViewById(R.id.IDEmail);
        sendButton = (Button)findViewById(R.id.IDButtonSend);

        // оформим вывод выбора пола из двух пунктов
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sexdata);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinnerSex.setAdapter(adapter);

        // заголовок
        spinnerSex.setPrompt("Пол");

        // выделяем элемент
        // spinner.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerSex.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // показываем позиция нажатого элемента
                //Toast.makeText(getBaseContext(), "Position = " + position, Toast.LENGTH_SHORT).show();

                entSex = sexdata[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }

    //Обработчик нажатия на кнопку "Отправить"
    public void onSendButtonClick(View view){
        Intent intent = new Intent(this, Activity2.class);
        try
        {
            //передаем данные во второе активити
            intent.putExtra("intentFIO", entFIO.getText().toString());
            intent.putExtra("intentBIRTHDATE", bDate.getText().toString());
            intent.putExtra("intentSEX", entSex);
            intent.putExtra("intentRANK", entRank.getText().toString());
            intent.putExtra("intentSALARY", entSalary.getText().toString());
            intent.putExtra("intentPHONE", entPhone.getText().toString());
            intent.putExtra("intentEMAIL", entEmail.getText().toString());

            startActivity(intent);
        }
        catch (Exception e)
        {


        }
    }
}
