/*
 * Copyright (c) 2018 denua.
 */

package cn.denua.v2ex.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import cn.denua.v2ex.Config;
import cn.denua.v2ex.ConfigRefEnum;
import cn.denua.v2ex.R;
import io.reactivex.annotations.Nullable;

/*
 * @author denua
 * @email denua@foxmail.com
 * @date 2018/12/11 20
 */
public class DialogUtil {

    public static void showDialogWithList(Context context,
                                              String[] arr,
                                              int defaultVal,
                                              String title,
                                          DialogListener<Integer> onSelectItemListener){

        AlertDialog.Builder builder = new AlertDialog.Builder(context, getTheme(context));
        builder.setTitle(title);
        builder.setSingleChoiceItems(arr, defaultVal, (dialog, which) -> {
            onSelectItemListener.onResult(which);
            dialog.dismiss();
        });
        builder.setPositiveButton(R.string.cancel, (dialog, which) -> dialog.dismiss());
        builder.create().show();
    }

    public static AlertDialog getProgress(Context context,
                                          String title,
                                          @Nullable DialogListener<Boolean> dialogListener){
        AlertDialog.Builder builder = new AlertDialog.Builder(context, getTheme(context));
        builder.setTitle(title);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 80);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(layoutParams);
        frameLayout.setPadding(0,50, 0, 50);
        ProgressBar progressBar = new ProgressBar(context);
        progressBar.setLayoutParams(layoutParams);
        frameLayout.addView(progressBar);
        builder.setView(frameLayout);
        builder.setCancelable(false);
        if (dialogListener != null) builder.setNegativeButton("取 消", (dialog, which) -> {
            dialogListener.onResult(false);
            dialog.dismiss();
        });
        return builder.create();
    }

    public static void showProgress(Context context,
                                    String title,
                                    @Nullable DialogListener<Boolean> dialogListener){
        getProgress(context, title, dialogListener).show();
    }

    public static void showMessage(Context context,
                                   String title,
                                   String msg,
                                   DialogListener<Boolean> dialogListener){

        AlertDialog.Builder builder = new AlertDialog.Builder(context, getTheme(context));
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton("确 定", (dialog, which) -> {
            dialogListener.onResult(true);
            dialog.dismiss();
        });
        builder.setNegativeButton("取 消", (dialog, which) -> {
            dialogListener.onResult(false);
            dialog.dismiss();
        });
        builder.create().show();
    }

    public static void showInputDialog(Context context,
                                       String title,
                                       String msg,
                                       String defaultValue,
                                       DialogListener<String> dialogListener){

        AlertDialog.Builder builder = new AlertDialog.Builder(context, getTheme(context));

        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(layoutParams);
        EditText editText = new EditText(context);
        editText.setLayoutParams(layoutParams);
        editText.setMaxLines(1);
        frameLayout.addView(editText);
        frameLayout.setPadding(35,25,35,25);

        if (msg != null){
            builder.setMessage(msg);
        }
        if (defaultValue != null){
            editText.setText(defaultValue);
        }
        builder.setTitle(title)
                .setView(frameLayout)
                .setPositiveButton(R.string.confirm, (dialog, which) -> {
                    dialogListener.onResult(editText.getText().toString());
                    dialog.dismiss();
                })
                .setNegativeButton(R.string.cancel, (dialog, which) -> dialog.dismiss())
                .create()
                .show();
    }

    private static int getTheme(Context context){
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.attr_style_alert_dialog, typedValue, true);
        return typedValue.data;
    }
    public interface DialogListener<T>{
        void onResult(T value);
    }
}
