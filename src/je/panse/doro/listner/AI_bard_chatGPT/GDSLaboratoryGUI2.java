package je.panse.doro.listner.AI_bard_chatGPT;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GDSLaboratoryGUI2 extends JFrame implements ActionListener {

    private static final JTextArea inputTextArea = new JTextArea(40, 35);
    private static final JTextArea outputTextArea = new JTextArea(40, 35);
    private static final String labbardorder = """
            make table
            if parameter does not exist -> remove the row;
            Parameter Value Unit 
            using value format 
            """;
    
    private JButton[] buttons;
    
    public GDSLaboratoryGUI2() {
        setupFrame();
        setupTextAreas();
        setupButtons();
        arrangeComponents();
    }

    private void setupFrame() {
        setTitle("GDS Laboratory Data");
        setSize(1200, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setupTextAreas() {
        outputTextArea.setEditable(true);
    }

    public static void appendTextAreas(String value) {
        outputTextArea.append(value);      
    }
    
    private void setupButtons() {
        String[] buttonLabels = {"Modify", "Copy to Clipboard", "Clear Input", "Clear Output", "Clear All", "Save and Quit"};
        buttons = new JButton[buttonLabels.length];
        
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = createButton(buttonLabels[i]);
        }
    }

    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.addActionListener(this);
        return button;
    }

    private void arrangeComponents() {
        JPanel buttonPanel = new JPanel(new FlowLayout());
        for (JButton button : buttons) {
            buttonPanel.add(button);
        }

        JPanel contentPanel = new JPanel(new GridBagLayout());
        addComponent(contentPanel, new JLabel("Input Data:"), 0, 0, GridBagConstraints.NORTH);
        addComponent(contentPanel, new JScrollPane(inputTextArea), 1, 0, GridBagConstraints.BOTH);
        addComponent(contentPanel, new JLabel("Output Data:"), 2, 0, GridBagConstraints.NORTH);
        addComponent(contentPanel, new JScrollPane(outputTextArea), 3, 0, GridBagConstraints.BOTH);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 4;
        constraints.anchor = GridBagConstraints.SOUTH;
        contentPanel.add(buttonPanel, constraints);

        add(contentPanel);
    }

    private void addComponent(JPanel panel, Component comp, int x, int y, int fill) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.fill = fill;
        panel.add(comp, constraints);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Modify" -> modifyAction();
            case "Copy to Clipboard" -> copyToClipboardAction();
            case "Clear Input" -> inputTextArea.setText("");
            case "Clear Output" -> outputTextArea.setText("");
            case "Clear All" -> {
                inputTextArea.setText("");
                outputTextArea.setText("");
            }
            case "Save and Quit" -> {
	            inputTextArea.setText("");
	            outputTextArea.setText("");
	            dispose();
            }
        }
    }

    private void modifyAction() {
        String textFromInputArea = inputTextArea.getText();
        outputTextArea.append(""
        		+ "\nthe below contents are data --------------------------\n" 
        		+ textFromInputArea 
        		+ "\nthe dataset finished --------------------------\n");
        outputTextArea.append("\n" + labbardorder);
        GDSLaboratoryDataModify.main(textFromInputArea);
        copyToClipboardAction();
    }

    private void copyToClipboardAction() {
        String textToCopy = outputTextArea.getText();
        StringSelection selection = new StringSelection(textToCopy);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GDSLaboratoryGUI2 gui = new GDSLaboratoryGUI2();
            gui.setVisible(true);
        });
    }
}
