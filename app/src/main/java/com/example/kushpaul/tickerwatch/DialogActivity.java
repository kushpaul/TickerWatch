package com.example.kushpaul.tickerwatch;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialogActivity extends BaseActivity {
    private int checkedID;
    @BindView(R.id.activity_dialog_rdg)
    RadioGroup radioGroup;
    private View v;

    @OnClick(R.id.activity_dialog_cancel)
    public void cancel(View v){
        cancel(v);
    }
    @OnClick(R.id.activity_dialog_ok)
    public void ok(View v){
        switch (checkedID){
            case R.id.activity_dialog_rb1:
                normalDialog();
                break;
            case R.id.activity_dialog_rb2:
                normalDialog2();
                break;
            case R.id.activity_dialog_rb3:
                normalDialog3();
                break;
            case R.id.activity_dialog_rb4:
                CustomDialog customDialog = new CustomDialog(this, new CustomDialog.ICustomDialogListener() {
                    @Override
                    public void onOKClicked(String msg) {
                        shortToast(msg);
                    }

                    @Override
                    public void onCancleClicked() {

                    }
                });
                customDialog.setCanceledOnTouchOutside(true);
                customDialog.show();
                break;
            default:
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                checkedID = checkedId;
            }
        });
    }
    private void normalDialog() {
        shortToast("You clicked Yes");
        finish();
    }
    private void normalDialog2() {
        shortToast("You clicked No");
        finish();
    }
    private void normalDialog3() {
        System.exit(0);
    }
}
