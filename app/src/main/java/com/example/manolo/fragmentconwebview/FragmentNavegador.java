package com.example.manolo.fragmentconwebview;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class FragmentNavegador extends Fragment {

    EditText etURL;
    Button btnCargarPagina;
    WebView webView1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_fragment_navegador, container, false);//FALTA
        etURL=(EditText)v.findViewById(R.id.etURL);
        btnCargarPagina=(Button)v.findViewById(R.id.btnCargarPagina);
        webView1=(WebView)v.findViewById(R.id.webView1);

        btnCargarPagina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url=etURL.getText().toString();
                if(!TextUtils.isEmpty(url)){
                    webView1.setWebViewClient(new WebViewClient()); //Ponemos esto para que no cargue la pagina en una nueva actividad, sino que se mantenga en el contenedor de fragment
                    webView1.getSettings().setJavaScriptEnabled(true);
                    webView1.loadUrl("http://"+url);
                }
                else
                    Toast.makeText(getContext(), "Debe introducir una URl en el campo de texto", Toast.LENGTH_LONG).show();
            }
        });


        return v;
    }


}
