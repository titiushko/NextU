package nextu.android.curso02.unidad02.actividad07_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText campoNumero1, campoNumero2, campoResultado;
    private TextView tituloResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNumero1 = (EditText)findViewById(R.id.campo_numero1);
        campoNumero2 = (EditText)findViewById(R.id.campo_numero2);

        tituloResultado = (TextView)findViewById(R.id.titulo_resultado);
        campoResultado = (EditText)findViewById(R.id.campo_resultado);
    }

    public void botonSumar(View vista) {
        int numero1 = Integer.parseInt(campoNumero1.getText().toString());
        int numero2 = Integer.parseInt(campoNumero2.getText().toString());
        int resultado = numero1 + numero2;

        tituloResultado.setText("Resultado:");
        campoResultado.setText(String.valueOf(resultado));
    }
}
