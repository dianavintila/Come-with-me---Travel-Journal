package com.dianavintila.comewithme___traveljournal.Trip;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dianavintila.comewithme___traveljournal.R;
import com.dianavintila.comewithme___traveljournal.Trip.FirebaseDatabase.TripData;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.xw.repo.BubbleSeekBar;

import java.util.Calendar;
import java.util.UUID;


public class AddTrip extends AppCompatActivity {

    public ImageView imageView;
    public Uri imageUri;

    private FirebaseStorage storage;
    private StorageReference storageReference;

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    private int year;
    private int month;
    private int day;

   private String StartDateString;
   private String EndDateString;

   private EditText nameTrip;
   private EditText nameDestination;

   private RadioGroup radioGroup;

    private TextView priceTextView;
    private TextView StartDateTextView;
    private TextView EndDateTextView;


    private BubbleSeekBar priceTrip;

    private RatingBar ratingBar;

    private Button saveTrip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);


        // find id
        nameTrip = findViewById(R.id.name_trip);
        nameDestination=findViewById(R.id.destination);
        radioGroup=findViewById(R.id.radiogroup);

        priceTrip=findViewById(R.id.price_seekbar);
        ratingBar=findViewById(R.id.ratingbar);
        imageView=findViewById(R.id.add_image);

        StartDateTextView=findViewById(R.id.tv_startdate);
        EndDateTextView=findViewById(R.id.tv_enddate);

        //storage
        storage=FirebaseStorage.getInstance();
        storageReference=storage.getReference();


        imageView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                choosePicture();
            }

        });

        saveTrip=findViewById(R.id.button_savetrip);
        saveTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = nameTrip.getText().toString().trim();
                String destination = nameDestination.getText().toString().trim();
                RadioButton radioButtonSelected= (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                String radioButtonString = (String) radioButtonSelected.getText();

                int price = priceTrip.getProgress();
                float rating = ratingBar.getRating();

                String startDate = StartDateTextView.getText().toString().trim();
                String endDate = EndDateTextView.getText().toString().trim();

                String url = imageUri.toString();

                String id = databaseReference.push().getKey();
                database = FirebaseDatabase.getInstance();
                databaseReference=database.getReference("trip");
                TripData trip = new TripData(id, name, destination, radioButtonString, price, rating, startDate, endDate, url);
                //TripData trip=new TripData(name,  destination,  radioButtonString,  price,  rating,  startDate,  endDate);
                databaseReference.setValue(trip); Toast.makeText(getApplicationContext(),"Trip saved" , Toast.LENGTH_LONG).show();



            }
        });



    }

    public void onClickStartDate(View view) {
        final Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.getTime();

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                if(month<9)
                    StartDateTextView.setText(dayOfMonth + "." +"0"+(month + 1) + "." + year);
                else
                    StartDateTextView.setText(dayOfMonth + "." + (month + 1) + "." + year);

            }
        }, year, month, day);
        datePickerDialog.show();
    }

    public void onClickEndDate(View view) {
        final Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.getTime();

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                if(month<9)
                    EndDateTextView.setText(dayOfMonth + "." +"0"+(month + 1) + "." + year);
                else
                    EndDateTextView.setText(dayOfMonth + "." + (month + 1) + "." + year);
            }
        }, year, month, day);
        datePickerDialog.show();

    }


    public void showDateTextView() {
        StartDateString = getIntent().getExtras().get("startDate").toString().trim();
        EndDateString  = getIntent().getExtras().get("endDate").toString().trim();

        StartDateTextView.setText(StartDateString);
        EndDateTextView.setText(EndDateString);
    }



    private void choosePicture() {
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK && data!=null && data.getData()!=null){
             imageUri = data.getData();
             imageView.setImageURI(imageUri);
             uploadPicture();
        }

    }

    private void uploadPicture() {

        final ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle("Uploading Image...");
        pd.show();

        final String randomKey= UUID.randomUUID().toString();
        StorageReference riversRef = storageReference.child("images/"+randomKey);

        riversRef.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        pd.dismiss();
                        Snackbar.make(findViewById(android.R.id.content),"Image Uploaded. ",Snackbar.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        pd.dismiss();
                        Toast.makeText(getApplicationContext(), "Failed to Upload", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                        double progressPercent=(100.00*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                        pd.setMessage("Progress: "+(int)progressPercent+"%");
                    }
                });
    }





    }




