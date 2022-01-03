package com.project.jetpackpractice.data

import androidx.paging.PagingSource


private const val UNSPLASH_STARTING_PAGE_INDEX = 1
class UnsplahPagingSource(private val unsplashApi: UnsplahApi, private val query: String):PagingSource<Int, UnsplashPhoto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashPhoto> {
        val position = params.key ?: UNSPLASH_STARTING_PAGE_INDEX

        val response: unspla
    }
}