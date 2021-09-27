package id.co.gesangmultimedia.obvitku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    String strNoTelp = "";
    String strnowa = "";
    String strDinas = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void polres(View view) {
        String strNoTelp = "0282541110";
        String strnowa = "087715090055";
        String strDinas = "Polres Cilacap";
        Intent polres = new Intent(MainActivity.this, DialerActivity.class);
        polres.putExtra("nodinas", strNoTelp);
        polres.putExtra("nowa", strnowa);
        polres.putExtra("dinas", strDinas);
        startActivity(polres);
    }

    public void kodim(View view) {
        String strNoTelp = "085870009919";
        String strnowa = "087715090055";
        String strDinas = "Kodim 0703 Cilacap";
        Intent kodim = new Intent(MainActivity.this, DialerActivity.class);
        kodim.putExtra("nodinas", strNoTelp);
        kodim.putExtra("nowa", strnowa);
        kodim.putExtra("dinas", strDinas);
        startActivity(kodim);
    }

    public void lanal(View view) {
        String strNoTelp = "085870009919";
        String strnowa = "087715090055";
        String strDinas = "Pangkalan TNI AL Cilacap";
        Intent lanal = new Intent(MainActivity.this, DialerActivity.class);
        lanal.putExtra("nodinas", strNoTelp);
        lanal.putExtra("nowa", strnowa);
        lanal.putExtra("dinas", strDinas);
        startActivity(lanal);
    }

    public void lapas(View view) {
        String strNoTelp = "085870009919";
        String strnowa = "087715090055";
        String strDinas = "Kemenkumham Kab. Cialcap";
        Intent lapas = new Intent(MainActivity.this, DialerActivity.class);
        lapas.putExtra("nodinas", strNoTelp);
        lapas.putExtra("nowa", strnowa);
        lapas.putExtra("dinas", strDinas);
        startActivity(lapas);
    }

    public void satpolpp(View view) {
        String strNoTelp = "085870009919";
        String strnowa = "087715090055";
        String strDinas = "Satuan Polisi Pamong Praja Kab. Cilacap";
        Intent satpol = new Intent(MainActivity.this, DialerActivity.class);
        satpol.putExtra("nodinas", strNoTelp);
        satpol.putExtra("nowa", strnowa);
        satpol.putExtra("dinas", strDinas);
        startActivity(satpol);
    }

    public void dinkes(View view) {
        String strNoTelp = "085870009919";
        String strnowa = "087715090055";
        String strDinas = "Dinas Kesehatan Kab. Cilacap";
        Intent dinkes = new Intent(MainActivity.this, DialerActivity.class);
        dinkes.putExtra("nodinas", strNoTelp);
        dinkes.putExtra("nowa", strnowa);
        dinkes.putExtra("dinas", strDinas);
        startActivity(dinkes);
    }

    public void naker(View view) {
        String strNoTelp = "085870009919";
        String strnowa = "087715090055";
        String strDinas = "Dinas Ketenagakerjaan Kab. Cilacap";
        Intent naker = new Intent(MainActivity.this, DialerActivity.class);
        naker.putExtra("nodinas", strNoTelp);
        naker.putExtra("nowa", strnowa);
        naker.putExtra("dinas", strDinas);
        startActivity(naker);
    }

    public void dishub(View view) {
        String strNoTelp = "085870009919";
        String strnowa = "087715090055";
        String strDinas = "Dinas Perhubungan Kab. Cilacap";
        Intent dishub = new Intent(MainActivity.this, DialerActivity.class);
        dishub.putExtra("nodinas", strNoTelp);
        dishub.putExtra("nowa", strnowa);
        dishub.putExtra("dinas", strDinas);
        startActivity(dishub);
    }

    public void damkar(View view) {
        String strNoTelp = "085870009919";
        String strnowa = "087715090055";
        String strDinas = "Dinas Pemadam Kebakaran Kab. Cilacap";
        Intent damkar = new Intent(MainActivity.this, DialerActivity.class);
        damkar.putExtra("nodinas", strNoTelp);
        damkar.putExtra("nowa", strnowa);
        damkar.putExtra("dinas", strDinas);
        startActivity(damkar);
    }
}