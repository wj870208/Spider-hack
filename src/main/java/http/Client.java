package http;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.buffer.Buffer;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;

/**
 * Created on 2017/10/13.
 *
 * @author hlj
 * @since 1.0.0
 */
public class Client extends AbstractVerticle {

    // Convenience method so you can run it in your IDE
    public static void main(String[] args) {
        Runner.runExample(Client.class);
    }

    @Override
    public void start() throws Exception {

        WebClient client = WebClient.create(vertx);

        client.getAbs("http://hackathon.mzsvn.com/download.php").send(ar -> {
            if(ar.succeeded()){
                HttpResponse<Buffer> response = ar.result();
                System.out.println(response.bodyAsString("utf-8"));
            }else{
                ar.cause().printStackTrace();
            }
        });
    }



}
