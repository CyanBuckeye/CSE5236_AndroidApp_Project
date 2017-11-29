package com.example.courseproject.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by andrew on 11/4/17.
 */

public class QuestionDB {
    static String[] PythonQuestion_array = {"Which of the following environment variable for Python is an alternative module search path?",
            " What is the output of print tinylist * 2 if tinylist = [123, 'john']",
            "Which of the following function of dictionary gets all the values from the dictionary?",
            "Which of the following function convert an integer to hexadecimal string in python?"};

    static int[] PythonAnswer_array = {4, 1, 3, 3};
    static String[][] PythonQuestion_choice = {{"PYTHONPATH", "PYTHONSTARTUP", "PYTHONCASEOK", "PYTHONHOME"},
            {"[123, 'john', 123, 'john']", "[123, 'john'] * 2", "Error", "None of the above."},
            {"getvalues()", "value()", "values()", "None of the above."},
            {"unichr(x)", "ord(x)", "hex(x)", "oct(x)"}
    };

    static String[] JavaQuestion_array = {
            "What is the size of byte variable?",
            "What is the size of short variable?",
            "What is the default value of byte variable?",
            "Which of the following is false about String?"
    };
    static int[] JavaAnswer_array = {1, 3, 1, 3};
    static String[][] JavaQuestion_choice = {{"8 bit", "16 bit", "32 bit", "64 bit"},
            {"8 bit", "16 bit", "32 bit", "64 bit"},
            {"0", "0.0", "null", "undefined"},
            {"String is immutable.", "String can be created using new operator.", "String is a primary data type.",
                    "None of the above."}
    };
    int type;
    public QuestionDB(int type){
        this.type = type;
    }

    public List<Integer> getIndex(){
        List<Integer> li;
        li = new ArrayList<>();
        for(int i = 0; i < 4; i++)
            li.add(i);
        Collections.shuffle(li);
        return li;
    }

    public String getQuestion(int idx){
        if(type == 0){
            return PythonQuestion_array[idx];
        }
        else{
            return JavaQuestion_array[idx];
        }
    }

    public String[] getChoices(int idx){
        if(type == 0){
            return PythonQuestion_choice[idx];
        }
        else{
            return JavaQuestion_choice[idx];
        }
    }

    public int getAnswer(int idx){
        if(type == 0){
            return PythonAnswer_array[idx];
        }
        else{
            return JavaAnswer_array[idx];
        }
    }
}
