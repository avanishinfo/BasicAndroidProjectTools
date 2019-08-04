package info.avanish.myapplication;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import info.avanish.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {

    ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);


        /*SafetyNet.getClient(this)
                .isVerifyAppsEnabled()
                .addOnCompleteListener(new OnCompleteListener<VerifyAppsUserResponse>() {
                    @Override
                    public void onComplete(Task<VerifyAppsUserResponse> task) {
                        if (task.isSuccessful()) {
                            VerifyAppsUserResponse result = task.getResult();
                            if (result.isVerifyAppsEnabled()) {
                                Log.d("MY_APP_TAG", "The Verify Apps feature is enabled.");
                            } else {
                                Log.d("MY_APP_TAG", "The Verify Apps feature is disabled.");
                            }
                        } else {
                            Log.e("MY_APP_TAG", "A general error occurred.");
                        }
                    }
                });*/

    }
}
