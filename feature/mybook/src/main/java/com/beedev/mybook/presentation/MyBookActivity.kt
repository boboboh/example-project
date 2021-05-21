package com.beedev.mybook.presentation

import android.os.Bundle
import com.beedev.core.common.BaseActivity
import com.beedev.core.extenstions.viewBinding
import com.beedev.mybook.R
import com.beedev.mybook.databinding.MyBookActivityBinding

class MyBookActivity : BaseActivity(R.layout.my_book_activity) {

    private val binding by viewBinding(MyBookActivityBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fragment = MyBookFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .replace(R.id.myBookContainer, fragment)
            .commit()
    }
}