package id.sch.smktelkom_mlg.tugas01.xirpl1022.tugaspertamaku;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText nama, email;
    TextView hasil;
    RadioGroup kelas;
    Spinner jurusan;
    CheckBox membaca, melukis, design;
    Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nama = (EditText) findViewById(R.id.Nama);
        email = (EditText) findViewById(R.id.Email);
        hasil = (TextView) findViewById(R.id.tvHasil);
        kelas = (RadioGroup) findViewById(R.id.Kelas);
        jurusan = (Spinner) findViewById(R.id.Jurusan);
        membaca = (CheckBox) findViewById(R.id.checkBoxBaca);
        melukis = (CheckBox) findViewById(R.id.checkBoxLukis);
        design = (CheckBox) findViewById(R.id.checkBoxDesign);

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });
    }

    private void doClick() {
        String nm = nama.getText().toString();
        String em = email.getText().toString();
        String kls = null;
        if (kelas.getCheckedRadioButtonId() != -1) {
            RadioButton rb =
                    (RadioButton) findViewById(kelas.getCheckedRadioButtonId());
            kls = rb.getText().toString();
        }
        String jrsn = jurusan.getSelectedItem().toString();
        String hb = "\n Hobi Anda : ";
        int startlen = hb.length();
        if (membaca.isChecked()) hb += membaca.getText() + " ";
        if (melukis.isChecked()) hb += melukis.getText() + " ";
        if (design.isChecked()) hb += design.getText() + " ";
        if (hb.length() == startlen) hb += "Tidak ada pada Pilihan";

        hasil.setText("Nama Anda : " + nm + "\n Alamat Email Anda : " + em + "\n Kelas : " + kls + "\n Jurusan : "
                + jrsn + hb);
    }
}
