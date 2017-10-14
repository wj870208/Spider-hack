package http;

import com.google.common.base.Splitter;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created on 2017/10/13.
 *
 * @author hlj
 * @since 1.0.0
 */
public class HttpUtil {

    static OkHttpClient httpClient = new OkHttpClient();


    public static List<String> get() throws IOException {
        Request build = new Request.Builder().url("http://hackathon.mzsvn.com/download.php").build();
        Response response = httpClient.newCall(build).execute();
        String result = response.body().string();
        return Splitter.on("\n").trimResults().splitToList(result);
    }


    public static String get(String url) throws IOException {
        Request build = new Request.Builder().url(url).build();
        Response response = httpClient.newCall(build).execute();

        return response.body().string();
    }


    public static void main(String[] args) throws IOException {

    }
}
