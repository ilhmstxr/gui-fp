
package gui_fp;


public class Gui_FP {

   
    public static void main(String[] args) {
        Login lg = new Login();
        lg.setVisible(true);
        lg.pack();
        lg.setLocationRelativeTo(null);
        lg.setDefaultCloseOperation(Login.EXIT_ON_CLOSE);
    }
    
}
