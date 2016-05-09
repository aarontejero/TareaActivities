package aaron_tejero.tareaactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity {

    private Button btnsiguiente;
    private android.support.design.widget.TextInputEditText nombre;
    private android.support.design.widget.TextInputEditText telefono;
    private android.support.design.widget.TextInputEditText email;
    private android.support.design.widget.TextInputEditText descripcion;
    private DatePicker fecha;
    private boolean bandera=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsiguiente=(Button)findViewById(R.id.btnsiguiente);
        nombre= (android.support.design.widget.TextInputEditText) findViewById(R.id.camponombre);
        telefono= (android.support.design.widget.TextInputEditText) findViewById(R.id.campotelefono);
        email= (android.support.design.widget.TextInputEditText) findViewById(R.id.campoemail);
        descripcion= (android.support.design.widget.TextInputEditText) findViewById(R.id.campodescripcion);
        fecha=(DatePicker)findViewById(R.id.dtpfecha);

        bandera= getIntent().getBooleanExtra("bandera",false);
        if (bandera==true)  {

            int ano= ((int) getIntent().getIntExtra("ano", 0));
            int mes= ((int) getIntent().getIntExtra("mes", 0));
            int dia= ((int) getIntent().getIntExtra("dia", 0));
            Log.i("dia", Integer.toString(dia));
            Log.i("mes", Integer.toString(mes));
            Log.i("año", Integer.toString(ano));
            fecha.updateDate(ano,mes,dia);
            nombre.setText(getIntent().getStringExtra("nombre"));
            descripcion.setText(getIntent().getStringExtra("descripcion"));
            email.setText(getIntent().getStringExtra("email"));
            telefono.setText(getIntent().getStringExtra("telefono"));
        }


        btnsiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new  Intent(MainActivity.this,Confirmar_datos.class);
                intent.putExtra("nombre",nombre.getText().toString());
                intent.putExtra("telefono", telefono.getText().toString());
                intent.putExtra("email", email.getText().toString());
                intent.putExtra("descripcion", descripcion.getText().toString());
                intent.putExtra("ano",Integer.toString(fecha.getYear()));
                intent.putExtra("mes",Integer.toString(fecha.getMonth()+1));
                intent.putExtra("dia",Integer.toString(fecha.getDayOfMonth()));
                startActivity(intent);
            }
        });




    }
}
