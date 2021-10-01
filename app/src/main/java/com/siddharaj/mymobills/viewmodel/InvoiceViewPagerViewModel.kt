package com.siddharaj.mymobills.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.siddharaj.mymobills.model.entities.Items


class InvoiceViewPagerViewModel : ViewModel() {

    private val mInvoiceNumber = MutableLiveData<String>()
    private val mCurrentDate = MutableLiveData<String>()
    private val mDueDate = MutableLiveData<String>()
    private val mName = MutableLiveData<String>()
    private val mPhoneNumber = MutableLiveData<String>()
    private val mAddress = MutableLiveData<String>()
    private val mCity = MutableLiveData<String>()
    private val mPinCode = MutableLiveData<String>()
    private val mState = MutableLiveData<String>()
    private val mGST = MutableLiveData<String>()
    private val mTotalAmount = MutableLiveData<String>()
    private val mSGST = MutableLiveData<String>()
    private val mSGSTAmount = MutableLiveData<String>()
    private val mCGST = MutableLiveData<String>()
    private val mCGSTAmount = MutableLiveData<String>()
    private val mIGST = MutableLiveData<String>()
    private val mIGSTAmount = MutableLiveData<String>()
    private val mGrandTotal = MutableLiveData<String>()

    private val mItemsList = MutableLiveData<ArrayList<Items>>()

    //
    fun setInvoiceNumber(iNumber:String){
        mInvoiceNumber.value=iNumber
    }
    fun getInvoiceNumber():LiveData<String>{
        return mInvoiceNumber
    }
    //
    fun setCurrentDate(date:String){
        mCurrentDate.value=date
    }
    fun getCurrentDate():LiveData<String>{
        return mCurrentDate
    }
    //
    fun setItems(item: ArrayList<Items>){
        mItemsList.value=item
    }
    fun getItems():LiveData<ArrayList<Items>>{
        return mItemsList
    }
    //
    fun setClientName(name: String) {
        mName.value = name
    }

    fun getClientName(): LiveData<String> {
        return mName
    }
    //
    fun setClientPhoneNumber(pNumber:String){
        mPhoneNumber.value =pNumber
    }
    fun getClientPhoneNumber():LiveData<String>{
        return mPhoneNumber
    }

    //
    fun setClientAddress(add: String) {
        mAddress.value = add
    }

    fun getClientAddress(): LiveData<String> {
        return mAddress
    }
    //
    fun setClientCity(city:String){
        mCity.value=city
    }
    fun getClientCity():LiveData<String>{
        return mCity
    }
    //
    fun setPinCode(pCode:String){
        mPinCode.value=pCode
    }
    fun getPinCode():LiveData<String>{
        return mPinCode
    }
    //
    fun setClientState(state:String){
        mState.value=state
    }
    fun getClientState():LiveData<String>{
        return mState
    }
    //
    fun setGST(gst: String) {
        mGST.value = gst
    }

    fun getGST(): LiveData<String> {
        return mGST
    }

    //
    fun setTotalAmount(tAmount:String){
        mTotalAmount.value=tAmount
    }
    fun getTotalAmount():LiveData<String>{
        return mTotalAmount
    }

   //
    fun setSgst(sgst:String){
        mSGST.value=sgst
    }
    fun getSgst():LiveData<String>{
        return mSGST
    }

    //
    fun setSgstAmount(sgstAmount:String){
        mSGSTAmount.value=sgstAmount
    }
    fun getSgstAmount():LiveData<String>{
        return mSGSTAmount
    }
    //
    fun setCgst(cgst:String){
        mCGST.value=cgst
    }
    fun getCgst():LiveData<String>{
        return mCGST
    }
    //
    fun setCgstAmount(cgstAmount:String){
        mCGSTAmount.value=cgstAmount
    }
    fun getCgstAmount():LiveData<String>{
        return mCGSTAmount
    }

    //
    fun setIgst(igst:String){
        mIGST.value=igst
    }
    fun getIgst():LiveData<String>{
        return mIGST
    }
    //
    fun setIgstAmount(igstAmount:String){
        mIGSTAmount.value=igstAmount
    }
    fun getIgstAmount():LiveData<String>{
        return mIGSTAmount
    }
    //
    fun setGrandTotal(gTotal:String){
        mGrandTotal.value=gTotal
    }
    fun getGrandTotal():LiveData<String>{
        return mGrandTotal
    }

//
    fun setDueDate(dDate:String){
        mDueDate.value=dDate
    }
    fun getDueDate():LiveData<String>{
        return mDueDate
    }
}