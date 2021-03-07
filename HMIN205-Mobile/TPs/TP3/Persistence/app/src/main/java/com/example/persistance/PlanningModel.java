package com.example.persistance;

import androidx.lifecycle.ViewModel;

public class PlanningModel extends ViewModel {

    private String[] creneaux;

    public String[] getCreneaux() {
        if (creneaux == null)
            initCreneaux();
        return creneaux;
    }

    private void initCreneaux() {
        creneaux = new String[4];
        creneaux[0] = "Rencontre client Dupont";
        creneaux[1] = "Travailler le dossier recrutement";
        creneaux[2] = "Réunion équipe";
        creneaux[3] = "Préparation dossier vente";
    }

}