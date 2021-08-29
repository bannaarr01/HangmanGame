/**
 *
 * @author Josh
 *        
 *       
 */
//import javax.swing.JFrame;   

import java.io.*;               //importing necessary packages
import java.util.Scanner;       //importing Scanner Class
import java.util.ArrayList;     //importing ArrayList
import java.util.Random;        //importing Random Class
import java.sql.*;
import javax.swing.JOptionPane;

  
public class hangman extends javax.swing.JFrame {
    
    String[] arrayforboth = readWords();
    String hiddenWord = arrayforboth[0];
    int indexforhint = Integer.parseInt(arrayforboth[1]);
    String hint = readHints();
    
    int countLoss = 0, countWin = 0;
    ArrayList<Character> AlreadyEntered = new ArrayList<Character>();
      
   Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    
    /*
    arrayforboth - is a string array which contains the hidden word randomly generated from a text file,
    and the index of the hidden word, so it can be used to generate the appropriate hint for it from the other text file.
    countWin - is the variable to hold the number of correct guesses
    countLoss - is the variable to hold the number of wrong guesses
    hiddenWord - is the variable holds the hidden word randomly generated 
    indexforhint - is the index for the hidden word
    hint - is the variable to hold the hint generated from the Hint.txt file.
    AlreadyEntered - is the arrayList to save all the characters entered
    **/
    public hangman() { 
        initComponents();
        setLocationRelativeTo(null);   //center the jframe on screen
        setResizable(false);
        txthint.setText(hint);
        DisplayLabels(hiddenWord.length());
     
        
    }
    
 

    /*
    initComponents - is the method where all the design parts of the JFrame holds
    We have set the JFrame appear to the middle of the screen. JFrame is not Resizable
    Im displaying the hint i've got before into the txthint textfield
    Calling the DisplayLabels method to show the number of sufficient labels according to the length of the hidden word.   
    **/
    public String[] readWords() {

        File wordsFile = new File("src/Words.txt");

        try {

            Scanner sc = new Scanner(wordsFile); //input the wordsFile to the scanner rather than input

            ArrayList<String> listWords = new ArrayList<String>();  // String Array List

            while (sc.hasNextLine()) {            //scan the whole wordfile line by line
                listWords.add(sc.nextLine());      // And add to the String Array list listwords
            }

            Random rad = new Random();
            int index = rad.nextInt(listWords.size());  

            String[] arrayForBoth = {listWords.get(index), Integer.toString(index)}; 
            return arrayForBoth;

        } catch (FileNotFoundException e) {
            System.exit(0);
        }
        return null;
    }

    /*
    readWord method has a return type of a String[] array which contains the hiddenword and the index of it.
    wordsFile contains the text file which holds many words for the program
    Scanner object sc, scans the wordsFile and adds all the words to a string ArrayList named listWords.
    rad is an object from Random class which randomly generate a number between 0(inclusive) to size of listWords(exclusive)
    the randomly generated number is stored in the integer variable index
    listWords.get(index)- generates the word accoding to the randomly generated index
    Integer.toString(index) - converts the index to store as String as it goes as a variable in the String array
    Method returns the String array
    **/
    public String readHints() {

        File hintsFile = new File("src/Hints.txt");

        try {

            Scanner sc1 = new Scanner(hintsFile);

            ArrayList<String> listHints = new ArrayList<String>();

            while (sc1.hasNextLine()) {
                listHints.add(sc1.nextLine());
            }

            return listHints.get(indexforhint);

        } catch (FileNotFoundException e) {
            System.exit(0);
        }
        return null;
    }

    /*
    readHints method has a return type of String which contains the appropriate hint for the hidden word
    hintsFile contains the text file which holds all the hints for the words
    Scanner object sc1, scans the hintsFile and add all the hints to an ArrayList named listHints
    listHints.get(indexforhint) - gets the apporopriate hint for the word, identified by the index of the previous array
    This is because both hints and the words are placed the text file in the same order
    **/
    public void DisplayLabels(int numberofLabels) {

        switch (numberofLabels) {
            case 3:
                letter1.setVisible(true);
                letter2.setVisible(true);
                letter3.setVisible(true);
                break;
            case 4:
                letter1.setVisible(true);
                letter2.setVisible(true);
                letter3.setVisible(true);
                letter4.setVisible(true);
                break;
            case 5:
                letter1.setVisible(true);
                letter2.setVisible(true);
                letter3.setVisible(true);
                letter4.setVisible(true);
                letter5.setVisible(true);
                break;
            case 6:
                letter1.setVisible(true);
                letter2.setVisible(true);
                letter3.setVisible(true);
                letter4.setVisible(true);
                letter5.setVisible(true);
                letter6.setVisible(true);
                break;
            case 7:
                letter1.setVisible(true);
                letter2.setVisible(true);
                letter3.setVisible(true);
                letter4.setVisible(true);
                letter5.setVisible(true);
                letter6.setVisible(true);
                letter7.setVisible(true);
                break;
            case 8:
                letter1.setVisible(true);
                letter2.setVisible(true);
                letter3.setVisible(true);
                letter4.setVisible(true);
                letter5.setVisible(true);
                letter6.setVisible(true);
                letter7.setVisible(true);
                letter8.setVisible(true);
                break;
            case 9:
                letter1.setVisible(true);
                letter2.setVisible(true);
                letter3.setVisible(true);
                letter4.setVisible(true);
                letter5.setVisible(true);
                letter6.setVisible(true);
                letter7.setVisible(true);
                letter8.setVisible(true);
                letter9.setVisible(true);
                break;
            case 10:
                letter1.setVisible(true);
                letter2.setVisible(true);
                letter3.setVisible(true);
                letter4.setVisible(true);
                letter5.setVisible(true);
                letter6.setVisible(true);
                letter7.setVisible(true);
                letter8.setVisible(true);
                letter9.setVisible(true);
                letter10.setVisible(true);
                break;
        }
    }

    
    
    /*
    DisplayLabel method displays the sufficient amount of labels for the word
    All the labels are hidden at the beginning, The number of labels appear according the length of the word
    Length of the hidden word is the arguement given to this method, which its accepted as the parameter,
    called numberofLabels.
    according the length of the word, sufficient amount of labels are displayed
    **/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtguess = new javax.swing.JTextField();
        txthint = new javax.swing.JTextField();
        letter1 = new javax.swing.JLabel();
        letter2 = new javax.swing.JLabel();
        letter3 = new javax.swing.JLabel();
        letter4 = new javax.swing.JLabel();
        letter5 = new javax.swing.JLabel();
        letter6 = new javax.swing.JLabel();
        letter7 = new javax.swing.JLabel();
        letter8 = new javax.swing.JLabel();
        letter9 = new javax.swing.JLabel();
        letter10 = new javax.swing.JLabel();
        btnguess = new javax.swing.JButton();
        btnhelp = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        txtwrongguess = new javax.swing.JTextField();
        panelGuess = new javax.swing.JSeparator();
        lblimage = new javax.swing.JLabel();
        lblwelcome = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1010, 575));
        setMinimumSize(new java.awt.Dimension(1010, 575));
        setPreferredSize(new java.awt.Dimension(1010, 575));
        getContentPane().setLayout(null);

        txtguess.setFont(new java.awt.Font("Times New Roman", 0, 21)); // NOI18N
        getContentPane().add(txtguess);
        txtguess.setBounds(21, 197, 360, 57);

        txthint.setFont(new java.awt.Font("Times New Roman", 0, 21)); // NOI18N
        txthint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthintActionPerformed(evt);
            }
        });
        getContentPane().add(txthint);
        txthint.setBounds(21, 334, 410, 54);

        letter1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        letter1.setText("X");
        getContentPane().add(letter1);
        letter1.setBounds(30, 119, 30, 29);
        letter1.setVisible(false);

        letter2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        letter2.setText("X");
        getContentPane().add(letter2);
        letter2.setBounds(67, 119, 30, 29);
        letter2.setVisible(false);

        letter3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        letter3.setText("X");
        getContentPane().add(letter3);
        letter3.setBounds(104, 119, 30, 29);
        letter3.setVisible(false);

        letter4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        letter4.setText("X");
        getContentPane().add(letter4);
        letter4.setBounds(141, 119, 30, 29);
        letter4.setVisible(false);

        letter5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        letter5.setText("X");
        getContentPane().add(letter5);
        letter5.setBounds(178, 119, 30, 29);
        letter5.setVisible(false);

        letter6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        letter6.setText("X");
        getContentPane().add(letter6);
        letter6.setBounds(215, 119, 30, 29);
        letter6.setVisible(false);

        letter7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        letter7.setText("X");
        getContentPane().add(letter7);
        letter7.setBounds(252, 119, 30, 29);
        letter7.setVisible(false);

        letter8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        letter8.setText("X");
        getContentPane().add(letter8);
        letter8.setBounds(289, 119, 30, 29);
        letter8.setVisible(false);

        letter9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        letter9.setText("X");
        getContentPane().add(letter9);
        letter9.setBounds(323, 119, 30, 29);
        letter9.setVisible(false);

        letter10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        letter10.setText("X");
        getContentPane().add(letter10);
        letter10.setBounds(357, 119, 30, 29);
        letter10.setVisible(false);

        btnguess.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnguess.setText("Guess");
        btnguess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguessActionPerformed(evt);
            }
        });
        getContentPane().add(btnguess);
        btnguess.setBounds(21, 425, 110, 55);

        btnhelp.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnhelp.setText("Help");
        btnhelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhelpActionPerformed(evt);
            }
        });
        getContentPane().add(btnhelp);
        btnhelp.setBounds(169, 425, 103, 55);

        btnexit.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnexit.setText("Exit");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });
        getContentPane().add(btnexit);
        btnexit.setBounds(315, 425, 85, 55);

        txtwrongguess.setFont(new java.awt.Font("Times New Roman", 0, 21)); // NOI18N
        getContentPane().add(txtwrongguess);
        txtwrongguess.setBounds(924, 491, 65, 45);

        panelGuess.setForeground(new java.awt.Color(255, 255, 255));
        panelGuess.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panelGuess.setAlignmentX(100.0F);
        panelGuess.setAlignmentY(100.0F);
        panelGuess.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(240, 240, 240)));
        panelGuess.setMaximumSize(new java.awt.Dimension(100, 100));
        panelGuess.setMinimumSize(new java.awt.Dimension(100, 100));
        panelGuess.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(panelGuess);
        panelGuess.setBounds(490, -10, 30, 590);

        lblimage.setBackground(new java.awt.Color(51, 255, 51));
        lblimage.setForeground(new java.awt.Color(102, 255, 102));
        lblimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hangman2Norm.PNG"))); // NOI18N
        getContentPane().add(lblimage);
        lblimage.setBounds(540, 21, 449, 449);

        lblwelcome.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblwelcome.setText("SAVE THE MAN FROM HANGING");
        getContentPane().add(lblwelcome);
        lblwelcome.setBounds(32, 21, 381, 29);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel1.setText("Hint !");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(21, 296, 57, 26);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel2.setText("Wrong Count");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(768, 500, 138, 26);

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTextField1.setText("NAME");
        getContentPane().add(jTextField1);
        jTextField1.setBounds(113, 68, 172, 26);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jButton1.setText("Game Record");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(540, 500, 180, 34);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Han2.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 430, 290);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Han2.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 290, 320, 270);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Han2.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(290, 0, 320, 230);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Han2_1.png"))); // NOI18N
        jLabel8.setToolTipText("");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(610, -20, 100, 70);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Han2_1.png"))); // NOI18N
        jLabel9.setToolTipText("");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(400, 190, 202, 220);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Han2_1.png"))); // NOI18N
        jLabel10.setToolTipText("");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(290, 240, 202, 210);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Han2_1.png"))); // NOI18N
        jLabel11.setToolTipText("");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(600, 390, 202, 170);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Han2_1.png"))); // NOI18N
        jLabel12.setToolTipText("");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(770, 390, 220, 170);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Han2_1.png"))); // NOI18N
        jLabel13.setToolTipText("");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(960, 390, 60, 170);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Han2_1.png"))); // NOI18N
        jLabel14.setToolTipText("");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(950, 230, 70, 170);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Han2_1.png"))); // NOI18N
        jLabel15.setToolTipText("");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(950, 70, 70, 170);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Han2_1.png"))); // NOI18N
        jLabel16.setToolTipText("");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(950, -30, 80, 130);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Han2_1.png"))); // NOI18N
        jLabel17.setToolTipText("");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(900, -30, 60, 70);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Han2_1.png"))); // NOI18N
        jLabel18.setToolTipText("");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(850, -30, 60, 70);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Han2_1.png"))); // NOI18N
        jLabel19.setToolTipText("");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(790, -30, 60, 70);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Han2_1.png"))); // NOI18N
        jLabel20.setToolTipText("");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(700, -30, 100, 70);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Han2_1.png"))); // NOI18N
        jLabel21.setToolTipText("");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(700, -30, 100, 70);

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Han2_1.png"))); // NOI18N
        jLabel22.setToolTipText("");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(410, 390, 202, 170);

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Han2_1.png"))); // NOI18N
        jLabel23.setToolTipText("");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(300, 350, 202, 210);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txthintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthintActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txthintActionPerformed

    private void btnhelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhelpActionPerformed
        // TODO add your handling code here:
        new help().setVisible(true);
    }//GEN-LAST:event_btnhelpActionPerformed

    private void btnguessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguessActionPerformed
     try {
            char guessLetter = Character.toLowerCase(txtguess.getText().charAt(0));
            boolean isEntered = false;

            /*
        guessLetter - is the letter entered by the player
        isEntered - is the a boolean variable to check whether the letter is already entered
             */
            
            for (char enteredChar : AlreadyEntered) {
                if (enteredChar == guessLetter) {
                    new Alreadyentered().setVisible(true);  //Frame to tell the player the letter is Already Entered
                    isEntered = true;
                    txtguess.setText(null);
                    txtguess.requestFocus();
                }
            }

            /*
        for loops checks the arrayList AlreadyEntered and assign each character to the char variable enteredChar
        If enteredChar is equal to the guessLetter another JFrame will appear to display the user has already entered
        the character.
        The boolean isEntered turns to true.
        txtguess will be empty and the cursor will be in the text box again
             */
            if (isEntered == false) {

                /*
        After the previous loop execution, if the enteredChar is not equal to the guessLetter, the boolean will remain false.
        So if the guessLetter is not entered before, the program will enter this if condition
                 */
                AlreadyEntered.add(guessLetter);
                // the guessLetter will be added to the AlreadyEntered array list

                char[] letterArray = new char[hiddenWord.length()];
                for (int i = 0; i < letterArray.length; i++) {
                    letterArray[i] = hiddenWord.charAt(i);
                }

                /*
                char letterArray stores all the letters of the hiddenWord generated
                for loop will assign each letter to the char array
                 */
                ArrayList<Integer> letterPosition = findLetter(letterArray, guessLetter);

                /*
                Integer arraylist letterPosition is to store the number of occurance of the guessLetter
                and the position of the letter in the hidden word
                findLetter is the method to search the letter in the array
                letterArray and the guessLetter are the arguments given to it.
                findLetter will return an ArrayList to the LetterPosition which will contain size as the number of occurance,
                and the integer values as the position of the guessLetter
                If the letterPosition arrayList is empty, it means the guessLetter is not in the hiddenWord
                 */
                if (letterPosition.size() >= 1) {
                    for (int labelnumber : letterPosition) {
                        displayLetter(labelnumber, guessLetter);
                    }
                    countWin += letterPosition.size();

                    if (countWin == hiddenWord.length()) {
                        
                        try{          
Class.forName("java.sql.Driver"); 
       con = DriverManager.getConnection("jdbc:mysql:///hangman","root","");
    stmt = con.createStatement();
      
  String query = "Update players SET win = win+1 where nickname = '" + jTextField1.getText() + " ';";
 
  stmt.executeUpdate(query);
       // JOptionPane.showMessageDialog(null,"Record Updated Succesfully");
       }
    catch(Exception e) {
        JOptionPane.showMessageDialog(null,"Error in updating Your Current Game Score !");
                       }
                        
                        new YouWin().setVisible(true);
                        dispose();
                    }
                }

                /*
                if the letterPosition array has some value in it, which means the guessLetter is in the hiddenWord
                The Integer variable labelnumber will assign each integer value in the arrayList
                displayLetter is the method to change the appropriate label with the guessLetter
                arguements to the method will be the guessLetter and the labelnumber which contains the position of the
                letter in the hiddenWord.
                After displaying the guessletter replacing the appropriate 'X',
                countWin will increase by the lettterPosition arrayList size, which is the number of occurence
                of the guessLetter in the hiddenWord
                When the countWin equals to the length of the hiddenWord, which means all the letter are being guessed,
                A new JFrame will appear to display the player have won the game.
                 */
                if (letterPosition.isEmpty()) {
                    countLoss++;
                    txtwrongguess.setText(Integer.toString(countLoss));
                    displayImage(countLoss);

                    if (countLoss == 7) {
                      //  String CorrectWord = "The correct word was " + hiddenWord;
                      try{          
Class.forName("java.sql.Driver"); 
       con = DriverManager.getConnection("jdbc:mysql:///hangman","root","");
    stmt = con.createStatement();
    
      
  String query = "Update players SET loose = loose+1 where nickname = '" + jTextField1.getText() + " ';";
 
  stmt.executeUpdate(query);
      //  JOptionPane.showMessageDialog(null,"Record Updated Succesfully");
       }
    catch(Exception e) {
        JOptionPane.showMessageDialog(null," Error in updating Your Current Game Score !");
                       }
         
                       String CorrectWord = " " + hiddenWord;
                        YouLoose form1 = new YouLoose();
                        form1.setVisible(true);
                        form1.setLabelText(CorrectWord); 
//calling the method in the YouLoose frame and assigning the correct word in it
                        dispose();
                    }
                }
                /*
                If the letterPosition is empty , which means the guessLetter is not in the hiddenWord
                countloss will be increased by 1, the countLoss will be displayed in the appropriate textfield
                displayImage method will be called to display the appropriate hangman Image
                arguement is the countLoss.
                If the countLoss is 7, which means the complete hangman is appeared.
                A new JFrame object named form1 will appear to inform that the user has lost the game
                CorrectWord is a String which shows the user the correct hiddenWord
                CorrectWord will be given as the arguement to the setLabelText in form1.
                 */

                txtguess.setText(null);
                txtguess.requestFocus();

                /*
                After guessing a letter, the text field will be empty and the cursor will be back in the text field.
                 */
            }
        } catch (Exception ex) { // handle exception when no letter is given to guess
            
                txtguess.setText(null);
                txtguess.requestFocus();
                /*
                After guessing a letter, the text field will be empty and the cursor will be back in the text field.
                 */
        }
    }                                        

    public ArrayList<Integer> findLetter(char[] charArray, char value) {

        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int j = 0; j < charArray.length; j++) {
            if (charArray[j] == value) {
                list.add(j);
            }
        }
        return list;
    }

    /*
    findLetter is the method to find the guessLetter in the hiddenWord, return type will be an Integer ArrayList
    charArray and char value will be the parameters
    for loop will check each and every letter in the hiddenWord, if its equal to the value, which represents the guessLetter
    if any letter is equal to the guessLetter, the index(position) of the letter in the charArray will be stored,
    as a value in the ArrayList named 'list'.
    After the loop is executed, the ArrayList will be returned, which will be captured as an ArrayList called,
    'LetterPosition'.
     */
    public void displayLetter(int x, char letter) {

        switch (x) {
            case 0:
                letter1.setText(Character.toString(letter));
                break;
            case 1:
                letter2.setText(Character.toString(letter));
                break;
            case 2:
                letter3.setText(Character.toString(letter));
                break;
            case 3:
                letter4.setText(Character.toString(letter));
                break;
            case 4:
                letter5.setText(Character.toString(letter));
                break;
            case 5:
                letter6.setText(Character.toString(letter));
                break;
            case 6:
                letter7.setText(Character.toString(letter));
                break;
            case 7:
                letter8.setText(Character.toString(letter));
                break;
            case 8:
                letter9.setText(Character.toString(letter));
                break;
            case 9:
                letter10.setText(Character.toString(letter));
                break;
        }
    }

    /*
    displayLetter is the method to display guessLetter in the correct Label.
    Integer x and  char letter will be the parameters which will represent the position of the guessLetter and the
    guessLetter respectively.
    According to the value x, which holds the position of the guessLetter in the hiddenWord, the appropriate
    label will change to guessLetter replacing the 'X'.
     */
    public void displayImage(int y) {

        switch (y) {
            case 1:
                lblimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("Hangman1.png")));
                break;
            case 2:
                lblimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("Hangman2.png")));
                break;
            case 3:
                lblimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("Hangman3.png")));
                break;
            case 4:
                lblimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("Hangman4.png")));
                break;
            case 5:
                lblimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("Hangman5.png")));
                break;
            case 6:
                lblimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("Hangman6.png")));
                break;
            case 7:
                lblimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("Hangman7.png")));
                break;
        }
    

    /*
    displayImage is the method to display the correct hangman image when the 
    user guess an incorrect value the parameter will be integer y, which represents 
    the lossCount According to y, the appropriate hangman Image will display in the JLabel.
     */
        
       

    }//GEN-LAST:event_btnguessActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnexitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:   
     try {
         
    Class.forName("java.sql.Driver");
    con = DriverManager.getConnection("jdbc:mysql:///hangman","root","");
    stmt = con.createStatement();
    String query = "Select *, (win+loose+draw) AS Sum FROM players where nickname = '" + jTextField1.getText()+ " ';";
    String query2 = "Select * from players Where nickname = '" + jTextField1.getText()+ " ';";
    rs = stmt.executeQuery(query);
    if (rs.next()){
  String namm = rs.getString("name");
  String summ = rs.getString("Sum");
  String winn = rs.getString("win");
  String loosse = rs.getString("loose");
  String draww = rs.getString("draw");
 int i = Integer.parseInt(winn);  
  JOptionPane.showMessageDialog(null,"Player's Name : "+namm+"\n\nTotal Game Played : "+summ+"\n\nNo. of  Win : "+winn+
       "\n\nNo. of  Loss : "+loosse+"\n\nNo. of  Draw : "+draww+"\n\n----------------------------\nTotal Score : "+(i*100)+".00\n----------------------------");
 
                  } 
    else 
        JOptionPane.showMessageDialog(null," Unable to Retrieve Record!");
    rs.close();
    stmt.close();
    con.close();
     }    
catch (Exception e){
    JOptionPane.showMessageDialog(null,"Error in connectivity");
    }
        
        

    }//GEN-LAST:event_jButton1ActionPerformed

    
    private void close(){    //close and dispose method
        this.setVisible(false);
        this.dispose();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
    
        
           public void run() {
              
            new hangman().setVisible(true);
            
 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnguess;
    private javax.swing.JButton btnhelp;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JLabel jTextField1;
    private javax.swing.JLabel lblimage;
    private javax.swing.JLabel lblwelcome;
    private javax.swing.JLabel letter1;
    private javax.swing.JLabel letter10;
    private javax.swing.JLabel letter2;
    private javax.swing.JLabel letter3;
    private javax.swing.JLabel letter4;
    private javax.swing.JLabel letter5;
    private javax.swing.JLabel letter6;
    private javax.swing.JLabel letter7;
    private javax.swing.JLabel letter8;
    private javax.swing.JLabel letter9;
    private javax.swing.JSeparator panelGuess;
    private javax.swing.JTextField txtguess;
    private javax.swing.JTextField txthint;
    private javax.swing.JTextField txtwrongguess;
    // End of variables declaration//GEN-END:variables

   
    
}
