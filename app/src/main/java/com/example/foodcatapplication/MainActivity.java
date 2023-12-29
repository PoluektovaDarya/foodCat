package com.example.foodcatapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    // элементы каждого выпадающего списка
    private String[] gender = {"Кот", "Кошка"} ;
    private String[]  age = {"1-5", "6-10", "10-20"} ;
    private String[] bodyType = {"Худой", "Нормальный", "Полный"} ;
    private String[] yesNo = {"Да", "Нет"} ;
    public String selectedGender, selectedAge, selectedBodyType, selectedYesNo;
    public long itemId = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn=(Button) findViewById(R.id.btnSee);
        DatabaseHelper dbHelper = new DatabaseHelper(this);

        // представление каждого элемента списка
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gender);
        ArrayAdapter<String> ageAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, age);
        ArrayAdapter<String> bodyTypeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, bodyType);
        ArrayAdapter<String> yesNoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, yesNo);
        //шаблон от выпадающего списка
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bodyTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yesNoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // сам выпадающий список(Spinner)
        Spinner spGender =(Spinner) findViewById(R.id.spGender);
        Spinner spAge =(Spinner) findViewById(R.id.spAge);
        Spinner spBodyType =(Spinner) findViewById(R.id.spBodyType);
        Spinner spYesNo =(Spinner) findViewById(R.id.spYesNo);
        // устанавливаем адаптер для выпадающего списка
        spGender.setAdapter(genderAdapter);
        spAge.setAdapter(ageAdapter);
        spBodyType.setAdapter(bodyTypeAdapter);
        spYesNo.setAdapter(yesNoAdapter);

        // определение того, какой возраст выбрал пользователь
        spGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long l) {
                selectedGender=parentView.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spAge.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long l) {
                selectedAge=parentView.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // определение того, какое телосложение выбрал пользователь
        spBodyType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long l) {
                selectedBodyType=parentView.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // определение того, выбрал ли пользователь стерилизовано/кастрировано животное
        spYesNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long l) {
                selectedYesNo=parentView.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // для котят
                if (("1-5".equals(selectedAge)) &&("Худой".equals(selectedBodyType)) &&("Нет".equals(selectedYesNo))){
                    itemId = 1;
                    DataItem dataItem = dbHelper.getDataItemById(itemId);

                    TextView textView = findViewById(R.id.textFood);
                    textView.setText(dataItem.getName());

                    ImageView imageView = findViewById(R.id.foodImage);
                    imageView.setImageResource(R.drawable.acana);

                    TextView textViewA = findViewById(R.id.textQuantityFood);
                    if (("Кошка".equals(selectedGender))){
                        textViewA.setText("30-35 грамм 3-4 раза в день");
                    } else
                        textViewA.setText("40-45 грамм 3-4 раза в день");

                } else if  (("1-5".equals(selectedAge)) &&("Нормальный".equals(selectedBodyType)) &&("Нет".equals(selectedYesNo))) {
                    itemId = 2;

                    DataItem dataItem = dbHelper.getDataItemById(itemId);

                    TextView textView = findViewById(R.id.textFood);
                    textView.setText(dataItem.getName());

                    ImageView imageView = findViewById(R.id.foodImage);
                    imageView.setImageResource(R.drawable.go_natural);

                    TextView textViewA = findViewById(R.id.textQuantityFood);
                    if (("Кошка".equals(selectedGender))){
                        textViewA.setText("40-55 грамм 3-4 раза в день");
                    } else
                        textViewA.setText("55-60 грамм 3-4 раза в день");
                } else if (("1-5".equals(selectedAge)) &&("Полный".equals(selectedBodyType)) &&("Нет".equals(selectedYesNo))){
                    itemId = 3;

                    DataItem dataItem = dbHelper.getDataItemById(itemId);

                    TextView textView = findViewById(R.id.textFood);
                    textView.setText(dataItem.getName());

                    ImageView imageView = findViewById(R.id.foodImage);
                    imageView.setImageResource(R.drawable.grandorf);

                    TextView textViewA = findViewById(R.id.textQuantityFood);
                    if (("Кошка".equals(selectedGender))){
                        textViewA.setText("60-75 грамм 2-3 раза в день");
                    } else
                        textViewA.setText("75-85 грамм 2-3 раза в день");
                } else if (("1-5".equals(selectedAge)) &&("Худой".equals(selectedBodyType)) &&("Да".equals(selectedYesNo))){
                    itemId = 4;
                    DataItem dataItem = dbHelper.getDataItemById(itemId);

                    TextView textView = findViewById(R.id.textFood);
                    textView.setText(dataItem.getName());

                    ImageView imageView = findViewById(R.id.foodImage);
                    imageView.setImageResource(R.drawable.formina);

                    TextView textViewA = findViewById(R.id.textQuantityFood);
                    if (("Кошка".equals(selectedGender))){
                        textViewA.setText("30-35 грамм 3-4 раза в день");
                    } else
                        textViewA.setText("40-45 грамм 3-4 раза в день");
                } else if  (("1-5".equals(selectedAge)) &&("Нормальный".equals(selectedBodyType)) &&("Да".equals(selectedYesNo))) {
                    itemId = 5;

                    DataItem dataItem = dbHelper.getDataItemById(itemId);

                    TextView textView = findViewById(R.id.textFood);
                    textView.setText(dataItem.getName());

                    ImageView imageView = findViewById(R.id.foodImage);
                    imageView.setImageResource(R.drawable.blitz);

                    TextView textViewA = findViewById(R.id.textQuantityFood);
                    if (("Кошка".equals(selectedGender))){
                        textViewA.setText("40-55 грамм 3-4 раза в день");
                    } else
                        textViewA.setText("55-60 грамм 3-4 раза в день");
                } else if (("1-5".equals(selectedAge)) &&("Полный".equals(selectedBodyType)) &&("Да".equals(selectedYesNo))){
                    itemId = 6;

                    DataItem dataItem = dbHelper.getDataItemById(itemId);

                    TextView textView = findViewById(R.id.textFood);
                    textView.setText(dataItem.getName());

                    ImageView imageView = findViewById(R.id.foodImage);
                    imageView.setImageResource(R.drawable.leonardo);

                    TextView textViewA = findViewById(R.id.textQuantityFood);
                    if (("Кошка".equals(selectedGender))){
                        textViewA.setText("60-75 грамм 2-3 раза в день");
                    } else
                        textViewA.setText("75-85 грамм 2-3 раза в день");
                } else if (("6-10".equals(selectedAge)) &&("Худой".equals(selectedBodyType)) &&("Нет".equals(selectedYesNo))){
                    itemId = 7;
                    DataItem dataItem = dbHelper.getDataItemById(itemId);

                    TextView textView = findViewById(R.id.textFood);
                    textView.setText(dataItem.getName());

                    ImageView imageView = findViewById(R.id.foodImage);
                    imageView.setImageResource(R.drawable.carnilove);

                    TextView textViewA = findViewById(R.id.textQuantityFood);
                    if (("Кошка".equals(selectedGender))){
                        textViewA.setText("30-40 грамм 3-4 раза в день");
                    } else
                        textViewA.setText("40-50 грамм 3-4 раза в день");
                } else if  (("6-10".equals(selectedAge)) &&("Нормальный".equals(selectedBodyType)) &&("Нет".equals(selectedYesNo))) {
                    itemId = 8;

                    DataItem dataItem = dbHelper.getDataItemById(itemId);

                    TextView textView = findViewById(R.id.textFood);
                    textView.setText(dataItem.getName());

                    ImageView imageView = findViewById(R.id.foodImage);
                    imageView.setImageResource(R.drawable.probalance);

                    TextView textViewA = findViewById(R.id.textQuantityFood);
                    if (("Кошка".equals(selectedGender))){
                        textViewA.setText("40-55 грамм 3-4 раза в день");
                    } else
                        textViewA.setText("55-60 грамм 3-4 раза в день");
                } else if (("6-10".equals(selectedAge)) &&("Полный".equals(selectedBodyType)) &&("Нет".equals(selectedYesNo))){
                    itemId = 9;

                    DataItem dataItem = dbHelper.getDataItemById(itemId);

                    TextView textView = findViewById(R.id.textFood);
                    textView.setText(dataItem.getName());

                    ImageView imageView = findViewById(R.id.foodImage);
                    imageView.setImageResource(R.drawable.eukanuba);

                    TextView textViewA = findViewById(R.id.textQuantityFood);
                    if (("Кошка".equals(selectedGender))){
                        textViewA.setText("60-75 грамм 2-3 раза в день");
                    } else
                        textViewA.setText("75-85 грамм 2-3 раза в день");
                } else if (("6-10".equals(selectedAge)) &&("Худой".equals(selectedBodyType)) &&("Да".equals(selectedYesNo))){
                    itemId = 10;
                    DataItem dataItem = dbHelper.getDataItemById(itemId);

                    TextView textView = findViewById(R.id.textFood);
                    textView.setText(dataItem.getName());

                    ImageView imageView = findViewById(R.id.foodImage);
                    imageView.setImageResource(R.drawable.science_plan);

                    TextView textViewA = findViewById(R.id.textQuantityFood);
                    if (("Кошка".equals(selectedGender))){
                        textViewA.setText("30-40 грамм 3-4 раза в день");
                    } else
                        textViewA.setText("40-50 грамм 3-4 раза в день");

                } else if  (("6-10".equals(selectedAge)) &&("Нормальный".equals(selectedBodyType)) &&("Да".equals(selectedYesNo))) {
                    itemId = 11;

                    DataItem dataItem = dbHelper.getDataItemById(itemId);

                    TextView textView = findViewById(R.id.textFood);
                    textView.setText(dataItem.getName());

                    ImageView imageView = findViewById(R.id.foodImage);
                    imageView.setImageResource(R.drawable.brit_care);

                    TextView textViewA = findViewById(R.id.textQuantityFood);
                    if (("Кошка".equals(selectedGender))){
                        textViewA.setText("40-55 грамм 3-4 раза в день");
                    } else
                        textViewA.setText("55-60 грамм 3-4 раза в день");
                } else if (("6-10".equals(selectedAge)) &&("Полный".equals(selectedBodyType)) &&("Да".equals(selectedYesNo))){
                    itemId = 12;

                    DataItem dataItem = dbHelper.getDataItemById(itemId);

                    TextView textView = findViewById(R.id.textFood);
                    textView.setText(dataItem.getName());

                    ImageView imageView = findViewById(R.id.foodImage);
                    imageView.setImageResource(R.drawable.summit);

                    TextView textViewA = findViewById(R.id.textQuantityFood);
                    if (("Кошка".equals(selectedGender))){
                        textViewA.setText("60-75 грамм 2-3 раза в день");
                    } else
                        textViewA.setText("75-85 грамм 2-3 раза в день");
                }
                else if (("11-20".equals(selectedAge)) &&("Худой".equals(selectedBodyType)) &&("Нет".equals(selectedYesNo))){
                    itemId = 16;
                    DataItem dataItem = dbHelper.getDataItemById(itemId);

                    TextView textView = findViewById(R.id.textFood);
                    textView.setText(dataItem.getName());

                    ImageView imageView = findViewById(R.id.foodImage);
                    imageView.setImageResource(R.drawable.choice_senior);

                    TextView textViewA = findViewById(R.id.textQuantityFood);
                    if (("Кошка".equals(selectedGender))){
                        textViewA.setText("30-35 грамм 3-4 раза в день");
                    } else
                        textViewA.setText("40-45 грамм 3-4 раза в день");

                } else if  (("11-20".equals(selectedAge)) &&("Нормальный".equals(selectedBodyType)) &&("Нет".equals(selectedYesNo))) {
                    itemId = 14;

                    DataItem dataItem = dbHelper.getDataItemById(itemId);

                    TextView textView = findViewById(R.id.textFood);
                    textView.setText(dataItem.getName());

                    ImageView imageView = findViewById(R.id.foodImage);
                    imageView.setImageResource(R.drawable.hills_science_plan);

                    TextView textViewA = findViewById(R.id.textQuantityFood);
                    if (("Кошка".equals(selectedGender))){
                        textViewA.setText("40-50 грамм 3-4 раза в день");
                    } else
                        textViewA.setText("55-55 грамм 3-4 раза в день");
                } else if (("11-20".equals(selectedAge)) &&("Полный".equals(selectedBodyType)) &&("Нет".equals(selectedYesNo))){
                    itemId = 15;

                    DataItem dataItem = dbHelper.getDataItemById(itemId);

                    TextView textView = findViewById(R.id.textFood);
                    textView.setText(dataItem.getName());

                    ImageView imageView = findViewById(R.id.foodImage);
                    imageView.setImageResource(R.drawable.grandorf_rabbit_and_turkey);

                    TextView textViewA = findViewById(R.id.textQuantityFood);
                    if (("Кошка".equals(selectedGender))){
                        textViewA.setText("60-75 грамм 2-3 раза в день");
                    } else
                        textViewA.setText("75-85 грамм 2-3 раза в день");
                } else if (("11-20".equals(selectedAge)) &&("Худой".equals(selectedBodyType)) &&("Да".equals(selectedYesNo))){
                    itemId = 13;
                    DataItem dataItem = dbHelper.getDataItemById(itemId);

                    TextView textView = findViewById(R.id.textFood);
                    textView.setText(dataItem.getName());

                    ImageView imageView = findViewById(R.id.foodImage);
                    imageView.setImageResource(R.drawable.grandorf_adult_cat_sterilized);

                    TextView textViewA = findViewById(R.id.textQuantityFood);
                    if (("Кошка".equals(selectedGender))){
                        textViewA.setText("30-35 грамм 3-4 раза в день");
                    } else
                        textViewA.setText("40-45 грамм 3-4 раза в день");
                } else if  (("11-20".equals(selectedAge)) &&("Нормальный".equals(selectedBodyType)) &&("Да".equals(selectedYesNo))) {
                    itemId = 17;

                    DataItem dataItem = dbHelper.getDataItemById(itemId);

                    TextView textView = findViewById(R.id.textFood);
                    textView.setText(dataItem.getName());

                    ImageView imageView = findViewById(R.id.foodImage);
                    imageView.setImageResource(R.drawable.brit_care_cat_missy_sterilised);

                    TextView textViewA = findViewById(R.id.textQuantityFood);
                    if (("Кошка".equals(selectedGender))){
                        textViewA.setText("40-50 грамм 3-4 раза в день");
                    } else
                        textViewA.setText("55-55 грамм 3-4 раза в день");
                } else if (("11-20".equals(selectedAge)) &&("Полный".equals(selectedBodyType)) &&("Да".equals(selectedYesNo))){
                    itemId = 18;

                    DataItem dataItem = dbHelper.getDataItemById(itemId);

                    TextView textView = findViewById(R.id.textFood);
                    textView.setText(dataItem.getName());

                    ImageView imageView = findViewById(R.id.foodImage);
                    imageView.setImageResource(R.drawable.almo_nature_adult_sterilised_cat);

                    TextView textViewA = findViewById(R.id.textQuantityFood);
                    if (("Кошка".equals(selectedGender))){
                        textViewA.setText("60-70 грамм 2-3 раза в день");
                    } else
                        textViewA.setText("75-80 грамм 2-3 раза в день");
                }
            }
        });
    }
}