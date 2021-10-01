package com.siddharaj.mymobills.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.siddharaj.mymobills.view.ui.fragments.*

class CreateInvoiceViewPagerAdapter(fm:FragmentManager):FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0-> {return EditInvoiceFragment()
            }
            1->{return PreviewInvoiceFragment()
            }

            else -> {return AllFragment()
            }
        }
    }
    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0-> { return "EDIT"}
            1->{ return "PREVIEW"}


        }
        return super.getPageTitle(position)
    }
}