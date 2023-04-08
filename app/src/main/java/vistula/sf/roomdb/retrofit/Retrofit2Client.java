package vistula.sf.roomdb.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vistula.sf.roomdb.BuildConfig;

public class Retrofit2Client {
    private static Retrofit2Client instance = null;
    private Retrofit retrofit;
    private OkHttpClient client;
    private ExploreService exploreService;

    public Retrofit2Client() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();


        if (BuildConfig.DEBUG) {
            okHttpBuilder.addInterceptor(loggingInterceptor);
        }

        client = okHttpBuilder.build();

        retrofit = new Retrofit.Builder().baseUrl(Constants.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        exploreService = retrofit.create(ExploreService.class);
    }

    public static Retrofit2Client getInstance() {
        if (instance == null) {
            instance = new Retrofit2Client();
        }

        return instance;
    }

    public ExploreService getExploreService() {
        return exploreService;
    }
}