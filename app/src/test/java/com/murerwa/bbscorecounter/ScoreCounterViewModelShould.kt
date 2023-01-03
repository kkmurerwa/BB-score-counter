package com.murerwa.bbscorecounter

import com.murerwa.bbscorecounter.utils.BaseUnitTest
import com.murerwa.bbscorecounter.utils.captureValues
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ScoreCounterViewModelShould: BaseUnitTest() {

    private val viewModel = ScoreCounterViewModel()

    @Test
    fun initializeScoresAtZero() = runTest {
        viewModel.teamAScore.captureValues {
            assertEquals(0, values[0])
        }

        viewModel.teamBScore.captureValues {
            assertEquals(0, values[0])
        }
    }

    @Test
    fun add1PointToTeamScore() {
        viewModel.add1Point("teamA")

        viewModel.teamAScore.captureValues {
            assertEquals(1, values[0])
        }

        viewModel.add1Point("teamB")

        viewModel.teamBScore.captureValues {
            assertEquals(1, values[0])
        }
    }

    @Test
    fun add2PointsToTeamScore() {
        viewModel.add2Points("teamA")

        viewModel.teamAScore.captureValues {
            assertEquals(2, values[0])
        }

        viewModel.add2Points("teamB")

        viewModel.teamBScore.captureValues {
            assertEquals(2, values[0])
        }
    }

    @Test
    fun add3PointsToTeamScore() {
        viewModel.add3Points("teamA")

        viewModel.teamAScore.captureValues {
            assertEquals(3, values[0])
        }

        viewModel.add3Points("teamB")

        viewModel.teamBScore.captureValues {
            assertEquals(3, values[0])
        }
    }


}