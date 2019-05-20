package staff;

import IOtimer.userDetector;
import java.io.FileNotFoundException;
import java.io.IOException;
import static staff.TUI_register.*;

public class registerFunction {
    public void check(){
        boolean flag = true;
        if (text_name.getText().length() > 20 ) {
            label_namenote.setText("20 chars limited");
            flag = false;
        }
        else if (text_name.getText().length() == 0){
            label_namenote.setText("Empty");
            flag = false;
        }
        else
            label_namenote.setText("Correct");
        if (text_id.getText().length() != 9) {
            label_idnote.setText("Only 9 numbers allowed");
            flag = false;
        }
        else {
            label_idnote.setText("Correct");
            for (int i = 0; i < text_id.getText().length(); i++) {
                int chr = text_id.getText().charAt(i);
                if ((chr > 57 || chr < 48)) {
                    label_idnote.setText("Only 9 numbers allowed");
                    flag = false;
                    break;
                }
            }
        }
        if ((text_email.getText().indexOf("@") + 1 < text_email.getText().length()) && text_email.getText().indexOf("@") > 0)
            label_emailnote.setText("Correct");
        else {
            label_emailnote.setText("Format:***@***");
            flag = false;
        }
        if (label_idnote.getText().equals("Correct")) {
            userDetector judgement = new userDetector();
            try {
                label_idnote.setText(judgement.useridRegister(text_id.getText()));
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }
        if(label_idnote.getText()=="ID already exist")
            flag=false;
        if (flag == true) {
            try {
                new Write_user_info(text_name.getText(), text_id.getText(), text_email.getText());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            text_id.setText("");
            text_name.setText("");
            text_email.setText("");
        }
    }
    public void clear(){
        text_id.setText("");
        text_name.setText("");
        text_email.setText("");
    }
}
