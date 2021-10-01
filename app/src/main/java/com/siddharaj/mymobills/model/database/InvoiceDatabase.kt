package com.siddharaj.mymobills.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.siddharaj.mymobills.model.entities.Invoice
import com.siddharaj.mymobills.model.entities.Items

@Database(entities = arrayOf(Invoice::class,Items::class), version = 1, exportSchema = false)
abstract class InvoiceDatabase:RoomDatabase() {
    abstract fun getInvoice():InvoiceDao
    companion object{
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: InvoiceDatabase? = null

        fun getDatabase(context: Context): InvoiceDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    InvoiceDatabase::class.java,
                    "invoice_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}