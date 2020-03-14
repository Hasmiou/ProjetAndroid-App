package fr.uge.projetandroid;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import fr.uge.projetandroid.entities.Product;

public class AjouterProduit extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerEtat;
    private Spinner spinnerCategorie;
    private Spinner spinnerType;
    private Product product;
    private EditText editTextNom;
    private EditText editTextPrix;
    private EditText editTextDescrition;
   // private Button buttonUploadImage;
    private ImageButton buttonUploadImage;
    private Button buttonAjouter;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_produit);

        product = new Product();

        spinnerEtat = (Spinner) findViewById(R.id.spinner_ajouterProduit_etat);
        spinnerCategorie = (Spinner) findViewById(R.id.spinner_ajouterProduit_categorie);
        spinnerType  = (Spinner) findViewById(R.id.spinner_ajouterProduit_type);
        editTextNom = (EditText)  findViewById(R.id.editText_ajouterProduit_nom);
        editTextPrix = (EditText)  findViewById(R.id.editText_ajouterProduit_prix);
        editTextDescrition = (EditText)  findViewById(R.id.editText_ajouterProduit_description);
        buttonUploadImage = (ImageButton)  findViewById(R.id.button_ajouterProduit_photo);
        buttonAjouter = (Button)  findViewById(R.id.button_ajouterproduit_ajouter);


        ArrayAdapter<CharSequence> adapterEtat = ArrayAdapter.createFromResource(this,
                R.array.etat_array, android.R.layout.simple_spinner_item);
        adapterEtat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEtat.setAdapter(adapterEtat);
        spinnerEtat.setOnItemSelectedListener(this);



        ArrayAdapter<CharSequence> adapterCategorie = ArrayAdapter.createFromResource(this,
                R.array.categorie_array, android.R.layout.simple_spinner_item);
        adapterCategorie.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategorie.setAdapter(adapterCategorie);
        spinnerCategorie.setOnItemSelectedListener(this);


        ArrayAdapter<CharSequence> adapterType = ArrayAdapter.createFromResource(this,
                R.array.type_bibliotheque_array, android.R.layout.simple_spinner_item);
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerType.setAdapter(adapterType);
        spinnerType.setOnItemSelectedListener(this);


        spinnerEtat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CharSequence charSequence = (CharSequence) parent.getItemAtPosition(position);
                Log.e("etat",charSequence.toString());
                product.setState(charSequence.toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CharSequence charSequence = (CharSequence) parent.getItemAtPosition(position);
                Log.e("type",charSequence.toString());
                product.setType(charSequence.toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinnerCategorie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CharSequence charSequence = (CharSequence) parent.getItemAtPosition(position);
                String categrorie = charSequence.toString();

                product.setCategory(categrorie);

                System.out.println("Item : " + charSequence.toString());
                Log.e("categorie",charSequence.toString());


                if(categrorie.equals("Bibliotheque")){
                    ArrayAdapter<CharSequence> adapterType = ArrayAdapter.createFromResource(AjouterProduit.this,
                            R.array.type_bibliotheque_array, android.R.layout.simple_spinner_item);
                    adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerType.setAdapter(adapterType);
                   // spinnerType.setOnItemSelectedListener(AjouterProduit.this);

                }
                else if(categrorie.equals("Electronique")){
                    ArrayAdapter<CharSequence> adapterType = ArrayAdapter.createFromResource(AjouterProduit.this,
                            R.array.type_electronique_array, android.R.layout.simple_spinner_item);
                    adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerType.setAdapter(adapterType);
                   // spinnerType.setOnItemSelectedListener(AjouterProduit.this);

                }
                else if(categrorie.equals("Mode et vetements")){
                    ArrayAdapter<CharSequence> adapterType = ArrayAdapter.createFromResource(AjouterProduit.this,
                            R.array.type_modevetement_array, android.R.layout.simple_spinner_item);
                    adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerType.setAdapter(adapterType);
                    //spinnerType.setOnItemSelectedListener(AjouterProduit.this);

                }
                else if(categrorie.equals("Musique")){
                    ArrayAdapter<CharSequence> adapterType = ArrayAdapter.createFromResource(AjouterProduit.this,
                            R.array.type_music_array, android.R.layout.simple_spinner_item);
                    adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerType.setAdapter(adapterType);
                    //spinnerType.setOnItemSelectedListener(AjouterProduit.this);

                }
                else if(categrorie.equals("Accessoires")){
                    ArrayAdapter<CharSequence> adapterType = ArrayAdapter.createFromResource(AjouterProduit.this,
                            R.array.type_accessoire_array, android.R.layout.simple_spinner_item);
                    adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerType.setAdapter(adapterType);
                    //spinnerType.setOnItemSelectedListener(AjouterProduit.this);

                }
                else if(categrorie.equals("Autre")){
                    ArrayAdapter<CharSequence> adapterType = ArrayAdapter.createFromResource(AjouterProduit.this,
                            R.array.type_autre_array, android.R.layout.simple_spinner_item);
                    adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerType.setAdapter(adapterType);
                   // spinnerType.setOnItemSelectedListener(AjouterProduit.this);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        buttonAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product.setName(editTextNom.getText().toString());
                product.setPrice(Double.parseDouble(editTextPrix.getText().toString()));
                product.setDescription(editTextDescrition.getText().toString());
                new AjouterProduit.AddProductTask().execute();

            }
        });


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) { }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



    private class AddProductTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(AjouterProduit.this);
            pDialog.setMessage("Ajout en cours...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            String urlString = "http://uge-webservice.herokuapp.com/api/product/";
            OutputStream out = null;

            try {
                URL url = new URL(urlString);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("POST");
                urlConnection.setRequestProperty("Content-Type","application/json");
                out = new BufferedOutputStream(urlConnection.getOutputStream());

                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
                writer.write(product.toJson());
                writer.flush();
                writer.close();
                out.close();
                Log.e("produit1",product.toJson());
                urlConnection.connect();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                Log.e("Erreur",e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();


            Log.e("produit2",product.toJson());


        }

    }
}
