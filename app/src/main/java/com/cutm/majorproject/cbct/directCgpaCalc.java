    package com.cutm.majorproject.cbct;

    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;
    import android.widget.Toast;

    import androidx.appcompat.app.AppCompatActivity;

    public class directCgpaCalc extends AppCompatActivity {

        private EditText cgpaEdit;
        private EditText totalCreditEdit;
        private EditText gradeEdit;
        private EditText creditEdit;

        private Button add;
        private Button calc;
        private Button reset;

        private TextView cgpaText;
        private TextView courseText;

        private int i = 0;
        private double sumGrade = 0;
        private double sumCredit = 0;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_direct_cgpa_calc);

            cgpaEdit = findViewById(R.id.cgpaEditTextId);
            totalCreditEdit = findViewById(R.id.totalCreditEarnedEditTextId);
            gradeEdit = findViewById(R.id.gradeEditTextId);
            creditEdit = findViewById(R.id.CreditEditTextId);

            add = findViewById(R.id.addButtonId);
            calc = findViewById(R.id.calculateButtonId);
            reset = findViewById(R.id.resetButtonId);

            cgpaText = findViewById(R.id.cgpaTextViewId);
            courseText = findViewById(R.id.addedCourseTextViewId);


            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try{
                        if(Double.parseDouble(creditEdit.getText().toString())<=10
                                && Double.parseDouble(creditEdit.getText().toString())>=1) {
                            if (Double.parseDouble(gradeEdit.getText().toString()) <= 10
                                    && Double.parseDouble(gradeEdit.getText().toString()) >= 0) {

                                sumGrade = sumGrade + (Double.parseDouble(gradeEdit.getText().toString()) * Double.parseDouble(creditEdit.getText().toString()));
                                sumCredit = sumCredit + Double.parseDouble(creditEdit.getText().toString());
                                i++;
                                Toast.makeText(com.cutm.majorproject.cbct.directCgpaCalc.this, "Added", Toast.LENGTH_SHORT).show();
                                courseText.setText(courseText.getText()+"\nCourse "+i+":\n"
                                        +"Grade: "+gradeEdit.getText().toString()+" Credit: "+creditEdit.getText().toString()+"\n");
                                gradeEdit.getText().clear();


                            }
                            else {
                                Toast.makeText(com.cutm.majorproject.cbct.directCgpaCalc.this, "Enter Correct Values", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(com.cutm.majorproject.cbct.directCgpaCalc.this, "Enter Correct Values", Toast.LENGTH_SHORT).show();
                        }
                    }

                    catch (Exception e){
                        Toast.makeText(com.cutm.majorproject.cbct.directCgpaCalc.this, "Enter  Values", Toast.LENGTH_SHORT).show();
                    }
            }
            });

            calc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try{
                        if(Double.parseDouble(cgpaEdit.getText().toString())<=10 && Double.parseDouble(cgpaEdit.getText().toString())>=0){
                            sumGrade = sumGrade + (Double.parseDouble(cgpaEdit.getText().toString())*Double.parseDouble(totalCreditEdit.getText().toString()));
                            sumCredit = sumCredit + Double.parseDouble(totalCreditEdit.getText().toString());

                            double result = sumGrade/sumCredit;

                            cgpaText.setText(String.format("CGPA is: %.3f" ,  result));
                        }

                        else{
                            Toast.makeText(com.cutm.majorproject.cbct.directCgpaCalc.this, "Enter Correct CGPA", Toast.LENGTH_SHORT).show();
                        }
                    }

                    catch (Exception e){
                        Toast.makeText(com.cutm.majorproject.cbct.directCgpaCalc.this, "Enter  Values", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            reset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    i = 0;
                    sumCredit = 0;
                    sumGrade = 0;
                    cgpaText.setText("");
                    courseText.setText("");

                    cgpaEdit.getText().clear();
                    totalCreditEdit.getText().clear();
                    gradeEdit.getText().clear();
                    creditEdit.getText().clear();

                    Toast.makeText(com.cutm.majorproject.cbct.directCgpaCalc.this, "Reseted", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }