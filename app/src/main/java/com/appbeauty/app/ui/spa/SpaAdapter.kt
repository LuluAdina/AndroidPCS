package com.appbeauty.app.ui.spa

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.appbeauty.app.R
import com.appbeauty.app.data.model.Spa
import com.appbeauty.app.databinding.ItemSpaBinding
import com.appbeauty.app.ui.base.BaseAdapter
import com.bumptech.glide.Glide

class SpaAdapter(val context: Context) : BaseAdapter<Spa>(R.layout.item_spa) {
    override fun onBind(binding: ViewDataBinding?, data: Spa) {
        val mBinding = binding as ItemSpaBinding
        Glide.with(context).load(data.image_link).into(mBinding.itemImageLink)
    }

    override fun onClick(binding: ViewDataBinding?, data: Spa) {
        val intent = Intent(context, SpaActivity::class.java)
        context.startActivity(intent)
    }
}