package com.example.runningtrackerapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters

@Database(
 entities = [Run::class],
 version = 1
)
@TypeConverters(Converters::class)
abstract class RunningDatabase :RoomDatabase(){
 abstract fun getRunDao():RunDAO
}