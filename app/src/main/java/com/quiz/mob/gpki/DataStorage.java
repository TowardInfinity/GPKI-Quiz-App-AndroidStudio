package com.quiz.mob.gpki;
import java.math.*;

public class DataStorage {

    private final String options[]={
            "Bara Imambara, Lucknow",
            "Bahai Temple, Delhi",
            "Brihadishwara Temple, Thanjavur",
            "Fatehpur Sikri, Agra",
            "Chhatrapati Shivaji Terminus, Mumbai",
            "Hawa Mahal, Jaipur",
            "India Gate, Delhi",
            "Kumbhalgarh Fort, Rajasthan",
            "Mahabat Maqbara, Junagadh",
            "Mysore Palace, Mysore",
            "Qutub Minar, Delhi",
            "Sanchi Stupa, Sanchi",
            "Harmandir Sahib, Amritsar",
            "Taj Mahal, Agra",
            "Victoria Memorial, Kolkata"
    };
    private final String options_direct[]={
            "bara",
            "bahai",
            "brihadishwara",
            "fatehpur",
            "chhatrapati",
            "hawa",
            "india",
            "kumbhalgarh",
            "mahabat",
            "mysore",
            "qutub",
            "sanchi",
            "harmandir",
            "taj",
            "victoria"
    };
    String getOptionsName(int i){
        return options[i];
    }
    String getOptionsDir(int i){
        return options_direct[i];
    }

    int[] getOptions(int ind){
        int opts[]={-10,-10,-10,-10};
        int a=(int) ((Math.random()*10)%4);
        int p=-10,i=1,c=0;
        opts[a]=ind;
        for(i=0;i<4;i++){
            if(i!=a) {
                while (1 == 1) {
                    p = (int) ((Math.random() * 15) % 15);
                    for (int j = 0; j < 4; j++) {
                        if (p != opts[j])
                            c++;
                    }
                    if (c == 4)
                        break;
                    else
                        c = 0;
                }
                if (p != ind)
                    opts[i] = p;
            }
        }
        return opts;
    }
}
