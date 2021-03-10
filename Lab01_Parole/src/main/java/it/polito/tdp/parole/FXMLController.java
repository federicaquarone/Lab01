package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML // fx:id="btnCancella"
    private Button btnCancella; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtTime"
    private TextArea txtTime; // Value injected by FXMLLoader

    @FXML
    void doInsert(ActionEvent event) {
    	String risultato="";
    	elenco.addParola(txtParola.getText());
    	for (String s: elenco.getElenco()) {
    		risultato += s+"\n";
    	   txtResult.setText(risultato);
    	   this.txtTime.setText(Long.toString(System.nanoTime()));
    }
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	elenco.reset();
    	txtParola.clear();
    	this.txtTime.setText(Long.toString(System.nanoTime()));
    }

    @FXML
    void doCancella(ActionEvent event) {
    	this.txtResult.clear();
    	elenco.cancella(this.txtParola.getText());
    	for(String s: elenco.getElenco()) {
    		this.txtResult.appendText(s+"\n");
    		this.txtTime.setText(Long.toString(System.nanoTime()));
    	}

    }
    
    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        elenco = new Parole() ;
    }
}
