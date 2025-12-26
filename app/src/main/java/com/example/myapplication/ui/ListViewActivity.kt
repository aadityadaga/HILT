package com.example.myapplication.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityListViewBinding
import com.example.myapplication.state.DataHandler
import com.example.myapplication.ui.adapter.TeamAdapter
import com.example.myapplication.viewmodel.ListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListViewActivity : AppCompatActivity() {
    private val viewModel: ListViewModel by viewModels()
    lateinit var binding: ActivityListViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_list_view
        )
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        fetchDetails()
    }

    private fun fetchDetails() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.teamsDetails.collect {
                    when (it) {
                        is DataHandler.Error -> {

                        }

                        is DataHandler.Loading -> {

                        }

                        is DataHandler.Success -> {
                            binding.recyclerView.adapter =
                                it.data?.teams?.let { teams -> TeamAdapter(teams) }
                        }
                    }
                }
            }
        }
    }
}