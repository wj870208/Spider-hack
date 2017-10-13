package http;

import io.vertx.core.AbstractVerticle;
/**
 * Created on 2017/10/13.
 *
 * @author hlj
 * @since 1.0.0
 */
public class Server extends AbstractVerticle {

    public static void main(String[] args) {
        Runner.runExample(Server.class);
    }

    @Override
    public void start() throws Exception {

        vertx.createHttpServer().requestHandler(req -> {

            req.response().end("Hello World");

        }).listen(8080, listenResult -> {
            if (listenResult.failed()) {
                System.out.println("Could not start HTTP server");
                listenResult.cause().printStackTrace();
            } else {
                System.out.println("Server started");
            }
        });
    }
}
