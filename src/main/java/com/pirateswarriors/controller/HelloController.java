package com.pirateswarriors.controller;

import com.pirateswarriors.model.Personnage;
import com.pirateswarriors.view.PersonnageVue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


    private Personnage personnage;
    private PersonnageVue personnageVue;
    @FXML
    private Label welcomeText;

    @FXML
    private Pane paneCentral;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.personnage = new Personnage();
        this.personnageVue = new PersonnageVue(this.personnage);
        this.paneCentral.getChildren().add(personnageVue.getImageBateau());

        // Établir la liaison entre le modèle et la vue
        personnage.positionXProperty().bind(personnageVue.getImageBateau().xProperty());

        personnage.positionYProperty().bind(personnageVue.getImageBateau().yProperty());

    }

    public Pane getPaneCentral() {
        return this.paneCentral;
    }



}