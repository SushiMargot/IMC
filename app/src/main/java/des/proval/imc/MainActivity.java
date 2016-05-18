package des.proval.imc;

import android.view.View.OnTouchListener;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
    private final String finalString = "Tu es vraiment trop gras";
    private final String defaut = "Il faut valider";
            Button envoyer = null;
    Button raz=null;
    EditText poids = null;
    EditText taille = null;

    RadioGroup group = null;

    TextView resultat = null;

    CheckBox mega = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        envoyer=(Button)findViewById(R.id.buttonCalcul);
        raz= (Button)findViewById(R.id.buttonRAZ);

        poids = (EditText)findViewById(R.id.editTextPoids);
        taille = (EditText)findViewById(R.id.editTextTaille);

        group=(RadioGroup)findViewById(R.id.radioGroup);

        resultat = (TextView)findViewById(R.id.resultat);
        mega = (CheckBox) findViewById(R.id.checkBox);
        envoyer.setOnClickListener(envoyerListener);
        raz.setOnClickListener(razListener);


    }


    // Uniquement pour le bouton "envoyer"
    private OnClickListener envoyerListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!mega.isChecked()) {
                float t =Float.valueOf( taille.getText().toString());
                float p = Float.valueOf(poids.getText().toString());

                if(t <= 0)
                    Toast.makeText(MainActivity.this, "Retourne chez ta mère manger de la soupe", Toast.LENGTH_SHORT).show();
                else {
                    if(group.getCheckedRadioButtonId() == R.id.radioCentimetre) t = t / 100;


                    t = (float)Math.pow(t, 2);
                    float imc = p / t;
                    resultat.setText("Votre IMC est " + String.valueOf(imc));
                }
            } else
                resultat.setText(finalString);
        }
    };
    private OnClickListener razListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            poids.getText().clear();
            taille.getText().clear();
            resultat.setText(defaut);
        }


        };
}