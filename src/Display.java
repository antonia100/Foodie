import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {
    private static final String TITLE = "Foodie";
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private JPanel mainPanel;
    private JButton newEntryBtn, addNewFoodBtn;
    private JTextField foodName,gramsField, foodNameEntry, gramsFieldEntry;
    private JLabel dateLabel, totalLabel;

    public Display(){
        createDisplay();
    }

    private void createDisplay(){
        setTitle(TITLE);
        setSize(new Dimension(WIDTH, HEIGHT));
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        mainPanel.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        mainPanel.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        mainPanel.setBackground(Color.ORANGE);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        dateLabel = new JLabel();
        dateLabel.setSize(new Dimension(100,100));
        dateLabel.setText("Date :");

        totalLabel = new JLabel();
        totalLabel.setSize(new Dimension(100,100));
        totalLabel.setText("Total :");

        JPanel logNewPanel = new JPanel();
        logNewPanel.setPreferredSize(new Dimension(600, 120));
        logNewPanel.setMinimumSize(new Dimension(600, 120));
        logNewPanel.setMinimumSize(new Dimension(600, 120));
        logNewPanel.setBackground(Color.gray);
        logNewPanel.setLayout(new BoxLayout(logNewPanel, BoxLayout.LINE_AXIS));

        JLabel addLabel = new JLabel();
        addLabel.setSize(new Dimension(100,100));
        addLabel.setText("Add Entry:");

        foodNameEntry = new JTextField();
        foodNameEntry.setPreferredSize(new Dimension(200,30));
        foodNameEntry.setMinimumSize(new Dimension(200,30));
        foodNameEntry.setMaximumSize(new Dimension(200, 30));

        JLabel gramsLabel = new JLabel();
        gramsLabel.setSize(new Dimension(100,100));
        gramsLabel.setText("Grams :");

        gramsFieldEntry = new JTextField();
        gramsFieldEntry.setPreferredSize(new Dimension(80,30));
        gramsFieldEntry.setMinimumSize(new Dimension(80,30));
        gramsFieldEntry.setMaximumSize(new Dimension(80, 30));

        newEntryBtn = new JButton();
        newEntryBtn.setSize(new Dimension(100,200));
        newEntryBtn.setText("Submit");

        logNewPanel.add(addLabel);
        logNewPanel.add(foodNameEntry);
        logNewPanel.add(gramsLabel);
        logNewPanel.add(gramsFieldEntry);
        logNewPanel.add(newEntryBtn);

        mainPanel.add(dateLabel);
        mainPanel.add(totalLabel);
        mainPanel.add(logNewPanel);

        addNewFoodPanel();

        add(mainPanel);

        pack();

    }

    private void addNewFoodPanel(){
        JPanel newFoodPanel = new JPanel();
        newFoodPanel.setMaximumSize(new Dimension(600,300));
        newFoodPanel.setMaximumSize(new Dimension(600,300));
        newFoodPanel.setPreferredSize(new Dimension(600,300));
        newFoodPanel.setBackground(Color.pink);

        JLabel addLabel = new JLabel();
        addLabel.setSize(new Dimension(100,100));
        addLabel.setText("New Food:");

        foodName = new JTextField();
        foodName.setPreferredSize(new Dimension(200,30));
        foodName.setMinimumSize(new Dimension(200,30));
        foodName.setMaximumSize(new Dimension(200, 30));

        JLabel gramsLabel = new JLabel();
        gramsLabel.setSize(new Dimension(100,100));
        gramsLabel.setText("Cals/100gr :");

        gramsField = new JTextField();
        gramsField.setPreferredSize(new Dimension(80,30));
        gramsField.setMinimumSize(new Dimension(80,30));
        gramsField.setMaximumSize(new Dimension(80, 30));

        addNewFoodBtn = new JButton();
        addNewFoodBtn.setSize(new Dimension(100,200));
        addNewFoodBtn.setText("Add");

        newFoodPanel.add(addLabel);
        newFoodPanel.add(foodName);
        newFoodPanel.add(gramsLabel);
        newFoodPanel.add(gramsField);
        newFoodPanel.add(addNewFoodBtn);

        mainPanel.add(newFoodPanel);

    }


    public JTextField getFoodNameEntry() {
        return foodNameEntry;
    }

    public JTextField getGramsFieldEntry() {
        return gramsFieldEntry;
    }

    public JLabel getDateLabel() {
        return dateLabel;
    }

    public JLabel getTotalLabel() {
        return totalLabel;
    }

    public JButton getNewEntryBtn() {
        return newEntryBtn;
    }

    public JButton getAddNewFoodBtn() {
        return addNewFoodBtn;
    }

    public JTextField getFoodName() {
        return foodName;
    }

    public JTextField getGramsField() {
        return gramsField;
    }

}
