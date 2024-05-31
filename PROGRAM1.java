import javax.swing.*;
import java.awt.*;

public class PROGRAM1 {
    public static void main(String [] args){

        JFrame frame = new JFrame(("GUI Components Example"));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        JTextField textField = new JTextField(20);
        JButton button = new JButton("Click");
        topPanel.add(textField);
        topPanel.add(button);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(1,1));
        JScrollBar scrollBar = new JScrollBar();
        leftPanel.add(scrollBar);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(1,1));
        Choice choice = new Choice();
        choice.add("Debit card");
        choice.add("Credit card");
        choice.add("Cash");
        rightPanel.add(choice);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,1));
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Shoes");
        listModel.addElement("Trousers");
        listModel.addElement("Shirt");
        JList<String> list = new JList<>(listModel);
        bottomPanel.add(new JScrollPane(list));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1,1));
        JCheckBox checkBox = new JCheckBox("Enable Feature");
        centerPanel.add(checkBox);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(rightPanel,BorderLayout.EAST);
        frame.add(bottomPanel,BorderLayout.SOUTH);
        frame.add(centerPanel,BorderLayout.CENTER);

        button.addActionListener(e-> JOptionPane.showMessageDialog(null,"Entered Text: " + textField.getText()));

        checkBox.addActionListener(e->{
            if (checkBox.isSelected()){
                JOptionPane.showMessageDialog(null,"Feature Enabled");
            } else {
                JOptionPane.showMessageDialog(null,"Feature Disabled");
            }
        });

        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
