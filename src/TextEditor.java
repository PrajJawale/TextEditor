//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class TextEditor implements ActionListener
//{
//    JFrame frame;
//    JMenuBar menubar;
//    JMenu file,edit;
//    // Create Items for menu
//    JMenuItem newFile , saveFile , openFile;
//    JMenuItem copy , paste , cut , selectAll , close ;
//
//    // To add the TextArea
//    JTextArea textArea;
//
//
//    TextEditor(){
//        frame = new JFrame();
//
//        //To initialise the menubar of frame
//        menubar = new JMenuBar();
//
//        textArea = new JTextArea();
//
//        // Add the menus in menuba
//        file = new JMenu("File");
//        edit = new JMenu("Edit");
//
//        // Add the item in File menu
//        newFile = new JMenuItem("NewFile");
//        saveFile= new JMenuItem("SaveFile");
//        openFile = new JMenuItem("OpenFile");
//
//        // To add ActionLIstner before the add in main list
//        newFile.addActionListener(this);
//        saveFile.addActionListener(this);
//        openFile.addActionListener(this);
//
//        file.add(newFile);
//        file.add(saveFile);
//        file.add(openFile);
//
//
//        // To add the item in edit menu
//        cut = new JMenuItem("Cut");
//        copy = new JMenuItem("Copy");
//        paste = new JMenuItem("Paste");
//        selectAll = new JMenuItem("SelectAll");
//        close = new JMenuItem("Close");
//
//        cut.addActionListener(this);
//        copy.addActionListener(this);
//        paste.addActionListener(this);
//        selectAll.addActionListener(this);
//        close.addActionListener(this);
//        // To add the action on menu item
//
//        edit.add(cut);
//        edit.add(copy);
//        edit.add(paste);
//        edit.add(selectAll);
//        edit.add(close);
//
//        //To add menus in menubar
//        menubar.add(file);
//        menubar.add(edit);
//
//        frame.setJMenuBar(menubar); // To set the menu's in menubar
//
//
//        // Add the panel for textArea
//        JPanel panel = new JPanel();
//        panel.setBorder(new EmptyBorder(5,5,5,5));
//        panel.setLayout(new BorderLayout(0,0));
//
//        panel.add(textArea,BorderLayout.CENTER);
//
//
//        //Set the frame of the textEditor
//
//        frame.setBounds(0,0,400,400);
//        frame.setVisible(true);
//        frame.setLayout(null);
//
//    }
//    public void actionPerformed(ActionEvent actionEvent){
//        if(actionEvent.getSource()==cut){
//            textArea.cut();
//        }
//        if(actionEvent.getSource()==copy){
//            textArea.copy();
//        }
//        if(actionEvent.getSource()==paste){
//            textArea.paste();
//        }
//        if(actionEvent.getSource()==selectAll){
//            textArea.selectAll();
//        }
//        if(actionEvent.getSource()==close){
//            System.exit(0);
//        }
//    }
//    public static void main(String[] args) {
//        TextEditor tx = new TextEditor();
//
//    }
//}


// Library in java
import javax.imageio.IIOException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

class TextEditor implements ActionListener {   // use actionListner interface access the method in actionListner
    //To create Frame we import Jframe class
    JFrame frame;

    JMenuBar menuBar;

    JMenu file , edit ;

    JMenuItem newFile , saveFile , openFile;
    JMenuItem copy , paste , cut , selectAll , close;

    JTextArea textArea;

    // For the accesing the class properties we create the constructer with only use of instacnce of this class we create the textArea
    TextEditor(){
        frame = new JFrame(); // making the instance of the class
        menuBar = new JMenuBar();

        textArea = new JTextArea();

        frame.setTitle("Text Editor");

        file = new JMenu("File");
        edit = new JMenu("Edit");

        // Adding item in the file Menu
        newFile = new JMenuItem("newFile");
        saveFile = new JMenuItem("saveFile");
        openFile = new JMenuItem("openFile");

        // add action listner here
        newFile.addActionListener(this);
        saveFile.addActionListener(this);
        openFile.addActionListener(this);

        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);

        //Adding item in the Edit menu
        //copy , paste , cut , selectAll , close
        copy = new JMenuItem("Copy");
        paste= new JMenuItem("Paste");
        cut = new JMenuItem("Cut");
        selectAll = new JMenuItem("SelectAll");
        close = new JMenuItem("Close");

        //Add actionListener for edit menuItem
        copy.addActionListener(this);
        paste.addActionListener(this);
        cut.addActionListener(this);
        selectAll.addActionListener(this);
        close.addActionListener(this);

        //Add
        edit.add(copy);
        edit.add(paste);
        edit.add(cut);
        edit.add(selectAll);
        edit.add(close);


        menuBar.add(file);
        menuBar.add(edit);

        // Frame Area

        frame.setJMenuBar(menuBar); // To set the menuBar in the frame
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5,5,5,5));

        panel.setLayout(new BorderLayout(0,0));

        panel.add(textArea,BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        panel.add(scrollPane);
        frame.add(panel);
       // frame.add(textArea); // To add the textArea to the frame
        frame.setBounds(0,0,500,500);
        frame.setVisible(true); // to visible the frame
        frame.setLayout(null);
    }
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        //System.out.println(textEditor);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource()==copy){
            textArea.copy();
        }

        if(actionEvent.getSource()==paste){
            textArea.paste();
        }

        if(actionEvent.getSource()==cut){
            textArea.cut();
        }

        if(actionEvent.getSource()==selectAll){
            textArea.selectAll();
        }

        if(actionEvent.getSource()==close){
            System.exit(0);
        }
        if(actionEvent.getSource()==saveFile){
            JFileChooser fileChooser = new JFileChooser("C:");
            int chooseOption = fileChooser.showSaveDialog(null);

        }

        if(actionEvent.getSource()==openFile){
            // open the file chooser
            JFileChooser fileChooser = new JFileChooser("C:");

            int chooseOption = fileChooser.showOpenDialog(null);
            //if we have clicked on the open button 
            if(chooseOption == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                String filepath = file.getPath();
                try{
                    FileReader fileread = new FileReader(filepath);
                    BufferedReader bufferedReader= new BufferedReader(fileread);

                    String intermediate="" , output="";
                    while((intermediate= bufferedReader.readLine())!=null ){
                        output+=intermediate + "\n";
                    }
                    textArea.setText(output);
                }catch (IOException fileNotFoundException){
                   fileNotFoundException.printStackTrace();
                }

            }
        }

        if(actionEvent.getSource()== saveFile){
            JFileChooser fileChooser = new JFileChooser("C");

            int chooseOption = fileChooser.showSaveDialog(null);

            if(chooseOption == JFileChooser.APPROVE_OPTION){
               File file = fileChooser.getSelectedFile().getAbsoluteFile();
               try{
                   FileWriter fileWriter = new FileWriter(file);

                   BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
                   textArea.write(bufferWriter);
                   bufferWriter.close();
               }catch (IOException ioException){
                   ioException.printStackTrace();
               }
            }
        }
    }
}