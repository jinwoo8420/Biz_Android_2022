package com.example.messangerapp;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.messangerapp.DTO.user;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.UploadTask;

/*
    회원 가입을 하는 화면

    이메일
    비밀번호
    이름
    프로필 사진(이미지 사진)
 */
public class SignupActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;

    EditText emailEdit, pwEdit, nameEdit;
    ImageView profileImage;
    Button okButton;

    final String TAG = "SignUpActivity";
    final int REQUEST_CODE_MEDIA = 101;
    Uri pickedImageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        String color = FirebaseRemoteConfig.getInstance().getString(getString(R.string.app_theme));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.parseColor(color));
        }

        firebaseAuth = FirebaseAuth.getInstance();

        emailEdit = findViewById(R.id.signup_edit_email);
        pwEdit = findViewById(R.id.signup_edit_pw);
        nameEdit = findViewById(R.id.signup_edit_name);
        profileImage = findViewById(R.id.signup_image_profile);
        okButton = findViewById(R.id.signup_button_ok);

        /*
            1. 이미지 뷰 클릭
            2. 앨범이 띄어짐
            3. 앨범에서 사진을 선택
            4. 선택된 앨범을 현재 액티비티로 가져옴.
            5. 선택된 사진을 서버의 Storage 저장.
            6. Storage 에 저장된 사진의 경로를 가져와야함.
            7. User 객체에 저장.
            8. 데이터베이스에  User 객체를 저장.
         */

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                startActivityForResult(intent, REQUEST_CODE_MEDIA);
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = emailEdit.getText().toString();
                final String pw = pwEdit.getText().toString();
                final String name = nameEdit.getText().toString();

                if (email.isEmpty() || pw.isEmpty() || name.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "빈칸 존재", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.createUserWithEmailAndPassword(email, pw)
                        .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // 정상적으로 회원가입이 됐을 때 데이터베이스에 회원 정보를 추가
                                    final String uid = task.getResult().getUser().getUid();
//                                    user newUser = new user(uid, name);
//                                    FirebaseDatabase database = FirebaseDatabase.getInstance();
//                                    database.getReference().child("Users").child(uid).setValue(newUser);
                                    if (pickedImageUri != null) {
                                        FirebaseStorage.getInstance()
                                                .getReference()
                                                .child(getString(R.string.child_users_profile_images))
                                                .child(uid)
                                                .putFile(pickedImageUri) // 앨범에 저장되어있는 사진을 서버에 저장.
                                                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                                    @Override
                                                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                                        FirebaseStorage.getInstance()
                                                                .getReference()
                                                                .child(getString(R.string.child_users_profile_images))
                                                                .child(uid)
                                                                .getDownloadUrl()
                                                                .addOnSuccessListener(new OnSuccessListener<Uri>() {
                                                                    @Override
                                                                    public void onSuccess(Uri uri) {
                                                                        FirebaseDatabase.getInstance()
                                                                                .getReference()
                                                                                .child(getString(R.string.child_users))
                                                                                .child(uid)
                                                                                .setValue(new user(uid, name, uri.toString()));
                                                                    }
                                                                });
                                                    }
                                                });
                                    }
                                    else {
                                        FirebaseDatabase.getInstance().getReference().child(getString(R.string.child_users)).child(uid).setValue(new user(uid, name));
                                    }
                                    Log.i(TAG, "Create User Success");
                                    finish();
                                }
                                else { // 인증 추가에 실패
                                    Log.i(TAG, "Create User Fail");
                                }
                            }
                        });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_MEDIA) {
            if(resultCode == RESULT_OK) {
                profileImage.setImageURI(data.getData());
                pickedImageUri = data.getData();
            }
        }
    }
}