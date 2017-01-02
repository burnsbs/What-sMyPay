package com.shearlogicllc.whatsmypay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText PaidBackBarPrct;
    EditText THPC;
    EditText ServiceDlrsPerHr;
    EditText CPTH;
    EditText RetailSales;
    TextView message;
    TextView message2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PaidBackBarPrct = (EditText) findViewById(R.id.PaidBackBarPerc);
        THPC =(EditText) findViewById(R.id.THPC);
        ServiceDlrsPerHr =(EditText) findViewById(R.id.ServiceDlrsPerHr);
        CPTH =(EditText) findViewById(R.id.CPTH);
        RetailSales = (EditText) findViewById(R.id.RetailSales);
        message = (TextView) findViewById(R.id.message);
        message2 = (TextView) findViewById(R.id.message2);




        //final String affermation2 = "Yes...you rock!";
        //final TextView affirmation_text =(TextView) findViewById(R.id.affirmation_text);
        //final Button button_Stat=(Button) findViewById(R.id.button_Stat);
        //button_Stat.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //       affirmation_text.setText(affermation2);

        //           }
        //    });
        //final Button Test_button=(Button) findViewById(R.id.Test_button);
        //Test_button.setBackground(getResources().get);



    // Example of a call to a native method
    //TextView tv = (TextView) findViewById(R.id.sample_text);
    //tv.setText(stringFromJNI());
    }



    public void CommissionStatusClicked(View v){
        float PaidBackBarMin = 40;
        float PaidBackBar = Float.parseFloat(PaidBackBarPrct.getText().toString());
        float THPC_Min = (float) 1.5;
        float RetailPerClient = Float.parseFloat(THPC.getText().toString());
        float SDPH_Min = (float)40;
        float SDPH = Float.parseFloat(ServiceDlrsPerHr.getText().toString());
        float CPTH_Min = (float) 1.5;
        float CutsPerTotalHours = Float.parseFloat(CPTH.getText().toString());
        int counter = 0;
        // my changes begin -b
        // I reversed the logic and added specific messages for each case -b
        String ServiceCommissionMsg = "";
        System.out.println(ServiceCommissionMsg);

        if(PaidBackBar < PaidBackBarMin){
            counter ++;
            ServiceCommissionMsg = ServiceCommissionMsg + "  You did not meet Paid Back Bar Min.";
            System.out.println(ServiceCommissionMsg);
        }
        if(RetailPerClient < THPC_Min){
            counter ++;
            ServiceCommissionMsg = ServiceCommissionMsg + "  You did not meet THPC Min.";
            System.out.println(ServiceCommissionMsg);
        }
        if(SDPH < SDPH_Min){
            counter ++;
            ServiceCommissionMsg = ServiceCommissionMsg + "  You did not meet SDPH Min.";
            System.out.println(ServiceCommissionMsg);
        }
        if(CutsPerTotalHours < CPTH_Min){
            counter ++;
            ServiceCommissionMsg = ServiceCommissionMsg + "  You did not meet CPTH Min.";
            System.out.println(ServiceCommissionMsg);
         }
        if(counter == 0){
            message.setText("Great Job! You will make service commission!");
        }
        else {
            message.setText("Sorry! You are missing at least one of the requirements" + ServiceCommissionMsg);
            counter = 0;
        }
        // my changes end -b
        }
    public void SalesCommissionStatusClicked(View v){
        float Retail_min = 100;
        float RetailSalesEntered = Float.parseFloat(RetailSales.getText().toString());
        int RetailPrctEarned = 0;

        if(RetailSalesEntered >= 100) {
            RetailPrctEarned++;
        }
        if(RetailSalesEntered >= 200){
            RetailPrctEarned ++;
        }
        if(RetailPrctEarned == 1){
            message2.setText("You will earn 10% Sales Commission!");
            RetailPrctEarned=0;
            }
        else if(RetailPrctEarned ==2){
            message2.setText("You will earn 20% Sales Commission!");
            RetailPrctEarned=0;
            }
        else if (RetailPrctEarned <10){
                    message2.setText("Sorry! You haven't earned Sales Commission yet");
            // fixed spelling of earned
            RetailPrctEarned=0;
            }
        }
}

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    //public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    //static {
    //    System.loadLibrary("native-lib");


