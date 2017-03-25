package com.mirego.cschat.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.EditText;

import com.mirego.cschat.R;
import com.mirego.cschat.controller.RegisterController;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mahad on 25/03/17.
 */

public class RegisterActivity extends BaseActivity{

    public static int PHOTO_SELECTED = 1;

    @BindView(R.id.register_root)
    ViewGroup root;

    @BindView(R.id.ret_username)
    EditText retUsername;

    @BindView(R.id.ret_password)
    EditText retPassword;

    @Inject
    RegisterController registerController;

    ProgressDialog progressDialog;
    String photoURL;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        //((CSChatApplication) getApplication()).component().inject(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.register_loading));
    }

    @OnClick(R.id.btn_register_submit)
    void onRegisterClicked(){
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        progressDialog.show();
        if(photoURL != null){

        }
    }

    @OnClick(R.id.btn_photo)
    void onPhotoClicked(){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, PHOTO_SELECTED);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == PHOTO_SELECTED){
            if(resultCode == RESULT_OK){
                Uri photoURI = data.getData();
                photoURL = photoURI.getPath();

                AmazonS3Client s3Client = new AmazonS3Client( new BasicAWSCredentials( MY_ACCESS_KEY_ID, MY_SECRET_KEY ) );

            }
        }
    }
}
