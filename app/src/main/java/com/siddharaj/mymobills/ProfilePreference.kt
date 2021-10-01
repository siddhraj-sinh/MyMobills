package com.siddharaj.mymobills

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProfilePreference(context:Context) {

    private val applicationContext = context.applicationContext
    private val dataStore: DataStore<Preferences>
    init {
        dataStore=applicationContext.createDataStore(name="profile_preferences")
    }
    // set data
    suspend fun businessLogo(bLogo:String){
        dataStore.edit { preferences->preferences[KEY_BUSINESS_LOGO]=bLogo }
    }
    suspend fun businessName(bName:String){
        dataStore.edit { preferences->preferences[KEY_BUSINESS_NAME]=bName }
    }
    suspend fun ownerName(oName: String){
        dataStore.edit { preferences -> preferences[KEY_OWNER_NAME]=oName }
    }

    suspend fun gstIn(gIn:String){
        dataStore.edit { preferences->preferences[KEY_GST_IN]=gIn }
    }
    suspend fun address(address:String){
        dataStore.edit { preferences->preferences[KEY_ADDRESS]=address }
    }
    suspend fun emailAddress(eAddress:String){
        dataStore.edit { preferences->preferences[KEY_EMAIL_ADDRESS]=eAddress }
    }
    suspend fun phoneNumber(pNumber:String){
        dataStore.edit { preferences->preferences[KEY_PHONE_NUMBER]=pNumber }
    }
    suspend fun website(website:String){
        dataStore.edit { preferences->preferences[KEY_WEBSITE]=website }
    }
    suspend fun bankName(bankName: String){
        dataStore.edit { preferences->preferences[KEY_BANK_NAME]=bankName }
    }
    suspend fun bankAccountNumber(bAccount:String){
        dataStore.edit { preferences->preferences[KEY_BANK_ACCOUNT_NUMBER]=bAccount }
    }
    suspend fun bankIfsc(bIFSC:String){
        dataStore.edit { preferences->preferences[KEY_BANK_IFSC]=bIFSC }
    }
    suspend fun invoiceNumber(iNumber:Int){
        dataStore.edit { preferences->preferences[KEY_INVOICE_NUMBER]=iNumber }
    }


    // get data
val businessLogo: Flow<String?> get() = dataStore.data.map { preferences ->
        preferences[KEY_BUSINESS_LOGO]
    }
    val businessName: Flow<String?>
        get() = dataStore.data.map { preferences ->
            preferences[KEY_BUSINESS_NAME]
        }
    val ownerName: Flow<String?>
        get() = dataStore.data.map { preferences ->
            preferences[KEY_OWNER_NAME]
        }
    val gstIn:Flow<String?> get() = dataStore.data.map { preferences ->
        preferences[KEY_GST_IN]
    }
    val address:Flow<String?> get() = dataStore.data.map { preferences ->
        preferences[KEY_ADDRESS]
    }
    val emailAddress:Flow<String?> get() = dataStore.data.map { preferences ->
        preferences[KEY_EMAIL_ADDRESS]
    }
     val phoneNumber:Flow<String?> get() = dataStore.data.map { preferences ->
         preferences[KEY_PHONE_NUMBER]
     }
    val website:Flow<String?> get() = dataStore.data.map { preferences ->
        preferences[KEY_WEBSITE]
    }
    val bankName:Flow<String?> get() = dataStore.data.map { preferences ->
        preferences[KEY_BANK_NAME]
    }
    val bankAccountNumber:Flow<String?> get() = dataStore.data.map { preferences ->
        preferences[KEY_BANK_ACCOUNT_NUMBER]
    }
    val bankIFSC:Flow<String?> get() = dataStore.data.map { preferences ->
        preferences[KEY_BANK_IFSC]
    }

    val invoiceNumber:Flow<Int?> get() = dataStore.data.map { preferences ->
        preferences[KEY_INVOICE_NUMBER]
    }

    companion object{
        val KEY_BUSINESS_LOGO = preferencesKey<String>("business_logo")
        val KEY_BUSINESS_NAME= preferencesKey<String>("business_name")
        val KEY_OWNER_NAME= preferencesKey<String>("owner_name")
        val KEY_GST_IN = preferencesKey<String>("gst_in")
        val KEY_ADDRESS= preferencesKey<String>("address")
        val KEY_EMAIL_ADDRESS= preferencesKey<String>("email_address")
        val KEY_PHONE_NUMBER = preferencesKey<String>("phone_number")
        val KEY_WEBSITE = preferencesKey<String>("website")
        val KEY_BANK_NAME = preferencesKey<String>("bank_name")
        val KEY_BANK_ACCOUNT_NUMBER = preferencesKey<String>("bank_account_number")
        val KEY_BANK_IFSC= preferencesKey<String>("bank_ifsc")

        val KEY_INVOICE_NUMBER = preferencesKey<Int>("invoice_number")

    }

}