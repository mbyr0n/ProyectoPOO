/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectopoo;

import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Iván
 */
public class LoginController implements Initializable {

    @FXML
    private PasswordField contrasenia;
    @FXML
    private TextField usuario;
    @FXML
    private Label mensaje;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(MouseEvent event) {
        try{
            String us = usuario.getText();
            String contr = contrasenia.getText();
            
            ArrayList<Negociante> negs = Negociante.readFileSer("negociantes.ser");
            boolean ev = false;
            
            for (Negociante n: negs){
                if (n.getCorreo()==us && n.getClave()== Util.toHexString(Util.generarHash(contr)))
                    ev = true;
            }
            
            if (!ev)
                throw new UsuarioNoExistenteException("Usuario Incorrecto");
            
            Alert a = new Alert(Alert.AlertType.INFORMATION,"Usuario Correcto");
            a.show();
            mensaje.setText("Usuario Correcto");
            cleanFields();
        }catch(UsuarioNoExistenteException u){
            Alert a = new Alert(Alert.AlertType.ERROR,u.getMessage());
            a.show();
        }catch (NoSuchAlgorithmException a){
            System.out.println(a);
        }
    }
    
     private void cleanFields(){
        usuario.setText("");
        contrasenia.setText("");
    }
    
}
