/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.qreator.vertx;

import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.StaticHandler;

public class VertxWebFormular {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        Route handler = router.route("/anfrage").handler((RoutingContext routingContext) -> {
            String typ = routingContext.request().getParam("typ");
            String name = routingContext.request().getParam("name");
            String passwort = routingContext.request().getParam("passwort");
            HttpServerResponse response = routingContext.response();
            response.putHeader("content-type", "application/json");
            JsonObject jo = new JsonObject();
            //String passwort = "#Informatik";

            if (name.equals("Julia")&&passwort.equals("Kim")) {
                jo.put("typ", "antwort");
                jo.put("text", "Das Passwort ist gültig. Sie sind erfolgreich angemeldet.");
            } else {
                jo.put("typ", "antwort");
            jo.put("text", "Das Passwort ist ungültig. Bitte versuchen Sie es erneut.");
            }
            response.end(Json.encodePrettily(jo));
        });

        // statische html-Dateien werden über den Dateipfad static ausgeliefert
        router.route("/static/*").handler(StaticHandler.create().setDefaultContentEncoding("UTF-8").setCachingEnabled(false));

        // router::accept akzeptiert eine Anfrage und leitet diese an den Router weiter
        server.requestHandler(router::accept).listen(8080);
    }
}
