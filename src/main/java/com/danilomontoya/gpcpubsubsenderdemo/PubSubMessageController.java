package com.danilomontoya.gpcpubsubsenderdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ing. Danilo Montoya Hernandez;
 * Email: danilo9831montoya@gmail.com
 * @version Id: <b>gpc-pub-sub-sender-demo</b> 12/12/2023, 5:29 PM
 **/
@RestController
public class PubSubMessageController {

    @Autowired
    private GpcPubSubSenderDemoApplication.PubSubOutboundGateway messagingGateway;

    @PostMapping("/publishMessage")
    public ResponseEntity<?> publishMessage(@RequestParam("message") String message) {
        messagingGateway.sendToPubSub(message);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
