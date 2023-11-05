package com.lauron.animal.midterm

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lauron.animal.midterm.databinding.ActivityAnimalDetailsBinding
import com.lauron.animal.midterm.models.Animal

class AnimalDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnimalDetailsBinding
    @SuppressLint("MutatingSharedPrefs")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        @Suppress("DEPRECATION") val animal = intent.getSerializableExtra("animal") as Animal

        binding.animalName.text = animal.name
        binding.animalDesc.text = animal.description

        val animalName=binding.animalName.text

        val sharedPreferences: SharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        val blockedAnimalsSet = sharedPreferences.getStringSet("blockedAnimals", HashSet()) ?: HashSet()

        binding.blockAnimalBtn.setOnClickListener {
            blockedAnimalsSet.add(animalName.toString())

            val editor = sharedPreferences.edit()
            editor.putStringSet("blockedAnimals", blockedAnimalsSet)
            editor.apply()

            finish()
        }
    }
}