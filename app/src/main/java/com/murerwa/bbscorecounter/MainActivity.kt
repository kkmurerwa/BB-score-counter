package com.murerwa.bbscorecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.LifecycleOwner
import com.murerwa.bbscorecounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel = ScoreCounterViewModel()
    private lateinit var binding: ActivityMainBinding

    private val teamAKey = "teamA"
    private val teamBKey = "teamB"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeScores()

        binding.apply {
            incrementTeamAScore()
            incrementTeamBScore()
        }
    }

    private fun ActivityMainBinding.incrementTeamAScore() {
        buttonAdd1ptToTeamA.setOnClickListener {
            viewModel.add1Point(teamAKey)
        }
        buttonAdd2ptsToTeamA.setOnClickListener {
            viewModel.add2Points(teamAKey)
        }
        buttonAdd3ptsToTeamA.setOnClickListener {
            viewModel.add3Points(teamAKey)
        }
    }

    private fun ActivityMainBinding.incrementTeamBScore() {
        buttonAdd1ptToTeamB.setOnClickListener {
            viewModel.add1Point(teamBKey)
        }
        buttonAdd2ptsToTeamB.setOnClickListener {
            viewModel.add2Points(teamBKey)
        }
        buttonAdd3ptsToTeamB.setOnClickListener {
            viewModel.add3Points(teamBKey)
        }
    }

    private fun observeScores() {
        viewModel.teamAScore.observe(this as LifecycleOwner) { score ->
            binding.textScoreTeamA.text = score.toString()
        }

        viewModel.teamBScore.observe(this as LifecycleOwner) { score ->
            binding.textScoreTeamB.text = score.toString()
        }
    }
}