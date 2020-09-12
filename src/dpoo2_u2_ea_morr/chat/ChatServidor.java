package dpoo2_u2_ea_morr.chat;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatServidor {
    
    JFrame ventana = null;
    JButton boton_enviar = null;
    JTextField mensaje_field = null;
    JTextArea mensaje_area = null;
    JPanel chat_panel = null;
    JPanel boton_panel = null;
    JScrollPane scroll = null;
    
    ServerSocket servidor = null;
    Socket socket = null;
    BufferedReader lector = null;
    PrintWriter escritor = null;
    
    public ChatServidor() {
        ventana = new JFrame("Servidor");
        boton_enviar = new JButton("Enviar");
        mensaje_field = new JTextField(5);
        mensaje_area = new JTextArea(10,12);
        scroll = new JScrollPane(mensaje_area);
        chat_panel = new JPanel();
        chat_panel.setLayout(new GridLayout(1,1));
        chat_panel.add(scroll);
        boton_panel = new JPanel();
        boton_panel.setLayout(new GridLayout(1,2));
        boton_panel.add(mensaje_field);
        boton_panel.add(boton_enviar);
        ventana.setLayout(new BorderLayout());
        ventana.add(chat_panel, BorderLayout.NORTH);
        ventana.add(boton_panel, BorderLayout.SOUTH);
        ventana.setBounds(1200, 100, 400, 230);
        ventana.setVisible(true);
        ventana.setResizable(false); 
        
        Thread main = new Thread(new Runnable() {
            public void run() {
                try {
                    try {
                        servidor = new ServerSocket(9000);
                        while(true){
                            socket = servidor.accept();
                            leerMensaje();
                            escribirMensaje();
                        }
                    } catch (Exception e) {
                        System.out.println("error al conectarse al puerto: "+e);
                    }
                    
                } catch (Exception e) {
                    System.out.println("error al correr socket: "+e);
                }
            }
        });
        main.start();
    }   
    
    public void leerMensaje(){
        Thread leer_hilo = new Thread(new Runnable(){
            public void run(){
                
                try {
                lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while(true){
                    String mensaje_recibido = lector.readLine();
                    mensaje_area.append("Cliente dice: "+mensaje_recibido);
                }

                } catch (Exception e) {
                    System.out.println("chat error al leer"+e);
                }
            
            }
        });
        leer_hilo.start();
    }
    
    public void escribirMensaje(){
        Thread escribir_hilo = new Thread(new Runnable() {
            public void run() {
                try {
                    escritor = new PrintWriter(socket.getOutputStream(),true);
                    boton_enviar.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            String mensaje = mensaje_field.getText();
                            escritor.println(mensaje);
                            mensaje_field.setText(null);
                            System.out.println("servidor boton enviar clicked");
                        }            
                    });
                } catch (Exception e) {
                    System.out.println("chat error al escribir"+e);
                }
            }
        });
        escribir_hilo.start();
    }
        
}
