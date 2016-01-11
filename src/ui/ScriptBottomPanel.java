package ui;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by Cabeza on 2016/1/11.
 */
public class ScriptBottomPanel extends JPanel{
    private Button open=new Button("open");
    private Button save=new Button("save");
    private Button run=new Button("run");
    private JPanel buttonGroupPanel=new JPanel();
    private JTextArea textArea=new JTextArea(9,5);
    private JScrollPane scroll = new JScrollPane(textArea);

    public ScriptBottomPanel(){
        this.setLayout(new BorderLayout());
        buttonGroupPanel.add(open);
        buttonGroupPanel.add(save);
        buttonGroupPanel.add(run);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.add(scroll, BorderLayout.CENTER);
        this.add(buttonGroupPanel, BorderLayout.SOUTH);
        this.initListener();
    }
    public void initListener(){
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc=new JFileChooser();
                jfc.setCurrentDirectory(new File("d://"));
                jfc.setFileFilter(new FileFilter() {
                    @Override
                    public boolean accept(File f) {
                        return f.getName().endsWith(".txt");
                    }

                    @Override
                    public String getDescription() {
                        return null;
                    }
                });
                if(jfc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
                    textArea.setText("");
                    try {
                        FileInputStream fis
                                = new FileInputStream(jfc.getSelectedFile());
                        InputStreamReader isr
                                = new InputStreamReader(fis,"utf-8");
                        BufferedReader br
                                = new BufferedReader(isr);
                        String str = null;
                        while ((str = br.readLine()) != null) {
                           textArea.append(str+"\r\n");
                        }
                        br.close();
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.setFileFilter(new FileFilter() {
                    @Override
                    public boolean accept(File f) {
                        return f.getName().endsWith(".txt");
                    }

                    @Override
                    public String getDescription() {
                        return null;
                    }
                });
                fc.setDialogType(JFileChooser.FILES_ONLY);
                fc.setDialogTitle("选择文件");
                fc.setMultiSelectionEnabled(false);
                if(fc.showSaveDialog(fc)==JFileChooser.APPROVE_OPTION ){
                    try{
                        FileOutputStream fos = new FileOutputStream(fc.getSelectedFile());
                        BufferedOutputStream bos
                                = new BufferedOutputStream(fos);
                        PrintWriter pw = new PrintWriter(bos, true);
                        pw.print(textArea.getText());
                        pw.close();
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }

                }

            }

        });
        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(textArea.getText());
            }
        });
    }

}
