package com.ardnn.academy.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ardnn.academy.data.ModuleEntity
import com.ardnn.academy.databinding.ItemsModuleListBinding

class DetailCourseAdapter : RecyclerView.Adapter<DetailCourseAdapter.ModuleViewHolder>() {
    private val listModules = ArrayList<ModuleEntity>()

    fun setModules(modules: List<ModuleEntity>?) {
        if (modules == null) {
            return
        }
        this.listModules.clear()
        this.listModules.addAll(modules)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleViewHolder {
        val itemsModuleListBinding = ItemsModuleListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return ModuleViewHolder(itemsModuleListBinding)
    }

    override fun onBindViewHolder(holder: ModuleViewHolder, position: Int) {
        holder.bind(listModules[position])
    }

    override fun getItemCount(): Int {
        return listModules.size
    }

    inner class ModuleViewHolder(private val binding: ItemsModuleListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(module: ModuleEntity) {
            binding.textModuleTitle.text = module.title
        }
    }
}