package ru.axtrace.hhres;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

public class DateDisplayPicker extends TextView implements DatePickerDialog.OnDateSetListener{

    int bYear = 1970;
    int bMonth = 0;
    int bDay = 1; 

    private Context _context;

    public DateDisplayPicker(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        _context = context;
    }

    public DateDisplayPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        _context = context;
        setAttributes();
    }

    public DateDisplayPicker(Context context) {
        super(context);
        _context = context;
        setAttributes();
    }

    private void setAttributes() {
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog();
            }
        });
    }

    private void showDateDialog() {
        try {
            DatePickerDialog dp = new DatePickerDialog(_context, this, bYear, bMonth, bDay);
            dp.show();
        }
        catch (Exception e)
        {

        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear,
                          int dayOfMonth) {
        try{
            setText(String.format("%s/%s/%s", monthOfYear, dayOfMonth, year));
            bDay = dayOfMonth;
            bMonth = monthOfYear;
            bYear = year;
        }
        catch (Exception e)
        {

        }
    }
}