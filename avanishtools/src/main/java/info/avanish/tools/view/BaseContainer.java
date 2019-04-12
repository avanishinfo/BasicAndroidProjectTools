package info.avanish.tools.view;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.kaopiz.kprogresshud.KProgressHUD;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import info.avanish.tools.R;
import info.avanish.tools.constant.ApiConstants;
import info.avanish.tools.data.MySingleton;


/**
 * A simple {@link Fragment} subclass.
 * @author Avanish Singh
 */
public class BaseContainer extends Fragment {

    private static final String FOLDER = "app_base_container";
    protected Context context;
    private KProgressHUD progressDialog;
    protected MySingleton myPrefernce;

    public BaseContainer() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            this.context = (BaseActivity) context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myPrefernce = MySingleton.getInstance(context);
        createProgressBar("");
    }

    public void createProgressBar(String detailsLabel) {
        progressDialog = KProgressHUD.create(context).setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel(getString(R.string.please_wait))
                .setDetailsLabel(detailsLabel).setWindowColor(getResources().getColor(R.color.colorBlack))
                .setDimAmount(0.5f);
    }

    public void showProgressBar() {
        /*if (context != null) {
            //if (!getActivity().isFinishing()) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.show();
                    }
                });
            //}
        } else {
            createProgressBar("");
            progressDialog.show();
        }*/

        progressDialog.show();
    }

    public void hideProgressBar() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    public void showSnakebar(String message, View view) {
        if (view == null) {
        } else {
            final Snackbar snackbar = Snackbar
                    .make(view, message, 7000);
            snackbar.setAction(R.string.close, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    snackbar.dismiss();
                }
            });
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent));
            snackbar.setActionTextColor(Color.WHITE);
            View sbView = snackbar.getView();
            TextView textView = (TextView) sbView.findViewById(R.id.snackbar_text);
            textView.setTextColor(ContextCompat.getColor(context, R.color.colorWhite));
            snackbar.show();
        }
    }

    protected void requestError(int code) {
        switch(code){
            case ApiConstants.STATUS_REQUEST_NOT_AVAILABLE:
                Toast.makeText(context, R.string.err_server_error404, Toast.LENGTH_SHORT).show();
                break;
            case ApiConstants.STATUS_REQUEST_BROKEN:
                Toast.makeText(context,R.string.err_server_error500, Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(context,R.string.err_server_errorUnknow, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void replaceFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        //transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.reverse_enter, R.anim.reverse_exit);
        transaction.replace(R.id.container_framelayout, fragment);
        transaction.commit();
        try {

            getChildFragmentManager().executePendingTransactions();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public void replaceFragmentWithBundle(Fragment fragment, boolean addToBackStack, Bundle bundle) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        fragment.setArguments(bundle);
        transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.reverse_enter, R.anim.reverse_exit);
        transaction.replace(R.id.container_framelayout, fragment);
        transaction.commit();
        try {

            getChildFragmentManager().executePendingTransactions();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public void removeFragment(Fragment fragment) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.remove(fragment);
        transaction.commit();
        try {
            getChildFragmentManager().executePendingTransactions();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public boolean popFragment() {
        Log.e("test", "pop fragment: " + getChildFragmentManager().getBackStackEntryCount());
        boolean isPop = false;
        if (getChildFragmentManager().getBackStackEntryCount() > 0) {
            isPop = true;
            getChildFragmentManager().popBackStack();
        }
        return isPop;
    }

    public boolean popall_Fragment() {

        boolean isPop = false;
        for (int i = 0; i < getChildFragmentManager().getBackStackEntryCount() - 1; ++i) {
            isPop = true;
            getChildFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
        return isPop;
    }

    public void addFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.add(R.id.container_framelayout, fragment);
        transaction.commit();
        getChildFragmentManager().executePendingTransactions();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}