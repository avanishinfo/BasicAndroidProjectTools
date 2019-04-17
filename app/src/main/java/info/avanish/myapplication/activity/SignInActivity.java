package info.avanish.myapplication.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Response;

import androidx.databinding.DataBindingUtil;
import info.avanish.myapplication.R;
import info.avanish.myapplication.api.LoginRequest;
import info.avanish.myapplication.databinding.ActivitySignInBinding;
import info.avanish.tools.api.ApiResponse;
import info.avanish.tools.api.ResponseParser;
import info.avanish.tools.api.VolleyNetworkRequest;
import info.avanish.tools.apputils.DeviceUtils;
import info.avanish.tools.constant.ApiConstants;
import info.avanish.tools.constant.PrefernceConstants;
import info.avanish.tools.constant.ValueConstants;
import info.avanish.tools.network.NetworkUtils;
import info.avanish.tools.others.ValidationErrorHelper;
import info.avanish.tools.view.BaseActivity;

public class SignInActivity extends BaseActivity {

    private static final String TAG = "SignInActivity";
    private static final int RC_SIGN_IN = 1001;
    private static final int RC_INSTA_IN = 1007;
    private ActivitySignInBinding mBinding;

    private String email, password;
    private LoginRequest loginRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in);

        setupToolbar();
        listener();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            loginRequest.cancel();

        } catch (Exception mE) {
            mE.printStackTrace();
        }
    }


    private void setupToolbar() {
        initToolbar(mBinding.toolbarLayout.toolbar);
        setTitle(R.string.login);
        enableBack(true);
        mBinding.toolbarLayout.toolbar.setNavigationIcon(R.drawable.arrow);
    }

    private void listener() {
        mBinding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFormValues();
                if (isValidForm())
                    if (NetworkUtils.isOnline(getApplicationContext())) {
                        callApi(email, password);
                    } else {
                        Toast.makeText(getApplicationContext(), R.string.err_network_connection, Toast.LENGTH_LONG).show();
                    }

            }
        });



        mBinding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.register.setAnimation(animateView());
               // startActivity(new Intent(SignInActivity.this, AppTypeActivity.class));
            }
        });

        mBinding.explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View mView) {
                Toast.makeText(SignInActivity.this, "working on it...", Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(SignInActivity.this, HomeUserActivity.class));
            }
        });

        mBinding.forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // startActivity(new Intent(SignInActivity.this, ForgotPasswordActivity.class));
            }
        });
    }

    private void getFormValues() {
        email = mBinding.email.getText().toString().trim();
        password = mBinding.password.getText().toString();

    }

    private boolean isValidForm() {
        boolean isValid = true;
        if (TextUtils.isEmpty(email)) {
            ValidationErrorHelper.showError(mBinding.wrapperEmail,
                    getString(R.string.s_enter_email_phone));
            isValid = false;
        } else {
            ValidationErrorHelper.clearError(mBinding.wrapperEmail);
        }

        if (TextUtils.isEmpty(password)) {
            ValidationErrorHelper.showError(mBinding.wrapperPassword,
                    getString(R.string.s_enter_password));
            isValid = false;

        } else {
            ValidationErrorHelper.clearError(mBinding.wrapperPassword);
        }

        return isValid;
    }

    private void callApi(String email, String password) {
        showProgressBar("login");

        Response.Listener<String> listener = response -> {
            ResponseParser responseParser = new ResponseParser();
            ApiResponse apiResponse = responseParser.parse(response);
            hideProgressBar();
            if (apiResponse.isSuccess()) {
                if (apiResponse.getDetails() != null) {
                   // Payload details = responseParser.getPayload(Payload.class);
                    afterSuccess();
                }

            } else {
                showSnakebar(apiResponse.getMessage(), mBinding.getRoot());
            }
            hideProgressBar();
        };

        Response.ErrorListener errorListener = error -> hideProgressBar();

        loginRequest = new LoginRequest(email, password, ApiConstants.PHONE_TYPE, DeviceUtils.getDeviceId(this), listener, errorListener);
        VolleyNetworkRequest.getInstance(this).addToRequestQueue(loginRequest);

    }

    private void afterSuccess() {
        myPrefernce.saveData(PrefernceConstants.IS_LOGIN, ValueConstants._TRUE);

       /* myPrefernce.saveData(PrefernceConstants.USER_ID, String.valueOf(mDetails.getUserId()));
        myPrefernce.saveData(PrefernceConstants.USER_FULLNAME, mDetails.getFullName());
        myPrefernce.saveData(PrefernceConstants.USER_EMAIL, mDetails.getEmail());
        myPrefernce.saveData(PrefernceConstants.USER_PHONE, mDetails.getPhoneNumber());
        myPrefernce.saveData(PrefernceConstants.USER_IS_AVAILABLE, mDetails.getIsAvailable());
        myPrefernce.saveData(PrefernceConstants.USER_PROFILE_IMAGE, mDetails.getProfileImage());
        myPrefernce.saveData(PrefernceConstants.USER_SOCIAL_ID, mDetails.getSocialId());
        myPrefernce.saveData(PrefernceConstants.USER_SOCIAL_TYPE, mDetails.getSocialType());*/

    }

}
