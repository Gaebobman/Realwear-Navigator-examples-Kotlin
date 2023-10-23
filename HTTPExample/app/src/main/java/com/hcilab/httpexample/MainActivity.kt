package com.hcilab.httpexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.hcilab.httpexample.databinding.ActivityMainBinding
import com.hcilab.httpexample.util.Constants.Companion.TAG
import com.hcilab.httpexample.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    // 뷰모델 생성
    private val viewModel by viewModels<WeatherViewModel>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // DataBinding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        viewModel.getWeather(
            "JSON", 14, 1,
            20231023, 1100, "54", "124"
        )

        viewModel.weatherResponse.observe(this) {
            for (i in it.body()?.response!!.body.items.item) {
                Log.d(TAG, "$i")
            }
        }
    }
}

