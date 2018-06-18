package com.quiz.mob.gpki;

import android.animation.Animator;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.File;

import static com.quiz.mob.gpki.Animation_page.collapse;
import static com.quiz.mob.gpki.Animation_page.expand;

public class MainActivity extends AppCompatActivity {

    protected int points=0;
    protected int correct=0;
    protected int wrong=0;
    private int answer[]={-10,-10,-10,-10,-10,-10,-10,-10,-10,-10,-10,-10,-10,-10,-10};
    protected int submitted[]={-10,-10,-10,-10,-10,-10,-10,-10,-10,-10,-10,-10,-10,-10,-10};
    int p,c;
    private Button option1;
    private Button option2;
    private Button option3;
    private Button option4;
    private Button previous;
    private Button next;
    private ImageView image;
    private RelativeLayout rLayout;
    private ProgressBar poBr;
    private int Question[]={-10,-10,-10,-10,-10,-10,-10,-10,-10,-10,-10,-10,-10,-10,-10};
    private int QuestionOptions[][]=new int[15][4];
    private int OperatingQuestion=0;

    DataStorage DS=new  DataStorage();
    Animation_page AP=new Animation_page();

    public int getCorrect(){
        return correct;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        option1 = (Button) findViewById(R.id.option1);
        option2 = (Button) findViewById(R.id.option2);
        option3 = (Button) findViewById(R.id.option3);
        option4 = (Button) findViewById(R.id.option4);
        previous = (Button) findViewById(R.id.previous);
        next = (Button) findViewById(R.id.next);
        image = (ImageView) findViewById(R.id.image);
        poBr = (ProgressBar) findViewById(R.id.pb);


        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(QuestionOptions[OperatingQuestion][0]==answer[OperatingQuestion] && submitted[OperatingQuestion]==-10){
                    correct++;
                    submitted[OperatingQuestion]=0;
                }
                else if(QuestionOptions[OperatingQuestion][0]==answer[OperatingQuestion] && submitted[OperatingQuestion]!=-10 && submitted[OperatingQuestion]!=0) {
                    correct++;
                    wrong--;
                    submitted[OperatingQuestion]=0;
                }
                else if(QuestionOptions[OperatingQuestion][0]!=answer[OperatingQuestion] && submitted[OperatingQuestion]==-10){
                    wrong++;
                    submitted[OperatingQuestion]=0;
                }
                else if(QuestionOptions[OperatingQuestion][0]!=answer[OperatingQuestion] && submitted[OperatingQuestion]!=0) {
                    wrong++;
                    correct--;
                    submitted[OperatingQuestion]=0;
                }
                Toast.makeText(MainActivity.this,
                        DS.getOptionsName(QuestionOptions[OperatingQuestion][0])+" pressed", Toast.LENGTH_LONG).show();
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(QuestionOptions[OperatingQuestion][1]==answer[OperatingQuestion] && submitted[OperatingQuestion]==-10){
                    correct++;
                    submitted[OperatingQuestion]=1;
                }
                else if(QuestionOptions[OperatingQuestion][1]==answer[OperatingQuestion] && submitted[OperatingQuestion]!=-10 && submitted[OperatingQuestion]!=1) {
                    correct++;
                    wrong--;
                    submitted[OperatingQuestion]=1;
                }
                else if(QuestionOptions[OperatingQuestion][1]!=answer[OperatingQuestion] && submitted[OperatingQuestion]==-10){
                    wrong++;
                    submitted[OperatingQuestion]=1;
                }
                else if(QuestionOptions[OperatingQuestion][1]!=answer[OperatingQuestion] && submitted[OperatingQuestion]!=1) {
                    wrong++;
                    correct--;
                    submitted[OperatingQuestion]=1;
                }
                Toast.makeText(MainActivity.this,
                        DS.getOptionsName(QuestionOptions[OperatingQuestion][1])+" pressed", Toast.LENGTH_LONG).show();
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(QuestionOptions[OperatingQuestion][2]==answer[OperatingQuestion] && submitted[OperatingQuestion]==-10){
                    correct++;
                    submitted[OperatingQuestion]=2;
                }
                else if(QuestionOptions[OperatingQuestion][2]==answer[OperatingQuestion] && submitted[OperatingQuestion]!=-10 && submitted[OperatingQuestion]!=2) {
                    correct++;
                    wrong--;
                    submitted[OperatingQuestion]=2;
                }
                else if(QuestionOptions[OperatingQuestion][2]!=answer[OperatingQuestion] && submitted[OperatingQuestion]==-10){
                    wrong++;
                    submitted[OperatingQuestion]=2;
                }
                else if(QuestionOptions[OperatingQuestion][2]!=answer[OperatingQuestion] && submitted[OperatingQuestion]!=2) {
                    wrong++;
                    correct--;
                    submitted[OperatingQuestion]=2;
                }
                Toast.makeText(MainActivity.this,
                        DS.getOptionsName(QuestionOptions[OperatingQuestion][2])+" pressed", Toast.LENGTH_LONG).show();
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(QuestionOptions[OperatingQuestion][3]==answer[OperatingQuestion] && submitted[OperatingQuestion]==-10){
                    correct++;
                    submitted[OperatingQuestion]=3;
                }
                else if(QuestionOptions[OperatingQuestion][3]==answer[OperatingQuestion] && submitted[OperatingQuestion]!=-10 && submitted[OperatingQuestion]!=3) {
                    correct++;
                    wrong--;
                    submitted[OperatingQuestion]=3;
                }
                else if(QuestionOptions[OperatingQuestion][3]!=answer[OperatingQuestion] && submitted[OperatingQuestion]==-10){
                    wrong++;
                    submitted[OperatingQuestion]=3;
                }
                else if(QuestionOptions[OperatingQuestion][3]!=answer[OperatingQuestion] && submitted[OperatingQuestion]!=3) {
                    wrong++;
                    correct--;
                    submitted[OperatingQuestion]=3;
                }
                Toast.makeText(MainActivity.this,
                        DS.getOptionsName(QuestionOptions[OperatingQuestion][3])+" pressed", Toast.LENGTH_LONG).show();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((OperatingQuestion-1)>0) {
                    OperatingQuestion--;
                    if (OperatingQuestion >= 0){
                        optionsExitMonumnet();
                        MonumentImage();
                    }
                }
                poBr.setProgress((OperatingQuestion)*(100/15));

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if((OperatingQuestion+1)<=14) {
                    OperatingQuestion++;
                    if (OperatingQuestion < 14 && Question[OperatingQuestion] == -10) {
                        optionsMonument();
                        optionsExitMonumnet();
                        MonumentImage();
                    } else if (OperatingQuestion < 14 && Question[OperatingQuestion] != -10) {
                        optionsExitMonumnet();
                        MonumentImage();
                    }
                    if(OperatingQuestion == 14){
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setTitle("Result");
                        alertDialog.setMessage("Total Correct question: "+getCorrect());
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                        System.exit(0);
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                    }
                }
                poBr.setProgress((OperatingQuestion)*(100/15));
                //expand.();
            }
        });
    }

    private void optionsMonument(){
        p=-10;c=0;
        while(1==1){
            p=(int)((Math.random()*15)%15);
            for(int i=0;i<15;i++){
                if(Question[i]!=p)
                    c++;
            }
            if(c==15){
                Question[OperatingQuestion]=p;
                break;
            }
            c=0;
        }
        int opts[]=DS.getOptions(p);
        QuestionOptions[OperatingQuestion][0]=opts[0];
        QuestionOptions[OperatingQuestion][1]=opts[1];
        QuestionOptions[OperatingQuestion][2]=opts[2];
        QuestionOptions[OperatingQuestion][3]=opts[3];
        answer[OperatingQuestion]=p;
    }
    private void optionsExitMonumnet(){
        option1.setText(""+DS.getOptionsName(QuestionOptions[OperatingQuestion][0]));
        option2.setText(""+DS.getOptionsName(QuestionOptions[OperatingQuestion][1]));
        option3.setText(""+DS.getOptionsName(QuestionOptions[OperatingQuestion][2]));
        option4.setText(""+DS.getOptionsName(QuestionOptions[OperatingQuestion][3]));
    }
    private void MonumentImage(){
        String pic=DS.getOptionsDir(Question[OperatingQuestion]);
        if((pic).equals("india"))
            image.setImageResource(R.drawable.india);
        else if((pic).equals("bahai"))
            image.setImageResource(R.drawable.bahai);
        else if((pic).equals("brihadishwara"))
            image.setImageResource(R.drawable.brihadishwara);
        else if((pic).equals("fatehpur"))
            image.setImageResource(R.drawable.fatehpur);
        else if((pic).equals("chhatrapati"))
            image.setImageResource(R.drawable.chhatrapati);
        else if((pic).equals("hawa"))
            image.setImageResource(R.drawable.hawa);
        else if((pic).equals("kumbhalgarh"))
            image.setImageResource(R.drawable.kumbhalgarh);
        else if((pic).equals("mahabat"))
            image.setImageResource(R.drawable.mahabat);
        else if((pic).equals("mysore"))
            image.setImageResource(R.drawable.mysore);
        else if((pic).equals("qutub"))
            image.setImageResource(R.drawable.qutub);
        else if((pic).equals("sanchi"))
            image.setImageResource(R.drawable.sanchi);
        else if((pic).equals("harmandir"))
            image.setImageResource(R.drawable.harmandir);
        else if((pic).equals("taj"))
            image.setImageResource(R.drawable.taj);
        else if((pic).equals("victoria"))
            image.setImageResource(R.drawable.victoria);
        else if((pic).equals("bara"))
            image.setImageResource(R.drawable.bara);
    }

}