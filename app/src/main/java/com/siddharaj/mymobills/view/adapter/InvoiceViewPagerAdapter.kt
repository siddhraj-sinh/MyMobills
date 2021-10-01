package com.siddharaj.mymobills.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.siddharaj.mymobills.view.ui.fragments.AllFragment
import com.siddharaj.mymobills.view.ui.fragments.OutstandingFragment
import com.siddharaj.mymobills.view.ui.fragments.PaidFragment

class InvoiceViewPagerAdapter(fm:FragmentManager):FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0-> {return AllFragment()
            }
            1->{return OutstandingFragment()
            }
            2->{return PaidFragment()
            }

            else -> {return AllFragment()
            }
        }
    }
    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0-> { return "ALL"}
            1->{ return "OUTSTANDING"}
            2->{return "PAID"}

        }
        return super.getPageTitle(position)
    }
}