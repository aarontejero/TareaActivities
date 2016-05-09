package aaron_tejero.tareaactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Confirmar_datos extends AppCompatActivity {

    TextView nombre;
    TextView descripcion;
    TextView email;
    TextView telefono;
    TextView fecha;
    Button btneditar;
    boolean bandera=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        nombre= (TextView)findViewById(R.id.tvnombre);
        descripcion= (TextView)findViewById(R.id.tvdescripcion);
        email= (TextView)findViewById(R.id.tvcorreo);
        telefono= (TextView)findViewById(R.id.tvtelefono);
        fecha= (TextView)findViewById(R.id.tvfecha);

        nombre.setText(getIntent().getStringExtra("nombre"));
        descripcion.setText(getIntent().getStringExtra("descripcion"));
        email.setText(getIntent().getStringExtra("email"));
        telefono.setText(getIntent().getStringExtra("telefono"));
        fecha.setText(getIntent().getStringExtra("dia") + "/" + getIntent().getStringExtra("mes") + "/" + getIntent().getStringExtra("ano"));


        btneditar= (Button)findViewById(R.id.btneditar);
        btneditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = fecha.getText().toString();
                String[] parts = text.split("/");
                int dia = Integer.parseInt(parts[0]);
                int mes = Integer.parseInt(parts[1]) - 1;
                int year = Integer.parseInt(parts[2]);

                bandera = true;

                Intent intent = new Intent(Confirmar_datos.this, MainActivity.class);
                intent.putExtra("nombre", nombre.getText().toString());
                intent.putExtra("telefono", telefono.getText().toString());
                intent.putExtra("email", email.getText().toString());
                intent.putExtra("descripcion", descripcion.getText().toString());
                intent.putExtra("bandera", bandera);
                intent.putExtra("ano", year);
                intent.putExtra("mes", mes);
                intent.putExtra("dia", dia);

                startActivity(intent);


            }
        });

    }
}
