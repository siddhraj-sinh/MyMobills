package com.siddharaj.mymobills.view.ui.fragments

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.siddharaj.mymobills.ProfilePreference
import com.siddharaj.mymobills.R
import com.siddharaj.mymobills.view.adapter.AddItemAdapter
import com.siddharaj.mymobills.model.entities.Items
import com.siddharaj.mymobills.viewmodel.InvoiceViewModel
import com.siddharaj.mymobills.viewmodel.InvoiceViewPagerViewModel
import kotlinx.android.synthetic.main.fragment_edit_invoice.*
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class EditInvoiceFragment : Fragment(), TextWatcher {


    private lateinit var mAddItemImageView: ImageView
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: AddItemAdapter
    private lateinit var list: ArrayList<Items>
    private lateinit var clearItemsTextView: TextView
    private var mId: Int = 1
    private lateinit var viewModel: InvoiceViewModel
    private lateinit var invoiceViewPagerViewModel: InvoiceViewPagerViewModel
    private lateinit var profilePreference: ProfilePreference

    private lateinit var tempTotalAmount: String
    private lateinit var tempSgst: String
    private lateinit var tempCgst: String
    private lateinit var tempIgst: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        list = ArrayList()
        viewModel = ViewModelProvider(this).get(InvoiceViewModel::class.java)

        invoiceViewPagerViewModel =
            ViewModelProvider(requireActivity()).get(InvoiceViewPagerViewModel::class.java)
        profilePreference = ProfilePreference(requireContext())
    }


    @SuppressLint("SimpleDateFormat")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //
        clearItemsTextView = view.findViewById(R.id.tv_clear_all_items)
        mRecyclerView = view.findViewById(R.id.rv_add_item)
        mAddItemImageView = view.findViewById(R.id.iv_add_item)
        //
        val invoiceNumber = view.findViewById<EditText>(R.id.et_invoice_number)
        val currentDate = view.findViewById<EditText>(R.id.et_invoice_date)
        val dueDate = view.findViewById<EditText>(R.id.et_invoice_due_date)
        val clientName = view.findViewById<EditText>(R.id.et_client_name)
        val clientGST = view.findViewById<EditText>(R.id.et_client_gst_in)
        val clientPhoneNumber = view.findViewById<EditText>(R.id.et_client_phone_number)
        val clientAddress = view.findViewById<EditText>(R.id.et_client_address)
        val clientCity = view.findViewById<EditText>(R.id.et_client_city_name)
        val clientPincode = view.findViewById<EditText>(R.id.et_client_pincode)
        val clientState = view.findViewById<EditText>(R.id.et_client_state)
        val totalAmount = view.findViewById<EditText>(R.id.et_total_amount)
        val sgst = view.findViewById<EditText>(R.id.et_sgst)
        val cgst = view.findViewById<EditText>(R.id.et_cgst)
        val cgstAmount = view.findViewById<EditText>(R.id.et_cgst_amount)
        val igst = view.findViewById<EditText>(R.id.et_igst)
        val igstAmount = view.findViewById<EditText>(R.id.et_igst_amount)
        val grandTotal = view.findViewById<EditText>(R.id.et_grand_total)
        val sgstAmount = view.findViewById<EditText>(R.id.et_sgst_amount)

        profilePreference.invoiceNumber.asLiveData().observe(viewLifecycleOwner, Observer {
            if (it != null) {
                mId = it
                invoiceNumber.setText(it.toString())
                invoiceViewPagerViewModel.setInvoiceNumber(it.toString())
            } else {
                invoiceNumber.setText("1")
                invoiceViewPagerViewModel.setInvoiceNumber("1")
            }
        })
        currentDate.addTextChangedListener(this)
        dueDate.addTextChangedListener(this)
        clientName.addTextChangedListener(this)
        clientPhoneNumber.addTextChangedListener(this)
        clientAddress.addTextChangedListener(this)
        clientCity.addTextChangedListener(this)
        clientPincode.addTextChangedListener(this)
        clientState.addTextChangedListener(this)
        clientGST.addTextChangedListener(this)
        totalAmount.addTextChangedListener(this)
        sgst.addTextChangedListener(this)
        sgstAmount.addTextChangedListener(this)
        cgst.addTextChangedListener(this)
        cgstAmount.addTextChangedListener(this)
        igst.addTextChangedListener(this)
        igstAmount.addTextChangedListener(this)
        grandTotal.addTextChangedListener(this)

        // set current date
        val myCalender = Calendar.getInstance()
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val theDate = sdf.format(myCalender.time)
        currentDate.setText(theDate)

        //duedate onclick listener
        dueDate.setOnClickListener {
           opendatePicker(it)

        }
        mAddItemImageView.setOnClickListener {
            showAddItemDialog()
        }

        clearItemsTextView.setOnClickListener {
            if (list.isNotEmpty()) {
                list.clear()
                setupListOfDataIntoRecyclerView()
                Toast.makeText(
                    requireContext(),
                    "All Items Removed Successfully",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(requireContext(), "Zero Items Added", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun opendatePicker(it: View?) {
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)


        DatePickerDialog(
            requireContext(),
            DatePickerDialog.OnDateSetListener { view, selectedYear, selectedmonth, selecteddayOfMonth ->
                val selectedDate = "$selecteddayOfMonth/${selectedmonth + 1}/$selectedYear"
                et_invoice_due_date.setText(selectedDate)
            },
            year,
            month,
            day
        ).show()

    }


    private fun setupListOfDataIntoRecyclerView() {
        mRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        mAdapter = AddItemAdapter(list)
        mRecyclerView.adapter = mAdapter
    }

    private fun showAddItemDialog() {
        val updateDialog = Dialog(requireContext(), R.style.Theme_Dialog)
        updateDialog.setCancelable(false)
        /*Set the screen content from a layout resource.
         The resource will be inflated, adding all top-level views to the screen.*/
        updateDialog.setContentView(R.layout.dialog_add_item)
        val itemNameEditText: EditText = updateDialog.findViewById(R.id.et_dialog_item_description)
        val itemQuantityEditText: EditText = updateDialog.findViewById(R.id.et_invoice_date)
        val itemCostEditText: EditText = updateDialog.findViewById(R.id.et_dialog_item_unit_cost)
        val tvAdd: TextView = updateDialog.findViewById(R.id.tvAdd)


        tvAdd.setOnClickListener {
            val one = itemNameEditText.text.toString()
            val two = itemQuantityEditText.text.toString()
            val three = itemCostEditText.text.toString()
            list.add(Items(mId, mId, one, two, three))
            invoiceViewPagerViewModel.setItems(list)
            setupListOfDataIntoRecyclerView()
            Toast.makeText(requireContext(), "Item Added", Toast.LENGTH_SHORT).show()
            updateDialog.dismiss()
        }


        val tvCancel: TextView = updateDialog.findViewById(R.id.tvCancel)
        tvCancel.setOnClickListener(View.OnClickListener {
            updateDialog.dismiss()
        })
        updateDialog.show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_edit_invoice, container, false)

        return view
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        val df = DecimalFormat("#.###")
        df.roundingMode = RoundingMode.CEILING
        when {
            et_invoice_date.text.hashCode() == s.hashCode() -> {
                invoiceViewPagerViewModel.setCurrentDate(s.toString())
            }
            et_invoice_due_date.text.hashCode() == s.hashCode() -> {
                invoiceViewPagerViewModel.setDueDate(s.toString())
            }
            et_client_name.text.hashCode() == s.hashCode() -> {
                invoiceViewPagerViewModel.setClientName(s.toString())
            }
            et_client_gst_in.text.hashCode() == s.hashCode() -> {
                invoiceViewPagerViewModel.setGST(s.toString())
            }
            et_client_phone_number.text.hashCode() == s.hashCode() ->{
                invoiceViewPagerViewModel.setClientPhoneNumber(s.toString())
            }
            et_client_address.text.hashCode() == s.hashCode() -> {
                invoiceViewPagerViewModel.setClientAddress(s.toString())
            }
            et_client_city_name.text.hashCode() == s.hashCode()->{
                invoiceViewPagerViewModel.setClientCity(s.toString())
            }
            et_client_pincode.text.hashCode() == s.hashCode()->{
                invoiceViewPagerViewModel.setPinCode(s.toString())
            }
            et_client_state.text.hashCode() == s.hashCode()->{
                invoiceViewPagerViewModel.setClientState(s.toString())
            }
            et_total_amount.text.hashCode() == s.hashCode() -> {
                tempTotalAmount = s.toString()


                if (tempTotalAmount.isNotEmpty() && et_sgst.text.toString().isNotEmpty()) {
                    val tp = tempSgst.toInt() * tempTotalAmount.toInt() * 0.01
                    et_sgst_amount.setText(df.format(tp).toString())
                }
                if (tempTotalAmount.isNotEmpty() && et_cgst.text.toString().isNotEmpty()) {
                    val tp = tempCgst.toInt() * tempTotalAmount.toInt() * 0.01
                    et_cgst_amount.setText(df.format(tp).toString())
                }
                if (tempTotalAmount.isNotEmpty() && et_igst.text.toString().isNotEmpty()) {
                    val tp = tempIgst.toInt() * tempTotalAmount.toInt() * 0.01
                    et_igst_amount.setText(df.format(tp).toString())
                }

                invoiceViewPagerViewModel.setTotalAmount(s.toString())

            }
            et_sgst.text.hashCode() == s.hashCode() -> {
                tempSgst = s.toString()
                if (tempSgst.isNotEmpty() && tempTotalAmount.isNotEmpty()) {
                    val sa = tempSgst.toInt() * tempTotalAmount.toInt() * 0.01
                    et_sgst_amount.setText(df.format(sa).toString())
                } else if (tempSgst.isEmpty()) {
                    et_sgst_amount.setText("")
                }
                invoiceViewPagerViewModel.setSgst(s.toString())

            }
            et_sgst_amount.text.hashCode() == s.hashCode() -> {
                invoiceViewPagerViewModel.setSgstAmount(s.toString())

            }
            et_cgst.text.hashCode() == s.hashCode() -> {
                tempCgst = s.toString()
                if (tempCgst.isNotEmpty() && tempTotalAmount.isNotEmpty()) {
                    val ca = tempCgst.toInt() * tempTotalAmount.toInt() * 0.01
                    et_cgst_amount.setText(df.format(ca).toString())
                } else if (tempCgst.isEmpty()) {
                    et_cgst_amount.setText("")
                }
                invoiceViewPagerViewModel.setCgst(s.toString())
            }
            et_cgst_amount.text.hashCode() == s.hashCode() -> {
                invoiceViewPagerViewModel.setCgstAmount(s.toString())
            }
            et_igst.text.hashCode() == s.hashCode() -> {
                tempIgst = s.toString()
                if (tempIgst.isNotEmpty() && tempTotalAmount.isNotEmpty()) {
                    val ia = tempIgst.toInt() * tempTotalAmount.toInt() * 0.01
                    et_igst_amount.setText(df.format(ia).toString())
                } else if (tempIgst.isEmpty()) {
                    et_igst_amount.setText("")
                }
                invoiceViewPagerViewModel.setIgst(s.toString())
            }
            et_igst_amount.text.hashCode() == s.hashCode() -> {
                invoiceViewPagerViewModel.setIgstAmount(s.toString())
            }
            et_grand_total.text.hashCode() == s.hashCode() -> {
                invoiceViewPagerViewModel.setGrandTotal(s.toString())
            }
        }
    }

    override fun afterTextChanged(s: Editable?) {

    }


}