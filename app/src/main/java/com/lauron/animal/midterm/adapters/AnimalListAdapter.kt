package com.lauron.animal.midterm.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lauron.animal.midterm.AnimalDetailsActivity
import com.lauron.animal.midterm.databinding.ListItemAnimalBinding
import com.lauron.animal.midterm.models.Animal

class AnimalListAdapter(private val animalList: MutableList<Animal>, private val context: Context) : RecyclerView.Adapter<AnimalListAdapter.AnimalViewHolder>() {

    inner class AnimalViewHolder(private val binding: ListItemAnimalBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val animal = animalList[position]
                    val intent = Intent(context, AnimalDetailsActivity::class.java)
                    intent.putExtra("animal", animal)
                    context.startActivity(intent)
                }
            }
        }

        fun bind(animal: Animal) {
            binding.animalName.text = animal.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val binding = ListItemAnimalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(animalList[position])
    }

    override fun getItemCount(): Int {
        return animalList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newData: List<Animal>) {
        animalList.clear()
        animalList.addAll(newData)
        notifyDataSetChanged()
    }
}