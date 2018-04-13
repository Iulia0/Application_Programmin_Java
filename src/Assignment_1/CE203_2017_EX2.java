package Assignment_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class CE203_2017_EX2 extends JFrame {

    JPanel bottom, center, top; // Jpanels positioned accordingly
    // add word to the list; display Words, Search word, remove last occurrence of a word, remove all occurrences of a word, clear the list
    JButton addWord, displayWords, searchWord, removeLastOccurrence, removeAllOccurrences, clearList;
    JTextField input, message; // input text field for user, message filed non-editable to display appropriate messages
    JTextArea result; // non-editable, used to display actions triggered by buttons
    List<String> storeWords = new LinkedList<String>(); // list for storing the words

    CE203_2017_EX2() {
        bottom = new JPanel();
        center = new JPanel();
        top = new JPanel();

        Button_Handler handle = new Button_Handler(this);

        addWord = new JButton("Add");
        displayWords = new JButton("Display");
        searchWord = new JButton("Search");
        removeLastOccurrence = new JButton("Remove last occurrence");
        removeAllOccurrences = new JButton("Remove all occurrences");
        clearList = new JButton("Clear list");

        addWord.addActionListener(handle);
        displayWords.addActionListener(handle);
        searchWord.addActionListener(handle);
        removeLastOccurrence.addActionListener(handle);
        removeAllOccurrences.addActionListener(handle);
        clearList.addActionListener(handle);

        JLabel prompt = new JLabel("Press one of the top buttons for an action");

        top.add(addWord);
        top.add(displayWords);
        top.add(searchWord);
        top.add(removeLastOccurrence);
        top.add(removeAllOccurrences);
        top.add(clearList);

        input = new JTextField(30);
        bottom.add(prompt);
        bottom.add(input);

        message = new JTextField(40);
        message.setHorizontalAlignment(JTextField.CENTER);
        message.setEditable(false);
        center.add(message, BorderLayout.PAGE_START);

        result = new JTextArea(25,50);
        result.setEditable(false);
        center.add(result, BorderLayout.CENTER);

        add(top, BorderLayout.NORTH);
        add(bottom, BorderLayout.SOUTH);
        add(center, BorderLayout.CENTER);
        setTitle("Iulia Petria, 1601159");
        setSize(800, 600);
    }
    // actions for buttons
    class Button_Handler implements ActionListener {
        CE203_2017_EX2 theApp;

        Button_Handler(CE203_2017_EX2 theApp) {
            this.theApp = theApp;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // add word to the list + check that the input is a valid word
            if (e.getSource() == addWord) {
                String userInput = input.getText();
                if (userInput.matches("!@#$%^&*()-|\'>.?/`~=:';\"+[]{]")  || checkFirstChar(userInput)){
                    message.setText("The word could not be added to the list as it is not a valid word");
                }
                else{
                    storeWords.add(userInput);
                    message.setText("The word \"" + userInput + "\" has been added");
                }
            }
            // display all words ending with user's inputted letter
            if (e.getSource() == displayWords) {
                String userInput = input.getText();
                if (userInput != null && !userInput.isEmpty()){
                message.setText("You are now displaying all the words in the list finishing with \"" + input.getText().charAt(0) + "\"");
                findLastWord(storeWords);
            }
            else{
                    message.setText("No text has been inputted");
                }
            }
            // search for word in list and display no of occurrences and positions
            if (e.getSource() == searchWord) {
                String userInput = input.getText();
                if (userInput != null && !userInput.isEmpty()) {
                    message.setText(null);
                    findOccurrences(storeWords);
                } else {
                    result.setText(null);
                    result.append("The total number of words in the list is: " + storeWords.size());
                }
            }
            // remove last occurrence of word
            if (e.getSource() == removeLastOccurrence) {
                try {
                    deleteLast(storeWords);
                    message.setText("You have successfully removed the word");
                }
                catch (IndexOutOfBoundsException e1) {
                    result.setText(null);
                    message.setText("No such word in the list");
                }

            }
            // remove all occurrences of word
            if (e.getSource() ==removeAllOccurrences){
                result.setText(null);
                storeWords.removeAll(Collections.singleton(input.getText()));
                message.setText("You have successfully removed all occurrences of the specified word");
            }
            // clear list
            if (e.getSource() == clearList){
                storeWords.clear();
                message.setText("The list is now empty");
            }
        }

    }
    // display all words ending with user's inputted letter
    private void findLastWord(List<String> myList){
        result.setText(null);
        String userInput = input.getText().toLowerCase();
        for (String word : myList){
            if (word.charAt(word.length() - 1) == userInput.charAt(0)){
                result.append(word + "\n" );
            }
        }
    }
    // search for word in the list and display no of occurrences and positions
    private void findOccurrences (List<String> myList){
        result.setText(null);
        String userInput = input.getText().toLowerCase();
        List <Integer> temp = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < myList.size(); i++){
            if(myList.get(i).equals(userInput)){
                temp.add(i);
                count++;
            }
        }
        String toBeAdded = (" The word \"" + userInput + "\" occurs " + count + " times, having the following positions: " + temp );
        result.append(toBeAdded);
    }
    // delete last entry of word
    public void deleteLast (List <String> myList){
        String userInput = input.getText().toLowerCase();
        int position = myList.lastIndexOf(userInput);
        myList.remove(position);
    }
    // if input is empty, or first character not a letter, return true
    public boolean checkFirstChar(String userInput){
        char firstLetter;
        boolean value = false;
        try{
            firstLetter = userInput.charAt(0);
            if (!(Character.isLetter(userInput.charAt(0)))){
                value = true;
            }
        }
        catch (StringIndexOutOfBoundsException e2){
            value = true;
        }
        return value;
    }

    public static void main(String[] args) {
        CE203_2017_EX2 app = new CE203_2017_EX2();
        app.setVisible(true);
    }
}
