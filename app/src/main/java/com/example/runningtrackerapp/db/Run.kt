package com.example.runningtrackerapp.db

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp

@Entity(tableName="running_table")
data class Run (
   var img:Bitmap?=null,
   var timestamp: Long=0L, ///when our run was
    var avgSpeedInKMH:Float=0F,
   var distanceInMeters:Int=0,
   var timeInMillis:Long=0L,//how long our run was
    var caloriesBurned:Int=0
        ){
      @PrimaryKey(autoGenerate = true)
      var id:Int?=null
}