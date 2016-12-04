package com.shearlogicllc.whatsmypay;

// import android.content.Intent; //<-- my version has this. bsb
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText PaidBackBarPrct; //my app doesn't have these.  I can't tell what they do. bsb
    EditText THPC; //I think they may be declaring objects which are defined later.
    EditText ServiceDlrsPerHr;
    EditText CPTH;
    EditText RetailSales;
    TextView message;
    TextView message2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PaidBackBarPrct = (EditText) findViewById(R.id.PaidBackBarPerc); //this look like it is defining an object which was declared on line 13.
        // would it work to say...
        // EditText PaidBackBarPrct = (EditText) findViewById(R.id.PaidBackBarPerc); // and remove line 13?
        // ... I researched this and believe that I'm understanding correctly.
        THPC =(EditText) findViewById(R.id.THPC); // if these are all numbers, you can change the keyboard by editing activity_main.xml (android:inputType="phone")
        ServiceDlrsPerHr =(EditText) findViewById(R.id.ServiceDlrsPerHr);
        CPTH =(EditText) findViewById(R.id.CPTH);
        RetailSales = (EditText) findViewById(R.id.RetailSales);
        message = (TextView) findViewById(R.id.message);
        message2 = (TextView) findViewById(R.id.message2);




        //final String affirmation2 = "Yes...you rock!";
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
        float PaidBackBarMin = 40; // not explicitly cast as float
        float PaidBackBar = Float.parseFloat(PaidBackBarPrct.getText().toString()); // this converts string to float?
        float THPC_Min = (float) 1.5; // this is explicity cast--does it matter?
        float RetailPerClient = Float.parseFloat(THPC.getText().toString());
        float SDPH_Min = (float)40;
        float SDPH = Float.parseFloat(ServiceDlrsPerHr.getText().toString());
        float CPTH_Min = (float) 1.5;
        float CutsPerTotalHours = Float.parseFloat(CPTH.getText().toString());
        int counter = 0;


        if(PaidBackBar >= PaidBackBarMin){
            counter ++;
        }
        if(RetailPerClient >= THPC_Min){
            counter ++;
        }
        if(SDPH >= SDPH_Min){
            counter ++;
        }
         if(CutsPerTotalHours>= CPTH_Min){
             counter ++;
         }
        if(counter == 4){
            message.setText("Great Job! You will make service commission!");
        }else if (counter < 4){
            message.setText("Sorry! You are missing at least one of the requirements");
            counter = 0;
        }
        }
    public void SalesCommissionStatusClicked(View v){ // I don't see where this is called.  Are you still working it or am I not seeing it?
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
        else if (RetailPrctEarned <10){  // Two notes: (1) you don't need the if statement you can end w/ an else.  (2) if you do use an if, it should be < 1 not < 10.
                    message2.setText("Sorry! You haven't earned Sales Commission yet");
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


