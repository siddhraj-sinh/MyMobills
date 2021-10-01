package com.siddharaj.mymobills.view.ui.fragments

import android.Manifest
import android.app.Dialog
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import com.siddharaj.mymobills.ProfilePreference
import com.siddharaj.mymobills.R
import kotlinx.android.synthetic.main.fragment_profile.*

import kotlinx.coroutines.launch


class ProfileFragment : Fragment() {

    private lateinit var profilePreference: ProfilePreference



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        profilePreference = ProfilePreference(requireContext())


    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val updateButton = view.findViewById<Button>(R.id.btn_upate)
        val imagePicker = view.findViewById<ImageView>(R.id.iv_logo_picker)
        //image pick click
        imagePicker.setOnClickListener {
            customImageSelectionDialog()
        }
        //update button click
        updateButton.setOnClickListener {
            insertData()
        }
        profilePreference.businessName.asLiveData().observe(viewLifecycleOwner, Observer {
            et_invoice_date.setText(it)
        })
        profilePreference.ownerName.asLiveData().observe(viewLifecycleOwner, Observer {
            et_owner_name.setText(it)
        })
        profilePreference.gstIn.asLiveData().observe(viewLifecycleOwner, Observer {
            et_gst_in.setText(it)
        })
        profilePreference.address.asLiveData().observe(viewLifecycleOwner, Observer {
            et_address.setText(it)
        })
        profilePreference.phoneNumber.asLiveData().observe(viewLifecycleOwner, Observer {
            et_phone.setText(it)
        })
        profilePreference.emailAddress.asLiveData().observe(viewLifecycleOwner, Observer {
            et_email.setText(it)
        })
        profilePreference.website.asLiveData().observe(viewLifecycleOwner, Observer {
            et_website.setText(it)
        })
        profilePreference.bankName.asLiveData().observe(viewLifecycleOwner, Observer {
            et_bank_name.setText(it)
        })
        profilePreference.bankAccountNumber.asLiveData().observe(viewLifecycleOwner, Observer {
            et_banc_ac.setText(it)
        })
        profilePreference.bankIFSC.asLiveData().observe(viewLifecycleOwner, Observer {
            et_ifsc_code.setText(it)
        })
       profilePreference.businessLogo.asLiveData().observe(viewLifecycleOwner, Observer {
           iv_business_logo.setImageURI(it?.toUri())
       })
        return view
    }

    private fun insertData() {
        val businessName = et_invoice_date.text.toString()
        val ownerName = et_owner_name.text.toString()
        val gstIn = et_gst_in.text.toString()
        val address = et_address.text.toString()
        val emailAddress = et_email.text.toString()
        val phoneNumber = et_phone.text.toString()
        val website = et_website.text.toString()
        val bankName = et_bank_name.text.toString()
        val bankAccountNumber = et_banc_ac.text.toString()
        val ifscCode = et_ifsc_code.text.toString()

        lifecycleScope.launch {
            profilePreference.businessName(businessName)
            profilePreference.ownerName(ownerName)
            profilePreference.gstIn(gstIn)
            profilePreference.address(address)
            profilePreference.emailAddress(emailAddress)
            profilePreference.phoneNumber(phoneNumber)
            profilePreference.website(website)
            profilePreference.bankName(bankName)
            profilePreference.bankAccountNumber(bankAccountNumber)
            profilePreference.bankIfsc(ifscCode)
        }

    }

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                Log.i("fuck", "Granted")
            } else {
                Log.i("fuck", "Denied")
            }
        }






    private fun customImageSelectionDialog() {
        val dialog = Dialog(requireContext(), R.style.Theme_Dialog)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.dialog_custom_image_selection)
        val camera: TextView = dialog.findViewById(R.id.tv_camera)
        val gallery: TextView = dialog.findViewById(R.id.tv_gallery)
        camera.setOnClickListener {

            //ask permission
            onClickRequestPermission(it)

        }
        gallery.setOnClickListener {
            //todo: ask permission and revert back the result
        }
        dialog.show()

    }





    //acessing camera permission
    private fun onClickRequestPermission(it: View?) {
        when {
            ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED -> {

                Toast.makeText(requireContext(),"Granted",Toast.LENGTH_SHORT).show()


            }

            ActivityCompat.shouldShowRequestPermissionRationale(
                requireActivity(),
                Manifest.permission.CAMERA
            ) -> {

                Toast.makeText(requireContext(),"rational",Toast.LENGTH_SHORT).show()
                    requestPermissionLauncher.launch(
                        Manifest.permission.CAMERA
                    )

            }

            else -> {
                requestPermissionLauncher.launch(
                    Manifest.permission.CAMERA
                )
                Toast.makeText(requireContext(),"else launch permission",Toast.LENGTH_SHORT).show()
            }
        }
    }



    }



