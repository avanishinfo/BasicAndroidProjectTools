package info.avanish.myapplication;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.snackbar.Snackbar;



/**
 * A simple {@link Fragment} subclass.
 * @author Avanish Singh
 */
public class BaseContainer extends Fragment {

    private static final String FOLDER = "app_base_container";
    protected Context context;
    //protected MySingleton session;

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
        //session = MySingleton.getInstance(context);

    }

    public void showSnakebar(String message, View view) {
        if (view == null) {
        } else {
            final Snackbar snackbar = Snackbar
                    .make(view, message, 7000);
            snackbar.setAction(info.avanish.tools.R.string.close, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    snackbar.dismiss();
                }
            });
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(context, info.avanish.tools.R.color.colorAccent));
            snackbar.setActionTextColor(Color.WHITE);
            View sbView = snackbar.getView();
            TextView textView = (TextView) sbView.findViewById(info.avanish.tools.R.id.snackbar_text);
            textView.setTextColor(ContextCompat.getColor(context, info.avanish.tools.R.color.colorWhite));
            snackbar.show();
        }
    }

    protected void requestError(int code) {
       /* switch(code){
            case ApiConstants.STATUS_REQUEST_NOT_AVAILABLE:
                Toast.makeText(context, info.avanish.tools.R.string.err_server_error404, Toast.LENGTH_SHORT).show();
                break;
            case ApiConstants.STATUS_REQUEST_BROKEN:
                Toast.makeText(context, info.avanish.tools.R.string.err_server_error500, Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(context, info.avanish.tools.R.string.err_server_errorUnknow, Toast.LENGTH_SHORT).show();
        }*/
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
        transaction.replace(info.avanish.tools.R.id.container_framelayout, fragment);
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
        transaction.setCustomAnimations(info.avanish.tools.R.anim.enter, info.avanish.tools.R.anim.exit, info.avanish.tools.R.anim.reverse_enter, info.avanish.tools.R.anim.reverse_exit);
        transaction.replace(info.avanish.tools.R.id.container_framelayout, fragment);
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


    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = getActivity().getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(getActivity());
        }
        assert imm != null;
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
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
        transaction.add(info.avanish.tools.R.id.container_framelayout, fragment);
        transaction.commit();
        getChildFragmentManager().executePendingTransactions();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}