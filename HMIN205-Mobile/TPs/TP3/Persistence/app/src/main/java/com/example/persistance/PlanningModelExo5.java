package com.example.persistance;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlanningModelExo5 extends ViewModel {

    private MutableLiveData<String[]> mSlots;

    public MutableLiveData<String[]> getSlots() {
        if (mSlots == null)
            initSlots();
        return mSlots;
    }

    private void initSlots() {
        String[] slots = new String[4];
        slots[0] = "Rencontre client Dupont";
        slots[1] = "Travailler le dossier recrutement";
        slots[2] = "Réunion équipe";
        slots[3] = "Préparation dossier vente";

        mSlots = new MutableLiveData<>();
        mSlots.setValue(slots);
    }
}