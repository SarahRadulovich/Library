
package library;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LibraryForm extends javax.swing.JFrame {


    public LibraryForm() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bookTitle = new javax.swing.JTextField();
        authorTitle = new javax.swing.JTextField();
        answerLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("frame");
        setBackground(new java.awt.Color(150, 100, 250));
        setForeground(java.awt.Color.pink);
        setSize(new java.awt.Dimension(491, 311));

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        jLabel1.setText("Looking for a book?");

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        jLabel2.setText("Looking for an author?");

        bookTitle.setToolTipText("");
        bookTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookTitleActionPerformed(evt);
            }
        });

        authorTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorTitleActionPerformed(evt);
            }
        });

        answerLabel.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        answerLabel.setText("Do we have it?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(bookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(authorTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))))
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(answerLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(authorTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(answerLabel)
                .addGap(83, 83, 83))
        );

        pack();
    }// </editor-fold>

    private void authorTitleActionPerformed(java.awt.event.ActionEvent evt) {
        String availability = null;
        String authorName = this.authorTitle.getText();
        try {
            availability = ReadingAuthors(authorName);
        } catch (IOException ex) {
            Logger.getLogger(LibraryForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.answerLabel.setText(availability);
    }

    private void bookTitleActionPerformed(java.awt.event.ActionEvent evt) {
        String availability = null;
        String bookName = this.bookTitle.getText();
        try {
            availability = ReadingFiles(bookName);
        } catch (IOException ex) {
            Logger.getLogger(LibraryForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.answerLabel.setText(availability);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibraryForm().setVisible(true);
            }
        });
    }
    
    public static String ReadingFiles(String title) throws FileNotFoundException, IOException {

        String availability = null;
        File file = new File("Titles.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line == null ? title == null : line.equals(title)) {
                    availability = "We have that book!";
                    break;
                } else {
                    availability = "We don't have that book.";
                }
            }
        }

        return availability;
    }
    
    public static String ReadingAuthors(String title) throws FileNotFoundException, IOException {

        String availability = null;
        File file = new File("Titles.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line == null ? title == null : line.equals(title)) {
                    availability = "We have that author!";
                    break;
                } else {
                    availability = "We don't have that author!";
                }
            }
        }

        return availability;
    }

    private javax.swing.JLabel answerLabel;
    private javax.swing.JTextField authorTitle;
    private javax.swing.JTextField bookTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
}
