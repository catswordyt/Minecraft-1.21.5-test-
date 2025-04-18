package com.example.mc;

import org.teavm.jso.dom.html.HTMLCanvasElement;
import org.teavm.jso.webgl.WebGL2RenderingContext;
import org.teavm.jso.webgl.WebGLContextAttributes;

public class Main {
    private static WebGL2RenderingContext gl;

    public static void main(String[] args) {
        HTMLCanvasElement canvas = (HTMLCanvasElement)
            org.teavm.jso.dom.html.Window.current()
              .getDocument().getElementById("canvas");

        WebGLContextAttributes attrs = WebGLContextAttributes.create();
        attrs.setAntialias(true);
        gl = (WebGL2RenderingContext) canvas.getContext("webgl2", attrs);
        if (gl == null) throw new RuntimeException("WebGL2 not supported");

        Network.init();         // init our WS proxy
        gameLoop(0);            // start render & tick
    }

    private static void gameLoop(double t) {
        gl.clearColor(0f, 0f, 0f, 1f);
        gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);
        // TODO: hook MinecraftClient.INSTANCE.render();

        org.teavm.jso.browser.Window.requestAnimationFrame(Main::gameLoop);
    }
}