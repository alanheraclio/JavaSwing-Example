package dpoo2_u2_ea_morr.chat;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatCliente {
    //SE CREAN LOS ELEMENTOS PARA CONSTRUIR LA VENTANA DEL CLIENTE
    JFrame ventana = null;
    JButton boton_enviar = null;
    JTextField mensaje_field = null;
    JTextArea mensaje_area = null;
    JPanel chat_panel = null;
    JPanel boton_panel = null;
    JScrollPane scroll = null;
    
    //SE CREAN LOS ELEMTOS PARA LA COMUNICACION POR SOCKETS
    Socket socket = null;
    BufferedReader lector = null;
    PrintWriter escritor = null;
    
    public ChatCliente() {
        //SE INICIALIZAN TODOS LOS ELEMENTOS EN EL CONSTRUCTOR
        ventana = new JFrame("Cliente");
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
        ventana.setBounds(1200, 400, 400, 230);
        ventana.setVisible(true);
        ventana.setResizable(false); 
        
        //SE LLAMA LA FUNCION QUE CONTIENE LOS HILOS DE LA COMUNICACION DEL CHAT
        correrHilos();
    } 
    
    //CLASE QUE LLAMA LAS FUNCIONES DE LEER Y EXCRIBIR EN EL CHAT
    public void correrHilos(){
        //SE CREA UN HILO PARA CORRER LOS OTROS HILOS DENTRO DE EL
        System.out.println("correr hilos cliente corriendo...");
        Thread main = new Thread(new Runnable() {
            public void run() {
                //SE INTENTA COMUNICAR AL CANAL DE COMUNICACION DEL SERVIDOR
                try {
                    //SE CONECTA AL PUERTO DEL CANAL DE COMUNACION QUE ABRIO EL SERVIDOR
                    socket = new Socket("localhost",9000);
                    //SE LLAMA A LOS METODOS LEER Y ESCRIBIR
                    leerMensaje();
                    escribirMensaje();
                 //EN CASO DE ERROR SE MUESTRA EL MENSAJE   
                } catch (Exception e) {
                    System.out.println("Error al correr socket en el cliente"+e);
                }
            }
        });
        //SE ARRANCA EL HILO
        main.start();
    }
    
    //METODO QUE CONTIENE EL HILO QUE OBTENDR ALOS MENSAJES
    public void leerMensaje(){
        //SE CREA UN HILO QUE MANTENDR ALA LECTURA DE LOS MENSAJES
        Thread leer_hilo = new Thread(new Runnable(){
            public void run(){
                //SE INTENTA OBTENER EL MENSAJE Y SE MUESTRA EN LA VENTANA
                try {
                lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while(true){
                    String mensaje_recibido = lector.readLine();
                    mensaje_area.append("Servidor dice: "+mensaje_recibido+"\n");
                }
                //EN CASO DE ERROR SE MUESTRA EL MENSAJE
                } catch (Exception e) {
                    System.out.println("chat error al leer"+e);
                }
            
            }
        });
        //SE ARRANCA EL HILO LEER
        leer_hilo.start();
    }
    
    //METODO PARA ENVIAR MENSAJES
    public void escribirMensaje(){
        //SE CREA UN HILO PARA ENVIAR MENSAJES
        Thread escribir_hilo = new Thread(new Runnable() {
            public void run() {
                try {
                    //SE INTENTA ENVIAR EL MENSAJE
                    escritor = new PrintWriter(socket.getOutputStream(),true);
                    //SE ASIGNA LA ACCION AL BOTON ENVIAR
                    boton_enviar.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            String mensaje = mensaje_field.getText();
                            escritor.println(mensaje);
                            mensaje_field.setText(null);
                            mensaje_area.append("Cliente dice: "+mensaje+"\n");
                            System.out.println("cliente boton enviar clicked");
                        }            
                    });
                    //EN CASO DE ERROR SE ENVIA EL MENSAJE
                } catch (Exception e) {
                    System.out.println("chat error al escribir"+e);
                }
            }
        });
        //SE ARRNACA EL HILO PARA ENVIAR EL MENSAJE
        escribir_hilo.start();
    }
    
}
