import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

//combined layout demo

public class PROGRAM2 {
    public static void main(String[]args){
        JFrame frame = new JFrame("Combined layout Demo");

        //Flow layout
        JPanel flowPanel = new JPanel(new FlowLayout());
        for(int i =1;i<=3;i++) {
            flowPanel.add(new JButton("Flow Button" + i));

        }
            //border layout
            JPanel borderPanel= new JPanel(new BorderLayout());
            borderPanel.add(new JButton("North"),BorderLayout.NORTH);
            borderPanel.add(new JButton("South"),BorderLayout.SOUTH);
            borderPanel.add(new JButton("East"),BorderLayout.EAST);
            borderPanel.add(new JButton("West"),BorderLayout.WEST);
            borderPanel.add(new JButton("Center"),BorderLayout.CENTER);


            //Grid layout
            JPanel gridPanel = new JPanel(new GridLayout(2,3));

            for(int i=1;i<=6;i++){
                gridPanel.add(new JButton("Grid Button"+1));
            }

            //GridBag layout
            JPanel gridBagPanel = new JPanel(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            for(int i=0;i<3;i++){
                c.gridx = i;
                c.gridy = i;
                gridBagPanel.add(new JButton("GridBag Button"+(i+1)),c);
            }

            //card layout
            JPanel cardPanel = new JPanel(new CardLayout());
            JButton card1 = new JButton("Card 1");
            JButton card2 = new JButton("Card 2");
            JButton card3 = new JButton("Card 3");
            cardPanel.add(card1, "Card1");
            cardPanel.add(card2, "Card2");
            cardPanel.add(card3, "Card3");

            ActionListener listener = e->{
                CardLayout cl = (CardLayout) (cardPanel.getLayout());
                cl.next(cardPanel);
            };

            card1.addActionListener(listener);
            card2.addActionListener(listener);
            card3.addActionListener(listener);

            //add panels to the frame
            frame.setLayout(new GridLayout(2,3));
            frame.add(flowPanel);
            frame.add(borderPanel);
            frame.add(gridPanel);
            frame.add(gridBagPanel);
            frame.add(cardPanel);

            frame.setSize(800,400);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setVisible(true);

        }
    }

