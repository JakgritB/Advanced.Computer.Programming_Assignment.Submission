package boottapak.jakgrit.lab7;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/*  This program is PlayerFormV1 that extends MySimpleWindow. 
 *  
 *  the title is "Player Form V1"
 *  this program creating a window has components:
 *  - Name : (input)
 *  - Nation : (input)
 *  - Birth : (input)
 *  - Gender : (Select)
 *  - Reset and Submit button
 * 
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class PlayerFormV1 extends MySimpleWindow {
    protected JLabel nameLabel, nationLabel, birthLabel, genderLabel;
    protected JTextField nameTxtField, nationTxtField, birthTxtField;
    protected JRadioButton maleButton, femaleButton;
    protected ButtonGroup genderButtonGroup;
    protected JPanel playerInfoPanel, genderButtonPanel;
    protected int txtFieldLength = 15;

    // this is constructure to create JFrame and add title
    protected PlayerFormV1(String title) {
        super(title);
    }

    protected JPanel addGenderButtons() {
        // create ButtonGroup and gender button
        genderButtonGroup = new ButtonGroup();
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female", true);

        // create button panel and add button to panel
        genderButtonPanel = new JPanel();
        genderButtonPanel.add(maleButton);
        genderButtonPanel.add(femaleButton);

        // and add button to ButtonGroup to make it can only select once
        genderButtonGroup.add(maleButton);
        genderButtonGroup.add(femaleButton);

        return genderButtonPanel;
    }

    protected JPanel addPlayerInfoInput() {
        // create label and text field(have 1 line)
        nameLabel = new JLabel("Name:");
        nameTxtField = new JTextField(txtFieldLength);
        nationLabel = new JLabel("Nationality:");
        nationTxtField = new JTextField(txtFieldLength);
        birthLabel = new JLabel("Date of Birth (eg.,31-01-2005):");
        birthTxtField = new JTextField(txtFieldLength);
        genderLabel = new JLabel("Gender:");

        // create panel and add label,txtfield to panel
        playerInfoPanel = new JPanel();
        playerInfoPanel.add(nameLabel);
        playerInfoPanel.add(nameTxtField);
        playerInfoPanel.add(nationLabel);
        playerInfoPanel.add(nationTxtField);
        playerInfoPanel.add(birthLabel);
        playerInfoPanel.add(birthTxtField);
        playerInfoPanel.add(genderLabel);

        // call addGenderButtons method and add to panel
        addGenderButtons();
        playerInfoPanel.add(genderButtonPanel);

        // set layout
        playerInfoPanel.setLayout(new GridLayout(4, 2, 10, 5));

        return playerInfoPanel;
    }

    @Override
    protected void addComponents() {
        super.addComponents();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.add(addPlayerInfoInput(), 0);

        mainPanel.setBorder(new EmptyBorder(5, 5, 0, 5));
    }

    public static void createAndShowGUI() {
        PlayerFormV1 msw = new PlayerFormV1("Player Form V1");
        msw.addComponents();
        msw.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
