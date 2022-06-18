package com.example.mymusicplayer.data.remote

import com.example.mymusicplayer.domain.AlbumModel
import com.example.mymusicplayer.domain.TrackModel
import com.example.mymusicplayer.domain.Tracks
import okhttp3.ResponseBody
import retrofit2.Response

class RemoteDataSourceFake : RemoteDataSource {

    override suspend fun getAlbums(flag: Boolean): List<AlbumModel> {
        val model = AlbumModel(
            0,
            "https://images.unsplash.com/photo-1568127861543-b0c0696c735f?ixlib" +
                    "=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=470&q=80",
            "Some Text",
            1
        )

        val mutableListOf = ArrayList<AlbumModel>(10)
        if (flag)
            for (i in 0..10) {
                mutableListOf.add(model.copy(name = "Itunes $i", id = i.toLong()))
            }
        else
            for (i in 0..10) {
                mutableListOf.add(model.copy(name = "Library $i", id = i.toLong()))
            }
        /*for (i in 0..10) {
            mutableListOf.add(model.copy(name = "Some Text $i", id = i.toLong()))
        }*/
        return mutableListOf
    }

    override suspend fun getTracks(albumId: Long): Tracks {

        return Tracks(
            AlbumModel(
                0,
                "https://images.unsplash.com/photo-1568127861543-b0c0696c735f?ixlib" +
                        "=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=470&q=80",
                "Some Text",
                1
            ),
            arrayListOf(
                TrackModel(
                    1,
                    "California",
                    "https://inspiry-2ee60.web.app/music/images/itunes/hip_hop.jpg",
                    "California",
                    "https://muzati.net/music/0-0-1-18352-20",
                )
            )
        )
    }

    override suspend fun downloadFile(fileUrl: String): Response<ResponseBody> {
        TODO("Not yet implemented")
    }
}