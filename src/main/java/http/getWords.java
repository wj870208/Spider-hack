package http;

/**
 * @author yuzhe
 * @since 10/13/17
 */
public class getWords {

//    private static String[] urls = new String[100];
//    private static Set<String> keyWords = new HashSet<>();
//    private static CloseableHttpClient client = HttpClientUtil.getCloseableHttpClient();
//
//    private static String downloadUrl = "http://hackathon.mzsvn.com/download.php";
//    private static String submitUrl = "http://hackathon.mzsvn.com/submit.php";
//    static {
//        try {
//            String urlsStr = HttpClientUtil.get(client, downloadUrl);
//
//            urls = urlsStr.split("\n");
//
//            FileReader adultReader = new FileReader("/home/yuzhe/IdeaProjects/hack/src/main/resources/Adult");
//            Scanner inAdult = new Scanner(adultReader);
//            FileReader dirtyAdult = new FileReader("/home/yuzhe/IdeaProjects/hack/src/main/resources/Dirty");
//            Scanner inDirty = new Scanner(dirtyAdult);
//
//
//            while(inAdult.hasNextLine()){
//                String line = inAdult.nextLine();
//                keyWords.add(line);
//            }
//            while(inDirty.hasNextLine()){
//                String line = inDirty.nextLine();
//                keyWords.add(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        int i = 0;
//        Map<String, String> map = new HashMap<>();
//        map.put("token", "ftRuSu26ZObjOt04");
//        for(String url : urls){
//            i++;
//            try {
//                String content = HttpClientUtil.get(client, url);
//                int startIndex = content.indexOf("<title>") + 7;
//                int endIndex = content.indexOf("</title>");
//                String title = content.substring(startIndex, endIndex);
//                int score = getScore(title);
//                System.out.println(title + " : " + score);
//                map.put("url" + i, String.valueOf(score));
//            }catch (Exception e){
//                map.put("url" + i, "70");
//                continue;
//            }
//        }
//
//        String result = HttpClientUtil.post(client, submitUrl, map);
//        System.out.println(result);
//    }
//
//    private static int getScore(String title) {
//        JiebaSegmenter segmenter = new JiebaSegmenter();
//        List<String> strings = segmenter.sentenceProcess(title);
//        for(String s : strings){
//            if(keyWords.contains(s.trim())){
//                return 0;
//            }
//        }
//        return 100;
//    }

}
