package staff;

import IOtimer.userDetector;
import java.io.FileNotFoundException;
import java.io.IOException;
import static staff.TUI_register.*;
import user.user;
/**
 * The check layer.
 * This class is mainly to check the legality of the user's input
 * @author group 107
 * @version 4.0
 */
public class registerFunction {
    /**
     * This method is called when the input is to be checked and give the corresponding tips after checking
     */
    public void check(){
        boolean flag = true;
        //Check if the name is empty or more than 20 digits.
        user u=new user(text_email.getText(),text_name.getText(),text_id.getText());
        if (text_name.getText().length() > 20 ) {
            label_namenote.setText("20 chars limited");
            flag = false;
        }
        else if (text_name.getText().length() == 0){
            label_namenote.setText("Empty");
            flag = false;
        }
        //Check if the student number is exactly nine figures.
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
        //Check if the mailbox format matches ***@***
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
                new writeUserInfo(u.getName(),u.getID(),u.getEmail());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            text_id.setText("");
            text_name.setText("");
            text_email.setText("");
        }
    }

    /**
     *Clear the content of textfield.
     */
    public void clear(){
        text_id.setText("");
        text_name.setText("");
        text_email.setText("");
    }
}
