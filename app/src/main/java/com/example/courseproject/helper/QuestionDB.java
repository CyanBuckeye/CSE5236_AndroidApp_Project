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

    static String[] LinuxQuestion_array = {"The dmesg command", "The command “mknod myfifo b 4 16”",
    "Which command is used to set terminal IO characteristic?", "Which command is used to record a user login session in a file"};
    static int[] LinuxAnswer_array = {3, 1, 4, 3};
    static String[][] LinuxQuestion_choice = {{"Shows user login logoff attempts",
            "Shows the syslog file for info messages",
            "kernel log messages",
            "Shows the daemon log messages"},
            {"Will create a block device if user is root",
             "Will create a block device for all users",
             "Will create a FIFO if user is not root",
             "None of the mentioned"},
            {"tty", "ctty", "ptty", "stty"},
            {"macro", "read", "script", "none of the mentioned"}
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
        if(type == 1){
            return JavaQuestion_array[idx];
        }
        if(type == 2){
            return LinuxQuestion_array[idx];
        }

        return new String();
    }

    public String[] getChoices(int idx){
        if(type == 0){
            return PythonQuestion_choice[idx];
        }
        if(type == 1){
            return JavaQuestion_choice[idx];
        }
        if(type == 2){
            return LinuxQuestion_choice[idx];
        }
        return null;
    }

    public int getAnswer(int idx){
        if(type == 0){
            return PythonAnswer_array[idx];
        }
        if(type == 1){
            return JavaAnswer_array[idx];
        }
        if(type == 2){
            return LinuxAnswer_array[idx];
        }
        return -1;
    }
}
