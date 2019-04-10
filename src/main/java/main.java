import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class main {
    public static void main(String[] args) {
        String test_url = "https://mp.weixin.qq.com/s?src=11&timestamp=1554895801&ver=1538&signature=60pcl2*yGZ4I1xxrarYOiTLFnwMcQEedOfSEwZYU0M0hRFZgEHibBhxrXDBKkCP7hF1zfAqTwKxdCAKfz-ZlyKkeTS8s*odb*IHQZ27mafR2Hl8V4YxmyALE3f4ksu8f&new=1";
        System.out.println(getPageContent(test_url));
    }

    private static String getPageContent(String url){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            String content = response.body().string();
            Document doc = Jsoup.parse(content);
            Element con = doc.getElementById("js_content");
            System.out.println(con.text());
            return con.text();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
