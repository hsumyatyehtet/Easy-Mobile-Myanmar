package dev.hmyh.easymobile.network

import dev.hmyh.easymobile.data.vos.PostVO
import dev.hmyh.easymobile.utils.ALL_POST
import dev.hmyh.easymobile.utils.API_KEY
import dev.hmyh.easymobile.utils.KEY
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface EasyMobileApi {

    @GET(ALL_POST)
    fun getAllPosts(
        @Query(KEY)token: String = API_KEY
    ):Observable<DataResponse<List<PostVO>>>


}