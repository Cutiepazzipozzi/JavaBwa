import java.net.*;

import java.io.*;
import java.awt.*;
import java.awt.event.*;

// 15-1
class Exercise15_1 {
    public static void main(String[] args) {
        byte[] ip = {(byte)192, (byte)168, (byte)10, (byte)100};
        byte[] subnet = {(byte)255, (byte)255, (byte)255, (byte)0};

        byte[] nwAddress = new byte[4];
        byte[] hostAddress = new byte[4];

        System.out.print("네트워크 주소:");

        for(int i = 0; i < ip.length; i++) {
            nwAddress[i] = (byte) (ip[i] & subnet[i]);
            System.out.print(nwAddress[i] >= 0 ? nwAddress[i] : nwAddress[i]+256);
            System.out.print(".");
        }

        System.out.println();
        System.out.print("호스트 주소:");

        for(int i = 0; i < ip.length; i++) {
            hostAddress[i] = (byte) (ip[i] & ~subnet[i]);
            System.out.print(hostAddress[i] >= 0 ? hostAddress[i] : hostAddress[i]+256);
            System.out.print(".");
        }

        System.out.println();
    }
}

//15-3
class SourceViewer extends Frame {
    TextField tf = new TextField();
    TextArea ta = new TextArea();
    SourceViewer(String title) { 
        super(title); 

        add(tf, "North");
        add(ta, "Center");

        tf.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                displaySource();
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
        }
        });

        setBounds(500, 200, 500, 300); 
        setVisible(true); 
    }
    void displaySource() {
        URL url = null;
        BufferedReader input = null;
        String address = tf.getText().trim();
        String line = "";

        ta.setText("");

        try {
            if(!address.startsWith("http://"))
            address = "http://"+address;
            url = new URL(address);
            input = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
        
            while((line=input.readLine()) != null) {
                ta.append(line);
                ta.append("\n");
            }
        } catch(Exception e) {
            ta.setText("유효하지 않은 URL입니다.");
        }
    }

    public static void main(String[] args) {
        SourceViewer mainWin = new SourceViewer("Source Viewer");
    }
}
