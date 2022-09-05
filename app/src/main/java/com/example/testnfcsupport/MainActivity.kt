package com.example.testnfcsupport

import android.content.pm.PackageManager.FEATURE_NFC_HOST_CARD_EMULATION
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testnfcsupport.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.switchNfcSupport.setOnClickListener{ testNFCSupport() }
    }

    private fun testNFCSupport() {
        val pm = packageManager
        val b = pm.hasSystemFeature(FEATURE_NFC_HOST_CARD_EMULATION)
        if (binding.switchNfcSupport.isChecked) {
            if (b)
                binding.textNfcSupport.text = getString(R.string.not_supported, "Yes")
            else
                binding.textNfcSupport.text = getString(R.string.not_supported, "No")
        }
        println("test")
    }
}