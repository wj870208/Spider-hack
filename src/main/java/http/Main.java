package http;

import com.google.common.collect.Sets;

import com.huaban.analysis.jieba.JiebaSegmenter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created on 2017/10/14.
 *
 * @author hlj
 * @since 1.0.0
 */
public class Main {

    private static String[] urls = new String[100];
    private static Set<String> keyWords = new HashSet<>(10000);

    private static String downloadUrl = "http://hackathon.mzsvn.com/download.php";
    private static String submitUrl = "http://hackathon.mzsvn.com/submit.php";

    private static JiebaSegmenter segmenter = new JiebaSegmenter();
    static {
        try {
            List<String> list = FileUtils.readLines(new File("D:\\dmpspace\\spider\\src\\main\\resources\\Dirty.txt"), "utf-8");
            for (Object o : list) {
                keyWords.addAll(segmenter.sentenceProcess(o.toString()));
            }
            keyWords.addAll(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        int i = 0;
        StringBuilder sb = new StringBuilder(200);
        sb.append(submitUrl).append("?token=ftRuSu26ZObjOt04");

        List<String> urlList = HttpUtil.get();
        for (String url : urlList) {
            i++;
            sb.append("&url").append(i).append("=");
            try {
                Document doc = Jsoup.connect(url).get();
                String title = doc.title();
                int score = 0;
                if (StringUtils.isBlank(title)) {
                    score = 75;
                }else{
                    score = getScore(title);
                }
                sb.append(score);
            } catch (Exception e) {
                sb.append("25");
            }
        }
        System.out.println(sb.toString());
        String response = HttpUtil.get(sb.toString());
        System.out.println(response);
    }

    private static int getScore(String title) {
        HashSet<String> titleSet = new HashSet<>(segmenter.sentenceProcess(title));
        Sets.SetView<String> intersection = Sets.intersection(keyWords, titleSet);
        int keywordNum = intersection.size();
        return keywordNum > 0 ? 0 : 100;
    }
}
