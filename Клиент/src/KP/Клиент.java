/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KP;
import java.awt.HeadlessException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author User
 */
public class Клиент extends javax.swing.JFrame{
Socket client;
    String ip,port;
    DataOutputStream out;
    DataInputStream in;

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Клиент.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    //</editor-fold>
    
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Клиент().setVisible(true);
        });
    }

   
    public Клиент() {
        initComponents();
        jTabbedPane1.setEnabled(false);
    }

    
private class Potok extends Thread 
    {
        @Override
        public void run()
        {
            try 
            {
                ip = jTextField1.getText();
                port = jTextField2.getText();
                client = new Socket(ip, Integer.parseInt(port));
                showMessageDialog(null, "Ты в ИГРЕ!", "Game", INFORMATION_MESSAGE);
                        jTabbedPane1.setSelectedIndex(1);
            }
            catch (HeadlessException | IOException | NumberFormatException ex) 
            {
               showMessageDialog(null, "Не удалось подключиться к серверу! \nПроверьте правильно ли введен порт для подключения "
                       + "\nили запущен сервер!", "Клиент", ERROR_MESSAGE);
            
            }
        }
    }

private class Rule1 extends Thread
    {
        @Override
        public void run ()
        {
            
            try{
               
          
            out = new DataOutputStream(client.getOutputStream());
            out.writeUTF("1\n");
            out.flush();
            
            in = new DataInputStream(client.getInputStream());
            String str = in.readUTF();
                if ("true\n".equals(str)) {
                    showMessageDialog(null, "+", "Game", INFORMATION_MESSAGE);}
                if ("false\n".equals(str)) 
                {showMessageDialog(null, "-", "Game", INFORMATION_MESSAGE); }
            
            }catch (IOException ex)
            {
            showMessageDialog(null, "Ошибка отправки", "Game", ERROR_MESSAGE);
            }
             
    }
}
private class Rule2 extends Thread
    {
        @Override
        public void run ()
        {
            try 
            {
                 in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());
            out.writeUTF("0\n");
            out.flush();
             out.flush();
            String str = in.readUTF();
                if ("true\n".equals(str)) {
                    showMessageDialog(null, "+", "Game", INFORMATION_MESSAGE);}
                if ("false\n".equals(str)) 
                {showMessageDialog(null, "-", "Game", INFORMATION_MESSAGE); }
                    }
        catch (IOException ex)
            {
            showMessageDialog(null, "Ошибка отправки", "Game", ERROR_MESSAGE);
            } 
           }
    }
public class Recv extends Thread{

        @Override
        public void run() {
            while (true) {
                    try {
                        DataInputStream fileNameInfo = new DataInputStream(client.getInputStream());
                        String fileName = fileNameInfo.readUTF();
                        InputStream in = client.getInputStream();
                        FileOutputStream fOut = new FileOutputStream("C:\\" + fileName);
                        byte[] bt = new byte[1024];
                        while ((in.read(bt)) > 0) {
                            fOut.write(bt);
                        }
                             Runtime.getRuntime().exec("start notepad 'C:\\" + fileName + "'");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
        }
        
    
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        a1 = new javax.swing.JLabel();
        a2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        a4 = new javax.swing.JLabel();
        a5 = new javax.swing.JLabel();
        a6 = new javax.swing.JLabel();
        a3 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        a7 = new javax.swing.JLabel();
        a8 = new javax.swing.JLabel();
        a9 = new javax.swing.JLabel();
        a10 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        a11 = new javax.swing.JLabel();
        a12 = new javax.swing.JLabel();
        a13 = new javax.swing.JLabel();
        a14 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        a15 = new javax.swing.JLabel();
        a16 = new javax.swing.JLabel();
        a17 = new javax.swing.JLabel();
        a18 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        s1 = new javax.swing.JLabel();
        s3 = new javax.swing.JLabel();
        s2 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel42 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel43 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 520));
        setMinimumSize(new java.awt.Dimension(800, 520));
        setPreferredSize(new java.awt.Dimension(800, 520));
        getContentPane().setLayout(null);

        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("ДОБРО ПОЖАЛОВАТЬ В ИГРУ");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(120, 10, 590, 50);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("IP = ");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(340, 160, 60, 30);

        jTextField1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jTextField1.setText("127.0.0.1");
        jPanel2.add(jTextField1);
        jTextField1.setBounds(390, 160, 130, 30);

        jTextField2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jTextField2.setText("8080");
        jPanel2.add(jTextField2);
        jTextField2.setBounds(390, 200, 130, 30);

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("PORT = ");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(310, 200, 80, 30);

        jButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 0, 0));
        jButton1.setText("Начать игру");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(320, 340, 190, 50);

        jButton8.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(153, 0, 0));
        jButton8.setText("Автор");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8);
        jButton8.setBounds(690, 410, 80, 27);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/KP/3386879-forest-trees-background-dark.jpg"))); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 500);

        jTabbedPane1.addTab("Начало", jPanel2);

        jPanel3.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Ха-ха, вот ты и попался! Теперь игра будет идти по моим правилам! ");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(60, 40, 710, 30);

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Ты должен ответить на вопрос!");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(410, 70, 340, 20);

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 29)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Сколько видов волков на земле?");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(130, 120, 760, 70);

        a1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        a1.setForeground(new java.awt.Color(204, 204, 204));
        a1.setText("a) 24");
        a1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a1MouseClicked(evt);
            }
        });
        jPanel3.add(a1);
        a1.setBounds(300, 250, 50, 30);

        a2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        a2.setForeground(new java.awt.Color(204, 204, 204));
        a2.setText("б) 25");
        a2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a2MouseClicked(evt);
            }
        });
        jPanel3.add(a2);
        a2.setBounds(420, 250, 50, 30);

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Клиент\\src\\KP\\3386879-forest-trees-background-dark.jpg")); // NOI18N
        jPanel3.add(jLabel5);
        jLabel5.setBounds(0, -10, 800, 500);

        jTabbedPane1.addTab("Игра №1", jPanel3);

        jPanel8.setLayout(null);

        jLabel22.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 204, 204));
        jLabel22.setText("Какова длина китайской стены?");
        jPanel8.add(jLabel22);
        jLabel22.setBounds(60, 80, 760, 70);

        jLabel23.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 204, 204));
        jLabel23.setText("Повезло!");
        jPanel8.add(jLabel23);
        jLabel23.setBounds(190, 30, 130, 30);

        a4.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        a4.setForeground(new java.awt.Color(204, 204, 204));
        a4.setText("б) 18,1 тыс. км");
        a4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a4MouseClicked(evt);
            }
        });
        jPanel8.add(a4);
        a4.setBounds(230, 250, 170, 20);

        a5.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        a5.setForeground(new java.awt.Color(204, 204, 204));
        a5.setText("в) 20 тыс. км");
        a5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a5MouseClicked(evt);
            }
        });
        jPanel8.add(a5);
        a5.setBounds(430, 200, 140, 20);

        a6.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        a6.setForeground(new java.awt.Color(204, 204, 204));
        a6.setText("г) 23,6 тыс. км");
        a6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a6MouseClicked(evt);
            }
        });
        jPanel8.add(a6);
        a6.setBounds(590, 250, 150, 20);

        a3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        a3.setForeground(new java.awt.Color(204, 204, 204));
        a3.setText("а) 21,2 тыс. км");
        a3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a3MouseClicked(evt);
            }
        });
        jPanel8.add(a3);
        a3.setBounds(60, 190, 160, 30);

        jLabel21.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel21.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Клиент\\src\\KP\\3386879-forest-trees-background-dark.jpg")); // NOI18N
        jPanel8.add(jLabel21);
        jLabel21.setBounds(0, 0, 800, 500);

        jTabbedPane1.addTab("Игра №2", jPanel8);

        jPanel9.setLayout(null);

        jLabel24.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 204, 204));
        jLabel24.setText("Ну тут просто.");
        jPanel9.add(jLabel24);
        jLabel24.setBounds(90, 30, 710, 30);

        jLabel25.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 204, 204));
        jLabel25.setText("Сколько лучей у обычной снежинки?");
        jPanel9.add(jLabel25);
        jLabel25.setBounds(50, 90, 680, 70);

        a7.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        a7.setForeground(new java.awt.Color(204, 204, 204));
        a7.setText("а) 4");
        a7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a7MouseClicked(evt);
            }
        });
        jPanel9.add(a7);
        a7.setBounds(150, 250, 60, 30);

        a8.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        a8.setForeground(new java.awt.Color(204, 204, 204));
        a8.setText("б) 6");
        a8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a8MouseClicked(evt);
            }
        });
        jPanel9.add(a8);
        a8.setBounds(290, 260, 40, 30);

        a9.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        a9.setForeground(new java.awt.Color(204, 204, 204));
        a9.setText("в) 8");
        a9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a9MouseClicked(evt);
            }
        });
        jPanel9.add(a9);
        a9.setBounds(430, 260, 40, 20);

        a10.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        a10.setForeground(new java.awt.Color(204, 204, 204));
        a10.setText("г) 5");
        a10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a10MouseClicked(evt);
            }
        });
        jPanel9.add(a10);
        a10.setBounds(550, 250, 40, 30);

        jLabel26.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel26.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Клиент\\src\\KP\\3386879-forest-trees-background-dark.jpg")); // NOI18N
        jPanel9.add(jLabel26);
        jLabel26.setBounds(0, 0, 800, 500);

        jTabbedPane1.addTab("Игра №3", jPanel9);

        jPanel10.setLayout(null);

        jLabel28.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(204, 204, 204));
        jLabel28.setText(" к Солнцу планета?");
        jPanel10.add(jLabel28);
        jLabel28.setBounds(360, 100, 880, 70);

        jLabel29.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(204, 204, 204));
        jLabel29.setText("Что насчет Астрономии?");
        jPanel10.add(jLabel29);
        jLabel29.setBounds(50, 10, 710, 30);

        a11.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        a11.setForeground(new java.awt.Color(204, 204, 204));
        a11.setText("а) Нептун");
        a11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a11MouseClicked(evt);
            }
        });
        jPanel10.add(a11);
        a11.setBounds(80, 240, 100, 30);

        a12.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        a12.setForeground(new java.awt.Color(204, 204, 204));
        a12.setText("б) Уран");
        a12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a12MouseClicked(evt);
            }
        });
        jPanel10.add(a12);
        a12.setBounds(240, 280, 80, 30);

        a13.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        a13.setForeground(new java.awt.Color(204, 204, 204));
        a13.setText("в) Меркурий");
        a13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a13MouseClicked(evt);
            }
        });
        jPanel10.add(a13);
        a13.setBounds(380, 230, 120, 30);

        a14.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        a14.setForeground(new java.awt.Color(204, 204, 204));
        a14.setText("г) Венера");
        a14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a14MouseClicked(evt);
            }
        });
        jPanel10.add(a14);
        a14.setBounds(560, 280, 110, 30);

        jLabel31.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(204, 204, 204));
        jLabel31.setText("Как называется ближайшая");
        jPanel10.add(jLabel31);
        jLabel31.setBounds(30, 60, 880, 70);

        jLabel30.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel30.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Клиент\\src\\KP\\3386879-forest-trees-background-dark.jpg")); // NOI18N
        jPanel10.add(jLabel30);
        jLabel30.setBounds(0, 0, 800, 500);

        jTabbedPane1.addTab("Игра №4", jPanel10);

        jPanel11.setLayout(null);

        jLabel32.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(204, 204, 204));
        jLabel32.setText("Ну давай, посмотрим, что ты тут ответишь!!!");
        jPanel11.add(jLabel32);
        jLabel32.setBounds(120, 10, 710, 30);

        jLabel33.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(204, 204, 204));
        jLabel33.setText("Советской энциклопедии?");
        jPanel11.add(jLabel33);
        jLabel33.setBounds(240, 110, 860, 70);

        a15.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        a15.setForeground(new java.awt.Color(204, 204, 204));
        a15.setText("а) К");
        a15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a15MouseClicked(evt);
            }
        });
        jPanel11.add(a15);
        a15.setBounds(140, 230, 50, 30);

        a16.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        a16.setForeground(new java.awt.Color(204, 204, 204));
        a16.setText("г) М");
        a16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a16MouseClicked(evt);
            }
        });
        jPanel11.add(a16);
        a16.setBounds(550, 310, 60, 30);

        a17.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        a17.setForeground(new java.awt.Color(204, 204, 204));
        a17.setText("в) С");
        a17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a17MouseClicked(evt);
            }
        });
        jPanel11.add(a17);
        a17.setBounds(410, 230, 50, 30);

        a18.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        a18.setForeground(new java.awt.Color(204, 204, 204));
        a18.setText("б) П");
        a18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a18MouseClicked(evt);
            }
        });
        jPanel11.add(a18);
        a18.setBounds(280, 310, 60, 30);

        jLabel35.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(204, 204, 204));
        jLabel35.setText("С какой буквы начинаются ");
        jPanel11.add(jLabel35);
        jLabel35.setBounds(20, 30, 520, 70);

        jLabel36.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(204, 204, 204));
        jLabel36.setText("слова, опубликованные в 16 м томе");
        jPanel11.add(jLabel36);
        jLabel36.setBounds(120, 70, 690, 70);

        jLabel34.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel34.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Клиент\\src\\KP\\3386879-forest-trees-background-dark.jpg")); // NOI18N
        jPanel11.add(jLabel34);
        jLabel34.setBounds(0, 0, 800, 500);

        jTabbedPane1.addTab("Игра №5", jPanel11);

        jPanel4.setLayout(null);

        jLabel16.setFont(new java.awt.Font("Comic Sans MS", 1, 8)); // NOI18N
        jLabel16.setText("О");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel16);
        jLabel16.setBounds(700, 220, 30, 30);

        jButton5.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(153, 0, 0));
        jButton5.setText("Сдаться");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5);
        jButton5.setBounds(540, 20, 190, 50);

        jLabel17.setFont(new java.awt.Font("Comic Sans MS", 1, 29)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setText("Найди черный кружочек!");
        jPanel4.add(jLabel17);
        jLabel17.setBounds(20, 0, 370, 60);

        jLabel11.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Клиент\\src\\KP\\3386879-forest-trees-background-dark.jpg")); // NOI18N
        jPanel4.add(jLabel11);
        jLabel11.setBounds(0, 0, 800, 500);

        jTabbedPane1.addTab("-", jPanel4);

        jPanel1.setLayout(null);

        s1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/KP/1.png"))); // NOI18N
        s1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                s1MouseClicked(evt);
            }
        });
        jPanel1.add(s1);
        s1.setBounds(0, 150, 235, 300);

        s3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/KP/3.png"))); // NOI18N
        s3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                s3MouseClicked(evt);
            }
        });
        jPanel1.add(s3);
        s3.setBounds(560, 160, 200, 310);

        s2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/KP/2.png"))); // NOI18N
        s2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                s2MouseClicked(evt);
            }
        });
        jPanel1.add(s2);
        s2.setBounds(300, 160, 200, 300);

        jLabel20.setFont(new java.awt.Font("Comic Sans MS", 1, 29)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 204, 204));
        jLabel20.setText("Есть 3 чаши, одна из них отравлена, выбирай.");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(50, 20, 700, 70);

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Клиент\\src\\KP\\3386879-forest-trees-background-dark.jpg")); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 0, 800, 500);

        jTabbedPane1.addTab("-", jPanel1);

        jPanel5.setLayout(null);

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/KP/+.png"))); // NOI18N
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel27);
        jLabel27.setBounds(360, 170, 130, 140);

        jLabel10.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Клиент\\src\\KP\\3386879-forest-trees-background-dark.jpg")); // NOI18N
        jPanel5.add(jLabel10);
        jLabel10.setBounds(0, 0, 800, 500);

        jTabbedPane1.addTab("-", jPanel5);

        jPanel6.setLayout(null);

        jLabel39.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel39.setText("о");
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel39MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel39);
        jLabel39.setBounds(380, 370, 20, 20);

        jLabel41.setFont(new java.awt.Font("Comic Sans MS", 1, 29)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(204, 204, 204));
        jLabel41.setText("Найди черный кружочек!");
        jPanel6.add(jLabel41);
        jLabel41.setBounds(50, 20, 700, 70);

        jButton4.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(153, 0, 0));
        jButton4.setText("Сдаться");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton4);
        jButton4.setBounds(600, 10, 190, 50);

        jLabel12.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Клиент\\src\\KP\\3386879-forest-trees-background-dark.jpg")); // NOI18N
        jPanel6.add(jLabel12);
        jLabel12.setBounds(0, 0, 800, 500);

        jTabbedPane1.addTab("-", jPanel6);

        jPanel12.setLayout(null);

        jLabel44.setFont(new java.awt.Font("Comic Sans MS", 1, 60)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(204, 204, 204));
        jLabel44.setText("Ты не справился!");
        jPanel12.add(jLabel44);
        jLabel44.setBounds(120, 100, 650, 100);

        jLabel45.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(204, 204, 204));
        jLabel45.setText("И что ты будешь делать? ");
        jPanel12.add(jLabel45);
        jLabel45.setBounds(150, 170, 520, 70);

        jButton2.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jButton2.setForeground(new java.awt.Color(153, 0, 0));
        jButton2.setText("Сбежать");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton2);
        jButton2.setBounds(230, 290, 320, 130);

        jLabel48.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(204, 204, 204));
        jLabel48.setText("Я так и думал! ");
        jPanel12.add(jLabel48);
        jLabel48.setBounds(230, 80, 520, 70);

        jButton6.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(153, 0, 0));
        jButton6.setText("Принять данные");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton6);
        jButton6.setBounds(570, 10, 190, 50);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jPanel12.add(jTextArea2);
        jTextArea2.setBounds(20, 10, 530, 60);

        jLabel42.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel42.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Клиент\\src\\KP\\3386879-forest-trees-background-dark.jpg")); // NOI18N
        jPanel12.add(jLabel42);
        jLabel42.setBounds(0, 0, 800, 500);

        jTabbedPane1.addTab("Плохо", jPanel12);

        jPanel13.setLayout(null);

        jLabel47.setFont(new java.awt.Font("Comic Sans MS", 1, 60)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(204, 204, 204));
        jLabel47.setText("Теперь ты свободен!");
        jPanel13.add(jLabel47);
        jLabel47.setBounds(90, 120, 650, 70);

        jButton3.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jButton3.setForeground(new java.awt.Color(153, 0, 0));
        jButton3.setText("Выход");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton3);
        jButton3.setBounds(220, 280, 360, 130);

        jLabel49.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(204, 204, 204));
        jLabel49.setText("Молодец, ты справился!");
        jPanel13.add(jLabel49);
        jLabel49.setBounds(170, 60, 520, 70);

        jButton7.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(153, 0, 0));
        jButton7.setText("Принять данные");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton7);
        jButton7.setBounds(580, 10, 180, 50);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jPanel13.add(jTextArea1);
        jTextArea1.setBounds(20, 10, 530, 60);

        jLabel43.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel43.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Клиент\\src\\KP\\3386879-forest-trees-background-dark.jpg")); // NOI18N
        jPanel13.add(jLabel43);
        jLabel43.setBounds(0, 0, 800, 500);
        jPanel13.add(jScrollPane1);
        jScrollPane1.setBounds(0, 10, 2, 2);

        jTabbedPane1.addTab("Хорошо", jPanel13);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 10, 800, 510);

        getAccessibleContext().setAccessibleName("Игра");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void a14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a14MouseClicked
  
       a12.setVisible(false);
        a13.setVisible(false);
        a11.setVisible(false);
                        Rule2 r28 = new Rule2();
        r28.start();
        jTabbedPane1.setSelectedIndex(9);
    }//GEN-LAST:event_a14MouseClicked

    private void a13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a13MouseClicked
     
       
        a12.setVisible(false);
        a11.setVisible(false);
        a14.setVisible(false);
                Rule1 r12 = new Rule1();
        r12.start();
        jTabbedPane1.setSelectedIndex(5);

    }//GEN-LAST:event_a13MouseClicked

    private void a12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a12MouseClicked

       
        a11.setVisible(false);
        a13.setVisible(false);
        a14.setVisible(false);
                                Rule2 r29 = new Rule2();
        r29.start();
        jTabbedPane1.setSelectedIndex(9);
       
    }//GEN-LAST:event_a12MouseClicked

    private void a11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a11MouseClicked

         a12.setVisible(false);
        a13.setVisible(false);
        a14.setVisible(false);
                                Rule2 r24 = new Rule2();
        r24.start();
        jTabbedPane1.setSelectedIndex(9);
        
    }//GEN-LAST:event_a11MouseClicked

    private void a10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a10MouseClicked

        a7.setVisible(false);
        a8.setVisible(false);
        a9.setVisible(false);
        Rule2 r27 = new Rule2();
        r27.start();
        jTabbedPane1.setSelectedIndex(8);
        
    }//GEN-LAST:event_a10MouseClicked

    private void a9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a9MouseClicked

          a7.setVisible(false);
        a8.setVisible(false);
        a10.setVisible(false);
        Rule2 r25 = new Rule2();
        r25.start();
        jTabbedPane1.setSelectedIndex(8);
       
    }//GEN-LAST:event_a9MouseClicked

    private void a8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a8MouseClicked

         a7.setVisible(false);
        a10.setVisible(false);
        a9.setVisible(false);
                        Rule1 r11 = new Rule1();
        r11.start();
        jTabbedPane1.setSelectedIndex(4);
       
    }//GEN-LAST:event_a8MouseClicked

    private void a7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a7MouseClicked

        a10.setVisible(false);
        a8.setVisible(false);
        a9.setVisible(false);
                Rule2 r32 = new Rule2();
        r32.start();
        jTabbedPane1.setSelectedIndex(8);

    }//GEN-LAST:event_a7MouseClicked

    private void a3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a3MouseClicked

        a4.setVisible(false);
        a5.setVisible(false);
        a6.setVisible(false);
        Rule1 r = new Rule1();
        r.start();
        jTabbedPane1.setSelectedIndex(3);
                
    }//GEN-LAST:event_a3MouseClicked

    private void a6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a6MouseClicked

        a4.setVisible(false);
        a5.setVisible(false);
        a3.setVisible(false);
                Rule2 r3 = new Rule2();
        r3.start();
        jTabbedPane1.setSelectedIndex(7);
                
    }//GEN-LAST:event_a6MouseClicked

    private void a5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a5MouseClicked

           a4.setVisible(false);
        a3.setVisible(false);
        a6.setVisible(false);
        Rule2 r22 = new Rule2();
        r22.start();
        jTabbedPane1.setSelectedIndex(7);
               
    }//GEN-LAST:event_a5MouseClicked

    private void a4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a4MouseClicked

        a3.setVisible(false);
        a5.setVisible(false);
        a6.setVisible(false);
        Rule2 r2 = new Rule2();
        r2.start();
        jTabbedPane1.setSelectedIndex(7);
       
    }//GEN-LAST:event_a4MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Potok p = new Potok();
        p.start();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void a15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a15MouseClicked
      
      a16.setVisible(false);
          a17.setVisible(false);
          a18.setVisible(false);
                           Rule2 t61 = new Rule2();
        t61.start();
        jTabbedPane1.setSelectedIndex(10);
                 
    }//GEN-LAST:event_a15MouseClicked

    private void a16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a16MouseClicked
    
         a15.setVisible(false);
          a17.setVisible(false);
          a18.setVisible(false);
                                  Rule1 r18 = new Rule1();
        r18.start();
        jTabbedPane1.setSelectedIndex(11);
                           
    }//GEN-LAST:event_a16MouseClicked

    private void a17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a17MouseClicked

        a15.setVisible(false);
          a16.setVisible(false);
          a18.setVisible(false);
          Rule2 t6 = new Rule2();
        t6.start();
        jTabbedPane1.setSelectedIndex(10);              
    }//GEN-LAST:event_a17MouseClicked

    private void a18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a18MouseClicked

        a15.setVisible(false);
          a17.setVisible(false);
          a16.setVisible(false);  
                    Rule2 t63 = new Rule2();
        t63.start();
        jTabbedPane1.setSelectedIndex(10);         
    }//GEN-LAST:event_a18MouseClicked

    private void s1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s1MouseClicked
 
      s2.setVisible(false);
          s3.setVisible(false);  
                    Rule2 t16 = new Rule2();
        t16.start();
        jTabbedPane1.setSelectedIndex(10);
    }//GEN-LAST:event_s1MouseClicked

    private void s2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s2MouseClicked

        s1.setVisible(false);
          s3.setVisible(false);
                    Rule1 t = new Rule1();
        t.start();
        jTabbedPane1.setSelectedIndex(3);

                           
    }//GEN-LAST:event_s2MouseClicked

    private void s3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s3MouseClicked

               s1.setVisible(false);
          s2.setVisible(false);
                    Rule1 t = new Rule1();
        t.start();
        jTabbedPane1.setSelectedIndex(3);

                     
    }//GEN-LAST:event_s3MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       System.exit(0);
 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked

       Rule1 t2 = new Rule1();
        t2.start();
        jTabbedPane1.setSelectedIndex(4); 
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked

      Rule1 t3 = new Rule1();
        t3.start();
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_jLabel39MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jTabbedPane1.setSelectedIndex(10);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void a2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a2MouseClicked

          a1.setVisible(false);
        Rule2 r2 = new Rule2();
        r2.start();
        jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_a2MouseClicked

    private void a1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a1MouseClicked
         a2.setVisible(false);
        Rule1 r1 = new Rule1();
       r1.start();
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_a1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jTabbedPane1.setSelectedIndex(10);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        Rule1 t3ы = new Rule1();
        t3ы.start();
        jTabbedPane1.setSelectedIndex(2);
        
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

BufferedReader br = null;
 
        Recv rec = new Recv();
        rec.start();
        List<String> list = new ArrayList<String>();
        File file = new File("C:\\Users\\User\\Documents\\NetBeansProjects\\Сервер\\ДанныеСервера.txt");
        BufferedReader reader = null;
        try {
        reader = new BufferedReader(new FileReader(file));
        String text = null;
        while ((text = reader.readLine()) != null) {
        list.add(text);
        
        }
        String joined = String.join("\n", list);
    jTextArea2.append(joined);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
        try {
        if (reader != null) {
        reader.close();
        }
        } catch (IOException e) {
        }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
              Recv rec = new Recv();
        rec.start();
        List<String> list = new ArrayList<String>();
    File file = new File("C:\\Users\\User\\Documents\\NetBeansProjects\\Сервер\\ДанныеСервера.txt");
    BufferedReader reader = null;

try {
    reader = new BufferedReader(new FileReader(file));
    String text = null;

    while ((text = reader.readLine()) != null) {
        list.add(text);
        
    }String joined = String.join("\n", list);
    jTextArea1.append(joined);
} catch (FileNotFoundException e) {
} catch (IOException e) {
} finally {
    try {
        if (reader != null) {
            reader.close();
        }
    } catch (IOException e) {
    }
}      
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Автор a = new Автор();
        a.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

       
    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a1;
    private javax.swing.JLabel a10;
    private javax.swing.JLabel a11;
    private javax.swing.JLabel a12;
    private javax.swing.JLabel a13;
    private javax.swing.JLabel a14;
    private javax.swing.JLabel a15;
    private javax.swing.JLabel a16;
    private javax.swing.JLabel a17;
    private javax.swing.JLabel a18;
    private javax.swing.JLabel a2;
    private javax.swing.JLabel a3;
    private javax.swing.JLabel a4;
    private javax.swing.JLabel a5;
    private javax.swing.JLabel a6;
    private javax.swing.JLabel a7;
    private javax.swing.JLabel a8;
    private javax.swing.JLabel a9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel s1;
    private javax.swing.JLabel s2;
    private javax.swing.JLabel s3;
    // End of variables declaration//GEN-END:variables
}
