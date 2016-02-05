package com.example.akki.thenewshour.adapters;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.akki.thenewshour.constants.AppConstants;
import com.example.akki.thenewshour.fragements.HomePageListingFragement;

public class HomePageViewPagerAdapter extends FragmentStatePagerAdapter {

    public HomePageViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return AppConstants.TOTAL_NO_OF_PAGES;
    }


    @Override
    public Fragment getItem(int position) {
        return HomePageListingFragement.getInstance(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case AppConstants.MOST_POPULAR_DATA:
                return AppConstants.MOST_POPULAR_TAG_DRAWER;
            case AppConstants.MOVIE_REVIEW_DATA:
                return AppConstants.MOVIE_REVIEW_TAG_DRAWER;
            case AppConstants.GEOGRAPHIC_DATA:
                return AppConstants.GEOGRAPHIC_TAG_DRAWER;
            case AppConstants.BESTSELLER_DATA:
                return AppConstants.BESTSELLER_TAG_DRAWER;
        }
        return super.getPageTitle(position);
    }


}
