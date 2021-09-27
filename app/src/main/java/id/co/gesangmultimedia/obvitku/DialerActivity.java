package id.co.gesangmultimedia.obvitku;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telecom.PhoneAccountHandle;
import android.telephony.PhoneNumberUtils;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Method;
import java.util.Objects;

public class DialerActivity extends AppCompatActivity {
    TextView tvDinas;
    TextView tvNoTelp;
    TextView tvNoHp;
    String strDinas = "";
    String strNoTelp = "";
    String strNoHp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialer);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            TelephonyManager tm=(TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        }

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CALL_PHONE)) {
                Toast.makeText(this, "Membutuhkan ijin Telepon", Toast.LENGTH_SHORT).show();
            } else {

                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        1);
            }
        }
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                Toast.makeText(this, "Membutuhkan ijin Telepon", Toast.LENGTH_SHORT).show();
            } else {

                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        1);
            }
        }
        TextView tvDinas = findViewById(R.id.tvNamaDinas);
        TextView tvNoTelp = findViewById(R.id.tvNomerDinas);
        TextView tvNoHp = findViewById(R.id.tvNoKadin);

        String strNoTelp = super.getIntent().getExtras().getString("nodinas");
        String strNoHp = super.getIntent().getExtras().getString("nowa");
        String strDinas = super.getIntent().getExtras().getString("dinas");

        tvDinas.setText(strDinas);
        tvNoHp.setText(strNoHp);
        tvNoTelp.setText(strNoTelp);

        EditText etNoTelpon = findViewById(R.id.etNoTelpon);

        ImageButton ibKantor = findViewById(R.id.ibNoDinas);
        ImageButton ibHp = findViewById(R.id.ibNoKadin);
        ImageButton ibWa = findViewById(R.id.ibWhatsapp);

        ImageButton ibTelponDinas = findViewById(R.id.ibTelpDinas);
        ibTelponDinas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ibHp.setVisibility(View.GONE);
                ibWa.setVisibility(View.GONE);
                ibKantor.setVisibility(View.VISIBLE);
                etNoTelpon.setText(strNoTelp);
            }
        });
        ImageButton ibTelponKadin = findViewById(R.id.ibTelponKadin);
        ibTelponKadin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ibHp.setVisibility(View.VISIBLE);
                ibWa.setVisibility(View.VISIBLE);
                ibKantor.setVisibility(View.GONE);
                etNoTelpon.setText(strNoHp);
            }
        });
        switch (strDinas) {
            case "Polres Cilacap": {
                ImageButton imbDinas = findViewById(R.id.ibLogoStack);
                imbDinas.setImageResource(R.drawable.polresclp);
                break;
            }
            case "Kodim 0703 Cilacap": {
                ImageButton imbDinas = findViewById(R.id.ibLogoStack);
                imbDinas.setImageResource(R.drawable.kodim);
                break;
            }
            case "Pangkalan TNI AL Cilacap": {
                ImageButton imbDinas = findViewById(R.id.ibLogoStack);
                imbDinas.setImageResource(R.drawable.lanal);
                break;
            }
            case "Kemenkumham Kab. Cialcap": {
                ImageButton imbDinas = findViewById(R.id.ibLogoStack);
                imbDinas.setImageResource(R.drawable.pengayoman);
                break;
            }
            case "Satuan Polisi Pamong Praja Kab. Cilacap": {
                ImageButton imbDinas = findViewById(R.id.ibLogoStack);
                imbDinas.setImageResource(R.drawable.satpolpp);
                break;
            }
            case "Dinas Kesehatan Kab. Cilacap": {
                ImageButton imbDinas = findViewById(R.id.ibLogoStack);
                imbDinas.setImageResource(R.drawable.dinkes);
                break;
            }
            case "Dinas Ketenagakerjaan Kab. Cilacap": {
                ImageButton imbDinas = findViewById(R.id.ibLogoStack);
                imbDinas.setImageResource(R.drawable.disnaker);
                break;
            }
            case "Dinas Perhubungan Kab. Cilacap": {
                ImageButton imbDinas = findViewById(R.id.ibLogoStack);
                imbDinas.setImageResource(R.drawable.dishub);
                break;
            }
            case "Dinas Pemadam Kebakaran Kab. Cilacap": {
                ImageButton imbDinas = findViewById(R.id.ibLogoStack);
                imbDinas.setImageResource(R.drawable.damkar);
                break;
            }
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    public void kantor(View view) {
        EditText nomerkantor = findViewById(R.id.etNoTelpon);
        Editable nomor = nomerkantor.getText();
        Intent telpon = new Intent(Intent.ACTION_CALL)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        telpon.setData(Uri.fromParts("tel", String.valueOf(nomor), null));
        final int simSlotIndex = 1; //Second sim slot

        try {
            @SuppressLint("DiscouragedPrivateApi") final Method getSubIdMethod = SubscriptionManager.class.getDeclaredMethod("getSubId", int.class);
            getSubIdMethod.setAccessible(true);
            final long subIdForSlot = ((long[]) Objects.requireNonNull(getSubIdMethod.invoke(SubscriptionManager.class, simSlotIndex)))[0];

            final ComponentName componentName = new ComponentName("com.android.phone", "com.android.services.telephony.TelephonyConnectionService");
            PhoneAccountHandle phoneAccountHandle = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                phoneAccountHandle = new PhoneAccountHandle(componentName, String.valueOf(subIdForSlot));
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                telpon.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", phoneAccountHandle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        telpon.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(telpon);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    public void hape(View view) {
        EditText noHP = findViewById(R.id.etNoTelpon);
        Editable nomor = noHP.getText();
        if(nomor.equals("")){
            Toast.makeText(this, "Nomor tidak ditemukan", Toast.LENGTH_LONG).show();
        }
        Intent telpon = new Intent(Intent.ACTION_CALL)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        telpon.setData(Uri.fromParts("tel", String.valueOf(nomor), null));
        final int simSlotIndex = 1; //Second sim slot

        try {
            @SuppressLint("DiscouragedPrivateApi") final Method getSubIdMethod = SubscriptionManager.class.getDeclaredMethod("getSubId", int.class);
            getSubIdMethod.setAccessible(true);
            final long subIdForSlot = ((long[]) Objects.requireNonNull(getSubIdMethod.invoke(SubscriptionManager.class, simSlotIndex)))[0];

            final ComponentName componentName = new ComponentName("com.android.phone", "com.android.services.telephony.TelephonyConnectionService");
            PhoneAccountHandle phoneAccountHandle = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                phoneAccountHandle = new PhoneAccountHandle(componentName, String.valueOf(subIdForSlot));
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                telpon.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", phoneAccountHandle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        telpon.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(telpon);

    }

    public void pesanwa(View view) {

        //PackageManager pm = getPackageManager();
        EditText noWa = findViewById(R.id.etNoTelpon);
        String smsNumber = noWa.getText().toString();
        //String smsNumber = "6285870009919"; // E164 format without '+' sign
        boolean isWhatsappInstalled = whatsappInstalledOrNot("com.whatsapp");
        if (isWhatsappInstalled) {

            Intent sendIntent = new Intent("android.intent.action.MAIN");
            sendIntent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
            sendIntent.putExtra("jid", PhoneNumberUtils.stripSeparators(smsNumber) + "@s.whatsapp.net");//phone number without "+" prefix

            startActivity(sendIntent);
        } else {
            Uri uri = Uri.parse("market://details?id=com.whatsapp");
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            Toast.makeText(this, "WhatsApp not Installed",
                    Toast.LENGTH_SHORT).show();
            startActivity(goToMarket);
        }
    }

    private boolean whatsappInstalledOrNot(String uri) {
        PackageManager pm = getPackageManager();
        boolean app_installed = false;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }

}