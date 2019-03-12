package com.hakansu.restgraphql

import android.content.Context
import androidx.annotation.NonNull
import com.apollographql.apollo.ApolloClient
import com.google.gson.Gson
import com.hakansu.restgraphql.data.DataRepository
import com.hakansu.restgraphql.data.RestApi
import com.hakansu.restgraphql.data.Repository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: App) {

    @Singleton
    @Provides
    @NonNull
    fun provideContext(): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun Repository(dataRepository: DataRepository): Repository {
        return dataRepository
    }

    @Provides
    @Singleton
    internal fun provideOkhttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder: Request.Builder
            requestBuilder = original.newBuilder()
                .addHeader("Authorization","bearer 7096370eb8647c5a8b9edff3748ad0b9d614e8f5")
            val request = requestBuilder.build()
            chain.proceed(request)
        }
        return httpClient.build()
    }

    @Provides
    @Singleton
    internal fun provideRetrofitClient(@NonNull okHttpClient: OkHttpClient): RestApi {
        val retrofit = Retrofit.Builder()
           .addConverterFactory(GsonConverterFactory.create(Gson()))
           .client(okHttpClient)
           .baseUrl(BuildConfig.BASE_URL)
           .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
           .build()

        return retrofit.create(RestApi::class.java)
    }

    @Provides
    @Singleton
    fun provideApolloClient(@NonNull okHttpClient: OkHttpClient): ApolloClient {
        return ApolloClient.builder()
            .serverUrl(BuildConfig.BASE_GRAPH_URL)
            .okHttpClient(okHttpClient)
            .build()
    }
}