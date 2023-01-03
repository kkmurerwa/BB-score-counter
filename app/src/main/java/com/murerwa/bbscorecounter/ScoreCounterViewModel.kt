package com.murerwa.bbscorecounter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreCounterViewModel: ViewModel() {
    val teamAScore = MutableLiveData(0)
    val teamBScore = MutableLiveData(0)

    fun add1Point(team: String) {
        when(team) {
            "teamA" -> {
                teamAScore.postValue(teamAScore.value!! + 1)
            }
            "teamB" -> {
                teamBScore.postValue(teamBScore.value!! + 1)
            }
            else -> {
                //Do nothing
            }
        }
    }

    fun add2Points(team: String) {
        when(team) {
            "teamA" -> {
                teamAScore.postValue(teamAScore.value!! + 2)
            }
            "teamB" -> {
                teamBScore.postValue(teamBScore.value!! + 2)
            }
            else -> {
                //Do nothing
            }
        }
    }

    fun add3Points(team: String) {
        when(team) {
            "teamA" -> {
                teamAScore.postValue(teamAScore.value!! + 3)
            }
            "teamB" -> {
                teamBScore.postValue(teamBScore.value!! + 3)
            }
            else -> {
                //Do nothing
            }
        }
    }
}