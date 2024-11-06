package com.vivek.wordsapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.vivek.wordsapp.database.WordAdapter
import com.vivek.wordsapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: WordViewModel by viewModels()
    private lateinit var wordAdapter: WordAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        binding.addWordFab.setOnClickListener {
            showAddWordDialog()
        }

        viewModel.getAllWords().observe(this) {
            Log.d("TAG",it.toString())
            wordAdapter.submitList(it)
        }
    }

    private fun setupRecyclerView() {
        binding.wordsRecyclerView.apply {
            wordAdapter = WordAdapter()
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = wordAdapter
        }
    }

    private fun showAddWordDialog() {
        MaterialDialog(this).show {
            input { materialDialog, text ->
                viewModel.saveWord(text.toString()).observe(this@MainActivity) {
                    Toast.makeText(context, if (it) "Success" else "Failed", Toast.LENGTH_SHORT)
                        .show()


                }
            }
            positiveButton(text = "Submit")
        }
    }
}