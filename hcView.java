package alphacare;
// website help for syling url: https://www.codemiles.com/java-examples/fonts-in-java-t2831.html
/**
 *
 * @author Rodrigo
 */
import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class hcView extends JFrame {

    private JPanel objectPanel;
    private JPanel buttonPanel;

    private final hcControl hcCntrl;

    public hcView(hcControl hcCntl) {
        this.hcCntrl = hcCntl;

        alphaCareStarter();

    }

    private void alphaCareStarter() {
        setTitle("Start");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        objectPanel = new JPanel(new GridLayout(2, 1));

        ImageIcon img = new ImageIcon("healthcare.png");

        objectPanel.add(new JLabel("AlphaCare", JLabel.CENTER)).setFont(new Font("Impact", 30, 40));

        objectPanel.add(new JLabel(img, JLabel.CENTER));

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton welcomeB = new JButton("Welcome");

        welcomeB.addActionListener(event -> optionScreen());

        buttonPanel.add(welcomeB);

        setContentPane(new JPanel(new BorderLayout()));
        getContentPane().add(objectPanel, BorderLayout.BEFORE_FIRST_LINE);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

    }

    private void optionScreen() {

        setTitle("Options");
        setSize(475, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        objectPanel = new JPanel(new GridLayout(1, 1));
        objectPanel.add(new JLabel("What would you like to do today?", JLabel.CENTER));

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton records = new JButton("Get Records");
        records.addActionListener(event -> patientOptions());
        buttonPanel.add(records);


        setContentPane(new JPanel(new BorderLayout()));
        getContentPane().add(objectPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }


    private void patientOptions() {
        setTitle("Selected Records");
        setSize(320, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        String[] patientChoices = {"Today's Patients", "All Patients"};
        String[] genders = {"Male", "Female"};

        final JComboBox<String> pcChoices = new JComboBox<>(patientChoices);  // url: https://stackoverflow.com/questions/22506331/simple-dropdown-menu-in-java
        final JComboBox<String> gChoices = new JComboBox<>(genders);
        pcChoices.setVisible(true);
        gChoices.setVisible(true);

        objectPanel = new JPanel(new GridLayout(2, 2));
        objectPanel.add(new JLabel("Choose Patients", JLabel.CENTER));
        objectPanel.add(pcChoices);
        objectPanel.add(new JLabel("Choose gender", JLabel.CENTER));
        objectPanel.add(gChoices);

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton patientInfo = new JButton("Generate Records");
        patientInfo.addActionListener(event -> getRecords(pcChoices, gChoices));
        buttonPanel.add(patientInfo);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(event -> optionScreen());
        buttonPanel.add(backButton);

        setContentPane(new JPanel(new BorderLayout()));
        getContentPane().add(objectPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    private void patientRecords(String[] patientRecords) {
        setTitle("Patient Records");
        setSize(750, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        objectPanel = new JPanel(new GridLayout(10, 0));
        objectPanel.add(new JLabel("Records:", JLabel.CENTER)).setFont(new Font("Verdana", 20, 20));
        objectPanel.add(new JLabel(""));

        int x = 0;
        for (String t : patientRecords) {
            objectPanel.add(new JLabel("        • " + patientRecords[x])).setFont(new Font("Verdana", 20, 15));
            objectPanel.add(new JLabel(""));
            x++;
        }

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton returnToOptions = new JButton("Back");
        returnToOptions.addActionListener(event -> patientOptions());
        buttonPanel.add(returnToOptions);

        setContentPane(new JPanel(new BorderLayout()));
        getContentPane().add(objectPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    private void getRecords(JComboBox<String> patientGender, JComboBox<String> workouts) {

        patientRecords(hcCntrl.dataListModel.ListRecords(patientGender.getSelectedIndex(), workouts.getSelectedIndex()));

    }

  

}
