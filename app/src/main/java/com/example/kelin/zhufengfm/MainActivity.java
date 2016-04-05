package com.example.kelin.zhufengfm;

import android.app.DownloadManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.example.kelin.zhufengfm.fragment.CustomFragment;
import com.example.kelin.zhufengfm.fragment.DiscoveryFragment;
import com.example.kelin.zhufengfm.fragment.DownLoadTingFragment;
import com.example.kelin.zhufengfm.fragment.PersonalFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private DiscoveryFragment  mDiscoveryFragment;
    private CustomFragment mCustomFragment;
    private DownLoadTingFragment mDownLoadTingFragment;
    private PersonalFragment  mPersonalFragment;

    private Fragment[] mFragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: fragment是否进行replace操作

        //采用fragment显示和隐藏的方式管理第一级的fragment
        // 默认添加到容器中，之后，切换RadioButton，进行显示和隐藏

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        mDiscoveryFragment = new DiscoveryFragment();
        mCustomFragment = new CustomFragment();
        mDownLoadTingFragment = new DownLoadTingFragment();
        mPersonalFragment = new PersonalFragment();

        mFragments = new Fragment[4];
        mFragments[0] = mDiscoveryFragment;
        mFragments[1] = mCustomFragment;
        mFragments[2] = mDownLoadTingFragment;
        mFragments[3] = mPersonalFragment;

        for (Fragment fragment : mFragments) {
            transaction.add(R.id.main_fragment_container,fragment);
            transaction.hide(fragment);
        }
        transaction.show(mFragments[0]);

        transaction.commit();

        //------------------------------------------

        RadioGroup tabBar = (RadioGroup) findViewById(R.id.main_tab_bar);

        if (tabBar != null) {
            tabBar.setOnCheckedChangeListener(this);
        }

    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentManager manager = getSupportFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();

        // 第一步，隐藏所有的fragment
        // 第二部，显示切换的fragment
        for (Fragment fragment : mFragments) {
            transaction.hide(fragment);
        }
        Fragment fragment = null;
        switch (checkedId){
            case R.id.main_tab_item_discovery:
                fragment = mFragments[0];
                break;
            case R.id.main_tab_item_custom:
                fragment = mFragments[1];
                break;
            case R.id.main_tab_item_download:
                fragment = mFragments[2];
                break;
            case R.id.main_tab_item_personal:
                fragment = mFragments[3];
                break;
        }
        if (fragment != null) {
            transaction.show(fragment);
        }

        transaction.commit();
    }
}
