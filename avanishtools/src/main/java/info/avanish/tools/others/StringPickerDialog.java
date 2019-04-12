package info.avanish.tools.others;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class StringPickerDialog extends DialogFragment {


    private static final String ARGS_ITEMS = "items";
    private static final String ARGS_TITLE = "title";
    private List<String> items = new ArrayList<>();
    private String title;
    private OnSelectedListener listener;

    public static StringPickerDialog newInstance(String title, List<String> items) {

        Bundle args = new Bundle();
        args.putStringArrayList(ARGS_ITEMS, (ArrayList<String>) items);
        args.putString(ARGS_TITLE, title);

        StringPickerDialog fragment = new StringPickerDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        List<String> newItems = args.getStringArrayList(ARGS_ITEMS);
        if (newItems != null) {
            items.clear();
            items.addAll(newItems);
        }
        title = args.getString(ARGS_TITLE);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        if (!TextUtils.isEmpty(title)){
            builder.setTitle(title);
        }
        builder.setItems(items.toArray(new String[items.size()]), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (listener != null) {
                    listener.onSelect(items.get(which), which);
                }

            }
        });
        return builder.create();
    }

    public interface OnSelectedListener{
        void onSelect(String val, int which);
    }

    public void setOnSelectedListener(OnSelectedListener listener){
        this.listener = listener;
    }


}
