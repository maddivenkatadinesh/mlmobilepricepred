package com.example.mobileprojectapp;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.EditText;

public class validation implements InputFilter {

    EditText e1,e2,e3;
    public int min =3000;
    public int max=5000;
    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        return null;
    }
}
