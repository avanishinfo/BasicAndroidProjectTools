package info.avanish.tools.others;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.databinding.DataBindingUtil;
import info.avanish.tools.R;
import info.avanish.tools.databinding.CustomAlertPopupBinding;


public class CustomAlertDialog extends Dialog {

  private Activity activity;
  private String title, message,cancelAction,okayAction;
  private CustomAlertPopupBinding mBinding;
  private AlertEvent mAlertEvent;

  public void onAlertEvent(AlertEvent mAlertEvent){
    this.mAlertEvent = mAlertEvent;
  }

  public CustomAlertDialog(Activity activity, String title,String message,String cancelAction,String okayAction) {
    super(activity);
    this.activity = activity;
    this.title = title;
    this.message = message;
    this.cancelAction = cancelAction;
    this.okayAction = okayAction;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    mBinding = DataBindingUtil.setContentView(activity.getParent(), R.layout.custom_alert_popup);

    setUpData();

    mBinding.cancelAction.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        dismiss();
      }
    });

    mBinding.okayAction.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          if (mAlertEvent!=null){
              mAlertEvent.OkayEvent();
          }
      }
    });

  }

  private void setUpData() {
    mBinding.titlePopup.setText(title);
    mBinding.messagePopup.setText(message);
    mBinding.cancelAction.setText(cancelAction);
    mBinding.okayAction.setText(okayAction);
  }

  interface AlertEvent{
    void OkayEvent();
  }

}