package com.sample.criminaliintent

import android.content.Context
import androidx.room.Room
import com.sample.criminaliintent.database.CrimeDatabase
import java.util.UUID

private const val DATABASE_NAME = "crimedatabase"
class CrimeRepository private  constructor(context: Context){
    private val database : CrimeDatabase =
        Room.databaseBuilder(
            context.applicationContext,
            CrimeDatabase::class.java,
            DATABASE_NAME
        ).build()
    private val crimeDao = database.crimeDao()
    fun getCrimes(): List<Crime> = crimeDao.getCrimes()
    fun getCrime(id: UUID): Crime? = crimeDao.getCrime(id)
    companion object {
        private var INSTANCE: CrimeRepository? = null
        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = CrimeRepository(context)
            }
        }
        fun get(): CrimeRepository {
            return INSTANCE ?:
            throw
            IllegalStateException("CrimeRepository must be initialized")
        }
    }
}