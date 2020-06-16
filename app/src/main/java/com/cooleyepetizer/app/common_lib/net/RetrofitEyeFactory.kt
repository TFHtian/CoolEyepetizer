package com.cooleyepetizer.app.common_lib.net

import com.cooleyepetizer.app.BuildConfig
import com.cooleyepetizer.app.common_lib.config.AppConfig
import com.cooleyepetizer.app.common_lib.config.Constant
import com.cooleyepetizer.app.utils.AppUtils
import com.cooleyepetizer.app.utils.CEPreference
import com.cooleyepetizer.app.utils.Debuger
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 网络请求(开眼网络带公共参数)
 */

open class RetrofitEyeFactory() {

    private var accessTokenStorage: String by CEPreference(Constant.ACCESS_TOKEN, "")

    private var userBasicCodeStorage: String by CEPreference(Constant.USER_BASIC_CODE, "")

    val retrofit: Retrofit

    init {
        //打印请求log
        val logging = HttpLoggingInterceptor()
        logging.level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
        val mOkHttpClient = OkHttpClient.Builder()
                .connectTimeout(AppConfig.HTTP_TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(addQueryParameterInterceptor())  //参数添加
                .addInterceptor(logging)
                .addInterceptor(headerInterceptor())
                .addInterceptor(PageInfoInterceptor())
                .build()
        retrofit = Retrofit.Builder()
                .baseUrl(AppConfig.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(mOkHttpClient)
                .build()
    }

    /**
     * 设置公共参数
     */
    private fun addQueryParameterInterceptor(): Interceptor {
        return Interceptor { chain ->
            val originalRequest = chain.request()
            val request: Request
            val modifiedUrl = originalRequest.url().newBuilder()
                // Provide your custom parameter here
                .addQueryParameter("udid", Constant.Ud_Id)
                .addQueryParameter("deviceModel", AppUtils.getMobileModel())
                .addQueryParameter("vc", Constant.VC)
                .addQueryParameter("vn", Constant.VN)
                .addQueryParameter("size", Constant.SIZE)
                .addQueryParameter("first_channel", Constant.FIRST_CHANNEL)
                .addQueryParameter("last_channel", Constant.LAST_CHANNEL)
                .addQueryParameter("system_version_code", Constant.SYSTEM_VERSION_CODE)
                .build()
            request = originalRequest.newBuilder().url(modifiedUrl).build()
            chain.proceed(request)
        }
    }

    /**
     * 拦截头部增加token
     */
    private fun headerInterceptor(): Interceptor {
        return Interceptor { chain ->
            var request = chain.request()

            //add access token
            val accessToken = getAuthorization()

            Debuger.printfLog("headerInterceptor", accessToken)

            if (!accessToken.isEmpty()) {
                Debuger.printfLog(accessToken)
                val url = request.url().toString()
                request = request.newBuilder()
                        .addHeader("Authorization", accessToken)
                        .url(url)
                        .build()
            }

            chain.proceed(request)
        }

    }

    /**
     * 获取token
     */
    private fun getAuthorization(): String {
        if (accessTokenStorage.isBlank()) {
            val basic = userBasicCodeStorage
            return if (basic.isBlank()) {
                //提示输入账号密码
                ""
            } else {
                //通过 basic 去获取token，获取到设置，返回token
                "Basic $basic"
            }
        }
        return "token $accessTokenStorage"

    }

    companion object {

        @Volatile
        private var mRetrofitFactory: RetrofitEyeFactory? = null

        private val instance: RetrofitEyeFactory
            get() {
                if (mRetrofitFactory == null) {
                    synchronized(RetrofitEyeFactory::class.java) {
                        if (mRetrofitFactory == null)
                            mRetrofitFactory = RetrofitEyeFactory()
                    }

                }
                return mRetrofitFactory!!
            }

        fun <T> createService(service: Class<T>): T {
            return instance.retrofit.create(service)
        }

        /**
         * 执行请求返回结果
         */
        fun <T> executeResult(observable: Observable<Response<T>>, subscriber: ResultObserver<T>) {
            observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber)
        }

    }

}
