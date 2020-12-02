package com.cyber.GameUtils;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class YCWOpener {
    public static void open(String reference) throws URISyntaxException, IOException {
        URI ycwuri;
        if(reference == null){
            ycwuri = new URI("https://ycwalameda.weebly.com");
        }
        else{
            ycwuri = new URI(reference);
        }
        Desktop.getDesktop().browse(ycwuri);
    }
}
