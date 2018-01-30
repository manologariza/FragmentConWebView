package com.example.manolo.fragmentconwebview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        FragmentNavegador fragmentInicial= new FragmentNavegador();

        transaction.add(R.id.LinearLayoutContenedorFragment, fragmentInicial);
        transaction.commit();

    }

    public void seleccionarFragmento(View v){
        Fragment miFragmento;

        if(v==findViewById(R.id.tvFragmentCalculadora)){
            miFragmento=new FragmentCalculadora();
        }
        else if(v==findViewById(R.id.tvFragmentNavegador)){
            miFragmento=new FragmentNavegador();
        }
        else{
            miFragmento=new FragmentNavegador();
        }

        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.LinearLayoutContenedorFragment, miFragmento);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
