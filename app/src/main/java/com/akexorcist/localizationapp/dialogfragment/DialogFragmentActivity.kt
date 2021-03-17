package com.akexorcist.localizationapp.dialogfragment

import android.os.Bundle
import com.akexorcist.localizationactivity.ui.LocalizationActivity
import com.akexorcist.localizationapp.R
import com.akexorcist.localizationapp.databinding.ActivityDialogFragmentBinding

class DialogFragmentActivity : LocalizationActivity() {
    private val binding by lazy { ActivityDialogFragmentBinding.inflate(layoutInflater) }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Activity title is not change the language automatically.
        setTitle(R.string.hello_world)
        binding.btnBack.setOnClickListener { super.onBackPressed() }
        binding.btnOpenContent.setOnClickListener {
            ContentDialogFragment.newInstance().apply {
                isCancelable = true
            }.show(supportFragmentManager, null)
        }
    }
}
