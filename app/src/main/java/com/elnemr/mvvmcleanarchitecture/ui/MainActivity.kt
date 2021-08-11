package com.elnemr.mvvmcleanarchitecture.ui

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.elnemr.mvvmcleanarchitecture.R
import com.elnemr.mvvmcleanarchitecture.base.view.BaseActivity
import com.elnemr.mvvmcleanarchitecture.data.local.MainDao
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity(override val layoutResourceId: Int = R.layout.activity_main) : BaseActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = findNavController(R.id.nav_host)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}