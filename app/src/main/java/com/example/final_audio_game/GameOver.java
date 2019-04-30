package com.example.final_audio_game;


import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.facebook.share.widget.ShareDialog;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GameOver extends AppCompatActivity {

//    private static final int REQUEST_VIDEO_CODE = 1000;
//    Button sharePhoto;
//    Button shareVideo;
    Button shareLink;
    CallbackManager callbackManager;
    ShareDialog shareDialog;

//    Target target = new Target() {
//        @Override
//        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
//            com.facebook.share.model.SharePhoto sharePhoto = new com.facebook.share.model.SharePhoto
//                    .Builder()
//                    .setBitmap(bitmap)
//                    .build();
//            if(ShareDialog.canShow(SharePhotoContent.class)) {
//                SharePhotoContent content = new SharePhotoContent.Builder()
//                        .addPhoto(sharePhoto)
//                        .build();
//                shareDialog.show(content);
//            }
//        }
//
//        @Override
//        public void onBitmapFailed(Drawable errorDrawable) {
//
//        }
//
//        @Override
//        public void onPrepareLoad(Drawable placeHolderDrawable) {
//
//        }
//    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        setContentView(R.layout.game_over);

        shareLink = findViewById(R.id.shareLink);
//        sharePhoto = findViewById(R.id.sharePhoto);
//        shareVideo = findViewById(R.id.shareVideo);

        callbackManager = CallbackManager.Factory.create();
        shareDialog = new ShareDialog(this);

        shareLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareDialog.registerCallback(callbackManager, new FacebookCallback<Sharer.Result>() {
                    @Override
                    public void onSuccess(Sharer.Result result) {
                        Toast.makeText(GameOver.this, "Share successful!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(GameOver.this, "Share cancelled!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(FacebookException error) {
                        Toast.makeText(GameOver.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

                ShareLinkContent linkContent = new ShareLinkContent.Builder()
                        .setQuote("I got a score of ")
                        .setContentUrl(Uri.parse("https://tenor.com/view/the-office-why-michael-scott-gif-5422774")) //put whatever link you think would be appropriate here
                        .build();
                if(ShareDialog.canShow(ShareLinkContent.class)) {
                    shareDialog.show(linkContent);
                }
            }
        });

//        sharePhoto.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //create callback
//                shareDialog.registerCallback(callbackManager, new FacebookCallback<Sharer.Result>() {
//                    @Override
//                    public void onSuccess(Sharer.Result result) {
//                        Toast.makeText(GameOver.this, "Share successful!", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onCancel() {
//                        Toast.makeText(GameOver.this, "Share cancelled!", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onError(FacebookException error) {
//                        Toast.makeText(GameOver.this, error.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//
//                //fetch photo; convert to bitmap
//                Picasso.with(getBaseContext())
//                        .load("https://pxhere.com/en/photo/1439045)")
//                        .into(target);
//
//            }
//        });

//        shareVideo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setType("video/*");
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                //startActivityForResult(Intent.createChooser(intent, "Select video", REQUEST_VIDEO_CODE));
//            }
//        });
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        if(resultCode == RESULT_OK) {
//            if(requestCode == REQUEST_VIDEO_CODE) {
//                Uri selectedVideo = data.getData();
//                ShareVideo video = new ShareVideo.Builder()
//                        .setLocalUrl(selectedVideo)
//                        .build();
//
//                ShareVideoContent videoContent = new ShareVideoContent.Builder()
//                        .setContentTitle("Watch this")
//                        .setContentDescription("This is so cool")
//                        .setVideo(video)
//                        .build();
//
//                if(shareDialog.canShow(ShareVideoContent.class)) {
//                    shareDialog.show(videoContent);
//                }
//            }
//        }
//    }

    PackageInfo info;
    public void printHashKey() {
        try {
            info = getPackageManager().getPackageInfo("com.example.final_audio_game;",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature: info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.toString();
        }
    }
}
