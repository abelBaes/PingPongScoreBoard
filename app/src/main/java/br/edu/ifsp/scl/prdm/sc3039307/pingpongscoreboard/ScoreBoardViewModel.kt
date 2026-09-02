package br.edu.ifsp.scl.prdm.sc3039307.pingpongscoreboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ScoreBoardViewModel: ViewModel() {

    private val _uiPlayersPoints = MutableStateFlow(PlayersPoints())
    val uiPlayerPoints: StateFlow<PlayersPoints> = _uiPlayersPoints.asStateFlow()

    fun addPointsPlayerA(){
        _uiPlayersPoints.update {it.copy(playerAPoints = it.playerAPoints + 1)}
    }

    fun addPointsPlayerB(){
        _uiPlayersPoints.update {it.copy(playerBPoints = it.playerBPoints + 1)}
    }

    fun restartMatch(){
        _uiPlayersPoints.update {it.copy(playerAPoints = 0, playerBPoints = 0)}
    }

}