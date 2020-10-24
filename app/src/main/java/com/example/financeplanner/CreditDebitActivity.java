package com.example.financeplanner;

import androidx.annotation.NonNull;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Telephony.Sms;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CreditDebitActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_debit);
    }

    public void calculateCreditDebit(View view) {

        if (this.checkSelfPermission(Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
            //TODO: Step 3 - Request for SMS Permission (Runtime)
//            requestPermissions(new String[]{Manifest.permission.READ_SMS}, 1923);

        } else {
            //TODO: Step 4 - Automatically calculate and show credit and debit
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 1923){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                //TODO: Step 5 - Show Credit and Debit if we accept permission also
            }
        }
    }

    // TODO : Step 1 - Add onclick
    public void showCreditAndDebit(View view) {
        System.out.println("Trying to show credit and debit");
        String creditedMessage = "Your account has been credited with Rs.";
        String debitedMessage = "Your account has been debited for Rs.";
        int creditAmount = 0, debitAmount = 0;
        List<String> messages = readSmsMessages();
        for (String message : messages) {
            //TODO - Step 7 : Complete the formula
        }
        ((TextView)findViewById(R.id.credit)).setText(String.valueOf(creditAmount));
        ((TextView)findViewById(R.id.debit)).setText(String.valueOf(debitAmount));
    }

    private int amountFromMessage(String message, String startingMessage) {
            String remaining = message.substring(startingMessage.length());
            String amountAsString = remaining.trim().split(" ")[0];
            return Integer.parseInt(amountAsString);
    }

    private List<String> readSmsMessages() {
        //TODO:  Step 6 - Create a content resolver, add columns for ID, Address, Body, and query
        // SMS content URI to get the cursor
        List<String> smsMessageBodies = new ArrayList<>();
//        while(cursor.moveToNext()){
//            String smsBody = cursor.getString(cursor.getColumnIndexOrThrow(Sms.Inbox.BODY));
//            smsMessageBodies.add(smsBody);
//        }
//        cursor.close();
        return smsMessageBodies;
    }
}