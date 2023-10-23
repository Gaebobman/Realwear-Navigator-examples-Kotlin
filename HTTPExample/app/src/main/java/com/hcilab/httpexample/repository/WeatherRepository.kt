package com.hcilab.httpexample.repository

import com.hcilab.httpexample.api.WeatherApi
import com.hcilab.httpexample.data.Weather
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepository @Inject constructor(
    private val weatherApi: WeatherApi
) {
    suspend fun getWeather(
        dataType: String, numOfRows: Int, pageNo: Int,
        baseDate: Int, baseTime: Int, nx: String, ny: String
    ): Response<Weather> {
        return weatherApi.getWeather(dataType, numOfRows, pageNo, baseDate, baseTime, nx, ny)
    }

}