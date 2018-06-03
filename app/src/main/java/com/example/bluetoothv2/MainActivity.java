package com.example.bluetoothv2;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothHeadset;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    public String attributes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        attributes = bluetoothadd();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(attributes);
    }

    private String bluetoothadd() {
        String attributes = "";
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();

        List<String> s = new ArrayList<String>();
        int count = 1;
        for (BluetoothDevice bt : pairedDevices) {
            attributes+= ("Device " + Integer.toString(count)+ ": \n");
            // s.add(bt.getName());
            attributes += ("Bluetooth Name = " + bt.getName() +"\n" + "Bluetooth Address = " + bt.getAddress()+"\n");
            Log.d("Bluetooth","Bluetooth Adress = " + bt.getAddress() +"\n" + "Bluetooth Name = " + bt.getName() + " Bluetooth UID " + bt.getUuids());

            attributes += ( "\n");
            count++;
        }

        return attributes;
    }



}
