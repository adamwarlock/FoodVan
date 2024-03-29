package com.foodvaninfowiz.foodorderingin.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.foodvaninfowiz.foodorderingin.Fragments.PageFragment;
import com.foodvaninfowiz.foodorderingin.MVP.CategoryListResponse;

import java.util.List;

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    private List<CategoryListResponse> categoryListResponses;

    public static int LOOPS_COUNT = 1000;

    public MyPagerAdapter(FragmentManager manager, List<CategoryListResponse> categoryListResponses) {
        super(manager);
        this.categoryListResponses = categoryListResponses;
    }


    @Override
    public Fragment getItem(int position) {
        if (categoryListResponses != null && categoryListResponses.size() > 0) {
            position = position % categoryListResponses.size(); // use modulo for infinite cycling

                return PageFragment.newInstance(position);
        } else {
            return PageFragment.newInstance(0);
        }
    }


    @Override
    public int getCount() {
        if (categoryListResponses != null && categoryListResponses.size() > 0) {
            return categoryListResponses.size(); // simulate infinite by big number of products
        } else {
            return 1;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
            return categoryListResponses.get(position).getCategory_name();
    }
}