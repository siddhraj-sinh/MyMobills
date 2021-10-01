package com.siddharaj.mymobills.view.ui.fragments

import android.os.Build
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import com.siddharaj.mymobills.MyCanvas
import com.siddharaj.mymobills.ProfilePreference
import com.siddharaj.mymobills.R
import com.siddharaj.mymobills.model.entities.Invoice
import com.siddharaj.mymobills.model.entities.Items
import com.siddharaj.mymobills.viewmodel.InvoiceViewModel
import com.siddharaj.mymobills.viewmodel.InvoiceViewPagerViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.launch


class PreviewInvoiceFragment : Fragment() {
    private lateinit var mCurrentDate: String
    private lateinit var mDueDate: String
    private lateinit var mName: String
    private lateinit var mPhoneNumber:String
    private lateinit var mAddress: String
    private lateinit var mCity:String
    private lateinit var mPinCode:String
    private lateinit var mState:String
    private lateinit var mGST: String
    private lateinit var mTotalAmount: String
    private lateinit var mSGST: String
    private lateinit var mSGSTAmount: String
    private lateinit var mCGST: String
    private lateinit var mCGSTAmount: String
    private lateinit var mIGST: String
    private lateinit var mIGSTAmount: String
    private lateinit var mGrandTotal: String
    private lateinit var checking: String
    private lateinit var mItems: ArrayList<Items>

    private lateinit var databaseViewModel: InvoiceViewModel
    private lateinit var invoiceViewPagerViewModel: InvoiceViewPagerViewModel
    private lateinit var profilePreference: ProfilePreference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databaseViewModel = ViewModelProvider(requireActivity()).get(InvoiceViewModel::class.java)
        invoiceViewPagerViewModel =
            ViewModelProvider(requireActivity()).get(InvoiceViewPagerViewModel::class.java)
        profilePreference = ProfilePreference(requireContext())



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        profilePreference.businessName.asLiveData().observe(viewLifecycleOwner, Observer {
            MyCanvas.businessName= it
        })
        return inflater.inflate(R.layout.fragment_preview_invoice, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fab = view.findViewById<FloatingActionButton>(R.id.fab_share)

       profilePreference.businessName.asLiveData().observe(viewLifecycleOwner, Observer {
            MyCanvas.businessName= it
        })

        invoiceViewPagerViewModel.getCurrentDate()
            .observe(requireActivity(), object : Observer<String> {
                override fun onChanged(t: String?) {
                    if (t != null) {
                        mCurrentDate = t
                    }
                }
            })
        invoiceViewPagerViewModel.getClientName()
            .observe(requireActivity(), object : Observer<String> {
                override fun onChanged(t: String?) {
                    if (t != null) {
                        mName = t

                    }
                    //setting canvas text
                    MyCanvas.clientCompanyName = t
                }

            })


        invoiceViewPagerViewModel.getClientPhoneNumber().observe(requireActivity(),object : Observer<String>{
            override fun onChanged(t: String?) {
                if(t != null){
                    mPhoneNumber=t
                }
                MyCanvas.clientPhoneNumber
            }
        })
        invoiceViewPagerViewModel.getClientAddress()
            .observe(requireActivity(), object : Observer<String> {
                override fun onChanged(t: String?) {
                    if (t != null) {
                        mAddress = t
                    }
                    MyCanvas.clientAddress=t
                }
            })
        invoiceViewPagerViewModel.getClientCity().observe(requireActivity(),object:Observer<String>{
            override fun onChanged(t: String?) {
                if(t != null){
                    mCity=t
                }
                MyCanvas.clientCity=t
            }
        })
        invoiceViewPagerViewModel.getPinCode().observe(requireActivity(),object:Observer<String>{
            override fun onChanged(t: String?) {
                if(t!=null){
                    mPinCode=t
                }
                MyCanvas.clientPincode=t
            }
        })
        invoiceViewPagerViewModel.getClientState().observe(requireActivity(),object : Observer<String>{

            override fun onChanged(t: String?) {
                if(t != null){
                    mState=t
                }
                MyCanvas.clientState=t
            }
        })
        invoiceViewPagerViewModel.getGST().observe(requireActivity(), object : Observer<String> {
            override fun onChanged(t: String?) {
                if (t != null) {
                    mGST = t
                }
                MyCanvas.clientGSTIN=t
            }
        })
        invoiceViewPagerViewModel.getTotalAmount()
            .observe(requireActivity(), object : Observer<String> {
                override fun onChanged(t: String?) {
                    if (t != null) {
                        mTotalAmount = t
                    }
                }
            })
        invoiceViewPagerViewModel.getSgst().observe(requireActivity(), object : Observer<String> {
            override fun onChanged(t: String?) {
                if (t != null) {
                    mSGST = t
                }
            }
        })
        invoiceViewPagerViewModel.getSgstAmount()
            .observe(requireActivity(), object : Observer<String> {
                override fun onChanged(t: String?) {
                    if (t != null) {
                        mSGSTAmount = t
                    }
                }
            })
        invoiceViewPagerViewModel.getCgst().observe(requireActivity(), object : Observer<String> {
            override fun onChanged(t: String?) {
                if (t != null) {
                    mCGST = t
                }
            }
        })
        invoiceViewPagerViewModel.getCgstAmount()
            .observe(requireActivity(), object : Observer<String> {
                override fun onChanged(t: String?) {
                    if (t != null) {
                        mCGSTAmount = t
                    }
                }
            })
        invoiceViewPagerViewModel.getIgst().observe(requireActivity(), object : Observer<String> {
            override fun onChanged(t: String?) {
                if (t != null) {
                    mIGST = t
                }
            }
        })
        invoiceViewPagerViewModel.getIgstAmount()
            .observe(requireActivity(), object : Observer<String> {
                override fun onChanged(t: String?) {
                    if (t != null) {
                        mIGSTAmount = t
                    }
                }
            })
        invoiceViewPagerViewModel.getGrandTotal()
            .observe(requireActivity(), object : Observer<String> {
                override fun onChanged(t: String?) {
                    if (t != null) {
                        mGrandTotal = t
                    }
                }
            })
        invoiceViewPagerViewModel.getDueDate()
            .observe(requireActivity(), object : Observer<String> {
                override fun onChanged(t: String?) {
                    if (t != null) {
                        mDueDate = t
                    }
                }
            })
        invoiceViewPagerViewModel.getItems()
            .observe(requireActivity(), object : Observer<ArrayList<Items>> {
                override fun onChanged(t: ArrayList<Items>?) {
                    if (t != null) {
                        mItems = t
                    }
                }
            })

        invoiceViewPagerViewModel.getInvoiceNumber()
            .observe(requireActivity(), object : Observer<String> {
                override fun onChanged(t: String?) {
                    if (t != null) {
                        checking = t
                    }
                }
            })
        var id: Int = 1

        profilePreference.invoiceNumber.asLiveData().observe(viewLifecycleOwner, Observer {
            if (it != null) {
                id = it

            }
        })


        fab.setOnClickListener {



            val inv = Invoice(id,
                mCurrentDate,
                mDueDate,
                mName,
                mGST,
                mPhoneNumber,
                mAddress,
                mCity,
                mPinCode,
                mState,
                mTotalAmount,
                mSGST,
                mSGSTAmount,
                mCGST,
                mCGSTAmount,
                mIGST,
                mIGSTAmount,
                mGrandTotal,
                false
            )
            databaseViewModel.insertInvoice(inv)
             lifecycleScope.launch {
                    profilePreference.invoiceNumber(id + 1)
                }


        }

    }


}