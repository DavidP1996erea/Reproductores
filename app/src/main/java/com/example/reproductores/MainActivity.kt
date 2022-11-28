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

    private var btnPlay: ImageView? = null
    private var btnPause: ImageView? = null
    private var btnStop: ImageView? = null
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
        //Obtenemos los tres botones de la interfaz
        btnPlay= findViewById(R.id.botonInicio);
        btnStop= findViewById(R.id.botonParar);
        btnPause= findViewById(R.id.botonPausa);

        //Y les asignamos el controlador de eventos



        //reproducir1Video()
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
        mediaplayerMusicaAlmacenada!!.start()
    }

    fun pausarMusicaURL(view: View) {
        mediaplayerMusicaAlmacenada!!.pause()
    }
    fun pararMusicaURL(view: View) {
        try {
            mediaplayerMusicaAlmacenada!!.stop()
            mediaplayerMusicaAlmacenada!!.prepare()
            mediaplayerMusicaAlmacenada!!.seekTo(0)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    /*
    override fun onClick(v: View) {
        //Comprobamos el identificador del boton que ha llamado al evento para ver
        //cual de los botones es y ejecutar la acción correspondiente
        when (v.getId()) {
            R.id.buttonPlay ->                 //Iniciamos el audio

            R.id.buttonPause ->                 //Pausamos el audio
                mediaplayer!!.pause()
            R.id.buttonStop ->                 //Paramos el audio y volvemos a inicializar

        }
    }

*/















/*
fun reproducir1Video(){
    val mediaController = MediaController(this)
    var videoView = findViewById<VideoView>(R.id.videoView)
    var url = "http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"
    val uri = Uri.parse(url)
    videoView.setVideoURI(uri)

    mediaController.setAnchorView(videoView)
    mediaController.setMediaPlayer(videoView)
    videoView.setMediaController(mediaController)
    videoView.requestFocus()
    videoView.start()


}
*/



}

