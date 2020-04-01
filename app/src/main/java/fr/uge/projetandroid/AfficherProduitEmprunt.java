package fr.uge.projetandroid;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import fr.uge.projetandroid.entities.Product;

public class AfficherProduitEmprunt extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private ImageView Imageproduit;

    private ImageButton star1;
    private ImageButton star2;
    private ImageButton star3;
    private ImageButton star4;
    private ImageButton star5;

    private TextView textView_jour;
    private TextView textView_heure;
    private TextView textView_minute;
    private TextView textView_seconde;


    private Button emprunter;
    private Button demandeEmprunt;
    private Button nouveauEmprunt;
    private Button nouvelleDemandeEmprunt;
    private Button button_dateDebut_emprunt;
    private Button button_heureDebut_emprunt;
    private Button button_dateFin_emprunt;
    private Button button_heureFin_emprunt;


    private LinearLayout layout_boutton_emprunt;
    private LinearLayout layout_saisirDate_emprunt;
    private LinearLayout layout_demande_emprunt_boutton;
    private LinearLayout layout_saisirDate_DemandeEmprunt;
    private LinearLayout layout_demande_emprunt_countdown;


    private String EVENT_DATE_TIME = "2020-03-31 05:02:00";
    private String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private LinearLayout linear_layout_jour, linear_layout_heure;
    private Handler handler = new Handler();
    private Runnable runnable;


    private int note=0;

    private Product product;
    private String date,heure;

    private DialogFragment datePickerDebutEmprunt;
    private DialogFragment datePickerFinEmprunt;
    private DialogFragment timePickerDebutEmprunt;
    private DialogFragment timePickerFinEmprunt;

    public static final int TYPE_DIALOG_FRAGMENT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_produit_emprunt);

        product = new Product();
        product.setAvailable(true);

        emprunter=(Button)findViewById(R.id.button_emprunter);
        demandeEmprunt=(Button)findViewById(R.id.button_demande_emprunt);
        nouveauEmprunt=(Button)findViewById(R.id.button_nouveau_emprunt);
        nouvelleDemandeEmprunt=(Button)findViewById(R.id.button_nouveau_DemandeEmprunt);
        button_dateDebut_emprunt=(Button)findViewById(R.id.button_dateDebut_emprunt);
        button_heureDebut_emprunt=(Button)findViewById(R.id.button_heureDebut_emprunt);
        button_dateFin_emprunt=(Button)findViewById(R.id.button_dateFin_emprunt);
        button_heureFin_emprunt=(Button)findViewById(R.id.button_heureFin_emprunt);

        Imageproduit = (ImageView) findViewById(R.id.imageView_imageAfficherProduit_emprunt);
        star1=(ImageButton)findViewById(R.id.imageButton_rating_1);
        star2=(ImageButton)findViewById(R.id.imageButton_rating_2);
        star3=(ImageButton)findViewById(R.id.imageButton_rating_3);
        star4=(ImageButton)findViewById(R.id.imageButton_rating_4);
        star5=(ImageButton)findViewById(R.id.imageButton_rating_5);

        textView_jour = (TextView)findViewById(R.id.textView_countdown_jour);
        textView_heure = (TextView)findViewById(R.id.textView_countdown_heure);
        textView_minute = (TextView)findViewById(R.id.textView_countdown_minute);
        textView_seconde = (TextView)findViewById(R.id.textView_countdown_seconde);




        layout_boutton_emprunt= findViewById(R.id.layout_boutton_emprunt);
        layout_saisirDate_emprunt= findViewById(R.id.layout_saisirDate_emprunt);
        layout_demande_emprunt_boutton= findViewById(R.id.layout_demande_emprunt_boutton);
        layout_saisirDate_DemandeEmprunt= findViewById(R.id.layout_saisirDate_DemandeEmprunt);
        layout_demande_emprunt_countdown= findViewById(R.id.layout_demande_emprunt_countdown);
        linear_layout_jour = findViewById(R.id.LinearLayout_Jour);
        linear_layout_heure = findViewById(R.id.LinearLayout_Heure);

        datePickerDebutEmprunt = new DatePickerFragment();
        datePickerFinEmprunt = new DatePickerFragment();
        timePickerDebutEmprunt = new TimePickerFragment();
        timePickerFinEmprunt = new TimePickerFragment();

        Picasso.get().load("http://makcenter.ma/uge/projetAndroid/IMG_20200329_012624_2710855663484451951.jpg")
                .resize(150, 150)
                .centerCrop()
                .error(R.drawable.ic_camera_alt_black_24dp)
                .into(Imageproduit);


        star1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setImageResource(R.drawable.star1);
                star2.setImageResource(R.drawable.star0);
                star3.setImageResource(R.drawable.star0);
                star4.setImageResource(R.drawable.star0);
                star5.setImageResource(R.drawable.star0);
                note =1;

            }
        });

        star2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setImageResource(R.drawable.star1);
                star2.setImageResource(R.drawable.star1);
                star3.setImageResource(R.drawable.star0);
                star4.setImageResource(R.drawable.star0);
                star5.setImageResource(R.drawable.star0);
                note =2;

            }
        });

        star3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setImageResource(R.drawable.star1);
                star2.setImageResource(R.drawable.star1);
                star3.setImageResource(R.drawable.star1);
                star4.setImageResource(R.drawable.star0);
                star5.setImageResource(R.drawable.star0);
                note =3;

            }
        });

        star4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setImageResource(R.drawable.star1);
                star2.setImageResource(R.drawable.star1);
                star3.setImageResource(R.drawable.star1);
                star4.setImageResource(R.drawable.star1);
                star5.setImageResource(R.drawable.star0);
                note =4;

            }
        });

        star5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setImageResource(R.drawable.star1);
                star2.setImageResource(R.drawable.star1);
                star3.setImageResource(R.drawable.star1);
                star4.setImageResource(R.drawable.star1);
                star5.setImageResource(R.drawable.star1);
                note =5;

            }
        });

        layout_saisirDate_DemandeEmprunt.setVisibility(View.GONE);
        layout_saisirDate_emprunt.setVisibility(View.GONE);

        emprunter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout_saisirDate_emprunt.setVisibility(View.VISIBLE);

            }
        });

        demandeEmprunt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout_saisirDate_DemandeEmprunt.setVisibility(View.VISIBLE);

            }
        });



        button_dateDebut_emprunt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                datePickerDebutEmprunt.show(getSupportFragmentManager(), "Datedebut");
                button_dateDebut_emprunt.setText(date);
                Log.e("DateDebut","-> "+date);
            }
        });


        button_dateFin_emprunt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                datePickerFinEmprunt.show(getSupportFragmentManager(), "Datefin");
                button_dateFin_emprunt.setText(date);
                Log.e("DateFin","-> "+date);
            }
        });

        button_heureDebut_emprunt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                timePickerDebutEmprunt.show(getSupportFragmentManager(), "Heuredebut");
                button_heureDebut_emprunt.setText(heure);
                Log.e("HeureDebut","-> "+heure);
            }
        });

        button_heureFin_emprunt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                timePickerFinEmprunt.show(getSupportFragmentManager(), "Heurefin");
                button_heureFin_emprunt.setText(heure);
                Log.e("HeureFin","-> "+heure);
            }
        });





        if(product.isAvailable()){
            layout_demande_emprunt_boutton.setVisibility(View.GONE);
            layout_demande_emprunt_countdown.setVisibility(View.GONE);


        }//product is available
        else {
            layout_boutton_emprunt.setVisibility(View.GONE);


        }//product is not available



        countDownStart();

    }



    private void countDownStart() {
        runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    handler.postDelayed(this, 1000);
                    SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
                    Date event_date = dateFormat.parse(EVENT_DATE_TIME);
                    Date current_date = new Date();
                    if (!current_date.after(event_date)) {
                        long diff = event_date.getTime() - current_date.getTime();
                        long Days = diff / (24 * 60 * 60 * 1000);
                        long Hours = diff / (60 * 60 * 1000) % 24;
                        long Minutes = diff / (60 * 1000) % 60;
                        long Seconds = diff / 1000 % 60;
                        //
                        textView_jour.setText(String.format("%02d", Days));
                        textView_heure.setText(String.format("%02d", Hours));
                        textView_minute.setText(String.format("%02d", Minutes));
                        textView_seconde.setText(String.format("%02d", Seconds));
                    } else {
                        linear_layout_jour.setVisibility(View.VISIBLE);
                        linear_layout_heure.setVisibility(View.GONE);
                        handler.removeCallbacks(runnable);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable, 0);
    }

    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(runnable);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        month++;
        date = dayOfMonth+"/"+month+"/"+year;
        Log.e("ksjrfs" , view.getAccessibilityClassName().toString());
        //Log.e("tag" , "->"+view.getTag().toString());
        Log.e("date" , "->"+date);

        if(view.equals(datePickerDebutEmprunt)){
            Log.e("dateDebut" , "->"+date);
        }
        else if (view.equals(datePickerFinEmprunt)){
            Log.e("dateFin" , "->"+date);
        }
        else {
            Log.e("za" , "->"+date);
        }
        Log.e("id" , "->"+view.getTag(1));
        FragmentManager fm = getSupportFragmentManager();
        DialogFragment df = (DialogFragment) fm.findFragmentByTag("Datedebut");
       

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        heure=hourOfDay+":"+minute;
    }
}
