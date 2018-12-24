package com.example.tnyknc.mobilailehekimligi;

import android.content.Intent;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class LoginActivity extends AppCompatActivity {

    public static Kullanici loginYapanKul = new Kullanici();

    private int kullaniciSayisi = 0;

    private Kullanici[] kullanicilar;

    EditText edt_kulAdi;
    EditText edt_sifre;

    Button btn_girisYap;
    Button btn_sifreSifirla;
    Button btn_uyeOl;

    RadioButton rb_hasta;
    RadioButton rb_doktor;

    private String kulAdi;
    private String sifre;
    private String turu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        esleme();

        kullanicilar = new Kullanici[10];

        for (int i=0; i <10 ; i++) kullanicilar[i] = new Kullanici();

        btn_uyeOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uyeOl(kullanicilar[kullaniciSayisi]);
            }
        });

        btn_girisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                girisYap();
            }
        });
    }

    private  void esleme() {

        edt_kulAdi = (EditText) findViewById(R.id.edt_kullaniciAdi);
        edt_sifre = (EditText) findViewById(R.id.edt_sifre);

        btn_girisYap = (Button) findViewById(R.id.btn_girisYap);
        btn_sifreSifirla = (Button) findViewById(R.id.btn_sifreSifirla);
        btn_uyeOl = (Button) findViewById(R.id.btn_uyeOl);

        rb_doktor = (RadioButton) findViewById(R.id.rbDoktorGirisi);
        rb_hasta = (RadioButton) findViewById(R.id.rbHastaGirisi);
    }

    private void uyeOl(Kullanici kullanici) {

        veriAl();

        kullanici.setAdi(kulAdi);
        kullanici.setSifre(sifre);
        kullanici.setTur(turu);

        kullaniciSayisi++;
    }

    private void girisYap(){

        veriAl();

        for (int i = 0; i < kullaniciSayisi; i++)
        {

            if (kullanicilar[i].getAdi().equals(kulAdi) &&
                    kullanicilar[i].getSifre().equals(sifre) &&
                    kullanicilar[i].getTur().equals(turu)) {

                loginYapanKul = kullanicilar[i];

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);


            }
        }
    }

    private void veriAl() {

        if (edt_kulAdi.getText().toString() != "")
            kulAdi = edt_kulAdi.getText().toString();

        if (edt_sifre.getText().toString() != "")
            sifre = edt_sifre.getText().toString();

        if (rb_doktor.isChecked())
            turu = "doktor";

        if (rb_hasta.isChecked())
            turu = "hasta";
    }
}
