package com.lauron.animal.midterm

import android.content.SharedPreferences
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.lauron.animal.midterm.adapters.AnimalListAdapter
import com.lauron.animal.midterm.databinding.ActivityAnimalNamesBinding
import com.lauron.animal.midterm.models.Animal

class AnimalNamesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnimalNamesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalNamesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences: SharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        val blockedAnimalsSet = sharedPreferences.getStringSet("blockedAnimals", HashSet()) ?: HashSet()
        val blockedAnimalsList = blockedAnimalsSet.toList()

        val animalList: MutableList<Animal> = mutableListOf(
            Animal("Fox", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eleifend ex at pharetra iaculis. Mauris auctor dolor ligula, rutrum suscipit diam luctus ut. Praesent tempor tortor non elit luctus pellentesque. Suspendisse imperdiet sapien ut nisi ultricies, sit amet maximus ipsum vulputate. Mauris a nisi ipsum. Cras scelerisque est ut lorem laoreet, a luctus nisl lacinia. Phasellus vestibulum dui nec massa volutpat, at ultrices metus tincidunt.", false),
            Animal("Dog", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eleifend ex at pharetra iaculis. Mauris auctor dolor ligula, rutrum suscipit diam luctus ut. Praesent tempor tortor non elit luctus pellentesque. Suspendisse imperdiet sapien ut nisi ultricies, sit amet maximus ipsum vulputate. Mauris a nisi ipsum. Cras scelerisque est ut lorem laoreet, a luctus nisl lacinia. Phasellus vestibulum dui nec massa volutpat, at ultrices metus tincidunt.", false),
            Animal("Cat", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eleifend ex at pharetra iaculis. Mauris auctor dolor ligula, rutrum suscipit diam luctus ut. Praesent tempor tortor non elit luctus pellentesque. Suspendisse imperdiet sapien ut nisi ultricies, sit amet maximus ipsum vulputate. Mauris a nisi ipsum. Cras scelerisque est ut lorem laoreet, a luctus nisl lacinia. Phasellus vestibulum dui nec massa volutpat, at ultrices metus tincidunt.", false),
            Animal("Bee", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eleifend ex at pharetra iaculis. Mauris auctor dolor ligula, rutrum suscipit diam luctus ut. Praesent tempor tortor non elit luctus pellentesque. Suspendisse imperdiet sapien ut nisi ultricies, sit amet maximus ipsum vulputate. Mauris a nisi ipsum. Cras scelerisque est ut lorem laoreet, a luctus nisl lacinia. Phasellus vestibulum dui nec massa volutpat, at ultrices metus tincidunt.", false),
            Animal("Ant", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eleifend ex at pharetra iaculis. Mauris auctor dolor ligula, rutrum suscipit diam luctus ut. Praesent tempor tortor non elit luctus pellentesque. Suspendisse imperdiet sapien ut nisi ultricies, sit amet maximus ipsum vulputate. Mauris a nisi ipsum. Cras scelerisque est ut lorem laoreet, a luctus nisl lacinia. Phasellus vestibulum dui nec massa volutpat, at ultrices metus tincidunt.", false),
            Animal("Eel", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eleifend ex at pharetra iaculis. Mauris auctor dolor ligula, rutrum suscipit diam luctus ut. Praesent tempor tortor non elit luctus pellentesque. Suspendisse imperdiet sapien ut nisi ultricies, sit amet maximus ipsum vulputate. Mauris a nisi ipsum. Cras scelerisque est ut lorem laoreet, a luctus nisl lacinia. Phasellus vestibulum dui nec massa volutpat, at ultrices metus tincidunt.", false),
            Animal("Zebra", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eleifend ex at pharetra iaculis. Mauris auctor dolor ligula, rutrum suscipit diam luctus ut. Praesent tempor tortor non elit luctus pellentesque. Suspendisse imperdiet sapien ut nisi ultricies, sit amet maximus ipsum vulputate. Mauris a nisi ipsum. Cras scelerisque est ut lorem laoreet, a luctus nisl lacinia. Phasellus vestibulum dui nec massa volutpat, at ultrices metus tincidunt.", false),
            Animal("Yak", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eleifend ex at pharetra iaculis. Mauris auctor dolor ligula, rutrum suscipit diam luctus ut. Praesent tempor tortor non elit luctus pellentesque. Suspendisse imperdiet sapien ut nisi ultricies, sit amet maximus ipsum vulputate. Mauris a nisi ipsum. Cras scelerisque est ut lorem laoreet, a luctus nisl lacinia. Phasellus vestibulum dui nec massa volutpat, at ultrices metus tincidunt.", false),
            Animal("Whale", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eleifend ex at pharetra iaculis. Mauris auctor dolor ligula, rutrum suscipit diam luctus ut. Praesent tempor tortor non elit luctus pellentesque. Suspendisse imperdiet sapien ut nisi ultricies, sit amet maximus ipsum vulputate. Mauris a nisi ipsum. Cras scelerisque est ut lorem laoreet, a luctus nisl lacinia. Phasellus vestibulum dui nec massa volutpat, at ultrices metus tincidunt.", false),
            Animal("Snail", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eleifend ex at pharetra iaculis. Mauris auctor dolor ligula, rutrum suscipit diam luctus ut. Praesent tempor tortor non elit luctus pellentesque. Suspendisse imperdiet sapien ut nisi ultricies, sit amet maximus ipsum vulputate. Mauris a nisi ipsum. Cras scelerisque est ut lorem laoreet, a luctus nisl lacinia. Phasellus vestibulum dui nec massa volutpat, at ultrices metus tincidunt.", false),
            Animal("Rat", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eleifend ex at pharetra iaculis. Mauris auctor dolor ligula, rutrum suscipit diam luctus ut. Praesent tempor tortor non elit luctus pellentesque. Suspendisse imperdiet sapien ut nisi ultricies, sit amet maximus ipsum vulputate. Mauris a nisi ipsum. Cras scelerisque est ut lorem laoreet, a luctus nisl lacinia. Phasellus vestibulum dui nec massa volutpat, at ultrices metus tincidunt.", false),
            Animal("Parrot", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eleifend ex at pharetra iaculis. Mauris auctor dolor ligula, rutrum suscipit diam luctus ut. Praesent tempor tortor non elit luctus pellentesque. Suspendisse imperdiet sapien ut nisi ultricies, sit amet maximus ipsum vulputate. Mauris a nisi ipsum. Cras scelerisque est ut lorem laoreet, a luctus nisl lacinia. Phasellus vestibulum dui nec massa volutpat, at ultrices metus tincidunt.", false),
            Animal("Lion", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eleifend ex at pharetra iaculis. Mauris auctor dolor ligula, rutrum suscipit diam luctus ut. Praesent tempor tortor non elit luctus pellentesque. Suspendisse imperdiet sapien ut nisi ultricies, sit amet maximus ipsum vulputate. Mauris a nisi ipsum. Cras scelerisque est ut lorem laoreet, a luctus nisl lacinia. Phasellus vestibulum dui nec massa volutpat, at ultrices metus tincidunt.", false),
            Animal("Goat", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eleifend ex at pharetra iaculis. Mauris auctor dolor ligula, rutrum suscipit diam luctus ut. Praesent tempor tortor non elit luctus pellentesque. Suspendisse imperdiet sapien ut nisi ultricies, sit amet maximus ipsum vulputate. Mauris a nisi ipsum. Cras scelerisque est ut lorem laoreet, a luctus nisl lacinia. Phasellus vestibulum dui nec massa volutpat, at ultrices metus tincidunt.", false),
         )

        animalList.sortBy { it.name }

        val context = this
        val adapter = AnimalListAdapter(animalList, context)

        val filteredAnimals = animalList.filterNot { blockedAnimalsList.contains(it.name) }
        adapter.updateData(filteredAnimals)

        val recyclerView = binding.animalNames
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val manageBlockButton = binding.mngBtn
        manageBlockButton.setOnClickListener {
            val intent = Intent(this, ManageBlockActivity::class.java)
            startActivity(intent)
        }
    }
}