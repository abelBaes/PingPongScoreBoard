package br.edu.ifsp.scl.prdm.sc3039307.pingpongscoreboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ScoreBoardViewModel(private val savedStateHandle: SavedStateHandle): ViewModel() {

    private companion object{
        const val PLAYERS_POINTS_KEY = "playersPointsKey"
    }

    private val _uiPlayersPoints = MutableStateFlow(savedStateHandle[PLAYERS_POINTS_KEY] ?: PlayersPoints())
    val uiPlayerPoints: StateFlow<PlayersPoints> = savedStateHandle.getStateFlow(key = PLAYERS_POINTS_KEY, initialValue = PlayersPoints())

    fun addPointsPlayerA(){
        val currentPoints = uiPlayerPoints.value
        savedStateHandle[PLAYERS_POINTS_KEY] = currentPoints.copy(
            playerAPoints = currentPoints.playerAPoints + 1
        )
    }

    fun addPointsPlayerB(){
        val currentPoints = uiPlayerPoints.value
        savedStateHandle[PLAYERS_POINTS_KEY] = currentPoints.copy(
            playerBPoints = currentPoints.playerBPoints + 1
        )
    }

    fun restartMatch(){
        savedStateHandle[PLAYERS_POINTS_KEY] = PlayersPoints(playerAPoints = 0, playerBPoints = 0)
    }

}