package com.example.runningtrackerapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RunDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run:Run)

    @Delete
    suspend fun deleteRun(run:Run)

    @Query("SELECT *FROM running_table ORDER BY timestamp DESC")//this is for run fragment
    fun getAllRunsSortedByDate():LiveData<List<Run>>

    @Query("SELECT *FROM running_table ORDER BY timeInMillis DESC")////this is for run fragment
    fun getAllRunsSortedByTimeInMillis():LiveData<List<Run>>

    @Query("SELECT *FROM running_table ORDER BY caloriesBurned DESC")////this is for run fragment
    fun getAllRunsSortedByCaloriesBurned():LiveData<List<Run>>

    @Query("SELECT *FROM running_table ORDER BY avgSpeedInKMH DESC")//this is for run fragment
    fun getAllRunsSortedByAvgSpeed():LiveData<List<Run>>

    @Query("SELECT *FROM running_table ORDER BY distanceInMeters DESC")//this is for run fragment
    fun getAllRunsSortedByDistance():LiveData<List<Run>>

    @Query("SELECT SUM(timeInMillis) FROM running_table")// for statistics fragment
    fun getTotalTimeInMillis():LiveData<Long>

    @Query("SELECT SUM(caloriesBurned) FROM running_table")//// for statistics fragment
    fun getTotalCaloriesBurned():LiveData<Int>

    @Query("SELECT SUM(distanceInMeters) FROM running_table")// for statistics fragment
    fun getTotalDistance():LiveData<Int>

    @Query("SELECT AVG(avgSpeedInKMH) FROM running_table")// for statistics fragment
    fun getTotalAvgSpeed():LiveData<Long>

}