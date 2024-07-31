package com.example.dialogos_kr;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    Button B1, B2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        B1 = findViewById(R.id.B1);
        B2 = findViewById(R.id.B2);

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogoB();
            }
        });

        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogoP();
            }
        });

    }

    private void DialogoB() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Diálogo básico");
        builder.setMessage("¿Desea guardar los cambios?");

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Presionó aceptar", Toast.LENGTH_LONG).show();
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Presionó cancelar", Toast.LENGTH_LONG).show();
            }
        });

        builder.show();

    }

    private void DialogoP(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.personalizado, null);
        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();

        Button Reg = view.findViewById(R.id.Reg);
        Button Can = view.findViewById(R.id.Can);

        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Registrado", Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });

        Can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Cancelado", Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });

    }
}