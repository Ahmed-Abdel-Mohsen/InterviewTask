package com.example.android.interviewtask;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.android.interviewtask.data.BookProvider;
import com.example.android.interviewtask.data.User;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ahmed on 6/27/2018.
 */

@SuppressLint("ValidFragment")
public class UserDialog extends AppCompatDialogFragment {
    int userID;

    @SuppressLint("ValidFragment")
    public UserDialog(int userID) {
        this.userID = userID;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_layout, null);

        BookProvider bookProvider = new BookProvider(getActivity());
        ArrayList<User> users = bookProvider.getAllUsers();
        Collections.sort(users);
        float percentage = 0;
        int order = 0;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == userID) {
                percentage = users.get(i).getPercentage();
                order = i + 1;
            }
        }
        TextView percentageTextView = view.findViewById(R.id.percentage_text_view);
        percentageTextView.setText(percentage + "");

        TableLayout table = view.findViewById(R.id.user_table);
        TableRow row0 = new TableRow(getContext());
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        row0.setLayoutParams(lp);
        TextView tv0 = new TextView(getContext());
        tv0.setText("User id");
        tv0.setTextSize(18);
        row0.addView(tv0);
        TextView tv1 = new TextView(getContext());
        tv1.setText("Name");
        tv1.setTextSize(18);
        tv1.setPadding(40, 0, 0, 0);
        row0.addView(tv1);
        table.addView(row0);
        for (int i = 0; i < users.size(); i++) {
            TableRow row = new TableRow(getContext());
            row.setLayoutParams(lp);
            TextView tv2 = new TextView(getContext());
            tv2.setText(users.get(i).getId() + "");
            tv2.setTextSize(14);
            tv2.setPadding(20, 0, 0, 0);
            row.addView(tv2);
            TextView tv3 = new TextView(getContext());
            tv3.setText(users.get(i).getName());
            tv3.setTextSize(14);
            tv3.setPadding(40, 0, 0, 0);
            row.addView(tv3);
            table.addView(row);
        }

        TextView orderTextView = view.findViewById(R.id.order_text_view);
        orderTextView.setText(order + "");
        builder.setView(view)
                .setTitle(R.string.dialog_title)
                .setPositiveButton(R.string.dialog_positive, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        return builder.create();
    }
}
