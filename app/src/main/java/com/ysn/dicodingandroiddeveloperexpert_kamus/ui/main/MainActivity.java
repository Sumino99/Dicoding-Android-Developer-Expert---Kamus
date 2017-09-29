package com.ysn.dicodingandroiddeveloperexpert_kamus.ui.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ysn.dicodingandroiddeveloperexpert_kamus.App;
import com.ysn.dicodingandroiddeveloperexpert_kamus.R;
import com.ysn.dicodingandroiddeveloperexpert_kamus.data.manager.DataManager;
import com.ysn.dicodingandroiddeveloperexpert_kamus.di.component.ActivityComponent;
import com.ysn.dicodingandroiddeveloperexpert_kamus.di.component.DaggerActivityComponent;
import com.ysn.dicodingandroiddeveloperexpert_kamus.di.module.ActivityModule;
import com.ysn.dicodingandroiddeveloperexpert_kamus.ui.dashboard.DashboardActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {

    private final String TAG = getClass().getSimpleName();
    @Inject
    MainPresenter mainPresenter;
    @Inject
    DataManager dataManager;
    private ActivityComponent activityComponent;

    @BindView(R.id.progress_bar_loading_activity_main)
    ProgressBar progressBarLoadingActivityMain;
    @BindView(R.id.text_view_preparing_data_activity_main)
    TextView textViewPreparingDataActivityMain;

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent
                    .builder()
                    .activityModule(new ActivityModule(this))
                    .appComponent(App.get(this).getAppComponent())
                    .build();
        }
        return activityComponent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);
        onAttach();
        mainPresenter.doLoadData(dataManager, this);
    }

    @Override
    protected void onResume() {
        onAttach();
        super.onResume();
    }

    @Override
    protected void onPause() {
        onDetach();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        onDetach();
        super.onDestroy();
    }

    @Override
    public void onAttach() {
        mainPresenter.onAttachView(this);
    }

    @Override
    public void onDetach() {
        mainPresenter.onDetachView();
    }

    @Override
    public void loadDataFailed() {
        textViewPreparingDataActivityMain.setVisibility(View.GONE);
        progressBarLoadingActivityMain.setVisibility(View.GONE);
        AlertDialog.Builder builderAlertDialogError = new AlertDialog.Builder(this);
        AlertDialog alertDialogError = builderAlertDialogError.create();
        alertDialogError.setCancelable(false);
        alertDialogError.setMessage("Error when load data. Please try again");
        alertDialogError.setButton(
                DialogInterface.BUTTON_POSITIVE,
                "Exit",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        System.exit(1);
                    }
                }
        );
        alertDialogError.show();
    }

    @Override
    public void loadData() {
        textViewPreparingDataActivityMain.setVisibility(View.GONE);
        progressBarLoadingActivityMain.setVisibility(View.GONE);
        Intent intentDashboardActivity = new Intent(this, DashboardActivity.class);
        startActivity(intentDashboardActivity);
    }
}

