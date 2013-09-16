package ru.axtrace.hhres;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends android.app.Activity{

 
    TextView tvFIO;
    TextView tvBdate;
    TextView tvSex;
    TextView tvRank;
    TextView tvSalary;
    TextView tvPhone;
    TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_layout);
        try
        {


            tvFIO = (TextView) findViewById(R.id.IDFio2);
            tvBdate = (TextView) findViewById(R.id.IDBDate2);
            tvSex= (TextView) findViewById(R.id.IDSex2);
            tvRank= (TextView) findViewById(R.id.IDRank2);
            tvSalary= (TextView) findViewById(R.id.IDSalary2);
            tvPhone= (TextView) findViewById(R.id.IDPhone2);
            tvEmail= (TextView) findViewById(R.id.IDEmail2);


            Intent intent = getIntent();

            //получаем данные с предыдущего активити
            String gFio = intent.getStringExtra("intentFIO");
            String gBdate = intent.getStringExtra("intentBIRTHDATE");
            String gSex = intent.getStringExtra("intentSEX");
            String gRank = intent.getStringExtra("intentRANK");
            String gSalary = intent.getStringExtra("intentSALARY");
            String gPhone = intent.getStringExtra("intentPHONE");
            String gEmail = intent.getStringExtra("intentEMAIL");



            tvFIO.setText(gFio);
            tvBdate.setText(gBdate);
            tvSex.setText(gSex);
            tvRank.setText(gRank);
            tvSalary.setText(gSalary);
            tvPhone.setText(gPhone);
            tvEmail.setText(gEmail);
        }
        catch (Exception e)
        {

        }

    }
    public void onButtonClick(View view){
        Toast toast = Toast.makeText(getApplicationContext(),
                "onClick Listener Would Be Here", Toast.LENGTH_SHORT);
        toast.show();
    }
    public void onEmailClick(View view){
        try
        {

            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_EMAIL,tvEmail.getText());
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Resume");
            startActivity(Intent.createChooser(shareIntent, "Отправить Email"));
        }
        catch (Exception e)
        {

        }
    }

    public void onPhoneClick(View view){
        try
        {
            Intent shareIntent = new Intent(Intent.ACTION_DIAL);
            shareIntent.putExtra(Intent.EXTRA_PHONE_NUMBER, Uri.parse("tel:" +tvPhone.getText()));
        }
        catch (Exception e)
        {

        }
    }

}
