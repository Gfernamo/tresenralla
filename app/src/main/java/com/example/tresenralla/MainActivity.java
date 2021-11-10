package com.example.tresenralla;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    ImageButton a1; ImageButton a2; ImageButton a3;
    ImageButton b1; ImageButton b2; ImageButton b3;
    ImageButton c1; ImageButton c2; ImageButton c3;
    int contador;
    boolean victoria=false;
    int marques[]={3,4,5,6,7,8,9,10,11};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a1 = findViewById(R.id.a1);
        a2 = findViewById(R.id.a2);
        a3 = findViewById(R.id.a3);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        a1.setOnClickListener(this);
        b1.setOnClickListener(this);
        c1.setOnClickListener(this);
        a2.setOnClickListener(this);
        b2.setOnClickListener(this);
        c2.setOnClickListener(this);
        a3.setOnClickListener(this);
        b3.setOnClickListener(this);
        c3.setOnClickListener(this);
        contador=0;
    }
    public void onClick(View v) {
        if (!victoria)
        {
            ImageButton botoPitjat=null;
            int posicio=0;

            if (v.getId() ==a1.getId()) {
                botoPitjat=a1;
            }
            else if (v.getId() ==a2.getId()) {
                botoPitjat=a2;
                posicio=1;
            }
            else if (v.getId() ==a3.getId()) {
                botoPitjat=a3;
                posicio=2;
            }
            else if (v.getId() ==b1.getId()) {
                botoPitjat=b1;
                posicio=3;
            }
            else if (v.getId() ==b2.getId()) {
                botoPitjat=b2;
                posicio=4;
            }
            else if (v.getId() ==b3.getId()) {
                botoPitjat=b3;
                posicio=5;
            }
            else if (v.getId() ==c1.getId()) {
                botoPitjat=c1;
                posicio=6;
            }
            else if (v.getId() ==c2.getId()) {
                botoPitjat=c2;
                posicio=7;
            }
            else if (v.getId() ==c3.getId()) {
                botoPitjat=c3;
                posicio=8;
            }
            contador++;
            marcaCasella(botoPitjat,posicio);
            if (contador<10)verificaVictoria();
            if (contador==9&&!victoria){
                mostrarFinal("Heu empatat!");
            }
        }
    }
    public void marcaCasella(ImageButton botoPitjat,int pos)
    {
        if (contador%2==0){
            botoPitjat.setImageResource(R.drawable.xpet);
            marques[pos]=1;
        }
        else {
            botoPitjat.setImageResource(R.drawable.opet);
            marques[pos]=2;
        }
        botoPitjat.setClickable(false);
    }
    private void verificaVictoria() {
        if ((marques[0]==marques[1]&&marques[0]==marques[2])||
        (marques[3]==marques[4]&&marques[3]==marques[5])||
        (marques[6]==marques[7]&&marques[6]==marques[8])||
        (marques[0]==marques[3]&&marques[0]==marques[6])||
        (marques[1]==marques[4]&&marques[1]==marques[7])||
        (marques[2]==marques[5]&&marques[2]==marques[8])||
        (marques[0]==marques[4]&&marques[0]==marques[8])||
        (marques[2]==marques[4]&&marques[2]==marques[6]))
        {
            if ((marques[0]+marques[1]+marques[2]==3)||
                (marques[3]+marques[4]+marques[5]==3)||
                (marques[6]+marques[7]+marques[8]==3)||
                (marques[0]+marques[3]+marques[6]==3)||
                (marques[1]+marques[4]+marques[7]==3)||
                (marques[2]+marques[5]+marques[8]==3)||
                (marques[0]+marques[4]+marques[8]==3)||
                (marques[2]+marques[4]+marques[6]==3)) {
                mostrarFinal("Han guanyat les creus!");
            }

            else{
                mostrarFinal("Han guanyat els cercles!");
            }
                victoria=true;
        }
    }
    public void mostrarFinal(String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(text);
        builder.setMessage("Vols tornar a jugar?");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                reiniciarJoc();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.exit(1);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void reiniciarJoc(){
        a1.setImageResource(R.drawable.quadre);
        a2.setImageResource(R.drawable.quadre);
        a3.setImageResource(R.drawable.quadre);
        b1.setImageResource(R.drawable.quadre);
        b2.setImageResource(R.drawable.quadre);
        b3.setImageResource(R.drawable.quadre);
        c1.setImageResource(R.drawable.quadre);
        c2.setImageResource(R.drawable.quadre);
        c3.setImageResource(R.drawable.quadre);
        victoria=false;
        contador=0;
        marques[0]=3;
        marques[1]=4;
        marques[2]=5;
        marques[3]=6;
        marques[4]=7;
        marques[5]=8;
        marques[6]=9;
        marques[7]=10;
        marques[8]=11;
        a1.setClickable(true);
        a2.setClickable(true);
        a3.setClickable(true);
        b1.setClickable(true);
        b2.setClickable(true);
        b3.setClickable(true);
        c1.setClickable(true);
        c2.setClickable(true);
        c3.setClickable(true);
    }
}