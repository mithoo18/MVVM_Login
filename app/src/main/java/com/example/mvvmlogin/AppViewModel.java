package com.example.mvvmlogin;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.util.regex.Pattern;

public class AppViewModel extends BaseObservable {

private Model model;
private String sucessMessage ="Login Successful";
private String errorMessage ="Email or Password Not Valid";

@Bindable
private String toastMessage = null;

    public String getToastMessage() {

        return toastMessage;
    }

    private void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    @Bindable
    public String getUserEmail(){
        return model.getEmail();
    }

    public void setUserEmail(String email){
        model.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }
    @Bindable
    public String getUserPassword(){
        return model.getPassword();
    }
    public void setUserPassword(String password){
        model.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }

    public AppViewModel() {
        model = new Model("","");
    }
    public void onButtonClicked()
    {
        if(isValid())
            setToastMessage(sucessMessage);
        else
            setToastMessage(errorMessage);
    }
    public boolean isValid()
    {
        return !TextUtils.isEmpty(getUserEmail()) &&
                Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches()
                && getUserPassword().length()>5;
    }
}
