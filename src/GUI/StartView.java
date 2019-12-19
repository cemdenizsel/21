package GUI;

import javax.swing.*;
import java.awt.*;

public class StartView extends JPanel {

   public StartView() {

       JDialog.setDefaultLookAndFeelDecorated(true);
       int response = JOptionPane.showConfirmDialog(null, "Are you older than 18 years old?", "Validation",
               JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
       if (response == JOptionPane.NO_OPTION) {
           System.exit(0);
       } else if (response == JOptionPane.YES_OPTION) {
           System.out.println();
       } else if (response == JOptionPane.CLOSED_OPTION) {
           System.exit(0);
       }
   }
   }


