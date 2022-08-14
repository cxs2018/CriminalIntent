package com.cuixuesen.android.criminalintent;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class PictureDialogFragment extends DialogFragment {
    public static PictureDialogFragment newInstance(String path) {
        Bundle args = new Bundle();
        args.putString("path", path);

        PictureDialogFragment pictureDialogFragment = new PictureDialogFragment();
        pictureDialogFragment.setArguments(args);
        return pictureDialogFragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        // 获取到之前传来的路径
        String path = getArguments().getString("path");
        // 创建一个dialog
        final Dialog dialog = new Dialog(getActivity());
        // 设置dialog的布局为之前创建的布局文件，里面仅有一个ImageView
        dialog.setContentView(R.layout.dialog_photo);
        // 找到控件
        ImageView imageView = (ImageView)dialog.findViewById(R.id.crime_photo_dialog);
        // 使用PictureUtils类的工具来获得缩放的Bitmap
        imageView.setImageBitmap(PictureUtils.getScaledBitmap(path, getActivity()));
        // 设置点击事件，当点击图片的时候，dialog消失
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        return dialog;
    }
}
