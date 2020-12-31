package com.appbeauty.app.ui.spa

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.observe
import com.appbeauty.app.R
import com.appbeauty.app.data.model.ActionState
import com.appbeauty.app.databinding.FragmentSpaBinding
import com.appbeauty.app.ui.home.MainActivity

class SpaFragment : Fragment() {
    private val parent : MainActivity by lazy { activity as MainActivity }
    private lateinit var binding: FragmentSpaBinding
    private val viewModel: SpaViewModel  by lazy { SpaViewModel() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentSpaBinding.inflate(inflater, container, false).apply {
            viewModel = this@SpaFragment.viewModel
            lifecycleOwner = this@SpaFragment
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
        observe()
    }

    private fun init() {
        binding.recyclerview.adapter = SpaAdapter(parent)
        viewModel.listSpa()
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.listSpa()
        }
    }

    private fun observe() {
        viewModel.loading.observe(viewLifecycleOwner){
        binding.swipeRefresh.isRefreshing = it
        }
        viewModel.actionState.observe(viewLifecycleOwner){
            if (it.isConsumed){
                Log.i("ActionState", "isConsumed")
            } else if (!it.isSuccess){
                Toast.makeText(parent, it.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

}