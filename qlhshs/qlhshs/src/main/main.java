package main;

import view.LoginJDialog;

public class main {
    public static void main(String [] args){
//        new MainJFrame().setVisible(true);
          LoginJDialog dialog = new LoginJDialog(null, true);
          dialog.setTitle("Dang nhap");
          dialog.setResizable(false);
          dialog.setLocationRelativeTo(null);
          dialog.setVisible(true);
    }
}
