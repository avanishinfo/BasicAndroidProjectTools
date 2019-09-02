package info.avanish.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.kaopiz.kprogresshud.KProgressHUD;

import info.avanish.myapplication.databinding.ActivityMainBinding;
import info.avanish.tools.widget.progress.MyProgressBar;

public class MainActivity extends BaseActivity {

    ActivityMainBinding mBinding;
    MyProgressBar progressBar;
    KProgressHUD progressHUD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        progressBar = MyProgressBar.create(MainActivity.this)
                .setStyle(MyProgressBar.Style.ANNULAR_DETERMINATE)
                .setLabel("Please wait")
                .setDetailsLabel("").setWindowColor(getResources().getColor(info.avanish.tools.R.color.colorBlack))
                .setDimAmount(0.5f);

        progressHUD = KProgressHUD.create(MainActivity.this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("Please wait")
                .setDetailsLabel("").setWindowColor(getResources().getColor(info.avanish.tools.R.color.colorBlack))
                .setDimAmount(0.5f);


        mBinding.libProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simulateProgressUpdate();
                progressBar.show();

                progressHUD.dismiss();

            }
        });

        mBinding.khud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                progressBar.dismiss();
                progressHUD.show();

            }
        });

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

    int currentProgress;
    int doctypesuccess;
    int myassignsuccess;
    int circlesuccess;

    private void simulateProgressUpdate() {

        progressBar.setMaxProgress(100);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {

                currentProgress += 1;
                progressBar.setProgress(currentProgress);
                progressBar.setDetailsLabel("Downloading...."+(currentProgress)+" %");
                if(currentProgress == 1) {
                    //download services.

                }if (doctypesuccess==1 && currentProgress == 50) {
                    progressBar.setLabel("Doc Type");
                }if(myassignsuccess==1 && currentProgress == 70){
                    progressBar.setLabel("My Assignment");
                }if (circlesuccess==1 && currentProgress == 90){
                    progressBar.setLabel("Circle");
                }
                if (currentProgress < 100) {
                    handler.postDelayed(this, 50);
                }
            }
        }, 100);
    }

}
