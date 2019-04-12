package info.avanish.tools.others;

import android.text.Editable;
import android.text.TextWatcher;

import com.google.android.material.textfield.TextInputLayout;

public class ValidationErrorHelper {
    public static void showError(TextInputLayout textInputLayout, String errorMsg) {
        textInputLayout.setError(errorMsg);
    }

    public static void clearError(TextInputLayout textInputLayout) {
        textInputLayout.setError(null);
        textInputLayout.setErrorEnabled(false);
    }

    public static void showHideError(final TextInputLayout inputLayout, final String error){
        inputLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() < 1) {
                    inputLayout.setErrorEnabled(true);
                    inputLayout.setError(error);
                }

                if (s.length() > 0) {
                    inputLayout.setError(null);
                    inputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

}