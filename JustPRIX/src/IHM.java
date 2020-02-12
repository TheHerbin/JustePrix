import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class IHM extends JDialog {
    private JPanel contentPane;
    private JButton Quitter;
    private JLabel Question;
    private JPanel start;
    private JTextField Reponse;
    private JButton Valider;
    private JLabel Fond;
    private JPanel total;
    private JButton BoutonJouer;
    private JButton restart;
    private JLabel nbrChance;
    private JButton buttonOK;
    private JButton buttonCancel;
    private Bordel bazar ;

    public IHM() {

        int reponse;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);


        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onQuitter();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onQuitter();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);



        init();
        bazar = new Bordel(5);
        bazar.initialisation();


    }

    private void init(){
        Quitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onQuitter();
            }
        });
        Valider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onValider();
            }
        });
        BoutonJouer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onJouer();
            }
        });

        restart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onRestart();
            }
        });


        Bordel bazar = new Bordel(5);



        total.setVisible(false);


    }


    private void onValider() {
        // add your code here
        recuperation​(Reponse.getText());

    }
    private void onJouer() {
        start.setEnabled(false);
        BoutonJouer.setEnabled(false);
        Fond.setEnabled(false);
        start.setVisible(false);
       total.setEnabled(true);
        Question.setEnabled(true);
        Quitter.setEnabled(true);
        Reponse.setEnabled(true);
        Valider.setEnabled(true);
        total.setVisible(true);



    }

    private void onRestart() {
        // add your code here
        init();
        bazar.initialisation();
        onJouer();
        Reponse.setText("");
        bazar.setChance(5);
        nbrChance.setText("Il vous reste 5 chances");
        Question.setText("Veuillez saisir votre réponse ici :");


    }

    private void onQuitter() {
        // add your code here if necessary
        dispose();
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        Fond = new JLabel(new ImageIcon("maxresdefault.jpg"));
        Fond.setIcon(new ImageIcon("maxresdefault.jpg"));
    }


    private void recuperation​(String recup) {


        test(recup);
        }







    private void incorect(){
        Question.setText("Ce n'est pas une réponse valide");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }


        Reponse.setText("");

        Question.setText("Veuillez rentrer votre réponse ici :");
    }

    private void test(String recup){
        ArrayList<Character> cherche = new ArrayList<>();
        for(int i=0;i<recup.length();i++){
            cherche.add(recup.charAt(i));


        }
        int nbrchi = 0;
        for (Character chiffre:cherche) {
            String pouquoi = "" + chiffre;



            if (pouquoi.equals("0") || pouquoi.equals("1") || pouquoi.equals("2") || pouquoi.equals("3") || pouquoi.equals("4") || pouquoi.equals("5") || pouquoi.equals("6") || pouquoi.equals("7") || pouquoi.equals("8") || pouquoi.equals("9")) {


                nbrchi = nbrchi +1;
                if (nbrchi == recup.length()) {
                    bazar.setReponse(Integer.parseInt(recup));
                    bRep();
                }



            } else {
                incorect();
                Question.setText("Ce n'est pas une réponse valide");

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();


                }


                break;

            }
        }


    }
    private void bRep(){
        if (bazar.comparRep() == "Vous avez gagné") {
            Reponse.setEnabled(false);
            Valider.setEnabled(false);
            Question.setText(bazar.comparRep());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //dispose();
        }
        if (bazar.getChance()>0) {
            nbrChance.setText(bazar.compteur());
            Question.setText(bazar.comparRep());
            Reponse.setText("");
        }else{
            Reponse.setEnabled(false);
            Valider.setEnabled(false);
            Question.setText("Vous avez perdu ! La réponse était : "+bazar.getRdmB());
        }
    }




}
