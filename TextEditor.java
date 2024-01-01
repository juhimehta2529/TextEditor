package TextEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
public class TextEditor{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Text Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 570);

        JTextField textField = new JTextField(20);
        JButton insertButton = new JButton("Insert");
        JButton clearButton = new JButton("Clear");
        JButton undoButton = new JButton("Undo");
        JButton redoButton = new JButton("Redo");
        JButton boldButton = new JButton("Bold");
        JButton sizeButton = new JButton("Size");

        insertButton.setBackground(new Color(128, 191, 255)); 
        undoButton.setBackground(new Color(255, 128, 128));   
        redoButton.setBackground(new Color(128, 255, 128));  
        boldButton.setBackground(new Color(255, 128, 255));   
        sizeButton.setBackground(new Color(255, 204, 102));  
        clearButton.setBackground(new Color(102, 178, 255));

        JTextArea textArea = new JTextArea(28, 55);
        textArea.setEditable(false);
        textArea.setForeground(Color.red);
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        
        textArea.setBackground(new Color(240, 240, 240));
        textField.setBackground(new Color(240, 240, 240)); 

        Stack<String> insertedTextStack = new Stack<>();
        Stack<String> undoneTextStack = new Stack<>(); 
        frame.setLayout(new FlowLayout());
        
        frame.add(clearButton);
        frame.add(undoButton);
        frame.add(redoButton);
        frame.add(boldButton);
        frame.add(sizeButton);
        frame.add(insertButton);
        frame.add(textField);

        frame.add(new JScrollPane(textArea));

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = textField.getText();

                if (!inputText.isEmpty()) {
                    textArea.append(inputText + "\n"); 
                    insertedTextStack.push(inputText);
                    undoneTextStack.clear();
                    textField.setText("");
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                insertedTextStack.clear();
                undoneTextStack.clear();
            }
        });

        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if (!insertedTextStack.isEmpty()) {
                    String undoneText = insertedTextStack.pop();
                    undoneTextStack.push(undoneText);
                    textArea.setText("");
                    for (String text : insertedTextStack) {
                        textArea.append(text + "\n");
                    }
                }
            }
        });

        redoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!undoneTextStack.isEmpty()) {
                    String redoneText = undoneTextStack.pop();
                    insertedTextStack.push(redoneText);
                    textArea.append(redoneText + "\n");
                }
            }
        });

        boldButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Font currentFont = textArea.getFont();
                Font boldFont = new Font(currentFont.getFontName(), Font.BOLD, currentFont.getSize());
                textArea.setFont(boldFont);
            }
        });

        sizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = {"12", "14", "18"};
                String selectedSize = (String) JOptionPane.showInputDialog(
                        frame,
                        "Select the font size:", 
                        "Font Size", 
                        JOptionPane.PLAIN_MESSAGE, 
                        null,
                        options,
                        "14"); 
                if (selectedSize != null) {  
                    int fontSize = Integer.parseInt(selectedSize);
                    textArea.setFont(new Font("Arial", Font.PLAIN, fontSize));
                }
            }
        });

        frame.getContentPane().setBackground(new Color(220, 220, 220)); 
        frame.setVisible(true);
    }
}

