package br.edu.ifsp.scl.prdm.sc3039307.pingpongscoreboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ScoreBoardViewModel: ViewModel() {
    var playerAPoints by mutableIntStateOf(0)
        private set

    var playerBPoints by mutableIntStateOf(0)
        private set

    fun addPointsPlayerA(){
        playerAPoints++
    }

    fun addPointsPlayerB(){
        playerBPoints++
    }

    fun restartMatch(){
        playerAPoints = 0
        playerBPoints = 0
    }

}