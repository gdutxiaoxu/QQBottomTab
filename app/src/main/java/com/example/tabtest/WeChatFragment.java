package com.example.tabtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * 微信 Fragment
 */
public class WeChatFragment extends Fragment implements View.OnClickListener {

    private EditText mEdWeChat;
    private EditText mEdFriend;
    private EditText mEdContacts;
    private EditText mEdSetting;

    public WeChatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wechat, container, false);

        mEdWeChat = (EditText) view.findViewById(R.id.et_wechat);
        mEdFriend = (EditText) view.findViewById(R.id.et_friend);
        mEdContacts = (EditText) view.findViewById(R.id.et_contacts);
        mEdSetting = (EditText) view.findViewById(R.id.et_setting);

        Button btnWeChat = (Button) view.findViewById(R.id.btn_wechat);
        Button btnFrrend = (Button) view.findViewById(R.id.btn_friend);
        Button btnContacts = (Button) view.findViewById(R.id.btn_contacts);
        Button btnSetting = (Button) view.findViewById(R.id.btn_setting);

        btnWeChat.setOnClickListener(this);
        btnFrrend.setOnClickListener(this);
        btnContacts.setOnClickListener(this);
        btnSetting.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        // 新消息数量
        String number;
        // 获取 Fragment 的托管 Activity
        MainActivity mainActivity = (MainActivity) getActivity();

        switch (v.getId()) {
            case R.id.btn_wechat:
                number = mEdWeChat.getText().toString().trim();
                if (!TextUtils.isEmpty(number)) {
                    mainActivity.updateMsgCount(MainActivity.TAB_WECHAT, Integer.valueOf(number));
                }
                break;
            case R.id.btn_friend:
                number = mEdFriend.getText().toString().trim();
                if (!TextUtils.isEmpty(number)) {
                    mainActivity.updateMsgCount(MainActivity.TAB_FRIEND, Integer.valueOf(number));
                }
                break;
            case R.id.btn_contacts:
                number = mEdContacts.getText().toString().trim();
                if (!TextUtils.isEmpty(number)) {
                    mainActivity.updateMsgCount(MainActivity.TAB_CONTACTS, Integer.valueOf(number));
                }
                break;
            case R.id.btn_setting:
                number = mEdSetting.getText().toString().trim();
                if (!TextUtils.isEmpty(number)) {
                    mainActivity.updateMsgCount(MainActivity.TAB_SETTING, Integer.valueOf(number));
                }
                break;
        }
    }
}
