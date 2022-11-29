package com.example.reproductores


import android.content.DialogInterface
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException


class MainActivity : AppCompatActivity(){

    private var mediaplayerMusicaAlmacenada: MediaPlayer? = null
    private var mediaPlayerMusicaURL:MediaPlayer?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaplayerMusicaAlmacenada = MediaPlayer.create(this, R.raw.lifelike);


        mediaPlayerMusicaURL= MediaPlayer()
        mediaPlayerMusicaURL?.setAudioStreamType(AudioManager.STREAM_MUSIC)
        mediaPlayerMusicaURL?.setDataSource("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-3.mp3")
        mediaPlayerMusicaURL?.prepare()



        reproducir1Video()
    }



    fun iniciarMusica(view: View) {
        mediaplayerMusicaAlmacenada!!.start()
    }

    fun pausarMusica(view: View) {
        mediaplayerMusicaAlmacenada!!.pause()
    }
    fun pararMusica(view: View) {
             try {
                 mediaplayerMusicaAlmacenada!!.stop()
                 mediaplayerMusicaAlmacenada!!.prepare()
                 mediaplayerMusicaAlmacenada!!.seekTo(0)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }


    fun iniciarMusicaURL(view: View) {
        mediaPlayerMusicaURL!!.start()
    }

    fun pausarMusicaURL(view: View) {
        mediaPlayerMusicaURL!!.pause()
    }
    fun pararMusicaURL(view: View) {
        try {
            mediaPlayerMusicaURL!!.stop()
            mediaPlayerMusicaURL!!.prepare()
            mediaPlayerMusicaURL!!.seekTo(0)
        } catch (e: IOException) {
            e.printStackTrace()
        }


}


    fun reproducir1Video() {
        val mediaController = MediaController(this)
        var videoView = findViewById<VideoView>(R.id.videoView)

        videoView.setVideoURI(Uri.parse("android.resource://$packageName/raw/pruebavideo"))
        mediaController.setAnchorView(videoView)
        mediaController.setMediaPlayer(videoView)
        videoView.setMediaController(mediaController)
        videoView.requestFocus()
        videoView.start()
    }

}

