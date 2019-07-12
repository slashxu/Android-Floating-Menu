package com.soliwork.floatingmenu;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.github.fafaldo.fabtoolbar.widget.FABToolbarLayout;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CircleMenu circleMenu;
    private FABToolbarLayout fabToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circleMenu = findViewById(R.id.circleMenu);
        findViewById(R.id.facebook).setOnClickListener(this);
        findViewById(R.id.twitter).setOnClickListener(this);
        findViewById(R.id.whatsapp).setOnClickListener(this);
        findViewById(R.id.email).setOnClickListener(this);
        findViewById(R.id.message).setOnClickListener(this);
        findViewById(R.id.floating).setOnClickListener(this);

        fabToolbarLayout = findViewById(R.id.fabTollBarLayout);

        menuCircle();
    }

    private void menuCircle(){
        circleMenu.setMainMenu(ContextCompat.getColor(getApplicationContext(),R.color.colorAccent),android.R.drawable.ic_menu_manage,android.R.drawable.ic_menu_preferences);
        circleMenu.addSubMenu(ContextCompat.getColor(getApplicationContext(),R.color.facebook),android.R.drawable.ic_menu_add);
        circleMenu.addSubMenu(ContextCompat.getColor(getApplicationContext(),R.color.twitter),android.R.drawable.ic_menu_delete);
        circleMenu.addSubMenu(ContextCompat.getColor(getApplicationContext(),R.color.whatsApp),android.R.drawable.ic_menu_edit);
        circleMenu.addSubMenu(ContextCompat.getColor(getApplicationContext(),R.color.email),android.R.drawable.ic_menu_save);
        circleMenu.addSubMenu(ContextCompat.getColor(getApplicationContext(),R.color.message),android.R.drawable.ic_menu_search);

        circleMenu.setOnMenuSelectedListener(new OnMenuSelectedListener() {
            @Override
            public void onMenuSelected(int i) {
                indexCircle(i);
            }
        });
    }

    private void indexCircle(int index) {
        switch (index){
            case 0:
                Toast.makeText(getApplicationContext(),"Adicionar",Toast.LENGTH_LONG).show();
                break;
            case 1:
                Toast.makeText(getApplicationContext(),"Deletar",Toast.LENGTH_LONG).show();
                break;
            case 2:
                Toast.makeText(getApplicationContext(),"Editar",Toast.LENGTH_LONG).show();
                break;
            case 3:
                Toast.makeText(getApplicationContext(),"Salvar",Toast.LENGTH_LONG).show();
                break;
            case 4:
                Toast.makeText(getApplicationContext(),"Procurar",Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.floating:
                fabToolbarLayout.show();
                break;
            case R.id.facebook:
                Toast.makeText(getApplicationContext(),"Adicionar",Toast.LENGTH_LONG).show();
                fabToolbarLayout.hide();
                break;
            case R.id.twitter:
                Toast.makeText(getApplicationContext(),"Deletar",Toast.LENGTH_LONG).show();
                fabToolbarLayout.hide();
                break;
            case R.id.whatsapp:
                Toast.makeText(getApplicationContext(),"Editar",Toast.LENGTH_LONG).show();
                fabToolbarLayout.hide();
                break;
            case R.id.email:
                Toast.makeText(getApplicationContext(),"Salvar",Toast.LENGTH_LONG).show();
                fabToolbarLayout.hide();
                break;
            case R.id.message:
                Toast.makeText(getApplicationContext(),"Procurar",Toast.LENGTH_LONG).show();
                fabToolbarLayout.hide();
                break;
        }
    }
}
