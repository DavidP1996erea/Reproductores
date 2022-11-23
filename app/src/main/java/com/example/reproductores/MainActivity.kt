package com.example.reproductores


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        reproducir1Video()
    }


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




}

