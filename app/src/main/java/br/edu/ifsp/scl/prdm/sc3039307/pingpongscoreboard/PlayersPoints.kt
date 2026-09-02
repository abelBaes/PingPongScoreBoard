package br.edu.ifsp.scl.prdm.sc3039307.pingpongscoreboard
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlayersPoints(
    val playerAPoints: Int = 0,
    val playerBPoints: Int = 0
) : Parcelable
